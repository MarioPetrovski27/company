package com.musala.company.validation;

public class InputValidation {

	protected static boolean isAlpha(String name) {
		char[] chars = name.toCharArray();

		for (char c : chars) {
			if (!Character.isLetter(c)) {
				return false;
			}
		}
		return true;
	}

	protected static String formatName(String name) {
		String s1 = name.substring(0, 1).toUpperCase();
		String nameCapitalized = s1 + name.substring(1).toLowerCase();
		return nameCapitalized;
	}

}
