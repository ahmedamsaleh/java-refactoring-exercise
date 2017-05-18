package com.ibm.bluemix;

import java.util.Comparator;
import java.util.List;

class PersonOutputGenerator {
  static void generateOutput(List<Person> personList, Comparator<Person> comparator, String outputMsg) {
    personList.sort(comparator);

    System.out.println(outputMsg);

    for(Person person : personList) {
      System.out.println(person);
    }
  }
}
