package ua.nure.filonitch.practice4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser implements Iterable<String> {
	private static final String ENCODING = "Cp1251";
	private Matcher patternMatcher;

	public Parser(File linkOfFile) throws FileNotFoundException {
		StringBuilder sb = new StringBuilder();
		Pattern patt = Pattern.compile("\\p{Lu}.*?\\.");
		Scanner scan = new Scanner(linkOfFile, ENCODING);
		while (scan.hasNextLine()) {
			sb.append(scan.nextLine()).append(" ");
			setPatternMatcher(patt.matcher(sb));
		}
		scan.close();
	}

	public Matcher getPatternMatcher() {
		return patternMatcher;
	}

	public final void setPatternMatcher(Matcher patternMatcher) {
		this.patternMatcher = patternMatcher;
	}

	@Override
	public Iterator<String> iterator() {

		return new ParserIterator(getPatternMatcher());
	}

	private static class ParserIterator implements Iterator<String> {
		private Matcher match;

		public ParserIterator(Matcher matcher) {
			this.match = matcher;
		}

		@Override
		public boolean hasNext() {

			return match.find();
		}

		@Override
		public String next() {
			int ind = 0;
			if (ind != 0 && !hasNext()) {
				throw new NoSuchElementException();
			}
			return match.group().replace("  ", " ");
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

}
