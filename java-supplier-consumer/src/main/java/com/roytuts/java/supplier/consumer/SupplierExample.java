package com.roytuts.java.supplier.consumer;

import java.util.function.Supplier;

public class SupplierExample {

	public static void main(String[] args) {
		supply(() -> "Hi");
		supply(() -> "Hey");
		supply(() -> "Hello");
	}

	public static void supply(Supplier<?> supplier) {
		System.out.println(supplier.get());
	}

}
