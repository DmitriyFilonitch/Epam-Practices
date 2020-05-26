package ua.nure.filonitch.practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {
	public static final String FILENAME = "part3.txt";

	public static void main(String[] args) {
		String input = Util.readFile(FILENAME);
		System.out.println(convert(input));
	}

	public static String convert(String input) {
		StringBuilder strbuild = new StringBuilder(input);
		Pattern patt = Pattern.compile("\\b\\p{L}{3}");
		Matcher matcher = patt.matcher(input);
		while (matcher.find()) {
			char firstChar = strbuild.charAt(matcher.start());
			if (Character.isUpperCase(firstChar)) {
				strbuild.setCharAt(matcher.start(), Character.toLowerCase(firstChar));
			} else {
				strbuild.setCharAt(matcher.start(), Character.toUpperCase(firstChar));
			}
		}
		return strbuild.toString();
	}

}
