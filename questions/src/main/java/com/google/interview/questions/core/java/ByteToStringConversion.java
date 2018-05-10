package com.google.interview.questions.core.java;

import java.io.UnsupportedEncodingException;

public class ByteToStringConversion {

	byte[] bytes;

	public ByteToStringConversion(byte[] bytes) {
		this.bytes = bytes;
	}

	public String convertByteToString() throws UnsupportedEncodingException {
		String str = new String(bytes, "UTF-8");
		return str;
	}

}
