package com.ibm.bluemix;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class CandidateApp {
	public static void main(String[] args) {
		List<Person> personList = new ArrayList<>();
		
		try {
			personList.addAll(PersonLoader.loadPersonRecordsFromFile(
					"./data/space.txt", "\\s+",
					new String[]{ Person.LAST_NAME, Person.FIRST_NAME, Person.IGNORE,
                            Person.GENDER, Person.DATE_OF_BIRTH, Person.COLOR }));
			personList.addAll(PersonLoader.loadPersonRecordsFromFile(
					"./data/pipe.txt", "\\s*\\|\\s*",
					new String[]{ Person.LAST_NAME, Person.FIRST_NAME, Person.IGNORE,
                            Person.GENDER, Person.COLOR, Person.DATE_OF_BIRTH }));
			personList.addAll(PersonLoader.loadPersonRecordsFromFile(
					"./data/comma.txt", "\\s*,\\s*",
					new String[]{ Person.LAST_NAME, Person.FIRST_NAME, Person.GENDER,
                            Person.COLOR, Person.DATE_OF_BIRTH }));
			
			PersonOutputGenerator.generateOutput1(personList);
			PersonOutputGenerator.generateOutput2(personList);
			PersonOutputGenerator.generateOutput3(personList);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
