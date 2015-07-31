package com.test.mysql;

public class Customer {
	public Customer(int int1, String string, int int2) {
		this.setAge(12);
		this.setCustId(13);
		this.setName("Vijay");
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	int custId;
	String name;
	int age;

}