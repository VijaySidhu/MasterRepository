package com.google.interview.questions.problemsolving;

import java.util.ArrayList;

/**
 * 1. Find the local minima and store it
 * as starting index. If not exists,
 * return. 2. Find the local maxima. and
 * store it as ending index. If we reach
 * the end, set the end as ending index.
 * 3. Update the solution (Increment
 * count of buy sell pairs) 4. Repeat
 * the above steps if end is not
 * reached.
 * 
 * Time Complexity: The outer loop runs
 * till i becomes n-1. The inner two
 * loops increment value of i in every
 * iteration. So overall time complexity
 * is O(n)
 * 
 * @author VijaySidhu
 *
 */
//Solution structure
class Interval {
	int buy, sell;
}

public class StockBuySell {
	// This function finds the buy sell schedule for maximum profit
	void stockBuySell(int price[], int n) {
		// Prices must be given for at least two days
		if (n == 1)
			return;

		int count = 0;

		// solution array
		ArrayList<Interval> sol = new ArrayList<Interval>();

		// Traverse through given price array
		int i = 0;
		while (i < n - 1) {
			// Find Local Minima. Note that the limit is (n-2) as we are
			// comparing present element to the next element. 
			while ((i < n - 1) && (price[i + 1] <= price[i]))
				i++;

			// If we reached the end, break as no further solution possible
			if (i == n - 1)
				break;

			Interval e = new Interval();
			e.buy = i++;
			// Store the index of minima

			// Find Local Maxima.  Note that the limit is (n-1) as we are
			// comparing to previous element
			while ((i < n) && (price[i] >= price[i - 1]))
				i++;

			// Store the index of maxima
			e.sell = i - 1;
			sol.add(e);

			// Increment number of buy/sell
			count++;
		}

		// print solution
		if (count == 0)
			System.out.println("There is no day when buying the stock " + "will make profit");
		else
			for (int j = 0; j < count; j++)
				System.out.println("Buy on day: " + sol.get(j).buy + "        " + "Sell on day : " + sol.get(j).sell);

		return;
	}

	public static void main(String args[]) {
		StockBuySell stock = new StockBuySell();

		// stock prices on consecutive days
		int price[] = { 100, 180, 260, 310, 40, 535, 695 };
		int n = price.length;

		// fucntion call
		stock.stockBuySell(price, n);
	}
}
