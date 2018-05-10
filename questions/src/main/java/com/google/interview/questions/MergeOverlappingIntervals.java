package com.google.interview.questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * a collection of intervals, merge all overlapping intervals. For example,
 * Given [1,3],[2,6],[8,10],[15,18], return [1,6],[8,10],[15,18].
 * 
 * @author VijaySidhu
 *
 */
public class MergeOverlappingIntervals {

	public static void main(String[] args) {
		Interval invl1 = new Interval();
		Interval invl2 = new Interval(1, 3);
		Interval invl3 = new Interval(2, 6);
		Interval invl4 = new Interval(8, 10);
		Interval invl5 = new Interval(15, 18);
		MergeOverlappingIntervals mi = new MergeOverlappingIntervals();
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(invl1);
		intervals.add(invl2);
		intervals.add(invl3);
		intervals.add(invl4);
		intervals.add(invl5);
		List<Interval> mergedIntervals = mi.merge(intervals);
		for (Interval intrv : mergedIntervals) {
			System.out.println("Start::" + intrv.start + " End::" + intrv.end);
		}

	}

	public List<Interval> merge(List<Interval> intervals) {
		/*
		 * If there is only one object then no work to merge
		 */
		if (intervals == null || intervals.size() < 2) {
			return intervals;
		}

		Collections.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval lhs, Interval rhs) {
				return lhs.start - rhs.start;
			}
		});

		for (int i = 0; i < intervals.size() - 1; i++) {
			if (intervals.get(i).end >= intervals.get(i + 1).start) {
				intervals.get(i).end = Math.max(intervals.get(i).end, intervals.get(i + 1).end);
				intervals.remove(intervals.get(i + 1));
				i--;
			}

		}
		return intervals;
	}

}
