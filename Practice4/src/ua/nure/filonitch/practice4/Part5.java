package ua.nure.filonitch.practice4;

import java.util.ResourceBundle;
import java.util.Scanner;

public class Part5 {

	private static final String CAKE = "cake";
	private static final String APPLE = "apple";
	private static final String TABLE = "table";

	private static String trans2Eng(String string) {
		ResourceBundle resRu = ResourceBundle.getBundle("resources_en");
		return resRu.getString(string);
	}

	private static String trans2Rus(String string) {
		ResourceBundle resEn = ResourceBundle.getBundle("resources_ru");
		return resEn.getString(string);
	}

	private static String trans2French(String string) {
		ResourceBundle resEn = ResourceBundle.getBundle("resources_fr");
		return resEn.getString(string);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String someword = scanner.nextLine();
			switch (someword) {
			case "table en":
				System.out.println(trans2Eng(TABLE));
				continue;
			case "table ru":
				System.out.println(trans2Rus(TABLE));
				continue;
			case "apple en":
				System.out.println(trans2Eng(APPLE));
				continue;
			case "apple ru":
				System.out.println(trans2Rus(APPLE));
				continue;
			case "cake en":
				System.out.println(trans2Eng(CAKE));
				continue;
			case "cake ru":
				System.out.println(trans2Rus(CAKE));
				continue;
			case "table fr":
				System.out.println(trans2French(TABLE));
				continue;
			case "apple fr":
				System.out.println(trans2French(APPLE));
				continue;
			case "cake fr":
				System.out.println(trans2French(CAKE));
				continue;
			case "stop":
				return;
			default:
				System.out.println("No such values");
			}
		}
	}
}
