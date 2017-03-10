package com.google.interview.questions.algorithms;

import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class VotingCount {

	public static void main(String[] args) {
		String[] votes = { "Alex", "Michael", "Harry", "Dave", "Michael", "Victor", "Harry", "Alex", "Mary", "Mary" };
		String s = VotingCount.electionWinner(votes);
		System.out.println(s);
	}

	static String electionWinner(String[] votes) {
		Map<String, Integer> tmap = new TreeMap<String, Integer>();
		Map<String, String> result = new TreeMap<String, String>();
		int counter = 1;
		for (String st : votes) {
			if (false == tmap.containsKey(st)) {
				tmap.put(st, counter);
			} else {
				int currentCount = tmap.get(st);
				tmap.put(st, currentCount + 1);
			}

		}
		int max = Collections.max(tmap.values());
		for (Entry<String, Integer> entry : tmap.entrySet()) { // Itrate through hashmap
			if (entry.getValue() == max) {
				result.put(entry.getKey(), entry.getKey()); // Print the key with max value
			}
		}

		//System.out.println(result.values().toArray()[result.size() - 1]);

		return result.values().toArray()[result.size() - 1].toString();
	}

}
