package com.google.interview.questions.arrays;

public class InPlaceRemoval {

	public static int removeElement(int[] A, int elem) {
		int i = 0;
		int j = 0;

		while (j < A.length) {
			if (A[j] != elem) {
				A[i] = A[j];
				i++;
			}
			j++;
		}
		return i;
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(removeElement(array, 7));
	}
}
