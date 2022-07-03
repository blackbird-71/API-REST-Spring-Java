package com.api.rest.example.repositories;

import org.springframework.stereotype.Repository;

import com.api.rest.example.entities.Address;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface AddressRepository extends CrudRepository<Address,Integer>{

}
