package com.grocery.Grocery.service;

import com.grocery.Grocery.dto.GroceryDto;
import com.grocery.Grocery.entity.GroceryEntity;

import java.util.List;
import java.util.Optional;

public interface GroceryService {
    List<GroceryDto> getAllGroceryItem();

    Optional<GroceryDto> getGroceryByID(Long id);

    GroceryDto createGroceryItem(GroceryDto groceryDto);

    GroceryDto updateGroceryItem(Long id, GroceryDto groceryDto);

    boolean deleteGroceryById(Long id);
}
