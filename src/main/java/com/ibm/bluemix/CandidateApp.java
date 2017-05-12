package com.ibm.bluemix;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CandidateApp {
  private static Runnable nullSpace() {
    return new Runnable() {
      public void run() {
      }
    };
  }

  private static Runnable space() {
    return new Runnable() {
      public void run() {
        System.out.println("");
      }
    };
  }

  private static Comparator<Person> genderThenLastName() {
    return new Comparator<Person>() {
      public int compare(Person p1, Person p2) {
        if(!p1.getGender().equals(p2.getGender())) {
          return p1.getGender().compareTo(p2.getGender());
        }

        return p1.getLastName().compareTo(p2.getLastName());
      }
    };
  }

  private static Comparator<Person> dobThenLastName() {
    return new Comparator<Person>() {
      public int compare(Person p1, Person p2) {
        if(p1.getDateOfBirth().compareTo(p2.getDateOfBirth()) != 0) {
          return p1.getDateOfBirth().compareTo(p2.getDateOfBirth());
        }

        return p1.getLastName().compareTo(p2.getLastName());
      }
    };
  }
  
  private static Comparator<Person> lastNameDescending() {
    return new Comparator<Person>() {
      public int compare(Person p1, Person p2) {
        return p2.getLastName().compareTo(p1.getLastName());
      }
    };
  }

  public static void main(String[] args) {
    List<Person> personList = new ArrayList<Person>();

    try {
      personList.addAll(PersonLoader.loadPersonRecordsFromSpaceFile());
      personList.addAll(PersonLoader.loadPersonRecordsFromPipeFile());
      personList.addAll(PersonLoader.loadPersonRecordsFromCommaFile());

      PersonOutputGenerator.generateOutput1(personList, "Output 1:", genderThenLastName(), nullSpace());
      PersonOutputGenerator.generateOutput2(personList, "Output 2:", dobThenLastName(), space());
      PersonOutputGenerator.generateOutput3(personList, "Output 3:", lastNameDescending(), space());

    }
    catch(FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}
