package com.roytuts.java.comparator.example;

import java.util.Comparator;

public class PersonAgeComparator implements Comparator<Person> {

	@Override
	public int compare(Person p1, Person p2) {
		return p1.getAge() - p2.getAge();
	}

}
