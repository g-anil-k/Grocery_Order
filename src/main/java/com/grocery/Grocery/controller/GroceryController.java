package com.grocery.Grocery.controller;


import com.grocery.Grocery.dto.GroceryDto;
import com.grocery.Grocery.service.GroceryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/grocery")
public class GroceryController {

    private final GroceryService groceryService;

    public GroceryController(GroceryService groceryService){
        this.groceryService = groceryService;
    }

    @GetMapping
    public ResponseEntity<List<GroceryDto>> getAllGroceryItems(){
        return ResponseEntity.ok(groceryService.getAllGroceryItem());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroceryDto> getGroceryById(@PathVariable Long id){
        Optional<GroceryDto> grocery = groceryService.getGroceryByID(id);
        return grocery.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<GroceryDto> createGroceryItem(@RequestBody GroceryDto groceryDto){
        return ResponseEntity.ok(groceryService.createGroceryItem(groceryDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GroceryDto> updateGroceryItem(@RequestBody GroceryDto groceryDto, @PathVariable Long id){
        return ResponseEntity.ok(groceryService.updateGroceryItem(id,groceryDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteGroceryById(@PathVariable Long id){
        Boolean result = groceryService.deleteGroceryById(id);
        if(result){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
    }















}
