package com.google.interview.questions.mathproblems;

class Coordinates {
	private int x;
	private int y;

	public Coordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}

public class FourPointsFormSquare {
	public boolean isSquare(Coordinates[] cordinates) {
		Coordinates startPoint = cordinates[0];
		int a1 = distanceSquare(startPoint, cordinates[1]);
		int a2 = distanceSquare(startPoint, cordinates[2]);
		int a3 = distanceSquare(startPoint, cordinates[3]);

		if (a1 == a2) { //then 0,3 is diagonal
			return compare(cordinates[3], cordinates[1], cordinates[2], a1, a3);
		} else if (a1 == a3) {
			return compare(cordinates[2], cordinates[1], cordinates[3], a1, a2);
		} else if (a2 == a3) {
			return compare(cordinates[1], cordinates[2], cordinates[3], a2, a1);
		} else {
			return false;
		}
	}

	private boolean compare(Coordinates startPoint, Coordinates point1, Coordinates point2, int len, int diag) {
		if (2 * len != diag) {
			return false;
		}
		int a1 = distanceSquare(startPoint, point1);
		int a2 = distanceSquare(startPoint, point2);
		if (a1 != len || a2 != len) {
			return false;
		}
		return true;
	}

	private int distanceSquare(Coordinates c1, Coordinates c2) {
		return (int) (Math.pow(Math.abs(c1.getX() - c2.getX()), 2) + Math.pow(Math.abs(c1.getY() - c2.getY()), 2));
	}

	public static void main(String args[]) {
		FourPointsFormSquare fpf = new FourPointsFormSquare();
		Coordinates c1 = new Coordinates(2, 2);
		Coordinates c2 = new Coordinates(6, 2);
		Coordinates c3 = new Coordinates(2, -2);
		Coordinates c4 = new Coordinates(6, -2);
		Coordinates[] c = new Coordinates[4];
		c[0] = c1;
		c[1] = c2;
		c[2] = c3;
		c[3] = c4;
		System.out.println(fpf.isSquare(c));
	}
}
