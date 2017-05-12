package com.ibm.bluemix;

import java.util.Comparator;
import java.util.List;

class PersonOutputGenerator {
  private static void print(List<Person> persons, String heading) {
    printHeading(heading);
    printPersons(persons);
  }

  private static void printHeading(String heading) {
    System.out.println(heading);
    System.out.println("");
  }

  private static void printPersons(List<Person> persons) {
    for(Person person : persons) {
      System.out.println(person);
    }
  }

  static void generateOutput(List<Person> persons, String heading,
      Comparator<Person> sorter, Runnable insertSpace) {
    
    persons.sort(sorter);
    insertSpace.run();
    print(persons, heading);
  }
}
