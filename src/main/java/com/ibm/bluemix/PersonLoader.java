package com.ibm.bluemix;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class PersonLoader {
  static List<Person> loadPersonRecords(String inputFilePath, String[] elements, String delimiter) throws java.io.FileNotFoundException {
    List<Person> personList = new ArrayList<Person>();

    try(Scanner scanner = new Scanner(new File(inputFilePath))) {
      while(scanner.hasNextLine()) {
        String line = scanner.nextLine();

        try {
          Person person = new Person(line, elements, delimiter);
          personList.add(person);
        }
        catch(PersonParseException e) {
          e.printStackTrace();
        }
      }
    }

    return personList;
  }
}
