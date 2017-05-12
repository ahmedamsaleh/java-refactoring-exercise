package com.ibm.bluemix;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static com.ibm.bluemix.Formater.*;
import static com.ibm.bluemix.Sorter.*;

public class CandidateApp {

  public static void main(String[] args) {
    List<Person> personList = new ArrayList<Person>();

    try {
      personList.addAll(PersonLoader.loadPersonRecordsFromSpaceFile());
      personList.addAll(PersonLoader.loadPersonRecordsFromPipeFile());
      personList.addAll(PersonLoader.loadPersonRecordsFromCommaFile());

      PersonOutputGenerator.generateOutput(personList, "Output 1:", genderThenLastName(), nullSpace());
      PersonOutputGenerator.generateOutput(personList, "Output 2:", dobThenLastName(), space());
      PersonOutputGenerator.generateOutput(personList, "Output 3:", lastNameDescending(), space());

    }
    catch(FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}
