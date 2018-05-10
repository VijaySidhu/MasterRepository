package com.google.interview.questions.algorithms;

class MXN {

	public final double amount;

	public MXN(double amount) {
		this.amount = amount;
	}

	public String toString() {
		return "MXN(" + this.amount + ")";
	}

}

class USD {

	public final double amount;

	public USD(double amount) {
		this.amount = amount;
	}

	public String toString() {
		return "USD(" + this.amount + ")";
	}

}

class BTC {

	public final double amount;

	public BTC(double amount) {
		this.amount = amount;
	}

	public String toString() {
		return "BTC(" + this.amount + ")";
	}

}

public class Rates {
	public static final double USD_MXN = 1.1837;

	public static final double BTC_MXN = 1.3829;

	public static final double MXN_USD = 1 / USD_MXN;

	public static final double MXN_BTC = 1 / BTC_MXN;

	public static final double USD_BTC = MXN_BTC / MXN_USD;

	public static final double BTC_USD = 1 / USD_BTC;

	public static USD usd(MXN mxn) {
		return new USD(mxn.amount * MXN_USD);
	}

	public static BTC btc(MXN mxn) {
		return new BTC(mxn.amount * MXN_BTC);
	}

	public static BTC btc(USD usd) {
		return new BTC(usd.amount * USD_BTC);
	}

	public static MXN mxn(USD usd) {
		return new MXN(usd.amount * USD_MXN);
	}

	public static MXN mxn(BTC btc) {
		return new MXN(btc.amount * BTC_MXN);
	}

	public static void main(String[] args) {

		MXN pesos = new MXN(0.6102);
		System.out.println(Math.abs(btc(usd(pesos)).amount - btc(pesos).amount));

	}

}
