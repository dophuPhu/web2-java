package com.example.ducphujava.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @ManyToOne
    // @JoinColumn(name = "order_id")
    // private Order order;
    @ManyToOne
    @JsonBackReference
    private Order order;

    // private Long productId;
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product; // Thay thế productId bằng mối quan hệ với Product
    private int quantity;
    private Double price;

    // Constructors, Getters, and Setters
}
