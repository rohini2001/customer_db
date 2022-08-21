package com.example.custom.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.custom.entity.Customer;


public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	
}
