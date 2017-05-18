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

			PersonOutputGenerator.generateOutput(personList, (Person p1, Person p2) -> {
            if(!p1.getGender().equals(p2.getGender())) {
              return p1.getGender().compareTo(p2.getGender());
            }
            return p1.getLastName().compareTo(p2.getLastName());
          }, "Output 1:\n");
			PersonOutputGenerator.generateOutput(personList, (Person p1, Person p2) -> {
            if(p1.getDateOfBirth().compareTo(p2.getDateOfBirth()) != 0) {
              return p1.getDateOfBirth().compareTo(p2.getDateOfBirth());
            }

            return p1.getLastName().compareTo(p2.getLastName());
          }, "\nOutput 2:\n");
			PersonOutputGenerator.generateOutput(personList, (Person p1, Person p2) -> p2.getLastName().compareTo(p1.getLastName()), "\nOutput 3:\n");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
