package com.test.mysql;

public interface CustomerDAO {
	
	public void insert(Customer customer);

	public Customer findByCustomerId(int custId);
}
