package ua.nure.filonitch.practice3;

import java.security.SecureRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {
	public static final String FILENAME = "part1.txt";
	private static final String REGEX = "(?m)^(.+);(.+);(.+)$";
	private static final String REGEX2 = "(?m)^(.+)(.+)(.+)$";
	private static final int MIN = 999;
	private static final int MAX = 9001;
	public static final int NUM1 = 20;

	public static void main(String[] args) {
		String input = Util.readFile(FILENAME);
		System.out.println(convert1(input));
		System.out.println(convert2(input));
		System.out.println(convert3("Login;Name;Email\r\n" + "ivanov;Ivan Ivanov;ivanov@mail.com\r\n"
				+ "петров;Петр Петров;petrov@google.com\r\n" + "obama;Barack Obama;obama@google.com\r\n"
				+ "bush;Джордж Буш;bush@mail.com"));
		System.out.println(convert4(input));
	}

	private static String convert1(String input) {
		String regex = REGEX;
		Pattern patt = Pattern.compile(regex);
		Matcher match = patt.matcher(input);
		match.find();
		StringBuilder sb = new StringBuilder();
		while (match.find()) {
			sb.append(match.group(1) + ": ").append(match.group(3)).append(System.lineSeparator());
		}

		return sb.toString();
	}

	private static String convert2(String input) {
		String regex = REGEX;
		StringBuilder strbild = new StringBuilder();
		Pattern patt = Pattern.compile(regex);
		Matcher match = patt.matcher(input);
		String[] txt1 = input.split(";");
		String[] txt2 = new String[input.length()];
		String[] txt3 = new String[input.length()];
		int f = 0;
		for (int j = 3; j < txt1.length; j = j + 2) {
			txt2 = txt1[j].split(" ");
			for (int k = 0; k < txt2.length; k++) {
				if (txt2[k] != null) {
					txt3[f] = txt2[k];
					f++;
				} else {
					break;
				}
			}
		}

		match.find();
		int i = 1;
		while (match.find()) {
			strbild.append(txt3[i]).append(" ").append(txt3[i - 1]).append(" (email: ").append(match.group(3) + ")")
					.append(System.lineSeparator());
			i = i + 2;
		}
		return strbild.toString();
	}

	public static String convert3(String input) {
		String regex = REGEX;
		String[] array = new String[NUM1];
		Pattern patt = Pattern.compile(regex);
		Matcher match = patt.matcher(input);
		int s = 0;
		while (match.find()) {
			for (int n = 1; n < 4; n++, s++) {
				array[s] = match.group(n);
			}
		}
		String mail = "mail.com ==> ";
		String google = "google.com ==> ";
		StringBuilder strbuild = new StringBuilder();
		strbuild.append(mail);
		StringBuilder strbuild1 = new StringBuilder();
		strbuild1.append(google);
		for (int i = 2; i < NUM1 && array[i] != null; i = i + 3) {
			String regex1 = "@(.+)";
			Pattern patt1 = Pattern.compile(regex1);
			Matcher match1 = patt1.matcher(array[i]);
			while (match1.find()) {
				if ("mail.com".equals(match1.group(1))) {
					strbuild.append(array[i - 2] + ", ");
				} else {
					strbuild1.append(array[i - 2] + ", ");
				}
			}
		}
		String r = " ";
		if ("mail.com ==> ".equals(strbuild.toString())) {
			r = strbuild1.toString();
			r = r.substring(0, r.length() - 2);
		} else if ("google.com ==> ".equals(strbuild1.toString())) {
			r = strbuild.toString();
			r = r.substring(0, r.length() - 2);
		} else {
			r = strbuild.substring(0, strbuild.length() - 2) + System.lineSeparator()
					+ strbuild1.substring(0, strbuild1.length() - 2);
		}
		return r + System.lineSeparator();
	}

	public static String convert4(String input) {
		String regex = REGEX2;
		Pattern patt = Pattern.compile(regex);
		Matcher match = patt.matcher(input);

		StringBuilder strbild = new StringBuilder();
		SecureRandom passw = new SecureRandom();
		int checker = 0;
		while (match.find()) {
			if (checker == 0) {
				strbild.append(match.group(1)).append(match.group(2))
						.append(match.group(3) + ";" + "Password" + System.lineSeparator());
				checker++;
			} else {
				int generatePassword = MIN + passw.nextInt(MAX);
				strbild.append(match.group(1)).append(match.group(2))
						.append(match.group(3) + ";" + generatePassword + System.lineSeparator());
			}
		}
		return strbild.toString();
	}
}
