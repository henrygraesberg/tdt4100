package com.bytebadger.assembly.part2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LargestElementFinderTest {

    private final LargestElementFinder finder = new LargestElementFinder();

    @Test
    public void testFindLargest_withValidList() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int result = finder.findLargest(numbers);
        assertEquals(5, result, "The largest number should be 5.");
    }

    @Test
    public void testFindLargest_withNegativeNumbers() {
        List<Integer> numbers = Arrays.asList(-5, -3, -8, -1, -4);
        int result = finder.findLargest(numbers);
        assertEquals(-1, result, "The largest number should be -1.");
    }

    @Test
    public void testFindLargest_withSingleElement() {
        List<Integer> numbers = Arrays.asList(10);
        int result = finder.findLargest(numbers);
        assertEquals(10, result, "The largest number should be 10.");
    }

    @Test
    public void testFindLargest_withEmptyList() {
        List<Integer> numbers = Arrays.asList();
        assertThrows(IllegalArgumentException.class, () -> finder.findLargest(numbers),
                "An empty list should throw IllegalArgumentException.");
    }

    @Test
    public void testFindLargest_withNullList() {
        List<Integer> numbers = null;
        assertThrows(IllegalArgumentException.class, () -> finder.findLargest(numbers),
                "A null list should throw IllegalArgumentException.");
    }

    @Test
    public void testFindLargest_withDuplicateValues() {
        List<Integer> numbers = Arrays.asList(4, 4, 4, 4);
        int result = finder.findLargest(numbers);
        assertEquals(4, result, "The largest number should be 4 even with duplicates.");
    }
}

