package com.google.interview.questions.algorithms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Test {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new FileReader("C://workspace-sts-3.7.release//MasterRepository//questions//src//main//java//com//google//interview//questions//algorithms//in.txt"));
		PrintWriter out = new PrintWriter(new FileWriter("C://workspace-sts-3.7.release//MasterRepository//questions//src//main//java//com//google//interview//questions//algorithms//out.txt"));
		String[] quotes = {"2","1.1837 1.3829 0.6102","1.1234 1.2134 1.2311"};
		BellmanFordSP.arbitrage(quotes);
		//BellmanFordSP.run(in,out);

		in.close();
		out.close();
	}
}
