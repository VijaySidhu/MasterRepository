package com.google.interview.questions.problemsolving;

public class Point implements Comparable {

	double x, y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	double distanceFromOrigin() {
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}

	@Override
	public int compareTo(Object other) {
		if (!(other instanceof Point)) {
			throw new IllegalArgumentException("Points can only be compared with other points.");
		}
		double diff = (distanceFromOrigin() - ((Point) other).distanceFromOrigin());
		if (diff == 0) {
			return 0;
		} else {
			return diff > 0 ? 1 : -1;
		}
	}

}
