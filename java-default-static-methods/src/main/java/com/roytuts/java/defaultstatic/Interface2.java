package com.roytuts.java.defaultstatic;

public interface Interface2 {

	default String getMsg() {
		return "Hello";
	}

	static void display() {
		System.out.println("static in interface 2");
	}
}
