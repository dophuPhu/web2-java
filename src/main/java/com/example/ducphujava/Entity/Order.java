package com.example.ducphujava.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table; // Import thêm annotation Table
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Setter
@Getter
@Entity
@Table(name = "orders") // Chỉ định tên bảng nếu tên không khớp
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    // @ManyToOne
    // @JoinColumn(name = "user_id", referencedColumnName = "userId", insertable =
    // false, updatable = false)
    // private User user;

    private String address;
    private String phone;
    private String email;
    private String note;
    private Double totalPrice;
    @ManyToOne
    private Payment payment;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<OrderDetail> orderDetails;
}
