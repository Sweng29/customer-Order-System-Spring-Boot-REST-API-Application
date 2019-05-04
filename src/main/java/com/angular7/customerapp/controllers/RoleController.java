package com.angular7.customerapp.controllers;

import com.angular7.customerapp.models.ResponseEntity;
import com.angular7.customerapp.models.Role;
import com.angular7.customerapp.services.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/roles")
public class RoleController {

    private RoleService roleService;
    private ResponseEntity<Role> responseEntity;
    private List<Role> roleList;


    public RoleController(RoleService roleService) {
        this.roleService = roleService;
        responseEntity = new ResponseEntity<>();
        roleList = new ArrayList<>();
    }

    @RequestMapping(value = {"/",""},method = RequestMethod.GET)
    public ResponseEntity<Role> getAllRoles()
    {
        roleList = roleService.getAll();
        if (roleList.size() > 0){
            responseEntity.setStatus("200");
            responseEntity.setMessage("success");
            responseEntity.setResult(roleList);
            return responseEntity;
        }else{
            responseEntity.setStatus("201");
            responseEntity.setMessage("failed");
            responseEntity.setResult(null);
            return responseEntity;
        }
    }

    @RequestMapping(value = "/role/{id}",method = RequestMethod.GET)
    public ResponseEntity<Role> getRoleById(@RequestParam Long id)
    {
        if(id != null || id >0)
        {
            Role role = roleService.findById(id);
            if(role != null)
            {
                responseEntity.setStatus("200");
                responseEntity.setMessage("success");
                responseEntity.setResult(Arrays.asList(role));
            }else {
                responseEntity.setStatus("201");
                responseEntity.setMessage("failed");
                responseEntity.setResult(null);
            }
            return responseEntity;
        }else{
            responseEntity.setStatus("201");
            responseEntity.setMessage("failed");
            responseEntity.setResult(null);
            return responseEntity;
        }
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public ResponseEntity<Role> addRole(@RequestBody Role role)
    {
        if(role != null)
        {
            role = roleService.saveOrUpdate(role);
            if(role != null)
            {
                responseEntity.setStatus("200");
                responseEntity.setMessage("success");
                responseEntity.setResult(roleService.getAll());
            }else {
                responseEntity.setStatus("201");
                responseEntity.setMessage("failed");
                responseEntity.setResult(null);
            }
            return responseEntity;
        }else{
            responseEntity.setStatus("201");
            responseEntity.setMessage("failed");
            responseEntity.setResult(null);
            return responseEntity;
        }
    }

    @RequestMapping(value = "/",method = RequestMethod.PUT)
    public ResponseEntity<Role> updateRole(@RequestBody Role role)
    {
        if (role !=null && role.getRoleId() != null)
        {
            role = roleService.saveOrUpdate(role);
            if(role != null)
            {
                responseEntity.setStatus("200");
                responseEntity.setMessage("success");
                responseEntity.setResult(roleService.getAll());
            }else {
                responseEntity.setStatus("201");
                responseEntity.setMessage("failed");
                responseEntity.setResult(null);
            }
            return responseEntity;
        }else{
            responseEntity.setStatus("201");
            responseEntity.setMessage("failed");
            responseEntity.setResult(null);
            return responseEntity;
        }
    }

    @RequestMapping(value = "/role/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Role> deleteRole(@RequestParam Long id)
    {
        if (id != null && id > 0)
        {
            boolean role = roleService.deleteById(id);
            if(role)
            {
                responseEntity.setStatus("200");
                responseEntity.setMessage("success");
                responseEntity.setResult(roleService.getAll());
            }else {
                responseEntity.setStatus("201");
                responseEntity.setMessage("failed");
                responseEntity.setResult(null);
            }
            return responseEntity;

        }else {
            responseEntity.setStatus("201");
            responseEntity.setMessage("failed");
            responseEntity.setResult(null);
            return responseEntity;
        }
    }
}
