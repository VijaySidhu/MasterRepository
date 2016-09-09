package com.google.interview.questions.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DuplicateCharacters {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		DuplicateCharacters.findduplicates(line);
	}

	private static void findduplicates(String line) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i <= line.length() - 1; i++) {
			Character ch = line.charAt(i);
			if (!map.containsKey(ch)) {
				map.put(ch, 1);
			} else {
				map.put(ch, map.get(ch) + 1);
			}
		}
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {

			if (entry.getValue() > 1) {
				System.out.println(entry.getKey() + "::" + entry.getValue());

			}

		}
	}

}
