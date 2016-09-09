package com.google.interview.questions;

import java.util.Comparator;

public class Dog implements Comparator<Dog>, Comparable<Dog> {

	private String dogName;

	private int dogAge;

	Dog() {

	}

	Dog(String name, int id) {
		this.dogName = name;
		this.dogAge = id;
	}

	public String getDogName() {
		return dogName;
	}

	public void setDogName(String dogName) {
		this.dogName = dogName;
	}

	public int getDogAge() {
		return dogAge;
	}

	public void setDogAge(int age) {
		this.dogAge = age;
	}

	/**
	 * This method comes from Comparator interface
	 */
	public int compare(Dog o1, Dog o2) {
		return o1.dogAge - o2.dogAge;
	}

	/**
	 * This method comes from Comparable
	 */
	public int compareTo(Dog o) {
		if (this.dogName.compareTo(o.getDogName()) > 0) {
			return -1;
		} else if (this.dogName.compareTo(o.getDogName()) == 0) {
			return 0;
		} else {
			return 1;
		}
	}

}
