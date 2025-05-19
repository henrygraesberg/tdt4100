package com.bytebadger.assembly.part2;

import java.util.HashMap;
import java.util.Map;


public class CharacterFrequency {

    /**
     * This method counts the frequency of each character in a given string.
     * 
     * @return a Map with characters as keys and their frequencies as values
     */

    public static Map<Character, Integer> countCharacterFrequency(String input) {

        if(input == null)
            return new HashMap<Character, Integer>();

        HashMap<Character, Integer> seenLetters = new HashMap<Character, Integer>();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            
            if(seenLetters.containsKey(currentChar))
                seenLetters.put(currentChar, seenLetters.get(currentChar) + 1);
            else
                seenLetters.put(currentChar, 1);
        }

        return seenLetters;

    }
}
