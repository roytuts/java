package com.jeejava.java8.stream;

import java.util.List;

public class PersonGroupEntity {

	private String grpName;
	private List<PersonEntity> persons;

	public PersonGroupEntity() {
	}

	public PersonGroupEntity(String grpName, List<PersonEntity> persons) {
		this.grpName = grpName;
		this.persons = persons;
	}

	public String getGrpName() {
		return grpName;
	}

	public void setGrpName(String grpName) {
		this.grpName = grpName;
	}

	public List<PersonEntity> getPersons() {
		return persons;
	}

	public void setPersons(List<PersonEntity> persons) {
		this.persons = persons;
	}

}
