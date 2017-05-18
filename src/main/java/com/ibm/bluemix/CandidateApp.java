package com.ibm.bluemix;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class CandidateApp {
	public static void main(String[] args) {
		List<Person> personList = new ArrayList<Person>();
		
		try {
			personList.addAll(PersonLoader.loadPersonRecords("./data/space.txt", new String[] {Person.LAST_NAME, Person.FIRST_NAME, Person.IGNORE, Person.GENDER, Person.DATE_OF_BIRTH, Person.COLOR}, "\\s+"));
			personList.addAll(PersonLoader.loadPersonRecords("./data/pipe.txt", new String[] {Person.LAST_NAME, Person.FIRST_NAME, Person.IGNORE, Person.GENDER, Person.COLOR, Person.DATE_OF_BIRTH}, "\\s*\\|\\s*"));
			personList.addAll(PersonLoader.loadPersonRecords("./data/comma.txt", new String[] {Person.LAST_NAME, Person.FIRST_NAME, Person.GENDER, Person.COLOR, Person.DATE_OF_BIRTH}, "\\s*,\\s*"));

			PersonOutputGenerator.generateOutput1(personList);
			PersonOutputGenerator.generateOutput2(personList);
			PersonOutputGenerator.generateOutput3(personList);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
