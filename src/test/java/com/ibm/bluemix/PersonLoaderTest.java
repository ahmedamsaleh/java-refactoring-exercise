package com.ibm.bluemix;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.FileNotFoundException;
import java.util.List;

/**
 Unit test for Person.
 */
public class PersonLoaderTest extends TestCase {
  /**
   Create the test case

   @param testName name of the test case
   */
  public PersonLoaderTest(String testName) {
    super(testName);
  }

  /**
   @return the suite of tests being tested
   */
  public static Test suite() {
    return new TestSuite(PersonLoaderTest.class);
  }

  /**
   Test loading of space-delimited person file
   */
  public void testSpace() throws FileNotFoundException {
    List<Person> personList = PersonLoader.loadPersonRecords("./data/space.txt", new String[] {Person.LAST_NAME, Person.FIRST_NAME, Person.IGNORE, Person.GENDER, Person.DATE_OF_BIRTH, Person.COLOR}, "\\s+");
    assertEquals(3, personList.size());
    assertEquals("Kournikova", personList.get(0).getLastName());
    assertEquals("Hingis", personList.get(1).getLastName());
    assertEquals("Seles", personList.get(2).getLastName());
  }

  /**
   Test loading of pipe-delimited person file
   */
  public void testPipe() throws FileNotFoundException {
    List<Person> personList = PersonLoader.loadPersonRecords("./data/pipe.txt", new String[] {Person.LAST_NAME, Person.FIRST_NAME, Person.IGNORE, Person.GENDER, Person.COLOR, Person.DATE_OF_BIRTH}, "\\s*\\|\\s*");
    assertEquals(3, personList.size());
    assertEquals("Smith", personList.get(0).getLastName());
    assertEquals("Bonk", personList.get(1).getLastName());
    assertEquals("Bouillon", personList.get(2).getLastName());
  }

  /**
   Test loading of comma-delimited person file
   */
  public void testComma() throws FileNotFoundException {
    List<Person> personList = PersonLoader.loadPersonRecords("./data/comma.txt", new String[] {Person.LAST_NAME, Person.FIRST_NAME, Person.GENDER, Person.COLOR, Person.DATE_OF_BIRTH}, "\\s*,\\s*");
    assertEquals(3, personList.size());
    assertEquals("Abercrombie", personList.get(0).getLastName());
    assertEquals("Bishop", personList.get(1).getLastName());
    assertEquals("Kelly", personList.get(2).getLastName());
  }
}
