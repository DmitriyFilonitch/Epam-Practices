package ua.nure.filonitch.practice6.part6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Part6 {

	public static final String CURS = " ==> ";
	private String fileOfName;
	private String[] inp;

	public static void main(String[] args) {
		new Part6().inputing(args[0], args[1], args[2], args[3]);
	}

	private boolean inputing(String inp, String fileOfName, String t, String oper) {
		if (!("--input".equals(inp) || "-i".equals(inp))) {
			return false;
		}
		if (!("--task".equals(t) || "-t".equals(t))) {
			return false;
		}

		this.fileOfName = fileOfName;
		spliting();

		switch (oper) {
		case "frequency":
			frequecyResult();
			break;
		case "length":
			lengthResult();
			break;
		case "duplicates":
			dublicatResult();
			break;
		default:
			return false;
		}
		return true;
	}

	private String getInput() {
		StringBuilder sb = new StringBuilder();
		try (Scanner file = new Scanner(new File(fileOfName), "CP1251")) {
			while (file.hasNext()) {
				sb.append(file.next()).append(" ");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	public void spliting() {
		StringBuilder sb = new StringBuilder();
		Pattern p = Pattern.compile("[a-zA-Z]+");
		Matcher m = p.matcher(getInput());
		while (m.find()) {
			sb.append(m.group() + " ");
		}
		inp = sb.toString().split(" ");
	}

	static class Counter {

		private int len;
		private int pl;
		private int counterC = 1;

		public Counter(int pl) {
			this.pl = pl;
		}

		public Counter(int len, int pl) {
			this.len = len;
			this.pl = pl;
		}

		public Counter setCounter(int c) {
			this.counterC = c;
			return this;
		}

		public int getLength() {
			return len;
		}

		public int getCounter() {
			return counterC;
		}
	}

	private void lengthResult() {

		final HashMap<String, Counter> word = new HashMap<>();
		for (int pl = 0; pl < inp.length; pl++) {
			String i = inp[pl];
			word.putIfAbsent(i, new Counter(i.length(), pl));
		}

		TreeMap<String, Counter> sortedWords = new TreeMap<>(new Comparator<String>() {
			@Override
			public int compare(String o, String o1) {
				Counter c1 = word.get(o);
				Counter c2 = word.get(o1);
				int len = c2.len - c1.len;
				if (len == 0) {
					return c1.pl - c2.pl;
				} else {
					return len;
				}
			}
		});
		sortedWords.putAll(word);

		int k = 0;
		for (Entry<String, Counter> entry : sortedWords.entrySet()) {
			String s = entry.getKey();
			if (k == 3) {
				break;
			}
			k++;
			System.out.println(s + CURS + sortedWords.get(s).getLength());
		}
	}

	private void frequecyResult() {

		final HashMap<String, Counter> w = new HashMap<>();
		for (int pl = 0; pl < inp.length; pl++) {
			String i = inp[pl];
			if (w.get(i) == null) {
				w.put(i, new Counter(pl));
			} else {
				w.get(i).setCounter(w.get(i).getCounter() + 1);
			}
		}

		TreeMap<String, Counter> sortedWords = new TreeMap<>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				Counter c1 = w.get(o1);
				Counter c2 = w.get(o2);
				int cou = c2.counterC - c1.counterC;
				if (cou == 0) {
					return c1.pl - c2.pl;
				} else {
					return cou;
				}
			}
		});
		sortedWords.putAll(w);

		TreeSet<String> firstStr = new TreeSet<>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		});
		int k = 0;
		for (Entry<String, Counter> entry : sortedWords.entrySet()) {
			String str = entry.getKey();
			if (k == 3) {
				break;
			}
			k++;
			firstStr.add(str);
		}
		for (String str : firstStr) {
			System.out.println(str + CURS + sortedWords.get(str).getCounter());
		}
	}

	private void dublicatResult() {

		final Map<String, Integer> w = new LinkedHashMap<>();
		for (int pl = 0; pl < inp.length; pl++) {
			String i = inp[pl];
			Integer counterOfDublicates = w.get(i);
			if (counterOfDublicates == null) {
				w.put(i, 1);
			} else {
				counterOfDublicates += 1;
				w.put(i, counterOfDublicates);
			}
		}
		int k = 0;
		for (Map.Entry<String, Integer> wordCounter : w.entrySet()) {
			if (k == 3) {
				break;
			}
			if (wordCounter.getValue() > 1) {
				k++;
				System.out.println(
						new StringBuilder(wordCounter.getKey()).reverse().toString().toUpperCase(Locale.ENGLISH));
			}
		}
 
	}
}
