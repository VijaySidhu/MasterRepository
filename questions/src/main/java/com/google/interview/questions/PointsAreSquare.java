package com.google.interview.questions;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PointsAreSquare {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		Point[] points = new Point[4];
		while ((line = in.readLine()) != null) {
			points[0] = new Point(Integer.valueOf(line.charAt(1)), Integer.valueOf(line.charAt(3)));
			points[1] = new Point(Integer.valueOf(line.charAt(8)), Integer.valueOf(line.charAt(10)));
			points[2] = new Point(Integer.valueOf(line.charAt(15)), Integer.valueOf(line.charAt(17)));
			points[3] = new Point(Integer.valueOf(line.charAt(22)), Integer.valueOf(line.charAt(24)));
			break;
		}

		int minX = Integer.MAX_VALUE;
		int maxX = Integer.MIN_VALUE;
		int minY = Integer.MAX_VALUE;
		int maxY = Integer.MIN_VALUE;
		// Find min/max x/y
		for (Point p : points) {
			minX = Math.min(minX, p.x);
			maxX = Math.max(maxX, p.x);
			minY = Math.min(minY, p.y);
			maxY = Math.max(maxY, p.y);
		}
		// Array of booleans to mark if 
		// we find points in cc direction starting at UL
		boolean[] found = new boolean[4];
		for (Point p : points) {
			//UL:minX, maxY
			if (p.x == minX && p.y == maxY)
				found[0] = true;
			//UR:maxX, maxY
			if (p.x == maxX && p.y == maxY)
				found[1] = true;
			//LR:maxX, minY
			if (p.x == maxX && p.y == minY)
				found[2] = true;
			//LL:minX, minY
			if (p.x == minX && p.y == minY)
				found[3] = true;
		}
		for (boolean b : found) {
			if (!b) {
				System.out.println(false);
				return;
			}
		}
		System.out.println(true);
	}
}