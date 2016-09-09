package com.google.interview.questions.string;

import java.util.Arrays;

//Time :: O(MN)
public class ChemicalSymbolsSearch {

	public static void main(String[] args) {
		ChemicalSymbolsSearch.replace();
	}

	public static void replaceKMP() {
		String[] arr = { "Amazon", "Microsoft", "Google" };
		String[] symbols = { "I", "Am", "cro", "Na", "le", "abc" };

		for (String chemical : arr) {
			for (String sym : symbols) {
				KMP kmp = new KMP(chemical, sym);
				System.out.println(chemical.substring(kmp.getIndex(), kmp.getSymbolLength()));
			}

		}
	}

	public static void replace() {
		String[] arr = { "Amazon", "Microsoft", "Google" };
		String[] symbols = { "I", "Am", "cro", "Na", "le", "abc" };
		for (int i = 0; i < arr.length; i++) {
			String name = arr[i];
			String selectedSymbol = "";
			for (String symbol : symbols) {
				if (name.contains(symbol)) {
					selectedSymbol = symbol;
				}
			}
			if (selectedSymbol.length() > 0) {
				arr[i] = name.replace(selectedSymbol, "[" + selectedSymbol + "]");
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
