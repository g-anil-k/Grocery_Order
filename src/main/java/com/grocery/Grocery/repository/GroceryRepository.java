package com.grocery.Grocery.repository;

import com.grocery.Grocery.entity.GroceryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroceryRepository extends JpaRepository<GroceryEntity,Long> {
}
