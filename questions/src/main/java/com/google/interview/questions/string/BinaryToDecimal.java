package com.google.interview.questions.string;

import java.util.regex.Pattern;

/**
 * A) Convert the integral part of
 * binary to decimal equivalent
 * 
 * Multiply each digit separately from
 * left side of radix point till the
 * first digit by 20, 21, 22,…
 * respectively. Add all the result
 * coming from step 1. Equivalent
 * integral decimal number would be the
 * result obtained in step 2.
 * 
 * B) Convert the fractional part of
 * binary to decimal equivalent
 * 
 * Divide each digit from right side of
 * radix point till the end by 21, 22,
 * 23, … respectively. Add all the
 * result coming from step 1. Equivalent
 * fractional decimal number would be
 * the result obtained in step 2.
 * 
 * @author VijaySidhu
 *
 */
public class BinaryToDecimal {
	public int getDecimalFromBinary(int binary) {

		int decimal = 0;
		int power = 0;
		while (true) {
			if (binary == 0) {
				break;
			} else {
				int tmp = binary % 10;
				decimal += tmp * Math.pow(2, power);
				binary = binary / 10;
				power++;
			}
		}
		return decimal;
	}

	public double binToDec(String bin) {
		String[] split = bin.split(Pattern.quote("."));
		double integralSum = 0;
		// Process first Integral part
		String integralPart = split[0];
		int lengthIntegralPart = integralPart.length();
		int integralPower = 0;
		int read = lengthIntegralPart - 1;
		while (lengthIntegralPart >= 1) {
			int temp = Integer.valueOf(integralPart.charAt(read));
			integralSum = integralSum + (temp * Math.pow(2, integralPower));
			integralPower++;
			read--;
			lengthIntegralPart--;
		}
		// Process Fractional Part
		String fractionalPart = split[1];
		int lenFractPart = fractionalPart.length();
		int fractionalPower = 1;
		double sumFractional = 0;
		int n = 1;
		while (n <= lenFractPart) {
			int temp = Integer.valueOf(fractionalPart.charAt(n));
			sumFractional = sumFractional + (temp * Math.pow(temp, fractionalPower));
			fractionalPower++;
			n++;
		}
		return integralSum + sumFractional;
	}

	public static void main(String a[]) {
		BinaryToDecimal bd = new BinaryToDecimal();
		String s = "110.101";
		System.out.println("11 ===> " + bd.getDecimalFromBinary(11));
		System.out.println("110 ===> " + bd.getDecimalFromBinary(110));
		System.out.println("100110 ===> " + bd.getDecimalFromBinary(100110));
		System.out.println("110.101 ===> " + bd.binToDec(s));
	}
}
