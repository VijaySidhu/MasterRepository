package com.google.interview.questions.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class ArrayToBT {

	public static void main(String[] args) {
		//ArrayToBT.findMax(6, "3 4 5 1 3 # 1");
		
		//ArrayToBT.findMax(14, "3 4 5 1 2 6 5 # 4 3 # 1 # # #");
		ArrayToBT.findMax(6, "63 4 5 1 3 # 1");
		//System.out.println(ArrayToBT.findMax(6, "3 4 5 1 3 # 1"));
		//System.out.println(ArrayToBT.findMax(6, "3 2 3 # 3 # 1"));

	}

	static int findMax(int n, String tree) {

		Map<Integer, Integer> leftPoundsSum = new TreeMap<>();
		class Pair {
			int root;
			int i;
			int j;
			Integer sum;
			boolean isPoundLeftSide;
			boolean isPound;

			Pair(String root, String i, String j) {

				this.root = Integer.valueOf(root);
				if (false == "#".equals(i) && false == "#".equals(j)) {
					this.i = Integer.valueOf(i);
					this.j = Integer.valueOf(j);
					sum = this.i + this.j;
				} else if (true == "#".equals(i) && false == "#".equals(j)) {
					this.j = Integer.valueOf(j);
					isPoundLeftSide = true;
					isPound = true;
				}
			}

			public Integer getSum() {
				return sum;
			}

			public boolean isPound() {
				return isPound;
			}

			public boolean isPoundLeftSide() {
				return isPoundLeftSide;
			}

			public int getI() {
				return i;
			}

			public void setI(int i) {
				this.i = i;
			}

			public int getJ() {
				return j;
			}

			public void setJ(int j) {
				this.j = j;
			}
		}
		List<Pair> pairs = new ArrayList<>();
		Stack<Pair> st = new Stack<>();
		Map<Integer, Pair> map = new TreeMap<>();
		String[] arr = tree.split(" ");
		int length = arr.length;
		for (int i = 0; i < (length - 1) / 2; i++) {
			Pair pr = new Pair(arr[0], arr[i * 2 + 1], arr[i * 2 + 2]);
			if (false == pr.isPound) {
				if (pr.getSum() != null) {
					map.put(pr.getSum(), pr);
				}
			} else if (true == pr.isPoundLeftSide) {
				if (st.size() > 0) {
					Pair prStack = st.pop();
					int leftPoundSum = pr.getJ() + prStack.getJ() + pr.root;
					leftPoundsSum.put(leftPoundSum, leftPoundSum);
				} else {
					st.push(pr);
				}
			}
		}
		Pair result = (Pair) map.values().toArray()[map.size() - 1];
		Integer resultLeftPoundSum = 0;
		if (leftPoundsSum.size() > 0) {
			resultLeftPoundSum = (Integer) leftPoundsSum.values().toArray()[leftPoundsSum.size() - 1];
		}
		if (resultLeftPoundSum != null && resultLeftPoundSum != 0) {
			System.out.println(resultLeftPoundSum);
			return resultLeftPoundSum;
		}
		System.out.println(result.getSum());
		return result.getSum();
	}

}
