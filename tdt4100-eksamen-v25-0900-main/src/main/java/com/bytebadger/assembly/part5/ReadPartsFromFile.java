package com.bytebadger.assembly.part5;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import no.ntnu.tdt4100.bytebadger.*;
import no.ntnu.tdt4100.bytebadger.part5.ResultSet;

public class ReadPartsFromFile {

    public static final String CSV_SPLIT_REGEX = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";

    /**
     * Parses a string containing product data into a {@link ComputerPart} object.
     * 
     * The method expects the <code>productLine</code> parameter to be a string with
     * values in a comma- or other delimiter-separated format where each value
     * represents a different attribute of the product. The parameter represents a
     * single line in the file resources/computer_parts.csv. The <code>splitRegexp</code>
     * parameter should be used to split the string into its parts.
     * 
     * The expected order of the values for the productLine string is:
     * product id, product name, manufacturer, unit price 
     * 
     * If the string does not contain exactly four such values, or if any of the
     * numeric fields cannot be parsed, the method returns
     * <code>null</code>.
     *
     * @param productLine A String containing the product data. It must contain
     *                    exactly four delimiter-separated values.
     * @param splitRegexp Regex expression to use for splitting the line.
     * 
     * @return A {@link ComputerPart} object constructed from the provided data, or
     *         <code>null</code> if the data could not be parsed into a ComputerPart.
     * 
     * @see ComputerPart
     */

    public static ComputerPart parseLine(String productLine, String splitRegexp) {

        String[] productParams = productLine.split(splitRegexp);

        if(productParams.length != 4) return null;

        try {
            return new ComputerPart(Integer.parseInt(productParams[0]), productParams[1], productParams[2], Double.parseDouble(productParams[3]));
        }
        catch (Exception e) {
            return null;
        }
    }

    /**
     * Reads the computer parts from the provided {@link InputStream},
     * identifies any lines with errors, and returns a
     * {@link no.ntnu.tdt4100.bytebadger.part5.ResultSet} object.
     * 
     * The method expects the input stream to contain Comma-Separated Values (CSV)
     * formated data. The first line, assumed to be the header, should be skipped.
     * Each subsequent line should be parsed into a {@link ComputerPart} object and added
     * to the corresponding {@link ResultSet#parts()} list in the result set. If
     * a line cannot be parsed into a ComputerPart as described by the
     * {@link #parseLine()} method because of an error in the data, then the
     * line number of the error should instead be added to the
     * {@link ResultSet#linesWithErrors()} list.
     * 
     * The {@link ReadPartsFromFile#CSV_SPLIT_REGEX} constant should be used to
     * split the lines into their separate parts, as this expression can handle
     * multiple edge cases for CSV data.
     * 
     * Note: You are NOT required to use the {@link #parseLine()} method in
     * this implementation, but you will likely find it useful. Both methods
     * must ble implemented however for full score.
     *
     * The file resources/computer_parts.csv contains the file to be read
     *
     * @param stream The {@link InputStream} containing the computer parts.
     *               You can assume it will not be null.
     * @return A {@link ResultSet} object containing a list of parts and a list
     *         of line numbers for lines that could not be parsed.
     * @throws IOException If an I/O error occurs when reading from the stream.
     * 
     * @see ResultSet
     * @see ComputerPart
     */

    public static ResultSet read(InputStream stream) throws IOException {

        String[] allParts = String.valueOf(stream.readAllBytes()).split("/n");

        ArrayList<IComputerPart> parts = new ArrayList<>();
        ArrayList<Integer> errorLines = new ArrayList<>();

        for (int i = 1; i < allParts.length; i++) {
            IComputerPart part = parseLine(allParts[i], CSV_SPLIT_REGEX);

            if(part == null) errorLines.add(i);
            else parts.add(part);
        }

        return new ResultSet(parts, errorLines);
    }

}
