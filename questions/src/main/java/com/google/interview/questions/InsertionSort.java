package com.google.interview.questions;

/**
 * Insertion Sort TimeComplexity Worst Case : O(n^2) Best Case : O(n), O(1)
 * Average Case: O(n^2) Worst Case Space: O(n), O(1) is auxilry
 * 
 * @author VijaySidhu
 *
 */
public class InsertionSort {

	public static void main(String[] args) {

		InsertionSort insetionSort = new InsertionSort();
		int[] unsortedArray = ScanNumbers.getScannedNumbersArray();
		ScanNumbers.printArray(insetionSort.sortWithInsertionSort(unsortedArray), "After Sorting with Insertion Sort");

	}

	/**
	 * 
	 * @param unsortedArray
	 * @return
	 */
	private int[] sortWithInsertionSort(int[] unsortedArray) {
		int size = unsortedArray.length;
		int temp;
		for (int i = 0; i < size; i++) {
			for (int j = i; j > 0; j--) {
				if (unsortedArray[j] < unsortedArray[j - 1]) {
					temp = unsortedArray[j];
					unsortedArray[j] = unsortedArray[j - 1];
					unsortedArray[j - 1] = temp;
				}

			}

		}

		return unsortedArray;
	}

}
