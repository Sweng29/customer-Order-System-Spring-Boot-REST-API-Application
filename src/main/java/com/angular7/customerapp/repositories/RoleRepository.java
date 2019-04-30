package com.angular7.customerapp.repositories;

import com.angular7.customerapp.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query("from Role r where r.isActive=1")
    List<Role> getAllByIsActive();

}
