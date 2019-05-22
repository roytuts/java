package com.jeejava.threadlocal;

import java.util.Date;

public class TaskThread implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.println("Thread: " + Thread.currentThread().getName() + " Formatted Date: "
					+ ThreadLocalPerThread.formatDate(new Date()));
		}
	}

}
