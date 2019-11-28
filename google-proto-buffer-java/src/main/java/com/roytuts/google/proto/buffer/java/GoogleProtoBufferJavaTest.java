package com.roytuts.google.proto.buffer.java;

import com.roytuts.google.proto.buffer.java.model.EmployeeProto.Employee;
import com.roytuts.google.proto.buffer.java.model.EmployeeProto.Employee.Address;
import com.roytuts.google.proto.buffer.java.model.EmployeeProto.Employee.AddressType;
import com.roytuts.google.proto.buffer.java.model.EmployeeProto.Employee.PhoneNumber;
import com.roytuts.google.proto.buffer.java.model.EmployeeProto.Employee.PhoneType;
import com.roytuts.google.proto.buffer.java.model.EmployeeProto.Organization;

public class GoogleProtoBufferJavaTest {

	public static void main(String[] args) {
		PhoneType phoneType = PhoneType.MOBILE;

		PhoneNumber phoneNumber = PhoneNumber.newBuilder().setNumber("1234567").setType(phoneType).build();

		AddressType addressType = AddressType.PERMANENT;

		Address address = Address.newBuilder().setStreet("Street").setCity("City").setZip(123456).setState("State")
				.setCountry("Country").setType(addressType).build();

		Employee employee = Employee.newBuilder().setId(1234).setName("Soumitra").setEmail("soumitra@email.com")
				.addPhones(phoneNumber).addAddress(address).build();

		Organization organization = Organization.newBuilder().addEmployee(employee).build();

		for (Employee emp : organization.getEmployeeList()) {
			System.out.println(emp.getId());
			System.out.println(emp.getName());
			System.out.println(emp.getEmail());
			System.out.println(emp.getPhonesList().get(0));
			System.out.println(emp.getAddressList().get(0));
		}
	}

}
