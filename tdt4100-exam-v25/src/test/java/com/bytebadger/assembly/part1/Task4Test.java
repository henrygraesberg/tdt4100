package com.bytebadger.assembly.part1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Task4Test {

    @Test
    public void testValidDecimal() {
        Task4 task4 = new Task4();
        double result = task4.decimalParser("123.45");
        assertEquals(123.45, result, 0.0001, "The decimal should be parsed correctly.");
    }

    @Test
    public void testIntegerAsString() {
        Task4 task4 = new Task4();
        double result = task4.decimalParser("1000");
        assertEquals(1000.0, result, 0.0001, "The integer value should be parsed as a double.");
    }

    @Test
    public void testNegativeDecimal() {
        Task4 task4 = new Task4();
        double result = task4.decimalParser("-45.67");
        assertEquals(-45.67, result, 0.0001, "The negative decimal value should be parsed correctly.");
    }

    @Test
    public void testEmptyString() {
        Task4 task4 = new Task4();
        assertThrows(NumberFormatException.class, () -> {
            task4.decimalParser("");
        }, "An empty string should throw a NumberFormatException.");
    }

    @Test
    public void testInvalidString() {
        Task4 task4 = new Task4();
        assertThrows(NumberFormatException.class, () -> {
            task4.decimalParser("abc123");
        }, "An invalid string should throw a NumberFormatException.");
    }
}
