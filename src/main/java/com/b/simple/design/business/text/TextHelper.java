package com.b.simple.design.business.text;

public class TextHelper {

	public String swapLastTwoCharacters(String str) {
		if (str.isBlank() || str.length() < 2) return str;

		int lastIndex = str.length() - 1;
		int secondLastIndex = str.length() - 2;
		char lastChar = str.charAt(lastIndex);
		char secondLastChar = str.charAt(secondLastIndex);

		str = str.substring(0, secondLastIndex);

		return str + lastChar + secondLastChar;
	}

	public String truncateAInFirst2Positions(String str) {
		if (str.isBlank() || str.length() < 2) return str;

		String firstTwoChars = str.substring(0, 2);
		firstTwoChars = firstTwoChars.replaceAll("A", "");

		String restOfString = str.substring(2);

		return firstTwoChars + restOfString;
	}
}
