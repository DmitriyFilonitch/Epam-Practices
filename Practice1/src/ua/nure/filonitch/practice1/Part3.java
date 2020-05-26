package ua.nure.filonitch.practice1;

public class Part3 {
	public static void main(String[] args) {
		for (int a = 0; a < args.length; a++) {
			if (a != args.length - 1) {
				System.out.print(args[a] + " ");
			} else {
				System.out.println(args[a]);
			}
		}
	}
}
