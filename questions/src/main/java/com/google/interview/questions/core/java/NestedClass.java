package com.google.interview.questions.core.java;

public class NestedClass {

	private int id;

	static final String CONSTANT = "";

	// Static NEsted Class
	static class NestedStatic {

	}

	// Inner class
	class InnerClass {

	}

	// local inner class
	//A local inner class can access all the members of the enclosing class and local final variables in the scope it’s defined.
	public void print() {
		class Local {
			String name;
		}
		Local logger = new Local();
	}

	//Static class object can be created with following statement.
	public static void main(String[] args) {
		NestedClass.NestedStatic nestedStatic = new NestedClass.NestedStatic();

		NestedClass outer = new NestedClass();
		NestedClass.InnerClass innerClass = outer.new InnerClass();
	}
}
