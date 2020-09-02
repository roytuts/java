package com.roytuts.java.remove.duplicate.objects.from.list;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class RemoveDuplicateObjectsApp {

	public static void main(String[] args) {
		List<Car> cars = buildCars();
		System.out.println("Cars with duplicates: " + cars.size());
		System.out.println("------------------------------");

		cars.stream().forEach(c -> System.out.println(c));

		System.out.println();
		
		List<Car> carWithoutDuplicates = getCarsWithoutDuplicates2(cars);

		System.out.println();
		System.out.println("Cars without duplicates: " + carWithoutDuplicates.size());
		System.out.println("------------------------------");

		carWithoutDuplicates.stream().forEach(c -> System.out.println(c));

		/*
		 * List<Car> carWithoutDuplicates = getCarsWithoutDuplicates(cars);
		 * 
		 * System.out.println(); System.out.println("Cars without duplicates: " +
		 * carWithoutDuplicates.size());
		 * System.out.println("------------------------------");
		 * 
		 * carWithoutDuplicates.stream().forEach(c -> System.out.println(c));
		 */
	}

	private static List<Car> getCarsWithoutDuplicates(final List<Car> cars) {
		Set<Car> carSet = new TreeSet<Car>(new CarComparator());
		for (Car car : cars) {
			carSet.add(car);
		}
		List<Car> withoutDuplicates = new ArrayList<Car>(carSet);
		return withoutDuplicates;
	}

	private static List<Car> getCarsWithoutDuplicates2(final List<Car> cars) {
		Set<Car> carSet = new HashSet<Car>();

		for (Car car : cars) {
			carSet.add(car);
		}

		List<Car> withoutDuplicates = new ArrayList<Car>(carSet);

		return withoutDuplicates;
	}

	private static List<Car> buildCars() {
		List<Car> cars = new ArrayList<Car>();

		Car car1 = new Car("Tata Motors", "Indica", 1990, true);
		Car car2 = new Car("Tata Motors", "Sumo", 1992, true);
		Car car3 = new Car("Maruti Suzuki", "WagonR", 1990, true);
		Car car4 = new Car("Tata Motors", "Sumo", 1994, true);
		Car car5 = new Car("Tata Motors", "Indica", 1990, true);
		Car car6 = new Car("Maruti Suzuki", "Swift", 2006, true);
		Car car7 = new Car("Hundai", "SX4", 1990, true);
		Car car8 = new Car("Tata Motors", "Zica", 2015, true);
		Car car9 = new Car("Maruti Suzuki", "Dzire", 2008, true);
		Car car10 = new Car("Maruti Suzuki", "Swift", 2006, true);

		cars.add(car1);
		cars.add(car2);
		cars.add(car3);
		cars.add(car4);
		cars.add(car5);
		cars.add(car6);
		cars.add(car7);
		cars.add(car8);
		cars.add(car9);
		cars.add(car10);

		return cars;
	}

}
