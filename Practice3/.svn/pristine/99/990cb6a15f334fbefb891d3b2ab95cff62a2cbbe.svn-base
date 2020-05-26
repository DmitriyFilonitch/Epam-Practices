
package ua.nure.filonitch.practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 {
	public static final String FILENAME = "part2.txt";
	public static final int MINIMALSYMB = 100;
	public static void main(String[] args) {
		String input = Util.readFile(FILENAME);
		System.out.println(convert(input));
	}

	public static String convert(String input) {
		StringBuilder strbuild = new StringBuilder();
		String regex = "[\\p{Alpha}\\p{InCyrillic}]+";
		Pattern patt = Pattern.compile(regex);
		Matcher match = patt.matcher(input);
		while (match.find()) {
			strbuild.append(match.group() + " ");
		}

		return minimalOfElement(strbuild.toString());
	}

	public static String minimalOfElement(String string) {
		int min = MINIMALSYMB;
		int max = 0;
		int k = 0;
		StringBuilder str = new StringBuilder();
		StringBuilder str1 = new StringBuilder();
		String minimal = "Min:";
		String maximal = "Max:";
		str.append(minimal);
		str1.append(maximal);
		String[] array = new String[string.length()];
	    String regex = "[\\p{Alpha}\\p{InCyrillic}]+";
		Pattern patt = Pattern.compile(regex);
		Matcher match = patt.matcher(string);
		while (match.find()) {
			array[k] = match.group();
			if (array[k].length() < min) {
				min = array[k].length();
			} else if (array[k].length() > max) {
				max = array[k].length();
			}
			k++;
		}
		deleteOfElement(array);
		for (int j = 0; j < array.length; j++) {
			if (array[j] != null && array[j].length() == min) {
				str.append(" " + array[j] + ",");
			} else if (array[j] != null && array[j].length() == max) {
				str1.append(" " + array[j] + ",");
			}
		}
		return str.toString().substring(0, str.length() - 1) + System.lineSeparator()
				+ str1.toString().substring(0, str1.length() - 1);
	}

	public static String[] deleteOfElement(String[] array) {
		for (int x = 0; x < array.length - 1; x++) {
			for (int y = x + 1; y < array.length; y++) {
				if (array[x] != null && array[x].equals(array[y])) {
					array[y] = null;
				}
			}
		}

		return array;
	}
}
