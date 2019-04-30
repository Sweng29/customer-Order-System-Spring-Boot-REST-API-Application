package com.angular7.customerapp.repositories;

import com.angular7.customerapp.models.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    @Query("from UserRole  u where u.isActive=1")
    List<UserRole> getAllByIsActive();

    @Query("from UserRole u where u.userDetails = ?1 AND u.isActive=1")
    List<UserRole> getAllRolesByUserId(Long userId);

}
