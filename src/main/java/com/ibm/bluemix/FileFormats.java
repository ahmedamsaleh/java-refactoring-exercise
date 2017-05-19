package com.ibm.bluemix;

/**
 Created by omar on 19-05-2017.
 */
class FileFormats {
  static final String[] SPACE_FILE = {Person.LAST_NAME, Person.FIRST_NAME, Person.IGNORE, Person.GENDER, Person.DATE_OF_BIRTH, Person.COLOR};
  static final String[] PIPE_FILE = {Person.LAST_NAME, Person.FIRST_NAME, Person.IGNORE, Person.GENDER, Person.COLOR, Person.DATE_OF_BIRTH};
  static final String[] COMMA_FILE = {Person.LAST_NAME, Person.FIRST_NAME, Person.GENDER, Person.COLOR, Person.DATE_OF_BIRTH};
}
