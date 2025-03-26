package com.grocery.Grocery.service;

import com.grocery.Grocery.dto.GroceryDto;
import com.grocery.Grocery.entity.GroceryEntity;
import com.grocery.Grocery.repository.GroceryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GroceryServiceImpl implements GroceryService{

    private final GroceryRepository groceryRepository;
    private final ModelMapper modelMapper;

    public GroceryServiceImpl(ModelMapper modelMapper,GroceryRepository groceryRepository){
        this.groceryRepository = groceryRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public List<GroceryDto> getAllGroceryItem() {
        List<GroceryEntity> groceryEntities = groceryRepository.findAll();
        return groceryEntities
                .stream()
                .map(groceryEntity -> modelMapper.map(groceryEntity, GroceryDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<GroceryDto> getGroceryByID(Long id) {
//        Optional<GroceryEntity> entity = groceryRepository.findById(id);
        return Optional.ofNullable(modelMapper.map(groceryRepository.findById(id), GroceryDto.class));
    }

    @Override
    public GroceryDto createGroceryItem(GroceryDto groceryDto) {
        GroceryEntity entity = modelMapper.map(groceryDto,GroceryEntity.class);
        return modelMapper.map(groceryRepository.save(entity),GroceryDto.class);
    }

    @Override
    public GroceryDto updateGroceryItem(Long id, GroceryDto groceryDto) {
        GroceryEntity entity = modelMapper.map(groceryDto,GroceryEntity.class);
        entity.setId(id);
        return modelMapper.map(groceryRepository.save(entity),GroceryDto.class);
    }

    @Override
    public boolean deleteGroceryById(Long id) {
        if(groceryRepository.existsById(id)){
            groceryRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
