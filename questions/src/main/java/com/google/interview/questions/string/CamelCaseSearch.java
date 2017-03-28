package com.google.interview.questions.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CamelCaseSearch {
	public static void main(String args[]) {
		ArrayList<String> list = new ArrayList<String>();
		Map<String, List<Integer>> map = new HashMap();
		list.add("HiHello");
		list.add("HelloYou");
		list.add("HelloYouThere");
		ArrayList<String> patternList = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		String pattern = sc.next();

		/*
		 * for (String s : list) { CamelCaseIndex ci = new CamelCaseIndex(s);
		 * String input = ci.getInput(); List<Integer> indexes =
		 * ci.getIndexes(); map.put(input, indexes); for (int i = 0; i <
		 * pattern.length(); i++) { for (Integer ind : indexes) { if
		 * (pattern.charAt(i) == input.charAt(ind)) {
		 * 
		 * } }
		 * 
		 * }
		 * 
		 * }
		 */

		int flag = 0;
		for (int i = 0; i < list.size(); i++) {
			String s = list.get(i);
			int len = 0;
			int pattern_len = pattern.length() - 1;
			int pat = 0;
			while ((len != s.length() - 1 && pat != pattern.length() - 1) || flag != 1) {
				if (s.charAt(len) == pattern.charAt(pat)) {
					len++;
					if (pat < pattern_len) {
						pat++;
					} else
						break;
				} else if (len != 0 && pat != 0 && len != s.length() - 1)
					len++;
				else
					flag = 1;
			}
			if (flag == 0) {
				patternList.add(s);
			} else
				flag = 0;
		}

		System.out.println(patternList);

	}
}
