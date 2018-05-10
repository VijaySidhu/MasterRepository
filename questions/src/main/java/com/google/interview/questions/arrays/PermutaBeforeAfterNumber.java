package com.google.interview.questions.arrays;

public class PermutaBeforeAfterNumber {
	// Check if array permutation exist such that
	// each element indicate either number of
	// elements before or after it.
	public static boolean check(int arr[]) {
		int n = arr.length;
		int[] freq = new int[n];

		// Finding the frequency of each number.
		for (int i = 0; i < n; i++)
			freq[arr[i]]++;

		for (int i = 0; i < n; i++) {
			// Try to find number of element before
			// the current index.
			if (freq[i] != 0)
				freq[i]--;

			// Try to find number of element after
			// the current index.
			else if (freq[n - i - 1] != 0)
				freq[n - i - 1]--;

			// If no such number find, return false.
			else
				return false;
		}

		return true;
	}

	//Driver program
	public static void main(String[] args) {

		int arr[] = { 1, 3, 3, 2 };
		boolean bool = check(arr);
		if (bool)
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
