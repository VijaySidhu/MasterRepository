package com.google.interview.questions;

import java.util.Scanner;

public class RotateArray90 {
	// In place.
	// Relation matrix[i][j] = matrix[n-1-j][i] holds.
	static void rotateInPlace(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n / 2; ++i) {
			for (int j = i; j < n - 1 - i; ++j) {
				// save top
				int tmp = matrix[i][j];
				// left to top
				matrix[i][j] = matrix[n - 1 - j][i];
				// bottom to left
				matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
				// right to bottom
				matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
				// top to right
				matrix[j][n - 1 - i] = tmp;
			}
		}
		printArray(matrix);
	}
	
	 public static void printArray(int[][] a) {
	        for (int[] row : a) {
	            for (int col : row) {
	            	System.out.print(col + " ");
	                
	            }
	            System.out.println("");
	        }
	    }

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] mat = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				mat[i][j] = in.nextInt();
			}
		}
		rotateInPlace(mat);
		
	}

}
