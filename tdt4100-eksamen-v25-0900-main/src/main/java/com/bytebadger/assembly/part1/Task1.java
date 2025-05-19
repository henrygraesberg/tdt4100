package com.bytebadger.assembly.part1;

public class Task1 {

    /**
     * This method finds and prints all numbers between 100 and 200 that leave a remainder of 1 when divided by 3
     * and a remainder of 2 when divided by 5.
     */
    
    public void remainderFinder() {
        System.out.println("Numbers between 100 and 200 that satisfy the conditions:");
        for (int i = 100; i <= 200; i++) {

            // if (i % 1 == 3 && i % 2 == 5) { System.out.println(i); }
            // if (i % 3 == 1 && i % 5 == 2) { System.out.println(i); }
            // if (i % 1 == 3 || i % 2 == 5) { System.out.println(i); }
            if (i % 3 == 1 || i % 5 == 2) { System.out.println(i); }
        }
    }    

    public static void main(String[] args) {
        
        // You can write your own code here to test the method.

    }    
}
