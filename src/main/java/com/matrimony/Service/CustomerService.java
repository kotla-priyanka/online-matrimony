package com.matrimony.Service;

import java.util.List;


import com.matrimony.Entity.Customer;

public interface CustomerService {

	Customer saveCustomer(Customer customer);
	List<Customer> getAllCustomers();
	Customer getCustomerById(long id);
	Customer updateCustomer(Customer customer,long id);
	void deleteCustomer(long id);
	
	

}
