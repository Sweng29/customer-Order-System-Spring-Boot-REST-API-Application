package com.angular7.customerapp.services;

import com.angular7.customerapp.generics.Generic;
import com.angular7.customerapp.models.UserRole;
import com.angular7.customerapp.repositories.UserRoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserRoleService implements Generic<UserRole> {

    private UserRoleRepository userRoleRepository;

    public UserRoleService(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public List<UserRole> getAll() {
        return userRoleRepository.getAllByIsActive();
    }

    @Override
    public UserRole saveOrUpdate(UserRole entity) {
        return userRoleRepository.save(entity);
    }

    @Override
    public boolean deleteById(Long id) {
        userRoleRepository.deleteById(id);
        return true;
    }

    @Override
    public UserRole findById(Long id) {
        return userRoleRepository.findById(id).get();
    }

    public List<UserRole> getRolesByUserId(Long userId) {
        return userRoleRepository.getAllRolesByUserId(userId);
    }

}
