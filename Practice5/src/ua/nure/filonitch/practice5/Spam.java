package ua.nure.filonitch.practice5;

import java.util.Scanner;

public class Spam {

	private static final String[] messages = { "hello", "wutdoink", "damn","hey" };
	private static int[] times = { 500, 500, 500, 500 };

	public static void main(String[] args) throws InterruptedException {
		Worker w = new Worker();
		Thread t = new Thread(() -> {
			Scanner scann = new Scanner(System.in);
			scann.nextLine();
			scann.close();
			w.interrupt();
		});
		w.start();
		t.start();
		w.join();
		
	}

	public void start() {
		Worker w = new Worker();
		w.start();
	}

	public static class Worker extends Thread {
		@Override
		public void run() {
			int counterOftimes = 0;
			while (counterOftimes < messages.length) {
				try {
					Thread.sleep(times[counterOftimes]);
					System.out.println(messages[counterOftimes]);
					counterOftimes++;
					if (counterOftimes == messages.length) {
						break;
					}
				} catch (InterruptedException exept) {
					break;
				}
			}
		}
	}
}
