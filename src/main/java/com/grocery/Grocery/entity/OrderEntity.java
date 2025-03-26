package com.grocery.Grocery.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Orders")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate orderDate;
    private double totalPrice;

    @ManyToOne
    @JoinColumn(name = "Customer_order")
    private CustomerEntity customerOrder;

    @ManyToMany
    @JoinTable(name = "order_grocery_mapping",
                joinColumns = @JoinColumn(name = "grocery_id"),
                inverseJoinColumns = @JoinColumn(name = "order_id")
                )
    private Set<GroceryEntity> groceries;
}
