package com.roytuts.java.shallowdeep.copyclone;

import com.roytuts.java.shallowdeep.copyclone.vo.Department;
import com.roytuts.java.shallowdeep.copyclone.vo.Employee;

public class DeepCopyCloneTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		Employee employee = new Employee("Soumitra");
		Department department = new Department("Computer", employee);

		Department clonedDept = (Department) department.clone();

		System.out.println("Employee name in department : " + department.getEmployee().getName());
		System.out.println("Employee name in clonedDept : " + clonedDept.getEmployee().getName());

		System.out.println();
		System.out.println("After setting Employee name to cloned object");
		System.out.println();

		clonedDept.getEmployee().setName("Soumitra2");

		System.out.println("After setting, Employee name in clonedDept : " + clonedDept.getEmployee().getName());
		System.out.println("After setting, Employee name in department : " + department.getEmployee().getName());
	}

}
