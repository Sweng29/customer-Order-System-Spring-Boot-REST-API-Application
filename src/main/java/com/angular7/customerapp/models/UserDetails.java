package com.angular7.customerapp.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "user_details")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDetails {
    @Id
    @GeneratedValue
    private Long userId;
    @Column(unique = true,nullable = false)
    @NotBlank(message = "user name should be unique nad not be null")
    private String userName;
    //@Pattern(regexp = "DD/MM/YYYY",message = "Date of birth should be in DD/MM/YYYY format")
    private String dateOfBirth;
    @Email(message = "Email address should be unique and not null")
    @Column(nullable = false,unique = true)
    private String email;
    @NotBlank(message = "Password must not be empty")
    private String password;
    @Column(length = 1)
    private Integer isActive;
}
