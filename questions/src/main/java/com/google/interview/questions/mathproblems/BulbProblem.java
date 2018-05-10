package com.google.interview.questions.mathproblems;

/**
 * There are n bulbs that are initially off. You first turn on all the bulbs.
 * Then, you turn off every second bulb. On the third round, you toggle every
 * third bulb (turning on if it's off or turning off if it's on). For the nth
 * round, you only toggle the last bulb. Find how many bulbs are on after n
 * rounds. Example: Given n = 3.
 * 
 * At first, the three bulbs are [off, off, off]. After first round, the three
 * bulbs are [on, on, on]. After second round, the three bulbs are [on, off,
 * on]. After third round, the three bulbs are [on, off, off].
 * 
 * So you should return 1, because there is only one bulb is on.
 * 
 * 
 * Translates to below question How many integer from 1 to n (inclusively)
 * having odd numbers of divisors?
 * 
 * Sol: We see that the ith bulb is switched (on to off, or off to on) in the
 * kth round if and only if i % k == 0. Initially the ith is on, so if i's
 * number of divisors is odd, it will be on after n rounds, otherwise it is off.
 * 
 * @author VijaySidhu
 *
 */
public class BulbProblem {
	public static int bulbSwitch(int n) {
		return (int) Math.sqrt(n);
	}

	public static void main(String[] args) {
		System.out.println(BulbProblem.bulbSwitch(3));
	}
}
