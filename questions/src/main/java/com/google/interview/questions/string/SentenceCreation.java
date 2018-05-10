package com.google.interview.questions.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SentenceCreation {

	public static void main(String[] args) {
		String text = "Love I Cats and Dogs";
		String pattern = "I Love Cats";
		System.out.println(SentenceCreation.sentenceCreation(text, pattern));
	}

	public static boolean sentenceCreation(String text, String pattern) {
		List<String> listTextWords = Arrays.asList(text.split(" "));
		List<String> listPatternWords = Arrays.asList(pattern.split(" "));
		Map<String, String> map = new HashMap<String, String>();
		for (String textWord : listTextWords) {
			map.put(textWord.toLowerCase(), textWord.toLowerCase());
		}
		for (String patternWord : listPatternWords) {
			String hasWord = map.get(patternWord.toLowerCase());
			if (null == hasWord) {
				return false;
			}
		}
		return true;
	}

}
