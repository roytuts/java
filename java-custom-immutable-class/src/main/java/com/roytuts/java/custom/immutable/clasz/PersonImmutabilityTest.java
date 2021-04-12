package com.roytuts.java.custom.immutable.clasz;

public class PersonImmutabilityTest {

	public static void main(String[] args) {
		Person person = new Person("Soumitra", new Address("City", "Country"));
		// Person person = new Person("Soumitra", new MyAddress("City", "Country"));

		Address address = person.getAddress();
		System.out.println(address);

		address.setCity("City1");
		address.setCountry("Country1");
		
		System.out.println("person.getAddress(): " + person.getAddress());
		
		System.out.println("After: " + address);
	}

}
