package ua.nure.filonitch.practice4;

import java.io.File;
import java.io.FileNotFoundException;

public class Part4 {

	private String nameOfFile;

	Part4(String filename) {
		setFileName(filename);
	}

	public String getFileName() {
		return nameOfFile;
	}

	public final void setFileName(String fileName) {

		this.nameOfFile = fileName;
	}

	public void output() throws FileNotFoundException {
		Parser pars = null;
		pars = new Parser(new File(getFileName()));
		for (String st : pars) {
			System.out.println(st);
		}
	}

	public static void main(String[] args) {
		try {
			new Part4("part4.txt").output();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
