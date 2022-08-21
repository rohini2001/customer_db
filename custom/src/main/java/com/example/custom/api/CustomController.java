package com.example.custom.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.custom.dto.CardDTO;
import com.example.custom.dto.CustomerDTO;
import com.example.custom.exception.BarclaysException;
import com.example.custom.service.CardCustomerService;

/**
 * 
 * @author Admin
 *
 */
@RestController
@RequestMapping("/api/customer")
public class CustomController {
	
	@Autowired
	CardCustomerService cardCustomerService;
	

	
	@GetMapping("/{customerId}")
	public ResponseEntity<CustomerDTO> getCustomer(@PathVariable Integer customerId) throws BarclaysException {
		CustomerDTO customer = cardCustomerService.getCustomerDetails(customerId);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	@PostMapping( "/")
	public ResponseEntity<Integer> addCustomer(@RequestBody CustomerDTO customer) throws BarclaysException {
		Integer id = cardCustomerService.addCustomer(customer);
		return new ResponseEntity<>(id, HttpStatus.OK);
	}
	
	
	@PostMapping("{customerId}/newcard")
	public ResponseEntity<String> issueCard(@PathVariable Integer customerId, @RequestBody CardDTO card) throws BarclaysException {
		cardCustomerService.issueCardToExistingCustomer(customerId, card);
		return new ResponseEntity<>("Card issued successfully", HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{customerId}")
	public ResponseEntity<String> deleteCustomer(@PathVariable Integer customerId) throws BarclaysException {
		cardCustomerService.deleteCustomer(customerId);
		return new ResponseEntity<>("Customer deleted successfully", HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{customerId}/cards")
	public ResponseEntity<String> deleteCustomerCards(@PathVariable Integer customerId, @RequestBody List<Integer> cardIds) throws BarclaysException {
		cardCustomerService.deleteCardOfExistingCustomer(customerId, cardIds);
		return new ResponseEntity<>("Card deleted successfully", HttpStatus.OK);
	}
}
