package com.bytebadger.assembly.part2;

import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class CharacterFrequencyTest {

    @Test
    public void testCharacterFrequency() {
        Map<Character, Integer> result = CharacterFrequency.countCharacterFrequency("hello");
        assertEquals(1, result.get('h'));
        assertEquals(1, result.get('e'));
        assertEquals(2, result.get('l'));
        assertEquals(1, result.get('o'));
    }

    @Test
    public void testEmptyString() {
        Map<Character, Integer> result = CharacterFrequency.countCharacterFrequency("");
        assertTrue(result.isEmpty());
    }

    @Test
    public void testNullInput() {
        Map<Character, Integer> result = CharacterFrequency.countCharacterFrequency(null);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testSingleCharacter() {
        Map<Character, Integer> result = CharacterFrequency.countCharacterFrequency("aaaa");
        assertEquals(4, result.get('a'));
        assertEquals(1, result.size());
    }

    @Test
    public void testMixedCaseCharacters() {
        Map<Character, Integer> result = CharacterFrequency.countCharacterFrequency("aAbB");
        assertEquals(1, result.get('a'));
        assertEquals(1, result.get('A'));
        assertEquals(1, result.get('b'));
        assertEquals(1, result.get('B'));
    }

}

