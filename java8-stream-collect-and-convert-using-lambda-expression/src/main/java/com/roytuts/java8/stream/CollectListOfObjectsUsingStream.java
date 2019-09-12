package com.roytuts.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectListOfObjectsUsingStream {

	public static void main(String[] args) {

		PersonEntity pe1 = new PersonEntity(1000, "Soumitra roy", "contact@roytuts.com");
		PersonEntity pe2 = new PersonEntity(1001, "arup chatterjee", "arup@chatterjee.com");
		PersonEntity pe3 = new PersonEntity(1002, "Souvik Sanyal", "souvik@sanyal.com");
		PersonEntity pe4 = new PersonEntity(1003, "suman Mukherjee", "suman@mukherjee.com");
		PersonEntity pe5 = new PersonEntity(1004, "soumitra sarkar", "contact@roytuts.com");
		PersonEntity pe6 = new PersonEntity(1005, "Anjel Ghosh", "anjel@ghosh.com");
		PersonEntity pe7 = new PersonEntity(1006, "suman Pandit", "suman@pandit.com");
		PersonEntity pe8 = new PersonEntity(1007, "Ranjit pandit", "ranjit@pandit.com");
		PersonEntity pe9 = new PersonEntity(1008, "TK pal", "tk@pal.com");
		PersonEntity pe10 = new PersonEntity(1009, "Abhisekh paul", "abhisekh@paul.com");
		PersonEntity pe11 = new PersonEntity(1010, "Sumanjit raut", "sumanjit@raut.com");

		PersonGroupEntity pg1 = new PersonGroupEntity("Product", new ArrayList<PersonEntity>(Arrays.asList(pe9)));
		PersonGroupEntity pg2 = new PersonGroupEntity("Service",
				new ArrayList<PersonEntity>(Arrays.asList(pe1, pe2, pe3, pe4, pe5, pe7, pe10, pe11)));
		PersonGroupEntity pg3 = new PersonGroupEntity("Solution", new ArrayList<PersonEntity>(Arrays.asList(pe6)));
		PersonGroupEntity pg4 = new PersonGroupEntity("Teaching", new ArrayList<PersonEntity>(Arrays.asList(pe8)));
		PersonGroupEntity pg5 = new PersonGroupEntity("Core", null);

		List<PersonGroupEntity> personGroupEntities = new ArrayList<>(Arrays.asList(pg1, pg2, pg3, pg4, pg5));

		List<PersonGroupDto> personGroupDtos = personGroupEntities.stream().map(pg -> {
			PersonGroupDto personGroupDto = new PersonGroupDto();
			personGroupDto.setGroupName(pg.getGrpName());
			if (pg.getPersons() != null) {
				List<PersonDto> personDtos = pg.getPersons().stream().map(p -> {
					PersonDto personDto = new PersonDto();
					personDto.setId(p.getId());
					String[] fullName = splitNamesInitCharCapitalize(p.getName());
					personDto.setFirstName(fullName[0]);
					personDto.setLastName(fullName[1]);
					personDto.setEmailAddress(p.getEmail());
					return personDto;
				}).collect(Collectors.toList());
				personGroupDto.setPersons(personDtos);
			} else {
				personGroupDto.setPersons(new ArrayList<>());
			}
			return personGroupDto;
		}).collect(Collectors.toList());

		personGroupDtos.forEach(pg -> System.out.println(pg));
	}

	private static String[] splitNamesInitCharCapitalize(String name) {
		String[] splits = name.split("\\s");
		String firstNameInitChar = splits[0].substring(0, 1).toUpperCase();
		String lastNameInitChar = splits[1].substring(0, 1).toUpperCase();
		String[] fullName = new String[] { firstNameInitChar + splits[0].substring(1),
				lastNameInitChar + splits[1].substring(1) };
		return fullName;
	}

}
