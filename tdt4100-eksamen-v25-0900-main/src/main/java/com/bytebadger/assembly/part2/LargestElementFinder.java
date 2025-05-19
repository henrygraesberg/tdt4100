package com.bytebadger.assembly.part2;

import java.util.List;

public class LargestElementFinder {

    /**
     * This method finds the largest element in a list of numbers.
     * If multiple elements share the same largest value, return any of them.  
     * 
     * Example: 
     * A list of numbers (3, 7, 2, 9, 5, 10, 1) will return the number 10.
     * 
     * @param numbers a list of Integer numbers
     * @throws IllegalArgumentException if the list is null or empty
     * @return the largest number
     */

    public int findLargest(List<Integer> numbers) {

        if(numbers == null || numbers.size() < 1)
            throw new IllegalArgumentException();

        Integer maxVal = numbers.get(0);

        for (int i = 1; i < numbers.size(); i++) {
            Integer currentNum = numbers.get(i);

            maxVal = currentNum > maxVal ? currentNum : maxVal;
        }

        return maxVal;
    }
}
