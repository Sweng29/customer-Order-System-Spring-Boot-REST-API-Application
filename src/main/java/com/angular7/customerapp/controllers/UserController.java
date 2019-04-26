package com.angular7.customerapp.controllers;

import com.angular7.customerapp.models.ResponseEntity;
import com.angular7.customerapp.models.UserDetails;
import com.angular7.customerapp.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "api/users")
public class UserController {

    private UserService userService;
    private ResponseEntity<UserDetails> responseEntity;

    public UserController(UserService userService) {
        this.userService = userService;
        this.responseEntity = new ResponseEntity<>();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<UserDetails> getAllUsers()
    {
        List<UserDetails> usersList = userService.getAll();
        if (usersList.size() > 0) {
            responseEntity.setStatus("200");
            responseEntity.setMessage("success");
            responseEntity.setResult(usersList);
            return responseEntity;
        }
        responseEntity.setStatus("201");
        responseEntity.setMessage("failed");
        responseEntity.setResult(null);
        return responseEntity;
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

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity<UserDetails> addUserDetails(@RequestBody UserDetails userDetails) {
        if (userDetails != null) {
            userDetails.setIsActive(1);
            userDetails = userService.saveOrUpdate(userDetails);
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

    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<UserDetails> updateUserDetails(@RequestBody UserDetails userDetails) {
        if (userDetails != null && userDetails.getUserId() != null) {
            userDetails = userService.saveOrUpdate(userDetails);
            responseEntity.setStatus("200");
            responseEntity.setMessage("success");
            responseEntity.setResult(Arrays.asList(userDetails));
        }
        responseEntity.setStatus("201");
        responseEntity.setMessage("failed");
        responseEntity.setResult(null);
        return responseEntity;
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<UserDetails> deleteUserDetails(@RequestParam Long id) {
        if (id != null) {
            if (userService.deleteById(id)) {
                responseEntity.setStatus("200");
                responseEntity.setMessage("success");
                responseEntity.setResult(userService.getAll());
                return responseEntity;
            }
        }
        responseEntity.setStatus("201");
        responseEntity.setMessage("failed");
        responseEntity.setResult(null);
        return responseEntity;
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDetails> getUserDetailsById(@RequestParam Long id) {
        if (id != null) {
            UserDetails userDetails = userService.findById(id);
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
