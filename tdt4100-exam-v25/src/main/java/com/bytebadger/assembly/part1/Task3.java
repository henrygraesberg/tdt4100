package com.bytebadger.assembly.part1;

import java.util.Random;

public class Task3 {

    /**
     * This method generates a random letter between the given start and end characters.
     * The characters are inclusive, and the method handles both uppercase and lowercase letters.
     */

    public void getRandomLetter(char start, char end) {
        start = Character.toLowerCase(start);
        end = Character.toLowerCase(end);

        if (start > end) {
            char temp = start;
            start = end;
            end = temp;
        }

        Random rand = new Random();

        char randomLetter = 'a'; // Placeholder initialization

        // char randomLetter = (char) (rand.nextInt(end - start - 1) + end);
        randomLetter = (char) (rand.nextInt(end - start + 1) + start);
        // char randomLetter = (char) (rand.nextInt(end) + start);
        // char randomLetter = (char) (rand.nextInt(end + start - 1) + start);

        

        System.out.println("Random letter between '" + start + "' and '" + end + "': " + randomLetter);
    }

    public static void main(String[] args) {
                
        // You can write your own code here to test the method.

    }
}