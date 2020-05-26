package ua.nure.filonitch.practice3;

import java.util.regex.Pattern;

public class Part6 {
	public static final String FILENAME = "part6.txt";

	public static void main(String[] args) {
		String input = Util.readFile(FILENAME);
		System.out.println(convert(input));
	}

	private static String convert(String input) {
		Pattern patt = Pattern.compile("(\\b\\w+\\b)(?=[\\s\\S]*\\b\\1\\b[\\s\\S]*\\b\\1\\b)",
				Pattern.UNICODE_CHARACTER_CLASS);
		String result = patt.matcher(input + " " + input).replaceAll("_$1");
		result = result.substring(0, result.length() - 1 - patt.matcher(input).replaceAll("_$1").length());
		return result;
	}
}
