package com.ibm.bluemixFormatted;

import com.ibm.bluemix.Person;
import com.ibm.bluemix.PersonLoader;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.FileNotFoundException;
import java.util.List;

public class PersonLoaderTestFormatted extends TestCase {
    public PersonLoaderTestFormatted(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(PersonLoaderTestFormatted.class);
    }

    private List<Person> getPersonList(String type) throws FileNotFoundException {
        if (type == "space"){
            return PersonLoader.loadPersonRecordsFromSpaceFile();
        }else if (type == "pipe"){
            return PersonLoader.loadPersonRecordsFromPipeFile();
        }
        return PersonLoader.loadPersonRecordsFromCommaFile();
    }

    public void testSpace() throws FileNotFoundException {
        assertEquals(3, getPersonList("space").size());
    	assertEquals("Kournikova", getPersonList("space").get(0).getLastName());
    	assertEquals("Hingis", getPersonList("space").get(1).getLastName());
    	assertEquals("Seles", getPersonList("space").get(2).getLastName());
    }

    public void testPipe() throws FileNotFoundException {
    	assertEquals(3, getPersonList("pipe").size());
    	assertEquals("Smith", getPersonList("pipe").get(0).getLastName());
    	assertEquals("Bonk", getPersonList("pipe").get(1).getLastName());
    	assertEquals("Bouillon", getPersonList("pipe").get(2).getLastName());
    }

    public void testComma() throws FileNotFoundException { 	
    	assertEquals(3, getPersonList("comma").size());
    	assertEquals("Abercrombie", getPersonList("comma").get(0).getLastName());
    	assertEquals("Bishop", getPersonList("comma").get(1).getLastName());
    	assertEquals("Kelly", getPersonList("comma").get(2).getLastName());
    }   
}
