package com.ibm.bluemix;

import java.util.Comparator;

/**
 Created by omar on 18-05-2017.
 */
public class Sorter {
  static Comparator<Person> lastNameDescending() {
    return (Person p1, Person p2) -> p2.getLastName().compareTo(p1.getLastName());
  }

  static Comparator<Person> dobThenLastName() {
    return (Person p1, Person p2) -> {
      if(p1.getDateOfBirth().compareTo(p2.getDateOfBirth()) != 0) {
        return p1.getDateOfBirth().compareTo(p2.getDateOfBirth());
      }

      return p1.getLastName().compareTo(p2.getLastName());
    };
  }

  static Comparator<Person> genderThenLastName() {
    return (Person p1, Person p2) -> {
      if(!p1.getGender().equals(p2.getGender())) {
        return p1.getGender().compareTo(p2.getGender());
      }
      return p1.getLastName().compareTo(p2.getLastName());
    };
  }
}
