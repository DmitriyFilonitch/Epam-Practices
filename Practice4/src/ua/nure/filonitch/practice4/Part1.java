package ua.nure.filonitch.practice4;

import java.io.ByteArrayOutputStream;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {
	private static final int SIZE = 119;
	private static final int CONST8 = 1071;
	private static final int CONST7 = 1104;
	private static final int CONST6 = 96;
	private static final int CONST5 = 122;
	private static final int CONST4 = 1039;
	private static final int CONST3 = 1072;
	private static final int CONST2 = 40;
	private static final int CONST1 = 97;
	public static final String FILE_NAME = "part1.txt";
	private static final String ENCODING = "Cp1251";

	public static void main(String[] args) {
		List<String> strings = null;
		try {
			strings = Files.readAllLines(new File(FILE_NAME).toPath(), Charset.forName(ENCODING));
		} catch (IOException exe1) {
			exe1.printStackTrace();
		}
		ByteArrayOutputStream output = new ByteArrayOutputStream(SIZE);
		PrintStream printOutData = System.out;
		try {
			System.setOut(new PrintStream(output, true, Charset.defaultCharset().name()));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		input(strings, System.out);
		String actualData = new String(output.toByteArray(), Charset.forName(Part1.ENCODING));
		System.setOut(printOutData);
		System.out.print(actualData);
	}

	public static void input(Iterable<?> list, OutputStream out) {
		StringBuffer strBuf = new StringBuffer();
		for (Object ob : list) {
			strBuf.append(ob).append(System.lineSeparator());
		}
		String regex = "([A-Za-z\\u0410-\\u044F\\u0401\\u0451"
				+ "\\u0406\\u0407\\u0456\\u0457])([a-z\\u0430-\\u044F\\u0401"
				+ "\\u0451\\u0406\\u0407\\u0456\\u0457]+)";
		Matcher match = Pattern
				.compile(regex, Pattern.MULTILINE | Pattern.UNICODE_CHARACTER_CLASS | Pattern.CASE_INSENSITIVE)
				.matcher(strBuf);
		strBuf = new StringBuffer();
		while (match.find()) {
			if (match.group().length() > 3) {
				int chr = match.group(1).charAt(0);
				if ((chr < CONST1 && chr > CONST2) || (chr < CONST3 && chr > CONST4)) {
					match.appendReplacement(strBuf, match.group(1).toLowerCase(Locale.ENGLISH));
					strBuf.append(match.group(2).toUpperCase(Locale.ENGLISH));
				} else {
					if ((chr < CONST5 && chr > CONST6) || (chr < CONST7 && chr > CONST8)) {
						match.appendReplacement(strBuf, match.group(1).toUpperCase(Locale.ENGLISH));
						strBuf.append(match.group(2).toUpperCase(Locale.ENGLISH));
					}
				}
			}
		}
		match.appendTail(strBuf);
		try {
			out.write(strBuf.toString().getBytes(ENCODING));
		} catch (IOException exe) {
			exe.printStackTrace();
		}

	}
}
