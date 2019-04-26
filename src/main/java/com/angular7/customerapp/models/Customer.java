package com.angular7.customerapp.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue
    private Long customerId;
    private String customerName;
    private String dateOfBirth;
    private String address;
    private Integer isActive;
    @OneToMany(mappedBy = "customer")
    private Set<Order> orders;

}
