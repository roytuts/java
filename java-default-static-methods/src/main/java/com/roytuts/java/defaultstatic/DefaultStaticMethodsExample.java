package com.roytuts.java.defaultstatic;

public class DefaultStaticMethodsExample {

	public static void main(String[] args) {
		InterfaceDefaultStaticMethods defaultStaticMethods = new ClassDefaultStaticMethods();

		System.out.println("Current Time: " + defaultStaticMethods.getLocalDateTime());
		System.out.println("Zonal Time: " + defaultStaticMethods.getZonedDateTime("US/Eastern"));
		System.out.println("getHello: " + defaultStaticMethods.getHello());
		System.out.println("getZoneId: " + InterfaceDefaultStaticMethods.getZoneId("US/Central"));
		System.out.println("getMsg: " + InterfaceDefaultStaticMethods.getMsg());

		System.out.println("--------------------------------------------");

		ClassInterface classInterface = new ClassInterface();
		System.out.println("Message: " + classInterface.getMsg());
	}

}
