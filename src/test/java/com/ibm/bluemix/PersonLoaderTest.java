package com.ibm.bluemix;

import java.io.FileNotFoundException;
import java.util.List;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class PersonLoaderTest extends TestCase {
    public PersonLoaderTest(String testName) {
        super(testName);
    }
    public static Test suite() {
        return new TestSuite(PersonLoaderTest.class);
    }

    public void testSpace() throws FileNotFoundException {
    	List<Person> personList = PersonLoader.loadPersonRecordsFromFile("./data/space.txt", "\\s+", new String[]{ Person.LAST_NAME, Person.FIRST_NAME, Person.IGNORE,
                Person.GENDER, Person.DATE_OF_BIRTH, Person.COLOR });
    	assertEquals(3, personList.size());
    	assertEquals("Kournikova", personList.get(0).getLastName());
    	assertEquals("Hingis", personList.get(1).getLastName());
    	assertEquals("Seles", personList.get(2).getLastName());
    }

    public void testPipe() throws FileNotFoundException {
    	List<Person> personList = PersonLoader.loadPersonRecordsFromFile("./data/pipe.txt", "\\s*\\|\\s*", new String[]{ Person.LAST_NAME, Person.FIRST_NAME, Person.IGNORE,
                Person.GENDER, Person.COLOR, Person.DATE_OF_BIRTH });
    	assertEquals(3, personList.size());
    	assertEquals("Smith", personList.get(0).getLastName());
    	assertEquals("Bonk", personList.get(1).getLastName());
    	assertEquals("Bouillon", personList.get(2).getLastName());
    }

    public void testComma() throws FileNotFoundException { 	
    	List<Person> personList = PersonLoader.loadPersonRecordsFromFile("./data/comma.txt", "\\s*,\\s*", new String[]{ Person.LAST_NAME, Person.FIRST_NAME, Person.GENDER,
                Person.COLOR, Person.DATE_OF_BIRTH });
    	assertEquals(3, personList.size());
    	assertEquals("Abercrombie", personList.get(0).getLastName());
    	assertEquals("Bishop", personList.get(1).getLastName());
    	assertEquals("Kelly", personList.get(2).getLastName());
    }   
}
