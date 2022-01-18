package com.mpirixan.springjwt.repository;

import java.util.Optional;

import com.mpirixan.springjwt.models.ERole;
import com.mpirixan.springjwt.models.Role;

import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository {
    
    Optional<Role> findByname(ERole name);
}
