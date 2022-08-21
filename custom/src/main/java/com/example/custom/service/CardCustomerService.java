package com.example.custom.service;

import java.util.List;

import com.example.custom.dto.CardDTO;
import com.example.custom.dto.CustomerDTO;
import com.example.custom.exception.BarclaysException;


	public interface CardCustomerService {
		public CustomerDTO getCustomerDetails(Integer customerId) throws BarclaysException;
		public Integer addCustomer(CustomerDTO customerDTO) throws BarclaysException;
		public void issueCardToExistingCustomer(Integer customerId, CardDTO cardDTO) throws BarclaysException;
		public void deleteCustomer(Integer customerId) throws BarclaysException;
		public void deleteCardOfExistingCustomer(Integer customerId, List<Integer> cardIdsToDelete) throws BarclaysException;	
			
	}


