package com.angular7.customerapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderDetails {

    @Id
    @GeneratedValue
    private Long orderDetailId;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Order order;
    @OneToMany(mappedBy = "orderDetails", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Item> items;
    private Integer isActive;

}
