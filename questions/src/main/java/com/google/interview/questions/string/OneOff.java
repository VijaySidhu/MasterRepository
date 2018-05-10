package com.google.interview.questions.string;

public class OneOff {

	private static boolean isOffByOne(String main, String sub) {
		if (main == null || sub == null || main.length() != sub.length())
			return false;
		boolean oneOff = false;
		for (int i = 0; i < main.length(); i++) {
			if (main.charAt(i) != sub.charAt(i)) {
				if (!oneOff)
					oneOff = true;
				else
					return false;
			}
		}
		return oneOff;
	}

	public static boolean findOfByOne(String str, String[] candidates) {
		if (str == null || str.length() < 1 || candidates.length == 0)
			return false;
		for (int i = 0; i < candidates.length; i++) {
			boolean isOff = isOffByOne(str, candidates[i]);
			if (isOff)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		String[] cands = { "bana", "apple", "banaba", "bonanza", "banamf" };
		System.out.println(findOfByOne("banana", cands));

	}

}
