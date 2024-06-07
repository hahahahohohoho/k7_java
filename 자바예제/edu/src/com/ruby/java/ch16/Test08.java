package com.ruby.java.ch16;

public class Test08 {

	public static void main(String[] args) {
		PrintThread t = new PrintThread();
		t.start();
	}
}

class PrintThread extends Thread {
	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				Thread.sleep(2000);
				System.out.println("출력 : " + i);
			}
		} catch (InterruptedException e) {
			System.out.println("Interrupt가 발생하여 Sleep 상태를 종료함");
		}
	}
}