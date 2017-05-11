package com.ibm.bluemixFormatted;

import com.ibm.bluemix.Person;
import com.ibm.bluemix.PersonLoader;
import com.ibm.bluemix.PersonOutputGenerator;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class CandidateAppFormatted {
	public static void main(String[] args) {
		List<Person> personList = new ArrayList<Person>();
		
		try {
			personList.addAll(PersonLoader.loadPersonRecordsFromSpaceFile());
			personList.addAll(PersonLoader.loadPersonRecordsFromPipeFile());
			personList.addAll(PersonLoader.loadPersonRecordsFromCommaFile());
			
			PersonOutputGenerator.generateOutput1(personList);
			PersonOutputGenerator.generateOutput2(personList);
			PersonOutputGenerator.generateOutput3(personList);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
