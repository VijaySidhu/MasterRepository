package com.google.interview.questions;

/**A robot on a plane has 2 types of commands: 
1. move forward by X units (X is integer 0 <= X <= 10000 ) 
2. rotate by X degrees (X is integer in range [-180, 180] ) 

 * Task is to detect if robot walks in a square. For that we need to find a cycle in path (360 turn) 
 * and if robot returns to origin after a while.
1. Start Robot looking North, Angle 0.
2. For each rotation move check if full cycle has been achieved >= 360 angle
3. Use a large treshold and test sample from i ... treshold times repeatedly.
4. If full turn not achieved return false
	Time: O(T * N) where T is the testing treshold and N array of moves size.
 */
public class DetectRobotCycle {
		
	public static void main(String[] args) {
		int m[] = {10, 180, 10};
		System.out.println(isWallPossible(m));

		int m1[] = {10, 45, 10, -45, 10, 45};
		System.out.println(isWallPossible(m1));
		
		int m2[] = {10, 45, 10, -45, 10, 45, 10, -45};
		System.out.println(isWallPossible(m2));		
	}
	
	public static boolean isWallPossible(int[] moves) {		
		int treshold = 10000;
		int i = 0;
		Position p = new Position(0, MoveDirection.N); // start north
		boolean rotate = false;

		while (i < treshold) {
			rotate = false;
			for (int j = 0; j < moves.length; j++) {
				if (rotate) {
					p.addAngle(moves[j]);
				} else {
					p.addSteps(moves[j]);					
				}
				rotate = !rotate;
			}
			if (p.cycled && p.x == 0 && p.y == 0) {
			   return true;	
			}		
			i++;
		}		
		return false;
	}

}
