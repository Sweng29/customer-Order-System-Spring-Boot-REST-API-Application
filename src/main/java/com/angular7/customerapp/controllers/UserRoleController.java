package com.angular7.customerapp.controllers;

import com.angular7.customerapp.models.ResponseEntity;
import com.angular7.customerapp.models.Role;
import com.angular7.customerapp.models.UserRole;
import com.angular7.customerapp.services.UserRoleService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/user-roles")
public class UserRoleController {

    private UserRoleService userRoleService;
    private ResponseEntity<UserRole> responseEntity;
    private List<UserRole> userRoleList;

    public UserRoleController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
        this.responseEntity = new ResponseEntity<>();
        this.userRoleList = new ArrayList<>();
    }

    @RequestMapping(value = {"/",""},method = RequestMethod.GET)
    public ResponseEntity<UserRole> getAllUserRoles()
    {
        userRoleList = userRoleService.getAll();
        if (userRoleList.size() > 0){
            responseEntity.setStatus("200");
            responseEntity.setMessage("success");
            responseEntity.setResult(userRoleList);
            return responseEntity;
        }else{
            responseEntity.setStatus("201");
            responseEntity.setMessage("failed");
            responseEntity.setResult(null);
            return responseEntity;
        }
    }

    @RequestMapping(value = "/user-role/{id}",method = RequestMethod.GET)
    public ResponseEntity<UserRole> getUsersByRoleId(@RequestParam Long id)
    {
        if(id != null && id >0)
        {
            responseEntity.setStatus("200");
            responseEntity.setMessage("success");
            responseEntity.setResult(userRoleList);
            return responseEntity;
        }else{
            responseEntity.setStatus("201");
            responseEntity.setMessage("failed");
            responseEntity.setResult(null);
            return responseEntity;
        }
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public ResponseEntity<UserRole> addUserRole(@RequestBody UserRole userRole)
    {
        if(userRole != null)
        {
            responseEntity.setStatus("200");
            responseEntity.setMessage("success");
            responseEntity.setResult(userRoleList);
            return responseEntity;
        }else{
            responseEntity.setStatus("201");
            responseEntity.setMessage("failed");
            responseEntity.setResult(null);
            return responseEntity;
        }
    }

    @RequestMapping(value = "/",method = RequestMethod.PUT)
    public ResponseEntity<UserRole> updateUserRole(@RequestBody UserRole userRole)
    {
        if (userRole !=null && userRole.getUserRoleId() != null)
        {
            responseEntity.setStatus("200");
            responseEntity.setMessage("success");
            responseEntity.setResult(userRoleList);
            return responseEntity;
        }else{
            responseEntity.setStatus("201");
            responseEntity.setMessage("failed");
            responseEntity.setResult(null);
            return responseEntity;
        }
    }

    @RequestMapping(value = "/user-role/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<UserRole> deleteUserRoleByRoleId(@RequestParam Long id)
    {
        if (id != null && id > 0)
        {
            responseEntity.setStatus("200");
            responseEntity.setMessage("success");
            responseEntity.setResult(userRoleList);
            return responseEntity;
        }else {
            responseEntity.setStatus("201");
            responseEntity.setMessage("failed");
            responseEntity.setResult(null);
            return responseEntity;
        }
    }

    @RequestMapping(value = "/user-role/user/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<UserRole> deleteAllRolesByUserId(@RequestParam Long id)
    {
        if (id != null && id > 0)
        {
            responseEntity.setStatus("200");
            responseEntity.setMessage("success");
            responseEntity.setResult(userRoleList);
            return responseEntity;

        }else {
            responseEntity.setStatus("201");
            responseEntity.setMessage("failed");
            responseEntity.setResult(null);
            return responseEntity;
        }
    }

    @RequestMapping(value = "/user-role/user/{id}",method = RequestMethod.GET)
    public ResponseEntity<UserRole> getRolesByUserId(@RequestParam Long id)
    {
        if (id != null && id > 0)
        {
            responseEntity.setStatus("200");
            responseEntity.setMessage("success");
            responseEntity.setResult(userRoleList);
            return responseEntity;
        }else {
            responseEntity.setStatus("201");
            responseEntity.setMessage("failed");
            responseEntity.setResult(null);
            return responseEntity;
        }
    }
}
