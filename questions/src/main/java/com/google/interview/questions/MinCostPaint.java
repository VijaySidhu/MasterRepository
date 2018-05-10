package com.google.interview.questions;

/*
 * Problem
 * You are given a range [first, last], initially white. You need to paint it black. 
For this purpose you have a set of triples 
[(f, l, cost), ...] - where each triple means that you can paint range [f, l] for `cost` coins (limitations: cost is floating point >= 0, f, l, first, last are integers). 
Find minimum cost needed to paint the whole range [first, last] or return -1 if it's impossible 
Example:


[first, last] = [0, 5] and set of triples is
[[0, 5, 10], [0, 4, 1], [0, 2,5], [2, 5, 1]]
Clearly the answer is to take [0, 4, 1] and [2, 5, 1] - the total cost will be 2. 
Another example:


[first, last] = [0, 5]
triples are [[1,4, 10], [2, 5, 6]]
answer is -1, because it's impossible to color whole range.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*Greedy solution approach:
1. Filter all Triples not fit for selection (not within range) - O(n)
2. Sort triples according to weight formula (num. uncovered range length + cost). Best options will be picked first - O(n logn)
3. Keep removing triples from list while full range not covered and while list not empty.
Total Time: - O(n log n)*/

public class MinCostPaint {
	public static void main(String[] args) {
		Range r = new Range(0, 5);
		Triple t1 = new Triple(0, 5, 10);
		Triple t2 = new Triple(0, 4, 1);
		Triple t3 = new Triple(0, 2, 5);
		Triple t4 = new Triple(2, 5, 1);
		List<Triple> list = new ArrayList<Triple>();
		list.add(t1);
		list.add(t2);
		list.add(t3);
		list.add(t4);
		findMinCostPaint(r, list);

		Triple t2a = new Triple(1, 4, 10);
		Triple t2b = new Triple(2, 5, 6);
		List<Triple> list2 = new ArrayList<Triple>();
		list2.add(t2a);
		list2.add(t2b);
		findMinCostPaint(r, list2);
	}

	public static int findMinCostPaint(Range r, List<Triple> ts) {

		List<Triple> tss = new ArrayList<Triple>();
		for (Triple triple : ts) {
			if (triple.s >= r.s && triple.s < triple.e) {
				tss.add(triple);
			}
		}

		tss.sort(new TripleComparator(r));

		List<Triple> result = new ArrayList<Triple>();
		Map<Integer, Boolean> paintedMap = new HashMap<Integer, Boolean>();
		for (int i = r.s; i <= r.e; i++) {
			paintedMap.put(i, Boolean.FALSE);
		}
		int paintedCount = 0;
		int cost = 0;

		while (!tss.isEmpty() && paintedCount < paintedMap.size()) {
			Triple t = tss.remove(0);
			for (int i = t.s; i <= t.e; i++) {
				if (paintedMap.containsKey(i) && paintedMap.get(i).equals(Boolean.FALSE)) {
					paintedMap.put(i, Boolean.TRUE);
					paintedCount++;
				}
			}
			cost += t.cost;
			result.add(t);
		}

		if (paintedCount < paintedMap.size()) {
			System.out.println("No possible ranges");
			return -1;
		}

		for (Triple triple : result) {
			System.out.println("(" + triple.s + "," + triple.e + ")");
		}
		System.out.println("min cost = " + cost);

		return cost;
	}
}