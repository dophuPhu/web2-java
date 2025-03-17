// package com.example.ducphujava.Entity;

// import jakarta.persistence.*;
// import lombok.AllArgsConstructor;
// import lombok.Builder;
// import lombok.Data;
// import lombok.NoArgsConstructor;

// import java.util.List;

// @Data
// @Builder
// @NoArgsConstructor
// @AllArgsConstructor
// @Entity
// @Table(name = "carts")
// public class Cart {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     // Liên kết với entity User
//     private Long userId;

//     private boolean active; // Đổi tên từ isActive thành active
//     private double totalPrice;

//     @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
//     private List<CartItem> items;

//     // Các getter và setter
//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public Long getUserId() {
//         return userId;
//     }

//     public void setUserId(Long userId) {
//         this.userId = userId;
//     }

//     public boolean isActive() {
//         return active; // Sửa để trả về active
//     }

//     public void setActive(boolean active) {
//         this.active = active; // Sửa để gán giá trị cho active
//     }

//     public double getTotalPrice() {
//         return totalPrice;
//     }

//     public void setTotalPrice(double totalPrice) {
//         this.totalPrice = totalPrice;
//     }

//     public List<CartItem> getItems() {
//         return items;
//     }

//     public void setItems(List<CartItem> items) {
//         this.items = items;
//     }
// }

package com.example.ducphujava.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "carts")
@JsonIgnoreProperties({ "items" }) // Bỏ qua thuộc tính items khi tuần tự hóa
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Liên kết với entity User
    private Long userId;

    @Column(nullable = false)
    private boolean active = true; // Gán giá trị mặc định cho active

    private double totalPrice;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<CartItem> items = new ArrayList<>(); // Khởi tạo danh sách items

    // Không cần các getter và setter vì đã có @Data từ Lombok
}
