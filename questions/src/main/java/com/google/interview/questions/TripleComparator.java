package com.google.interview.questions;

import java.util.Comparator;

class TripleComparator implements Comparator<Triple> {

	private Range rangeToCover;

	public TripleComparator(Range rangeToCover) {
		super();
		this.rangeToCover = rangeToCover;
	}

	public int compare(Triple o1, Triple o2) {
		Integer o1RangeUnCovered = (rangeToCover.e - o1.e) + (o1.s - rangeToCover.s);
		if (o1RangeUnCovered < 0) {
			o1RangeUnCovered = rangeToCover.e - rangeToCover.s;
		}

		Integer o2RangeUnCovered = (rangeToCover.e - o2.e) + (o2.s - rangeToCover.s);
		if (o2RangeUnCovered < 0) {
			o2RangeUnCovered = rangeToCover.e - rangeToCover.s;
		}

		Integer o1Weight = o1RangeUnCovered + o1.cost;
		Integer o2Weight = o2RangeUnCovered + o2.cost;

		return o1Weight.compareTo(o2Weight);
	}
}