package com.roytuts.java.instantiate.pvt.constructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class InstantiatePrivateConstructor {

	public static void main(String[] args) {
		String systemClassName = "java.lang.System";
		String runtimeClassName = "java.lang.Runtime";
		String classClassName = "java.lang.Class";

		try {
			Class<?> system = Class.forName(systemClassName);
			Constructor<?> sysConstructor = system.getDeclaredConstructor();
			sysConstructor.setAccessible(true);

			System sysObject = (System) sysConstructor.newInstance();
			Field[] systemFields = sysObject.getClass().getFields();

			System.out.println("Class Name: " + systemClassName);
			System.out.println("-------------------------------------------------");

			System.out.println("sysObject: " + sysObject);
			System.out.println("systemFields length: " + systemFields.length);

			for (int i = 0; i < systemFields.length; i++) {
				System.out.println("Field Name: " + systemFields[i].getName());
				System.out.println("Field Type: " + systemFields[i].getType());
			}

			System.out.println("===================================================");
			System.out.println();

			Class<?> runtime = Class.forName(runtimeClassName);
			Constructor<?> runConstructor = runtime.getDeclaredConstructor();
			runConstructor.setAccessible(true);

			Runtime runObject = (Runtime) runConstructor.newInstance();
			Field[] runFields = runObject.getClass().getFields();

			System.out.println("Class Name: " + runtimeClassName);
			System.out.println("-------------------------------------------------");

			System.out.println("runObject: " + runObject);
			System.out.println("runFields length: " + runFields.length);

			for (int i = 0; i < runFields.length; i++) {
				System.out.println("Field Name: " + runFields[i].getName());
				System.out.println("Field Type: " + runFields[i].getType());
			}

			System.out.println("===================================================");
			System.out.println();

			Class<?> clss = Class.forName(classClassName);
			Constructor<?> classConstructor = clss.getDeclaredConstructor();

			System.out.println("Class Name: " + classClassName);
			System.out.println("-------------------------------------------------");

			System.out.println("Now you will get Exception for below line");
			System.out.println();

			classConstructor.newInstance();
		} catch (InstantiationException | IllegalAccessException | SecurityException | NoSuchMethodException
				| IllegalArgumentException | InvocationTargetException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
