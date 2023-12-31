package com.boots.repository;

import com.boots.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role,Long > {
    List<Role> findByName(String name);
}
