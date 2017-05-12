package com.ibm.bluemix;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class CandidateApp {
  public static void main(String[] args) {
    List<Person> personList = new ArrayList<Person>();

    try {
      personList.addAll(PersonLoader.loadPersonRecordsFromSpaceFile());
      personList.addAll(PersonLoader.loadPersonRecordsFromPipeFile());
      personList.addAll(PersonLoader.loadPersonRecordsFromCommaFile());

      PersonOutputGenerator.generateOutput1(personList);
      PersonOutputGenerator.generateOutput2(personList);
      PersonOutputGenerator.generateOutput3(personList);

    }
    catch(FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}
