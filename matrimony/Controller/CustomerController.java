package com.matrimony.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matrimony.Entity.Customer;
import com.matrimony.Exception.ResourceNotFoundException;
import com.matrimony.Repository.CustomerRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestControllerzz
@RequestMapping("/api/v1")
public class CustomerController {
	@Autowired
	private CustomerRepository customerRepository;

	@GetMapping("/getcustomers")
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	// http://localhost:8080/api/v1/addcustomers
	@PostMapping("/addcustomers")
	public Customer createCustomer(@RequestBody Customer customer) {
		return customerRepository.save(customer);
	}

	// http://localhost:8080/api/v1/getcustomerbyid/11
	@GetMapping("/getcustomers/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not exist with id :" + id));
		return ResponseEntity.ok(customer);
	}

	// http://localhost:8080/api/v1/updatecustomers/13
	@PutMapping("/updatecustomers/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customerDetails) {
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not exist with id :" + id));

		customer.setfirstName(customerDetails.getfirstName());
		customer.setLastName(customerDetails.getLastName());
		customer.setPassword(customerDetails.getPassword());
		customer.setEmailId(customerDetails.getEmailId());
		customer.setCaste(customerDetails.getCaste());
		customer.setReligion(customerDetails.getReligion());
		customer.setEducation(customerDetails.getEducation());
		customer.setLanguage(customerDetails.getLanguage());
		customer.setLocation(customerDetails.getLocation());
		customer.setGender(customerDetails.getGender());
		customer.setHeight(customerDetails.getHeight());
		customer.setWeight(customerDetails.getWeight());
		customer.setProfession(customerDetails.getProfession());
		customer.setCountry(customerDetails.getCountry());
		customer.setPlans(customerDetails.getPlans());

		Customer updatedCustomer = customerRepository.save(customer);
		return ResponseEntity.ok(updatedCustomer);
	}

//	http://localhost:8080/api/v1/deletecustomers/1
	@DeleteMapping("/deletecustomers/{id}")
	public void deletecustomerbyid(@PathVariable long id) {

		customerRepository.deleteById(id);
	}
}
