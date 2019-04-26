package com.angular7.customerapp.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Size;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ResponseEntity<T> {
    private String status;
    private String message;
    private List<T> result;
}
