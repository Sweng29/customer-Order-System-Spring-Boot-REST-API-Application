package com.angular7.customerapp.controllers;

import com.angular7.customerapp.models.ResponseEntity;
import com.angular7.customerapp.models.UserDetails;
import com.angular7.customerapp.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    private UserService userService;
    private ResponseEntity<UserDetails> responseEntity;

    public UserController(UserService userService) {
        this.userService = userService;
        this.responseEntity = new ResponseEntity<>();
    }

    public List<UserDetails> getAllUsers()
    {
        return userService.getAll();
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResponseEntity<UserDetails> getLoggedIn(@RequestBody UserDetails userDetails)
    {
        if(userDetails!=null)
        {
           userDetails = userService.getLoggedIn(userDetails.getEmail(),userDetails.getPassword());
           responseEntity.setStatus("200");
           responseEntity.setMessage("success");
           responseEntity.setResult(Arrays.asList(userDetails));
           return responseEntity;
        }
        responseEntity.setStatus("201");
        responseEntity.setMessage("failed");
        responseEntity.setResult(null);
        return responseEntity;
    }
}
