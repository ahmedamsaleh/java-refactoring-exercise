package com.ibm.bluemix;

import java.util.Comparator;

public class Sorter {
  static Comparator<Person> genderThenLastName() {
    return new Comparator<Person>() {
      public int compare(Person p1, Person p2) {
        if(!p1.getGender().equals(p2.getGender())) {
          return p1.getGender().compareTo(p2.getGender());
        }

        return p1.getLastName().compareTo(p2.getLastName());
      }
    };
  }

  static Comparator<Person> dobThenLastName() {
    return new Comparator<Person>() {
      public int compare(Person p1, Person p2) {
        if(p1.getDateOfBirth().compareTo(p2.getDateOfBirth()) != 0) {
          return p1.getDateOfBirth().compareTo(p2.getDateOfBirth());
        }

        return p1.getLastName().compareTo(p2.getLastName());
      }
    };
  }

  static Comparator<Person> lastNameDescending() {
    return new Comparator<Person>() {
      public int compare(Person p1, Person p2) {
        return p2.getLastName().compareTo(p1.getLastName());
      }
    };
  }
}
