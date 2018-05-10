package com.google.interview.questions.string;

public class ReverseStringInArray {

	public static void main(String[] args) {
		String[] strings = { "This is an example" };
		String[] strArray = ReverseStringInArray.reverse(strings);
		for (String str : strArray) {
			System.out.println(str);

		}
	}

	private static String[] reverse(String[] strings) {
		String[] result = new String[8];
		String[] arr = strings[0].split(" ");
		int i = 0;
		for (String str : arr) {
			StringBuffer buffer = new StringBuffer();
			buffer = buffer.append(str).reverse();
			result[i] = buffer.toString();
			i++;
		}
		return result;
	}
	
	public static char[] stringReverseInPlace(char[] string) {
		  for(int i = 0, j = string.length - 1; i < string.length / 2; i++, j--) {
		    char c = string[i];
		    string[i] = string[j];
		    string[j] = c;
		  }
		  return string;
		}

}
