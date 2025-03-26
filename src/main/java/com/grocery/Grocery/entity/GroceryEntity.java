package com.grocery.Grocery.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "Grocery")
@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
public class GroceryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String category;
    private Double price;
    private long quantity;

    @ManyToMany(mappedBy = "groceries")
    private Set<OrderEntity> orderList;
}
