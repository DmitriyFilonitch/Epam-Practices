package ua.nure.filonitch.practice4;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {
	private static final String NO_SUCH_VALUES = "No such values";

	public static void main(String[] args) {
		try {
			Part3.input();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static String getData() throws IOException {
		StringBuilder strbuild = new StringBuilder();
		Scanner sca = new Scanner(new File("part3.txt"), "Cp1251");
		while (sca.hasNextLine()) {
			strbuild.append(sca.nextLine()).append(System.lineSeparator());
		}
		sca.close();
		return strbuild.toString();
	}

	public static void input() throws IOException {
		String strData = getData();
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String strNext = sc.nextLine();
			switch (strNext) {
			case "int":
				System.out.println(checkInt(strData));
				continue;
			case "char":
				System.out.println(checkChar(strData));
				continue;
			case "String":
				System.out.println(checkString(strData));
				continue;
			case "double":
				System.out.println(checkDouble(strData));
				continue;
			case "stop":
				return;
			default:
				System.out.println("Incorrect input");
			}
		}
	}

	public static String checkInt(String input) {
		String regexp = "(?<![-.])\\b[0-9]+\\b(?!\\.)";
		StringBuilder strbuild = new StringBuilder();
		Pattern patt = Pattern.compile(regexp);
		Matcher match = patt.matcher(input);
		int symb = 0;
		while (match.find()) {
			strbuild.append(match.group() + " ");
			symb++;
		}
		if (symb == 0) {
			strbuild.append(NO_SUCH_VALUES);
		}
		return strbuild.toString();
	}

	public static String checkChar(String input) {
		String regexp = "\\b[a-zA-Z\\u0410-\\u042F\\u0430-\\u044F]\\b";
		StringBuilder strbuild = new StringBuilder();
		Pattern patt = Pattern.compile(regexp);
		Matcher match = patt.matcher(input);
		int symb = 0;
		while (match.find()) {
			strbuild.append(match.group() + " ");
			symb++;
		}
		if (symb == 0) {
			strbuild.append(NO_SUCH_VALUES);
		}
		return strbuild.toString();
	}

	public static String checkString(String input) {
		String regexp = "[a-zA-Z\\u0410-\\u042F\\u0430-\\u044F]+";
		StringBuilder strbuild = new StringBuilder();
		Pattern patt = Pattern.compile(regexp);
		Matcher match = patt.matcher(input);
		int symb = 0;
		while (match.find()) {
			if (match.group().length() > 1) {
				strbuild.append(match.group() + " ");
				symb++;
			}
		}
		if (symb == 0) {
			strbuild.append(NO_SUCH_VALUES);
		}
		return strbuild.toString();
	}

	public static String checkDouble(String input) {
		String regexp = "[0-9]*+([.][0-9]*)";
		StringBuilder strbuild = new StringBuilder();
		Pattern patt = Pattern.compile(regexp);
		Matcher match = patt.matcher(input);
		int symb = 0;
		while (match.find()) {
			strbuild.append(match.group() + " ");
			symb++;
		}
		if (symb == 0) {
			strbuild.append(NO_SUCH_VALUES);
		}
		return strbuild.toString();
	}

}