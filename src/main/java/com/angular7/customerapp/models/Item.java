package com.angular7.customerapp.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Items")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Item {
    @Id
    @GeneratedValue
    private Long itemId;
    @NotBlank(message = "Item name should not be null")
    private String itemName;
    private String manufactureDate;
    private String expiryDate;
    @NotBlank(message = "Price should not be null")
    private String price;
    @ManyToOne
    @JoinColumn(name = "orderDetailId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private OrderDetails orderDetails;
    @Column(length = 1)
    private Integer isActive;
}
