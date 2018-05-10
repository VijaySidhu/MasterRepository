package LowestCommonAncestorBinaryTree;

public class GenerateLowestNumber {

	public static void main(String[] args) {
		System.out.println(GenerateLowestNumber.generateLowestNumber("4205123", 4));
	}

	public static String generateLowestNumber(String number, int n) {
		if (number == null || number.length() == 0 || n >= number.length())
			return null;
		int count = number.length() - n;
		char[] num = number.toCharArray();
		StringBuilder st = new StringBuilder();
		int start = 0;
		while (count > 0) {
			int end = number.length() - count + 1;
			int index = findMin(start, end, num);
			start = index + 1;
			st.append(num[index]);
			count--;
		}
		return st.toString();
	}

	public static int findMin(int start, int end, char[] number) {
		if (start > end || number == null || number.length == 0)
			return Integer.MIN_VALUE;
		if (start == end)
			return start;
		int min = start;
		for (int i = start; i < end; i++) {
			if (number[min] > number[i])
				min = i;
		}
		return min;
	}
}
