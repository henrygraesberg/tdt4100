package com.bytebadger.assembly.part1;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

public class Task1Test {

    @Test
    public void testRemainderFinderOutput() {
        // Redirect System.out
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            // Call the method
            Task1 task = new Task1();
            task.remainderFinder();

            // Get output
            String output = outputStream.toString();

            // Check for expected values
            assertTrue(output.contains("112"));
            assertTrue(output.contains("127"));
            assertTrue(output.contains("142"));
            assertTrue(output.contains("157"));
            assertTrue(output.contains("172"));
            assertTrue(output.contains("187"));

            // Optional: Check number of matches
            String[] lines = output.split("\r?\n");
            int count = lines.length - 1; // Subtract header line
            assertTrue(count > 0 && count < 50); // Reasonable range

        } finally {
            // Restore original System.out
            System.setOut(originalOut);
        }
    }
}
