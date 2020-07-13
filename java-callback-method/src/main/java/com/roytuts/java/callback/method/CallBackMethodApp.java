package com.roytuts.java.callback.method;

public class CallBackMethodApp {

	public static void main(String[] args) {

		new Worker().doWork(new Callable() {
			@Override
			public void call() {
				System.out.println("Callback Called");
			}
		});

	}

}
