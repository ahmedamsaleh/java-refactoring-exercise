package com.ibm.bluemix;

import java.util.List;

class PersonOutputGenerator {
  static void generateOutput1(List<Person> personList) {
    personList.sort((Person p1, Person p2) -> {
        if(!p1.getGender().equals(p2.getGender())) {
          return p1.getGender().compareTo(p2.getGender());
        }
        return p1.getLastName().compareTo(p2.getLastName());
      }
    );

    System.out.println("Output 1:\n");

    for(Person person : personList) {
      System.out.println(person);
    }
  }

  static void generateOutput2(List<Person> personList) {
    personList.sort((Person p1, Person p2)-> {
        if(p1.getDateOfBirth().compareTo(p2.getDateOfBirth()) != 0) {
          return p1.getDateOfBirth().compareTo(p2.getDateOfBirth());
        }

        return p1.getLastName().compareTo(p2.getLastName());
      }
    );

    System.out.println("\nOutput 2:\n");

    for(Person person : personList) {
      System.out.println(person);
    }
  }

  static void generateOutput3(List<Person> personList) {
    personList.sort((Person p1, Person p2) -> p2.getLastName().compareTo(p1.getLastName()));

    System.out.println("\nOutput 3:\n");

    for(Person person : personList) {
      System.out.println(person);
    }
  }
}
