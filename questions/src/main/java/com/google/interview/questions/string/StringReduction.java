package com.google.interview.questions.string;

/**
 * If the string cannot be reduced
 * further, then all letters in the
 * string are the same. 
 * Now if all
 * characters are present an even number
 * of times, or an odd number of times,
 * the only answer that is possible is
 * 2, because (0, 2, 0) is (even, even,
 * even) while (0, 1, 0) is (even, odd,
 * even) so only 2 preserves this
 * evenness.
 * all other cases 1
 * Time Complexity = O(n)
Auxiliary Space = O(1)
 * @author VijaySidhu
 *
 */
public class StringReduction {

	static int stringReduction(String str) {
		int n = str.length();
		// Count occurance of three chars
		int count[] = new int[3];
		for (int i = 0; i < n; i++) {
			count[str.charAt(i) - 'a']++;
		}
		// If all char are same
		if (count[0] == n || count[1] == n || count[2] == n)
			return n;
		// If all characters are present even number
		// of times or all are present odd number of
		// times.
		if ((count[0] % 2) == (count[1] % 2) && (count[1] % 2) == (count[2] % 2))
			return 2;
		return 1;
	}

	public static void main(String[] args) {
		String str = "abcbbaacb";
		System.out.println(stringReduction(str));
	}

}
