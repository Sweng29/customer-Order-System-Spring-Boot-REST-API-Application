package com.angular7.customerapp.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Orders_table")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue
    private Long orderId;
    private String orderName;
    private String orderDate;
    private Integer isActive;
    @OneToOne(mappedBy = "order")
    private OrderDetails orderDetails;
    @ManyToOne
    @JoinColumn(name = "customerId",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Customer customer;
}
