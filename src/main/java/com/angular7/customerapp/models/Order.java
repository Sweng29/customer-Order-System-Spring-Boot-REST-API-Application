package com.angular7.customerapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

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
    @JsonIgnore
    @OneToOne(mappedBy = "order", fetch = FetchType.LAZY)
    private OrderDetails orderDetails;

    /*
     *  Added due to cause :
     *  while testing for api/customers it was fetching all the realted order and order details
     *  of a customer
     * */

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerId",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Customer customer;
}
