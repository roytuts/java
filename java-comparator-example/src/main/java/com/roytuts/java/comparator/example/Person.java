package com.roytuts.java.comparator.example;

import java.util.Comparator;

public class Person {

	private String name;
	private int age;
	private String email;

	public Person(String name, int age, String email) {
		this.name = name;
		this.age = age;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", email=" + email + "]";
	}

	public static final Comparator<Person> PersonNameComparator = new Comparator<Person>() {
		@Override
		public int compare(Person p1, Person p2) {
			return p1.getName().compareToIgnoreCase(p2.getName());
		}
	};

	public static final Comparator<Person> PersonAgeComparator = new Comparator<Person>() {
		@Override
		public int compare(Person p1, Person p2) {
			return p1.getAge() - p2.getAge();
		}
	};

	public static final Comparator<Person> PersonEmailComparator = new Comparator<Person>() {
		@Override
		public int compare(Person p1, Person p2) {
			return p1.getEmail().compareToIgnoreCase(p2.getEmail());
		}
	};

}
