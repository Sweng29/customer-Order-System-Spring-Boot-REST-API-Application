package com.angular7.customerapp.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Products")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue
    private Long productId;
    @NotBlank(message = "Product name should not be null")
    private String productName;
    private String manufactureDate;
    private String expiryDate;
    @NotBlank(message = "Price should not be null")
    private String price;
    @Column(length = 1)
    private Integer isActive;
}
