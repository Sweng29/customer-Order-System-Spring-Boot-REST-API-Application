package com.angular7.customerapp.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderDetails {

    @Id
    @GeneratedValue
    private Long orderDetailId;
    @OneToOne
    @JoinColumn(name = "orderId",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Order order;
    private Integer isActive;

}
