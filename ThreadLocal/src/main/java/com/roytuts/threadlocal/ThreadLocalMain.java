package com.roytuts.threadlocal;

public class ThreadLocalMain {
	
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new TaskThread());
		Thread t2 = new Thread(new TaskThread());
		Thread t3 = new Thread(new TaskThread());

		t1.start();
		t2.start();
		t3.start();
	}

}
