package com.matrimony.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matrimony.Entity.Customer;
import com.matrimony.Exception.ResourceNotFoundException;
import com.matrimony.Repository.CustomerRepository;
import com.matrimony.Service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}


	@Override
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
		
	}


	@Override
	public List<Customer>getAllCustomers(){
		return customerRepository.findAll();
	}
	
	
	@Override
	public Customer getCustomerById(long id) {
		
		return customerRepository.findById(id).orElseThrow(() ->
		                new ResourceNotFoundException("Customer","Id",id));
			
		}


	@Override
	public Customer updateCustomer(Customer customer, long id) { 
		Customer cus = customerRepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Customer", "Id", id));
		
		cus.setFirstName(customer.getFirstName());
		cus.setLastName(customer.getLastName());
		cus.setPassword(customer.getPassword());
		cus.setEmailId(customer.getEmailId());
		cus.setCaste(customer.getCaste());
		cus.setReligion(customer.getReligion());
		cus.setEducation(customer.getEducation());
		cus.setLanguage(customer.getLanguage());
		cus.setLocation(customer.getLocation());
		cus.setGender(customer.getGender());
		cus.setHeight(customer.getHeight());
		cus.setWeight(customer.getWeight());
		cus.setProfession(customer.getProfession());
		cus.setCountry(customer.getCountry());
		cus.setPlans(customer.getPlans());
		
		customerRepository.save(cus);
		return cus;
	}


	@Override
	public void deleteCustomer(long id) {
		
		customerRepository.findById(id).orElseThrow(() -> 
		                      new ResourceNotFoundException("Customer","id",id));
		customerRepository.deleteById(id);
		
	}
		
	}
	

	


