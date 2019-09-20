package com.roytuts.java.comparator.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorTest {

	public static void main(String[] args) {
		Person p1 = new Person("Ram", 20, "ram@email.com");
		Person p2 = new Person("Syam", 28, "syam@email.com");
		Person p3 = new Person("Jadu", 24, "jadu@email.com");
		Person p4 = new Person("Madhu", 32, "madhu@email.com");
		Person p5 = new Person("Ganesh", 30, "ganesh@email.com");

		List<Person> persons = new ArrayList<Person>();
		persons.add(p1);
		persons.add(p2);
		persons.add(p3);
		persons.add(p4);
		persons.add(p5);

		System.out.println("Comparison based on Name");

		//Collections.sort(persons, new PersonNameComparator());
		Collections.sort(persons, Person.PersonNameComparator);

		persons.forEach(p -> System.out.println(p));

		System.out.println();

		System.out.println("Comparison based on Age");

		//Collections.sort(persons, new PersonAgeComparator());
		Collections.sort(persons, Person.PersonAgeComparator);

		persons.forEach(p -> System.out.println(p));

		System.out.println();

		System.out.println("Comparison based on Email");

		//Collections.sort(persons, new PersonEmailComparator());
		Collections.sort(persons, Person.PersonEmailComparator);

		persons.forEach(p -> System.out.println(p));
	}

}
