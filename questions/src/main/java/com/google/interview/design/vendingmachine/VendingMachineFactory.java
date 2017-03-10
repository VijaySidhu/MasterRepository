package com.google.interview.design.vendingmachine;

public class VendingMachineFactory {
	
	public static VendingMachine createVendingMachine() {
		return new VendingMachineImpl();
	}

}
