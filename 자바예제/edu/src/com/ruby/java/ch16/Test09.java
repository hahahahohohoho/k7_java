package com.ruby.java.ch16;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test09 {

	public static void main(String[] args) {

		ExecutorService threadPool1 = Executors.newFixedThreadPool(10);
		ExecutorService threadPool2 = Executors.newCachedThreadPool();

		threadPool1.execute(new Task());
		threadPool1.execute(() -> {
			for (int i = 0; i < 10; i++) {
				System.out.println("스레드 작업 2");
			}
		});

		threadPool1.shutdown();
		threadPool2.shutdown();
	}

}

class Task implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("스레드 작업 1");
		}

	}
}