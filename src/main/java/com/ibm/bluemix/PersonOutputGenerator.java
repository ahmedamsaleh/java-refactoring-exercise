package com.ibm.bluemix;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PersonOutputGenerator {

  private static void printOutput(List<Person> personList, String type) {
    System.out.println(type);
    for(Person person : personList) {
      System.out.println(person);
    }
  }

  public static void generateOutput1(List<Person> personList) {
    Collections.sort(personList, new Comparator<Person>() {
      // sort by Gender, then by LastName in ascending order
      public int compare(Person p1, Person p2) {
        if(!p1.getGender().equals(p2.getGender())) {
          return p1.getGender().compareTo(p2.getGender());
        }

        return p1.getLastName().compareTo(p2.getLastName());
      }
    });

    printOutput(personList, "Output 1:\n");
  }

  public static void generateOutput2(List<Person> personList) {
    Collections.sort(personList, new Comparator<Person>() {
      // sort by DateOfBirth in ascending order, then by LastName in ascending order
      public int compare(Person p1, Person p2) {
        if(p1.getDateOfBirth().compareTo(p2.getDateOfBirth()) != 0) {
          return p1.getDateOfBirth().compareTo(p2.getDateOfBirth());
        }
        return p1.getLastName().compareTo(p2.getLastName());
      }
    });

    printOutput(personList, "\nOutput 2:\n");
  }

  public static void generateOutput3(List<Person> personList) {
    Collections.sort(personList, new Comparator<Person>() {
      // sort by LastName in descending order
      public int compare(Person p1, Person p2) {
        return p2.getLastName().compareTo(p1.getLastName());
      }
    });

    printOutput(personList, "\nOutput 3:\n");
  }
}
