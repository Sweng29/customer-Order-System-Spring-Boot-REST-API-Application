package com.angular7.customerapp.services;

import com.angular7.customerapp.generics.Generic;
import com.angular7.customerapp.models.Role;
import com.angular7.customerapp.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements Generic<Role> {

    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.getAllByIsActive();
    }

    @Override
    public Role saveOrUpdate(Role entity) {
        return roleRepository.save(entity);
    }

    @Override
    public boolean deleteById(Long id) {
        roleRepository.deleteById(id);
        return true;
    }

    @Override
    public Role findById(Long id) {
        return roleRepository.findById(id).get();
    }
}
