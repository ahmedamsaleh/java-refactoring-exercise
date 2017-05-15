package com.ibm.bluemix;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class PersonOutputGenerator {
	static void generateOutput1(List<Person> personList) {
		personList.sort((p1, p2) -> {
            if (!p1.getGender().equals(p2.getGender())) {
                return p1.getGender().compareTo(p2.getGender());
            }
            return p1.getLastName().compareTo(p2.getLastName());
        });
		System.out.println("Output 1:");
		println();
		printPerson(personList);
	}

	static void generateOutput2(List<Person> personList) {
		personList.sort((p1, p2) -> {
            if (p1.getDateOfBirth().compareTo(p2.getDateOfBirth()) != 0) {
                return p1.getDateOfBirth().compareTo(p2.getDateOfBirth());
            }
            return p1.getLastName().compareTo(p2.getLastName());
        });
		println();
		System.out.println("Output 2:");
		println();
		printPerson(personList);
	}

	static void generateOutput3(List<Person> personList) {
		personList.sort((p1, p2) -> p2.getLastName().compareTo(p1.getLastName()));
		println();
		System.out.println("Output 3:");
		println();
		printPerson(personList);
	}

	private static void println() {
		System.out.println("");
	}

	private static void printPerson(List<Person> personList) {
		for (Person person : personList) {
			System.out.println(person);
		}
	}
}
