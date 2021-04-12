package com.roytuts.java.custom.immutable.clasz;

public final class Person {

	private final String name;
	private final Address address;
	// private final MyAddress address;
	
	public Person(String name, Address address) {
		this.name = name;
		//this.address = address;
		this.address = new Address(address.getCity(), address.getCountry());
	}

	// public Person(String name, MyAddress address) {
	// this.name = name;
	// this.address = address;
	// }

	public String getName() {
		return name;
	}
	
	public Address getAddress() {
		Address addr = new Address(address.getCity(), address.getCountry());
		return addr;
	}

	//public Address getAddress() {
		//return (Address) address.clone();
	//}

	// public MyAddress getAddress() {
	// return (MyAddress) address.clone();
	// }

	
}
