package com.ibm.bluemix;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class CandidateApp {
	public static void main(String[] args) {
		List<Person> personList = new ArrayList<Person>();
		
		try {
			populatePersonList(personList);
			generatePersonOutput(personList);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void generatePersonOutput(List<Person> personList) {
		PersonOutputGenerator.generateOutput1(personList);
		PersonOutputGenerator.generateOutput2(personList);
		PersonOutputGenerator.generateOutput3(personList);
	}

	private static void populatePersonList(List<Person> personList) throws FileNotFoundException {
		personList.addAll(PersonLoader.loadPersonRecordsFromSpaceFile());
		personList.addAll(PersonLoader.loadPersonRecordsFromPipeFile());
		personList.addAll(PersonLoader.loadPersonRecordsFromCommaFile());
	}
}
