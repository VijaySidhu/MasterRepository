package com.google.interview.questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class ChainInspection {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = in.readLine()) != null) {
			if (!line.equalsIgnoreCase("")) {
				Map chain = new TreeMap();
				boolean badChain = false;
				String elements[] = line.split(";");
				for (String pair : elements) {
					String items[] = pair.split("-");
					if (items[0].equalsIgnoreCase(items[1])) {
						badChain = true;
					} else {
						if (!chain.containsKey(items[0])) {
							chain.put(items[0], items[1]);
						} else {
							// bad chain 
							badChain = true;
							break;
						}
					}
				}

				int linksUsed = 1;
				int chainLength = chain.size();
				String value = (String) chain.get("BEGIN");
				if (chain.get("BEGIN") == null) {
					badChain = true;
				} else {
					while (!value.equalsIgnoreCase("END") && linksUsed < chainLength) {
						value = (String) chain.get(value);
						linksUsed++;
					}
				}
				if (!badChain && linksUsed == chainLength && value.equals("END")) {
					System.out.println("GOOD");
				} else {
					System.out.println("BAD");
				}
			}
		}
	}

}
