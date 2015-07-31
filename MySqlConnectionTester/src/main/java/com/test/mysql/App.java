package com.test.mysql;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");

		CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAOImpl");
		Customer customer = new Customer(1, "mkyong", 28);
		customerDAO.insert(customer);   

		Customer customer1 = customerDAO.findByCustomerId(1);
		System.out.println("Trying Commit  ");
		System.out.println(customer1);

	}
}
