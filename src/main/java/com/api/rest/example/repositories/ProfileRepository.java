package com.api.rest.example.repositories;

import org.springframework.stereotype.Repository;

import com.api.rest.example.entities.Profile;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface ProfileRepository extends CrudRepository<Profile,Integer>{

}
