package com.ibm.bluemixFormatted;

import com.ibm.bluemix.CandidateApp;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class CandidateAppTestFormatted extends TestCase {
	private final ByteArrayOutputStream systemOutStream = new ByteArrayOutputStream();

    public CandidateAppTestFormatted(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(CandidateAppTestFormatted.class);
    }

    public void testCandidateApp() throws IOException {
        System.setOut(new PrintStream(systemOutStream));
        CandidateAppFormatted.main(null);

        int i = 0;		
        try (Scanner scanner = new Scanner(systemOutStream.toString())) {
        	while (scanner.hasNextLine()) {
        		String line = scanner.nextLine();
        		assertEquals("Mismatched output on line " + (i + 1), Files.readAllLines(getPath()).get(i), line);
        		i++;
        	}
        }
        System.setOut(null);
    }

    private Path getPath() {
        return FileSystems.getDefault().getPath("test-data", "output.txt");
    }
}
