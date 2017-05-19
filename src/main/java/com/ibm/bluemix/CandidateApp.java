package com.ibm.bluemix;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class CandidateApp {

  public static void main(String[] args) {
    List<Person> personList = new ArrayList<Person>();

    try {
      loadPersons(personList);

      generateOutput(personList);

    }
    catch(FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  private static void generateOutput(List<Person> personList) {
    PersonOutputGenerator.generateOutput(personList, Sorter.genderThenLastName(), "Output 1:\n");
    PersonOutputGenerator.generateOutput(personList, Sorter.dobThenLastName(), "\nOutput 2:\n");
    PersonOutputGenerator.generateOutput(personList, Sorter.lastNameDescending(), "\nOutput 3:\n");
  }

  private static void loadPersons(List<Person> personList) throws FileNotFoundException {
    personList.addAll(PersonLoader.loadPersonRecords("./data/space.txt", FileFormats.SPACE_FILE, Delimiters.SPACE));
    personList.addAll(PersonLoader.loadPersonRecords("./data/pipe.txt", FileFormats.PIPE_FILE, Delimiters.PIPE));
    personList.addAll(PersonLoader.loadPersonRecords("./data/comma.txt", FileFormats.COMMA_FILE, Delimiters.COMMA));
  }

}
