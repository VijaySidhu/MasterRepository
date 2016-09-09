package com.google.interview.questions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class KNearestDuplicate {
	public static String checkDuplicateWithinK(int[][] mat, int k){
		class Cell{
			int row;
			int col;
			public Cell(int r, int c){
				this.row = r;
				this.col = c;
			}
		}
		
		int n = mat.length;
		int m = mat[0].length;
		k = Math.min(k, n*m);
		
		//map from distance to cell postions of the matrix
		Map<Integer, Set<Cell>> slidingWindow = new HashMap<Integer, Set<Cell>>();
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				if(slidingWindow.containsKey(mat[i][j])){
					for(Cell c : slidingWindow.get(mat[i][j])){
						int manhattanDist = Math.abs(i - c.row)+Math.abs(j - c.col);
						
						if(manhattanDist <= k){
							return "Yes";
						}
						
						if(i - c.row > k){
							slidingWindow.remove(c);
						}
					}
					
					slidingWindow.get(mat[i][j]).add(new Cell(i, j));
				}
				else{
					slidingWindow.put(mat[i][j], new HashSet<Cell>());
					slidingWindow.get(mat[i][j]).add(new Cell(i, j));
				}
			}
		}
		
		return "No";
	}

	public static void main(String[] a) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] mat = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				mat[i][j] = in.nextInt();
			}
		}

		int k = in.nextInt();
		in.close();
		System.out.println(checkDuplicateWithinK(mat, k));
	}
}
