package com.angular7.customerapp.repositories;

import com.angular7.customerapp.models.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserDetails,Long> {
    @Query("from UserDetails  u where u.isActive=1")
    public List<UserDetails> getAllByIsActive();
    @Query("from UserDetails u where u.email =: email AND u.password =: password AND u.isActive = 1")
    public UserDetails getLoggedIn(String email,String password);
}
