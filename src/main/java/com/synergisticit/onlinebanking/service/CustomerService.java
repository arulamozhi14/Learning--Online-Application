package com.synergisticit.onlinebanking.service;

import java.util.List;


import com.synergisticit.onlinebanking.domain.Customer;



public interface CustomerService {

	public void save(Customer customer);
	
	
	public Customer findById(int customerid);
	public boolean existsById(int customerid);
	
	
}
