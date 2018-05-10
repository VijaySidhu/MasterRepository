package com.google.interview.questions;
class Position {
	int x;
	int y;
	
	int angle;
	MoveDirection d;
	boolean cycled;
	
	public Position(int angle, MoveDirection d) {
		super();
		x = y = 0;
		this.angle = angle;
		this.d = d;
		this.cycled = false; 
	}

	public void addSteps(int s) {
		if (d.equals(MoveDirection.N)) {
			y += s;
		} else if (d.equals(MoveDirection.E)) {
			x += s;
		} else if (d.equals(MoveDirection.S)) {
			y -= s;
		} else if (d.equals(MoveDirection.W)) {
			x -= s;
		}
	}

	public void addAngle(int a) {
		angle += a;
		if (angle >= 360) {
			angle = angle % 360;
			cycled = true;
		}
		if(angle >= 0 && angle < 90) {
			d = MoveDirection.N;
		}
		else if(angle >= 90 && angle < 180) {
			d = MoveDirection.E;
		}
		else if(angle >= 180 && angle < 270) {
			d = MoveDirection.S;
		}
		else if(angle >= 270 && angle < 360) {
			d = MoveDirection.W;
		} 
	}
}
