package com.ruby.java.ch16;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test10 {

	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newCachedThreadPool();
		Future<Date> future = threadPool.submit(new Callable<Date>() {
			@Override
			public Date call() throws Exception {
				Thread.sleep(1000);
				return new Date();
			}
		});

		Date date = null;
		try {
			date = future.get();
			System.out.println(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}