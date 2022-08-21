package com.example.custom.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.custom.entity.Card;


public interface CardRepository extends CrudRepository<Card, Integer> {
	List<Card> findByCustomer_customerId(Integer customerId);
	void deleteByCustomer_customerId(Integer customerId);
}
