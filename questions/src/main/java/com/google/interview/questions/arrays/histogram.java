package com.google.interview.questions.arrays;

public class histogram {

	public static void main(String args[]) {
		//int arr[] = {5,4,3,6,0,1};
		int arr[] = { 0, 1, 1, 1, 1, 0 };
		int count = histogramMelt(arr);
		System.out.println("result =" + count);
	}

	public static boolean checkZero(int arr[]) {
		int flag = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				flag = 1;
			} else {
				flag = 0;
				break;
			}
			System.out.print(arr[i] + " ");
		}
		if (flag == 0)
			return false;
		else
			return true;
	}

	public static int histogramMelt(int arr[]) {
		boolean b;
		int count = 0;
		int l = arr.length;
		int val[] = new int[l];
		do {
			for (int i = 0; i < l; i++) {
				System.out.println(i + " " + arr[i]);
				if (i == 0 || i == l - 1) { //corner case first and last elements of the array
					val[i] = 0;
					System.out.println(i + " " + val[i]);
				} else {
					if ((arr[i] > arr[i + 1]) || (arr[i] > arr[i - 1])) { // other values are replaced by min(left,right) neighbours
						val[i] = Math.min(arr[i + 1], arr[i - 1]);
						System.out.println(i + " " + val[i]);
					} else {

						val[i] = arr[i] - 1; // every column has the top block exposed, so every column gets deducted by 1
						if (val[i] < 0)
							val[i] = 0; // avoid negatives
						System.out.println(i + " " + val[i]);
					}
				}

			}

			b = checkZero(val);
			arr = val;
			count++; // number of times the histogram was melted
		} while (b == false);
		return count;
	}
}