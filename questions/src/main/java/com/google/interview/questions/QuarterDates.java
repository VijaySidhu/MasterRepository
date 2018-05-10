package com.google.interview.questions;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class QuarterDates {

	public static void main(String[] args) {
		QuarterDates q = new QuarterDates();
		q.method();
	}

	private void method() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -1 - (cal.get(Calendar.MONTH) % 3));
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DATE));
		System.out.println(sdf.format(cal.getTime()));
		Calendar cal2 = Calendar.getInstance();
		cal2.add(Calendar.MONTH, -3 - (cal2.get(Calendar.MONTH) % 3));
		cal2.set(Calendar.DAY_OF_MONTH, 1);
		System.out.println(sdf.format(cal2.getTime()));
	}

}