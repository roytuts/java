package com.roytuts.java.defaultstatic;

public interface Interface1 {

	default String getMsg() {
		return "Hi";
	}

	static void display() {
		System.out.println("static in interface 1");
	}

}
