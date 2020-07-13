package com.roytuts.java.callback.method;

public class Worker {

	public void doWork(Callable callable) {
		System.out.println("Doing Work");
		callable.call();
	}

}
