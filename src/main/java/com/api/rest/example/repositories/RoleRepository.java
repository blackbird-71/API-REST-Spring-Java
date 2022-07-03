package com.api.rest.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.rest.example.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer>{

}
