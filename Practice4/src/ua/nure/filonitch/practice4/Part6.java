package ua.nure.filonitch.practice4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part6 {

	public static void main(String[] args) {
		String input = Util.readFile("part6.txt");
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String someword = scanner.nextLine();
			switch (someword) {
			case "Latn":
				System.out.println("Latn: " + outPutLatin(input));
				continue;
			case "Cyrl":
				System.out.println("Cyrl: " + outPutCyrillic(input));
				continue;
			case "latn":
				System.out.println("latn: " + outPutLatin(input));
				continue;
			case "cyrl":
				System.out.println("cyrl: " + outPutCyrillic(input));
				continue;
			case "Stop":
				return;
			case "stop":
				return;
			default:
				System.out.println(someword + ": Incorrect input");
			}
		}
	}

	private static String outPutCyrillic(String input) {
		StringBuilder strbuild = new StringBuilder();
		String regex = "[\\u0410-\\u044F\\u0456\\u0457\\u0451\\u0406\\u0407\\u0454]+";
		Pattern patt = Pattern.compile(regex, Pattern.UNICODE_CHARACTER_CLASS);
		Matcher match = patt.matcher(input);
		while (match.find()) {
			strbuild.append(match.group()).append(" ");
		}
		return strbuild.toString();
	}

	private static String outPutLatin(String input) {
		StringBuilder strbuild = new StringBuilder();
		String regex = "[A-z]+";
		Pattern patt = Pattern.compile(regex);
		Matcher match = patt.matcher(input);
		while (match.find()) {
			strbuild.append(match.group()).append(" ");
		}
		return strbuild.toString();
	}

}
