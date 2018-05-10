package com.google.interview.questions.string;

public class SearchOrder {
	public static void main(String[] args) {
		SearchOrder so = new SearchOrder();
		System.out.println(so.isSameOrder("vijaysinghsidhu", "vss"));
	}

	public boolean isSameOrder(String test, String sample) {

		int indexTest = 0;
		int indexSample = 0;
		while (indexTest < test.length() && indexSample < sample.length()) {
			if (test.charAt(indexTest) == sample.charAt(indexSample)) {
				++indexSample;
			}
			++indexTest;
		}
		return (indexSample == sample.length()) ? true : false;
	}

}
