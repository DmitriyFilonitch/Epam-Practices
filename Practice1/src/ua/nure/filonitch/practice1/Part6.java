package ua.nure.filonitch.practice1;

import java.util.stream.IntStream;

public class Part6 {
	public static void main(String[] args) {
		int s = Integer.parseInt(args[0]);
		int[] a = IntStream.iterate(2, k -> k + 1).filter(m -> IntStream.range(2, m).noneMatch(y -> m % y == 0)).limit(s).toArray();
		for (int k = 0; k < s; k++) {
			if (k == s - 1) {
				System.out.println(a[k] + " ");
			} else {
				System.out.print(a[k] + " ");
			}
		}

	}
}
