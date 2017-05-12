package com.ibm.bluemix;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.FileNotFoundException;
import java.util.List;

public class PersonLoaderTest extends TestCase {
  public PersonLoaderTest(String testName) {
    super(testName);
  }
  public static Test suite() {
    return new TestSuite(PersonLoaderTest.class);
  }

  public void testSpace() throws FileNotFoundException {
    List<Person> personList = PersonLoader.loadPersonRecordsFromSpaceFile();
    assertEquals(3, personList.size());
    assertEquals("Kournikova", personList.get(0).getLastName());
    assertEquals("Hingis", personList.get(1).getLastName());
    assertEquals("Seles", personList.get(2).getLastName());
  }

  public void testPipe() throws FileNotFoundException {
    List<Person> personList = PersonLoader.loadPersonRecordsFromPipeFile();
    assertEquals(3, personList.size());
    assertEquals("Smith", personList.get(0).getLastName());
    assertEquals("Bonk", personList.get(1).getLastName());
    assertEquals("Bouillon", personList.get(2).getLastName());
  }

  public void testComma() throws FileNotFoundException {
    List<Person> personList = PersonLoader.loadPersonRecordsFromCommaFile();
    assertEquals(3, personList.size());
    assertEquals("Abercrombie", personList.get(0).getLastName());
    assertEquals("Bishop", personList.get(1).getLastName());
    assertEquals("Kelly", personList.get(2).getLastName());
  }
}
