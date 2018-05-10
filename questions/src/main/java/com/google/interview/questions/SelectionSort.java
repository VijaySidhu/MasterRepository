package com.google.interview.questions;
/**
 * Just Place Largest Element in array at 0th, 0th+1,...so on...
 * Time Complexity  Best, Avg, and Worst Cases ::: O(n^2)
 * Space Complexity: Best Case O(1) Worst Case O(n)
 * @author VijaySidhu
 *
 */
public class SelectionSort {

	public static void main(String[] args) {
		SelectionSort selectionSort = new SelectionSort();
		int[] unsortedArray = ScanNumbers.getScannedNumbersArray();
		ScanNumbers.printArray(selectionSort.sortedWithSelectionSort(unsortedArray), "After Sorting with Selection Sort");

	}

	private int[] sortedWithSelectionSort(int[] unsortedArray) {
		int size = unsortedArray.length;
		for (int i = 0; i < size - 1; i++) {
			int index = 0;
			for (int j = i + 1; j < size; j++) {
				if (unsortedArray[j] < unsortedArray[i]) {
					index = j;
				}
				int smallNumber = unsortedArray[index];
				unsortedArray[index] = unsortedArray[i];
				unsortedArray[i] = smallNumber;

			}

		}
		return unsortedArray;

	}

}
