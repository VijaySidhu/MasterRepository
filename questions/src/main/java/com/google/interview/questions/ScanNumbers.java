package com.google.interview.questions;

import java.util.Scanner;

public class ScanNumbers {

	public static int[] getScannedNumbersArray() {
		int[] array;
		int n;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter number of elements");
		n = in.nextInt();
		// Initialize Array Size
		array = new int[n];
		System.out.println("Enter " + n + " integers");
		for (int i = 0; i < n; i++) {
			array[i] = in.nextInt();
		}
		return array;
	}

	public static int[] swapNumbers(int i, int j, int[] array) {
		int temp;
		temp = array[i];
		array[i] = array[j];
		array[j] = temp;
		return array;
	}

	public static void printArray(int[] array, String message) {
		System.out.println(message);
		for (int i = 0; i <= array.length - 1; i++) {
			System.out.print(array[i] + " ");
		}

	}

}
