package com.roytuts.java.shallowdeep.copyclone.vo;

public class Employee /*for deep copy or clone*/ implements Cloneable {

	private String name;

	public Employee(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// for deep copy or clone
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
