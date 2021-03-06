package ua.nure.filonitch.practice5;

import java.io.IOException;
import java.io.InputStream;

public class Part2 {
	public static void main(String[] args) {
		new Thread() {
			public void run() {
				try {
					Spam.main(null);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}.start();

		InputStream input = new InputStream() {
			private int c;

			@Override
			public int read() throws IOException {
					try {
						Thread.sleep(700);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					if (c < System.lineSeparator().length()) {
						return System.lineSeparator().getBytes()[c++];
					}
				return -1;
			}
		};
		System.setIn(input);
		System.setIn(System.in);
	}
	
}
