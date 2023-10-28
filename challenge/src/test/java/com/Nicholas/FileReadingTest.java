package com.Nicholas;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;

public class FileReadingTest {
    @Test
    public void file_success_read(){
        String[] args = {"files/test_1.txt"};

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Main.main(args);

        String consoleOutput = outputStream.toString();
        assertTrue(consoleOutput.contains("PERSON_NOT_FOUND"));
        assertTrue(consoleOutput.contains("PERSON_NOT_FOUND"));

        System.setOut(System.out);
    }

    @Test
    public void file_fail_read(){

        String[] args = {"files/invalid_files"};

        ByteArrayOutputStream errorStream = new ByteArrayOutputStream();
        System.setErr(new PrintStream(errorStream));

        Main.main(args);

        String errorMessage = errorStream.toString();
        assertTrue(errorMessage.contains("Error reading the command file"));

        System.setIn(System.in);
        System.setErr(System.err);
    }
}
