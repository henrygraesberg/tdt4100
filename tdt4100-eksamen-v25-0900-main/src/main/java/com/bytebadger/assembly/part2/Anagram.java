package com.bytebadger.assembly.part2;

import java.util.HashMap;
import java.util.stream.IntStream;

public class Anagram {

    /**
     * This method checks if two strings are anagrams.
     * 
     * Two strings are anagrams if they contain the same characters
     * in the same frequency, but possibly in a different order.
     * The method ignores case and spaces.
     * 
     * Empty strings cannot be anagrams.
     * Strings of different length cannot be anagrams.
     * 
     * Example:
     * The words "listen" and "silent" are anagrams.
     * 
     * @param str1 the first input string
     * @param str2 the second input string
     * @return a boolean value indicating whether the two strings are anagrams
     */
    public boolean isAnagram(String str1, String str2) {
        
        if(str1 == null ||
            str2 == null ||
            str1.length() == 0 || 
            str2.length() == 0 || 
            str1.length() != str2.length())
            return false;

        String str1Lower = str1.toLowerCase().replaceAll(" ", "");
        String str2Lower = str2.toLowerCase().replaceAll(" ", "");

        HashMap<Character, Integer> seenLetters = new HashMap<Character, Integer>();

        for (int i = 0; i < str1Lower.length(); i++) {
            char currentChar = str1Lower.charAt(i);

            if(str2Lower.indexOf(currentChar) == -1)
                return false;
            
            if(seenLetters.containsKey(currentChar))
                seenLetters.put(currentChar, seenLetters.get(currentChar) + 1);
            else
                seenLetters.put(currentChar, 1);
        }

        IntStream.Builder valuesBuilder = IntStream.builder();

        seenLetters.forEach((k, v) -> valuesBuilder.add(v));

        return valuesBuilder.build().sum() == str1Lower.length();
    }
}

