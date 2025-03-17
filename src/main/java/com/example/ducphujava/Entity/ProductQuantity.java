package com.example.ducphujava.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product_quantities")
public class ProductQuantity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "product_id", nullable = false)
    @JsonBackReference // Để tránh vòng lặp khi serialize từ phía ProductQuantity
    private Product product;

    @Column(nullable = false)
    private int quantity;

    public Long getProductById() {
        return product != null ? product.getId() : null;
    }

    @JsonProperty("productName")
    public String getProducts() {
        return product != null ? product.getTitle() : "Không có danh mục";
    }

    // Constructor không tham số
    public ProductQuantity() {
    }

    // Constructor với tham số
    public ProductQuantity(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}
