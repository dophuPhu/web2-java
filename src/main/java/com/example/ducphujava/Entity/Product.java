package com.example.ducphujava.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false, unique = true)
    private String photo;

    @Column(nullable = false)
    private double price;

    // ID
    public Long getCategoryId() {
        return category != null ? category.getId() : null;
    }

    @JsonProperty("categoryName")
    public String getCategoryName() {
        return category != null ? category.getName() : "Không có danh mục";
    }

    // Quan hệ nhiều sản phẩm - một danh mục
    @ManyToOne
    @JsonBackReference // Để tránh vòng lặp khi serialize phía "Product"
    private Category category;

    // Quan hệ 1-1 với ProductQuantity
    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonManagedReference // Để kiểm soát hướng serialize từ phía Product
    private ProductQuantity productQuantity;

    // Constructor không tham số
    public Product() {
    }

    // Constructor với tham số
    public Product(String title, String description, String photo, double price, Category category) {
        this.title = title;
        this.description = description;
        this.photo = photo;
        this.price = price;
        this.category = category;
    }
}
