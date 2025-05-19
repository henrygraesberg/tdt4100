package com.bytebadger.assembly.part1;

@SuppressWarnings("unused")
public class Task4 {

    /**
     * This method should parse a decimal number in String format and return it as a double.
     * You can assume that the string will only contain numbers, and may include a decimal point.
     * 
     * @param unparsedDecimal the decimal number in string format to parse
     * @return the parsed number as a double
     */

    public double decimalParser(String unparsedDecimal) {

        // return (double) unparsedDecimal.charAt(0); 
        // Double.valueOf(unparsedDecimal.charAt(0));
        // return (double) Integer.parseInt(unparsedDecimal); 
        return Double.parseDouble(unparsedDecimal);
    }

    public static void main(String[] args) {
        
        // You can write your own code here to test the method.
        
    }

}