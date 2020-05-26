package ua.nure.filonitch.practice5;

public class Part1 {
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new SomeThread();
		t1.start();
		t1.join();
		Thread t2 = new Thread(new RunnableImpl());
		t2.start();
		t2.join();
		Thread t3 = new Thread(Part1::run);
		t3.start();
		t3.join();

	}

	public static void run() {
		try {
			long start = System.currentTimeMillis();
			while (start + 1000 > System.currentTimeMillis()) {
				System.out.println(Thread.currentThread().getName());
				Thread.sleep(333);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
