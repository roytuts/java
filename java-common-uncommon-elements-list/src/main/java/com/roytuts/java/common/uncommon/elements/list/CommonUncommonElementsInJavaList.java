package com.roytuts.java.common.uncommon.elements.list;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CommonUncommonElementsInJavaList {

	public static void main(String[] args) {
		//opOnStrings();

		opOnObjects();
	}

	private static void opOnObjects() {
		List<User> ListOne = new ArrayList<>() {
			private static final long serialVersionUID = 1L;
			{
				add(new User("Soumitra", "Soumitra@email.com"));
				add(new User("Michael", "Michael@email.com"));
				add(new User("John", "John@email.com"));
				add(new User("Roytuts", "Roytuts@email.com"));
				add(new User("Roy Tutorials", "Roy-Tutorials@email.com"));
			}
		};

		List<User> ListTwo = new ArrayList<>() {
			private static final long serialVersionUID = 1L;
			{
				add(new User("Roy Tutorials", "Roy-Tutorials@email.com"));
				add(new User("Jerome", "Jerome@email.com"));
				add(new User("Ford", "Ford@email.com"));
				add(new User("Microservices", "Microservices@email.com"));
			}
		};

		System.out.println("List One: " + ListOne);
		System.out.println("List Two: " + ListTwo);

		List<User> baseList = new ArrayList<>(ListOne);
		baseList.retainAll(ListTwo);
		System.out.println("Common elements in List One and Two: " + baseList);

		baseList = new ArrayList<>(ListOne);
		baseList.removeAll(ListTwo);
		System.out.println("Uncommon elements in List One: " + baseList);

		baseList = new ArrayList<>(ListTwo);
		baseList.removeAll(ListOne);
		System.out.println("Uncommon elements in List Two: " + baseList);

		baseList = new ArrayList<>(ListOne);
		baseList.addAll(ListTwo);
		System.out.println("All elements in List One and List Two: " + baseList);

		Set<User> uniqueUsers = new HashSet<>();
		uniqueUsers.addAll(ListOne);
		uniqueUsers.addAll(ListTwo);
		System.out.println("Unique elements in List One and List Two: " + uniqueUsers);
	}

	private static void opOnStrings() {
		List<String> ListOne = new ArrayList<>() {
			private static final long serialVersionUID = 1L;
			{
				add("Soumitra");
				add("Michael");
				add("John");
				add("Roytuts");
				add("Roy Tutorials");
			}
		};

		List<String> ListTwo = new ArrayList<>() {
			private static final long serialVersionUID = 1L;
			{
				add("Roy Tutorials");
				add("Jerome");
				add("Ford");
				add("Microservices");
			}
		};

		System.out.println("List One: " + ListOne);
		System.out.println("List Two: " + ListTwo);

		List<String> baseList = new ArrayList<>(ListOne);
		baseList.retainAll(ListTwo);
		System.out.println("Common elements in List One and Two: " + baseList);

		baseList = new ArrayList<>(ListOne);
		baseList.removeAll(ListTwo);
		System.out.println("Uncommon elements in List One: " + baseList);

		baseList = new ArrayList<>(ListTwo);
		baseList.removeAll(ListOne);
		System.out.println("Uncommon elements in List Two: " + baseList);

		baseList = new ArrayList<>(ListOne);
		baseList.addAll(ListTwo);
		System.out.println("All elements in List One and List Two: " + baseList);

		Set<String> uniqueStrings = new HashSet<>();
		uniqueStrings.addAll(ListOne);
		uniqueStrings.addAll(ListTwo);
		System.out.println("Unique elements in List One and List Two: " + uniqueStrings);
	}

}
