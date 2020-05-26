package ua.nure.filonitch.practice6.part1;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Part1 {
	private static final InputStream STD_IN = System.in;

	private static final String ENCODING = "Cp1251";

	public static void main(String[] args) throws IOException {
		String input = "asd 43 asdf asd 43\r\n" + "434 asdf\r\n" + "kasdf asdf stop asdf\r\n" + "stop";
		System.setIn(new ByteArrayInputStream(input.replace("^", System.lineSeparator()).getBytes(ENCODING)));
		WordContainer.main(args);
		System.setIn(STD_IN);
	}
}
