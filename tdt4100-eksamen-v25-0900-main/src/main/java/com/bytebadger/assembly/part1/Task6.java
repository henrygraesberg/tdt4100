package com.bytebadger.assembly.part1;

import java.util.IllegalFormatException;

public class Task6 {

    /* Which of the following exceptions is most relevant in this case? */
    
    public static void main(String[] args) {
        try {
            int[] numbers = {10, 20, 30};
            System.out.println("Number: " + numbers[3]);
        } 

        // catch (IllegalFormatException e) { System.out.println("Illegal format!"); }
        ///catch (IllegalArgumentException e) { System.out.println("Illegal argument!"); }
        catch (ArrayIndexOutOfBoundsException e) { System.out.println("Array index out of bounds!"); }
        // catch (NullPointerException e) { System.out.println("Null pointer!"); }

        catch (Exception e) {} // Placeholder for exception handling
    
    }
}
