package com.google.interview.questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ClosestPairMethods {

	public static ArrayList<NodePoint> nodes = new ArrayList<NodePoint>();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = in.readLine()) != null) {
			String[] numbers = line.split("\\s");
			if (numbers.length == 1) {
				// one value; numPoints or 0? 
				int value = Integer.parseInt(line);
				if (value == 0) {
					// exit the program 
					findMinDistance();
					break;
				} else {
					// end the program for this input 
					if (!nodes.isEmpty()) {
						findMinDistance();
						// setup new data set 
						nodes.clear();
					}
				}
			} else {
				int x = Integer.parseInt(numbers[0]);
				int y = Integer.parseInt(numbers[1]);
				NodePoint newNode = new NodePoint(x, y);
				nodes.add(newNode);
			}
		}
	}

	public static void findMinDistance() {
		double minDistance = Double.MAX_VALUE;
		for (NodePoint node : nodes) {
			for (NodePoint otherNode : nodes) {
				if (node != otherNode) {
					double distance = node.getDistance(otherNode);
					if (distance < minDistance) {
						minDistance = distance;
					}
				}
			}
		}

		if (minDistance <= 10000) {
			System.out.println(String.format("%.4f", minDistance));
		} else {
			System.out.println("INFINITY");
		}
	}
}

class NodePoint {

	private int myX, myY;

	public NodePoint(int x, int y) {
		myX = x;
		myY = y;
	}

	public double getDistance(NodePoint other) {
		int x1, x2, y1, y2;
		x1 = myX;
		y1 = myY;
		x2 = other.getXCoord();
		y2 = other.getYCoord();

		int base = Math.abs(x1 - x2);
		int height = Math.abs(y1 - y2);
		double myDistance = Math.sqrt(Math.pow(base, 2.0) + Math.pow(height, 2.0));

		return myDistance;
	}

	public int getXCoord() {
		return myX;
	}

	public int getYCoord() {
		return myY;
	}

}
