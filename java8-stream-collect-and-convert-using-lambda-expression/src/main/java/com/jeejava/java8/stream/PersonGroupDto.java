package com.jeejava.java8.stream;

import java.util.ArrayList;
import java.util.List;

public class PersonGroupDto {

	private String groupName;
	private List<PersonDto> persons;

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public List<PersonDto> getPersons() {
		if (persons == null) {
			persons = new ArrayList<>();
		}
		return persons;
	}

	public void setPersons(List<PersonDto> persons) {
		this.persons = persons;
	}

	@Override
	public String toString() {
		return "PersonGroupDto [groupName=" + groupName + ", persons=" + persons + "]";
	}

}
