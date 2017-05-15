package com.ibm.bluemix;

import java.util.List;

class PersonOutputGenerator {
	static void generateOutput(List<Person> personList, String outputNumber) {
		sortPersonList(personList, outputNumber);
		printResult(personList, outputNumber);
	}

	private static void sortPersonList(List<Person> personList, String outputNumber) {
		switch (outputNumber) {
			case "Output 1:":
				personList.sort((p1, p2) -> {
					if (!p1.getGender().equals(p2.getGender())) {
						return p1.getGender().compareTo(p2.getGender());
					}
					return p1.getLastName().compareTo(p2.getLastName());
				});
				break;
			case "Output 2:":
				personList.sort((p1, p2) -> {
					if (p1.getDateOfBirth().compareTo(p2.getDateOfBirth()) != 0) {
						return p1.getDateOfBirth().compareTo(p2.getDateOfBirth());
					}
					return p1.getLastName().compareTo(p2.getLastName());
				});
				break;
			default:
				personList.sort((p1, p2) -> p2.getLastName().compareTo(p1.getLastName()));
				break;
		}
	}

	private static void printResult(List<Person> personList, String outputNumber) {
		if (!outputNumber.equals("Output 1:")){
			System.out.println("");
		}
		System.out.println(outputNumber);
		System.out.println("");
		printPerson(personList);
	}

	private static void printPerson(List<Person> personList) {
		for (Person person : personList) {
			System.out.println(person);
		}
	}
}
