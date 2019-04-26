package com.angular7.customerapp.services;

import com.angular7.customerapp.generics.Generic;
import com.angular7.customerapp.models.UserDetails;
import com.angular7.customerapp.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService implements Generic<UserDetails> {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDetails> getAll() {
        return this.userRepository.getAllByIsActive();
    }

    @Override
    public UserDetails saveOrUpdate(UserDetails entity) {
        return this.userRepository.save(entity);
    }

    @Override
    public boolean deleteById(Long id) {
        this.userRepository.deleteById(id);
        return true;
    }

    @Override
    public UserDetails findById(Long id) {
        return this.userRepository.findById(id).get();
    }

    public UserDetails getLoggedIn(String email,String password)
    {
        UserDetails userDetails = this.userRepository.getLoggedIn(email,password);
        if(userDetails!=null)
            return userDetails;
        return null;
    }
}
