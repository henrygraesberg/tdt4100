package com.bytebadger.assembly.part1;

class Task7 {
    /**
     * Returns the numbers from 1 to 100. But for multiples
     * of three, returns "Fizz" instead of the number, and for the multiples of
     * five,
     * returns "Buzz". For numbers that are multiples of both three and five,
     * returns "FizzBuzz".
     * 
     * Rearrange the code in the fizzBuzz method so the method behaves as dictated
     * above.
     */

    public String fizzBuzz(int number) {

        if (number % 3 == 0 && number % 5 == 0) {
            return "FizzBuzz";
        }

        if (number % 3 == 0) {
            return "Fizz";
        }

        if (number % 5 == 0) {
            return "Buzz";
        }

        return Integer.toString(number);
    }

    public static void main(String[] args) {
        Task7 task = new Task7();
        for (int i = 1; i <= 100; i++) {
            System.out.println(task.fizzBuzz(i));
        }
    }
}


