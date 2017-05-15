package com.ibm.bluemix;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Person {
	final static String FIRST_NAME = "firstName";
	final static String LAST_NAME = "lastName";
	final static String GENDER = "gender";
	final static String DATE_OF_BIRTH = "dateOfBirth";
	final static String COLOR = "color";
	final static String IGNORE = "ignore";
	
	private String firstName;
	private String lastName;
	private Gender gender;
	private Date dateOfBirth;
	private String color;

	Person(String line, String[] lineElements, String delimiter) throws PersonParseException {
		try (Scanner scanner = new Scanner(line)) {
			scanner.useDelimiter(delimiter);
			int i = 0;

			while (scanner.hasNext()) {
				String token = scanner.next();

				switch (lineElements[i++]) {
				case FIRST_NAME:
					firstName = token;
					break;
				case LAST_NAME:
					lastName = token;
					break;
				case GENDER:
					if (token.startsWith("M")) {
						gender = Gender.MALE;
					} else if (token.startsWith("F")) {
						gender = Gender.FEMALE;
					} else {
						throw new PersonParseException("Invalid gender encountered");
					}
					break;
				case DATE_OF_BIRTH:
					SimpleDateFormat format;
					if (token.contains("/")) {
						format = new SimpleDateFormat("MM/dd/yyyy");
					} else if (token.contains("-")) {
						format = new SimpleDateFormat("MM-dd-yyyy");
					} else {
						throw new PersonParseException("Invalid date encountered");
					}
					try {
						dateOfBirth = format.parse(token);
					} catch (ParseException e) {
						throw new PersonParseException("Invalid date encountered");
					}
					break;
				case COLOR:
					color = token;
					break;
				default:
					break;
				}
			}
	    }
	}

	String getFirstName() {return firstName;}
	String getLastName() {
		return lastName;
	}
	Gender getGender() {
		return gender;
	}
	Date getDateOfBirth() {
		return dateOfBirth;
	}
	String getColor() {
		return color;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat format = new SimpleDateFormat("M/d/yyyy");
		String sb = lastName +
				" " +
				firstName +
				" " +
				gender +
				" " +
				format.format(dateOfBirth) +
				" " +
				color;
		return sb;
	}
}
