package com.google.interview.questions.arrays;

//Merge algorithm's time complexity is O(n + m)
/**
 * Introduce read-indices i, j to traverse arrays A and B, accordingly.
 * Introduce write-index k to store position of the first free cell in the
 * resulting array. By default i = j = k = 0. At each step: if both indices are
 * in range (i < m and j < n), choose minimum of (A[i], B[j]) and write it to
 * C[k]. Otherwise go to step 4. Increase k and index of the array, algorithm
 * located minimal value at, by one. Repeat step 2. Copy the rest values from
 * the array, which index is still in range, to the resulting array.
 * 
 * @author VijaySidhu
 *
 */
public class MergeSortedArrays {

	public void merge(int[] A, int[] B, int[] C) {
		int i, j, k, m, n;
		i = 0;
		j = 0;
		k = 0;
		m = A.length;
		n = B.length;
		while (i < m && j < n) {
			if (A[i] <= B[j]) {
				C[k] = A[i];
				i++;
			} else {
				C[k] = B[j];
				j++;
			}
			k++;
		}
		if (i < m) {
			for (int p = i; p < m; p++) {
				C[k] = A[p];
				k++;
			}
		} else {
			for (int p = j; p < n; p++) {
				C[k] = B[p];
				k++;
			}
		}
	}

	public static void main(String[] args) {
		int[] a = { 1, 3, 5, 7, 9 };
		int[] b = { 2, 4, 6, 8, 10 };
		int[] c = { 11, 12, 13 };

	}

}
