package com.google.interview.questions.string;

import java.util.ArrayList;
import java.util.List;

public class CamelCaseIndex {

	String input;

	List<Integer> indexes;

	public CamelCaseIndex(String input) {
		this.input = input;
		indexes = new ArrayList<>();
		searchUpperCase(input);
	}

	private void searchUpperCase(String input) {
		int i = 1;
		int length = input.length();
		while (i != length) {
			if (Character.isUpperCase(input.charAt(i))) {
				indexes.add(i);
			}
		}
	}

	public String getInput() {
		return input;
	}

	public List<Integer> getIndexes() {
		return indexes;
	}

}
