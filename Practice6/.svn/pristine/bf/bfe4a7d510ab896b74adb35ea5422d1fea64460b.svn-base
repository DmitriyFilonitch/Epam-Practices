package ua.nure.filonitch.practice6;

import java.io.IOException;


import ua.nure.filonitch.practice6.part1.Part1;
import ua.nure.filonitch.practice6.part2.Part2;
import ua.nure.filonitch.practice6.part3.Part3;
import ua.nure.filonitch.practice6.part4.Part4;
import ua.nure.filonitch.practice6.part5.Part5;
import ua.nure.filonitch.practice6.part6.Part6;

public class Demo {

	public static void main(String[] args){
		try {
			Part1.main(args);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Part2.main(args);
		Part3.main(args);
		Part4.main(args);
		Part5.main(args);
		System.out.println("Frequency demonstration: ");
		Part6.main(new String[] { "-i", "part6.txt", "-t", "frequency" });
		System.out.println("Length demonstration: ");
		Part6.main(new String[] { "-i", "part6.txt", "-t", "length" });
		System.out.println("Duplicates demonstration: ");
		Part6.main(new String[] { "-i", "part6.txt", "-t", "duplicates" });
		
	}
}
