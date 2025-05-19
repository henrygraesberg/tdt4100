package com.bytebadger.assembly.part2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AnagramTest {

    private final Anagram anagram = new Anagram();

    @Test
    public void testAnagramsWithSameCharactersDifferentOrder() {
        // Test case where strings are anagrams but in different order
        assertTrue(anagram.isAnagram("listen", "silent"), "The strings should be anagrams.");
    }

    @Test
    public void testAnagramsWithSpaces() {
        // Test case where strings have spaces
        assertTrue(anagram.isAnagram("A man a plan a canal Panama", "A canal Panama a plan man A"), 
            "The strings should be anagrams, spaces should be ignored.");
    }

    @Test
    public void testAnagramsWithDifferentCases() {
        // Test case where strings are anagrams but with different case
        assertTrue(anagram.isAnagram("Race", "care"), "The strings should be anagrams, case should be ignored.");
    }

    @Test
    public void testNonAnagrams() {
        // Test case where strings are not anagrams
        assertFalse(anagram.isAnagram("hello", "world"), "The strings should not be anagrams.");
    }

    @Test
    public void testEmptyStrings() {
        // Test case where both strings are empty
        assertFalse(anagram.isAnagram("", ""), "Empty strings should not be anagrams.");
    }

    @Test
    public void testOneEmptyString() {
        // Test case where one string is empty
        assertFalse(anagram.isAnagram("hello", ""), "One empty string cannot be an anagram.");
    }

    @Test
    public void testNullStrings() {
        // Test case where one or both strings are null
        assertFalse(anagram.isAnagram(null, "hello"), "Null strings cannot be an anagram.");
        assertFalse(anagram.isAnagram("hello", null), "Null strings cannot be an anagram.");
        assertFalse(anagram.isAnagram(null, null), "Both null strings cannot be an anagram.");
    }

    @Test
    public void testDifferentLengths() {
        // Test case where strings have different lengths
        assertFalse(anagram.isAnagram("hello", "helloo"), "Strings of different lengths cannot be anagrams.");
    }

    @Test
    public void testAnagramsWithSpecialCharacters() {
        // Test case where strings include special characters
        assertTrue(anagram.isAnagram("hello!", "o!lelh"), "The strings should be anagrams, special characters should be considered.");
    }
}

