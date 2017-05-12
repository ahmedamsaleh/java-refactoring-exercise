package com.ibm.bluemix;

import java.util.Comparator;
import java.util.List;

class PersonOutputGenerator {
  private static void print(List<Person> personList, String heading) {
    printHeading(heading);
    printPersons(personList);
  }

  private static void printPersons(List<Person> personList) {
    for(Person person : personList) {
      System.out.println(person);
    }
  }

  private static void printHeading(String heading) {
    System.out.println(heading);
    System.out.println("");
  }

  static void generateOutput(List<Person> personList, String heading,
      Comparator<Person> comparator, Runnable spaceable) {
    
    personList.sort(comparator);
    spaceable.run();
    print(personList, heading);
  }
}
