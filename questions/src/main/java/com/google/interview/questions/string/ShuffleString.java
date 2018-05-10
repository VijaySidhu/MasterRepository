package com.google.interview.questions.string;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class ShuffleString {

	public static void main(String[] args) {
		LinkedHashMap<Character, Integer> hm = new LinkedHashMap<Character, Integer>();
		StringBuilder strnew = new StringBuilder("");

		String str = "AAAAZZCCCCBB";
		int k = 0;
		for (int i = 0; i < str.length(); i++) {
			if (hm.isEmpty()) {
				hm.put(str.charAt(i), 1);
			} else {
				boolean val = hm.containsKey(str.charAt(i));
				if (val == false) {
					hm.put(str.charAt(i), 1);
				} else {
					hm.put(str.charAt(i), hm.get(str.charAt(i)) + 1);
				}
			}

		}

		Set<Character> set = hm.keySet();

		Iterator<Character> itr = set.iterator();

		int flag = 1;

		while (true) {
			flag = 1;
			itr = set.iterator();
			while (itr.hasNext()) {
				Character ch = itr.next();
				int val = hm.get(ch);

				if (val != 0) {

					strnew.insert(k, ch);
					if (k > 0) {
						// If the character placed is equal to the existing current character, then swap with the character at two positions behind.
						if (strnew.charAt(k) == strnew.charAt(k - 1)) {

							strnew.setCharAt(k, strnew.charAt(k - 3));
							strnew.setCharAt(k - 3, ch);
						}
					}
					k++;
					hm.put(ch, val - 1);

				}

				if ((val - 1) > 0) {
					flag = 0;
				}

			}

			if (flag == 1)
				break;
		}

		System.out.println("New String:- " + strnew);

	}
}
