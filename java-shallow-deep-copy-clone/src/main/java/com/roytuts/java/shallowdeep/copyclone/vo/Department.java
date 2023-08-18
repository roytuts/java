package com.roytuts.java.shallowdeep.copyclone.vo;

public class Department implements Cloneable {

	private String name;
	private Employee employee;

	public Department(String name, Employee employee) {
		this.name = name;
		this.employee = employee;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	//shallow copy or clone
	/*@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}*/
	
	//deep copy or clone
	@Override
	public Object clone() throws CloneNotSupportedException {
		Department d = (Department) super.clone();
		d.setEmployee((Employee) d.getEmployee().clone());

		return d;
	}

}
