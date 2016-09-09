package com.google.interview.questions;

public class SetRowAndClmToZeroIfZero {
	
	public static void main(String[] args) {
		int[][] matrix={{2},{2},{2},{2},{0},
				 {2},{2},{2},{2},{0},
				 {2},{2},{2},{2},{2},
				 {2},{2},{2},{2},{2},
				 {2},{2},{2},{2},{2}};
		saveState(matrix);
		printMatrix(matrix, 5);
	}

	private static void saveState(int[][] matrix){
		int[] row = new int[matrix.length];
		int[] column = new int[matrix[0].length];
		for(int i=0; i < matrix.length; i++){
			for(int j=0 ; j <matrix[0].length;j++){
				if(matrix[i][j] == 0){
					row[i]=1;
					column[j]=1;
				}
			}
		}
		for(int i=0; i < matrix.length; i++){
			for(int j=0 ; j <matrix[0].length;j++){
				if(row[i]==1 || column[j]==1){
					matrix[i][j] = 0;
				}
			}
		}

		
	}
	
	public static void printMatrix(int[][] matrix,int n){
        System.out.print("\n");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(" "+matrix[i][j]);
            }
            System.out.print("\n");
        }
    }

}
