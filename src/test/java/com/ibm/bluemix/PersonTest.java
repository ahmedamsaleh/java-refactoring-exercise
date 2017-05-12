package com.ibm.bluemix;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.text.SimpleDateFormat;

public class PersonTest extends TestCase {
  public PersonTest(String testName) {
    super(testName);
  }
  public static Test suite() {
    return new TestSuite(PersonTest.class);
  }

  public void testSpace() throws PersonParseException {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    String[] fields = {Person.LAST_NAME, Person.FIRST_NAME, Person.IGNORE,
        Person.GENDER, Person.DATE_OF_BIRTH, Person.COLOR};

    String delimiter = "\\s+";

    String annaRaw = "Kournikova Anna F F 6-3-1975 Red";
    String martinaRaw = "Hingis Martina M F 4-2-1979 Green";
    String monicaRaw = "Seles Monica H F 12-2-1973 Black";

    Person anna = new Person(annaRaw, fields, delimiter);
    assertEquals("Anna", anna.getFirstName());
    assertEquals("Kournikova", anna.getLastName());
    assertEquals(Gender.FEMALE, anna.getGender());
    assertEquals("1975-06-03", format.format(anna.getDateOfBirth()));
    assertEquals("Red", anna.getColor());

    Person martina = new Person(martinaRaw, fields, delimiter);
    assertEquals("Martina", martina.getFirstName());
    assertEquals("Hingis", martina.getLastName());
    assertEquals(Gender.FEMALE, martina.getGender());
    assertEquals("1979-04-02", format.format(martina.getDateOfBirth()));
    assertEquals("Green", martina.getColor());

    Person monica = new Person(monicaRaw, fields, delimiter);
    assertEquals("Monica", monica.getFirstName());
    assertEquals("Seles", monica.getLastName());
    assertEquals(Gender.FEMALE, monica.getGender());
    assertEquals("1973-12-02", format.format(monica.getDateOfBirth()));
    assertEquals("Black", monica.getColor());
  }

  public void testPipe() throws PersonParseException {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    String[] elements = {Person.LAST_NAME, Person.FIRST_NAME, Person.IGNORE,
         Person.GENDER, Person.COLOR, Person.DATE_OF_BIRTH};
    
    String delimiter = "\\s*\\|\\s*";

    String steveRaw = "Smith | Steve | D | M | Red | 3-3-1985";
    String radekRaw = "Bonk | Radek | S | M | Green | 6-3-1975";
    String francisRaw = "Bouillon | Francis | G | M | Blue | 6-3-1975";

    Person steve = new Person(steveRaw, elements, delimiter);
    assertEquals("Steve", steve.getFirstName());
    assertEquals("Smith", steve.getLastName());
    assertEquals(Gender.MALE, steve.getGender());
    assertEquals("1985-03-03", format.format(steve.getDateOfBirth()));
    assertEquals("Red", steve.getColor());

    Person radek = new Person(radekRaw, elements, delimiter);
    assertEquals("Radek", radek.getFirstName());
    assertEquals("Bonk", radek.getLastName());
    assertEquals(Gender.MALE, radek.getGender());
    assertEquals("1975-06-03", format.format(radek.getDateOfBirth()));
    assertEquals("Green", radek.getColor());

    Person francis = new Person(francisRaw, elements, delimiter);
    assertEquals("Francis", francis.getFirstName());
    assertEquals("Bouillon", francis.getLastName());
    assertEquals(Gender.MALE, francis.getGender());
    assertEquals("1975-06-03", format.format(francis.getDateOfBirth()));
    assertEquals("Blue", francis.getColor());
  }

  public void testComma() throws PersonParseException {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    String[] elements = {Person.LAST_NAME, Person.FIRST_NAME, Person.GENDER,
        Person.COLOR, Person.DATE_OF_BIRTH};

    String delimiter = "\\s*,\\s*";

    String neilRaw = "Abercrombie, Neil, Male, Tan, 2/13/1943";
    String timothyRaw = "Bishop, Timothy, Male, Yellow, 4/23/1967";
    String sueRaw = "Kelly, Sue, Female, Pink, 7/12/1959";

    Person neil = new Person(neilRaw, elements, delimiter);
    assertEquals("Neil", neil.getFirstName());
    assertEquals("Abercrombie", neil.getLastName());
    assertEquals(Gender.MALE, neil.getGender());
    assertEquals("1943-02-13", format.format(neil.getDateOfBirth()));
    assertEquals("Tan", neil.getColor());

    Person timothy = new Person(timothyRaw, elements, delimiter);
    assertEquals("Timothy", timothy.getFirstName());
    assertEquals("Bishop", timothy.getLastName());
    assertEquals(Gender.MALE, timothy.getGender());
    assertEquals("1967-04-23", format.format(timothy.getDateOfBirth()));
    assertEquals("Yellow", timothy.getColor());

    Person sue = new Person(sueRaw, elements, delimiter);
    assertEquals("Sue", sue.getFirstName());
    assertEquals("Kelly", sue.getLastName());
    assertEquals(Gender.FEMALE, sue.getGender());
    assertEquals("1959-07-12", format.format(sue.getDateOfBirth()));
    assertEquals("Pink", sue.getColor());
  }

  public void testToString() throws PersonParseException {
    String[] elements = {Person.LAST_NAME, Person.FIRST_NAME, Person.IGNORE,
        Person.GENDER, Person.DATE_OF_BIRTH, Person.COLOR};

    String delimiter = "\\s+";

    String annaRaw = "Kournikova Anna F F 6-3-1975 Red";
    String martinaRaw = "Hingis Martina M F 4-2-1979 Green";
    String monicaRaw = "Seles Monica H F 12-2-1973 Black";

    Person anna = new Person(annaRaw, elements, delimiter);
    assertEquals("Kournikova Anna Female 6/3/1975 Red", anna.toString());

    Person martina = new Person(martinaRaw, elements, delimiter);
    assertEquals("Hingis Martina Female 4/2/1979 Green", martina.toString());

    Person monica = new Person(monicaRaw, elements, delimiter);
    assertEquals("Seles Monica Female 12/2/1973 Black", monica.toString());
  }
}
