package com.bytebadger.assembly.part1;

public class Task5 {

    /**
     * This method prints a pattern of letters in a triangular format.
     * The first line contains 1 letter, the second line contains 2 letters, and so on.
     * After 'z', it loops back to 'a'.
     * 
     * @param numLines the number of lines to print
     * 
     * Example output for numLines = 8:
     * a
     * b c
     * d e f
     * g h i j
     * k l m n o
     * p q r s t u
     * v w x y z a b
     * c d e f g h i j
     */

     public String stringOutput(int numLines) {

        // return stringOutput1(numLines);
        // return stringOutput2(numLines);    
        return stringOutput3(numLines);
        // return stringOutput4(numLines);

        // return ""; // Placeholder return statement to avoid compilation error
    
     }

    public String stringOutput1(int numLines) {
        StringBuilder result = new StringBuilder();
        char currentChar = 'z';

        for (int i = 1; i <= numLines; i++) {
            for (int space = 0; space < numLines - i; space++) {
                result.append("  ");
            }

            for (int j = 0; j < i; j++) {
                result.append(currentChar).append(" ");
                currentChar--;

                if (currentChar < 'a') {
                    currentChar = 'z';
                }
            }

            result.append("\n");
        }

        return result.toString();
    }

    public String stringOutput2(int numLines) {
        StringBuilder result = new StringBuilder();
        char currentChar = 'z';

        for (int i = 1; i <= numLines; i++) {
            for (int j = 0; j < i; j++) {
                result.append(currentChar).append(" ");
                currentChar--;

                if (currentChar < 'a') {
                    currentChar = 'z';
                }
            }
            result.append("\n");
        }

        return result.toString();
    } 

    public String stringOutput3(int numLines) {
        StringBuilder result = new StringBuilder();
        char currentChar = 'a';

        for (int i = 1; i <= numLines; i++) {
            for (int j = 0; j < i; j++) {
                result.append(currentChar).append(" ");
                currentChar++;
                if (currentChar > 'z') {
                    currentChar = 'a';
                }
            }
            result.append("\n");
        }

        return result.toString();
    } 

    
    public String stringOutput4(int numLines) {
        StringBuilder result = new StringBuilder();
        char currentChar = 'a';

        for (int i = 1; i <= numLines; i++) {
            for (int space = 0; space < numLines - i; space++) {
                result.append("  ");
            }

            for (int j = 0; j < i; j++) {
                result.append(currentChar).append(" ");
                currentChar++;

                if (currentChar > 'z') {
                    currentChar = 'a';
                }
            }

            result.append("\n");
        }

        return result.toString();
    }

    public static void main(String[] args) {
        
        // You can write your own code here to test the method.
        
        System.out.println(new Task5().stringOutput(8));
    }
}