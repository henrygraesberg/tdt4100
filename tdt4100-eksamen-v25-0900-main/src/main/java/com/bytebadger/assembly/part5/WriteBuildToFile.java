package com.bytebadger.assembly.part5;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import no.ntnu.tdt4100.bytebadger.*;

public class WriteBuildToFile {

    /**
     * Writes the details of a {@link no.ntnu.tdt4100.bytebadger.ICustomBuild} to the provided
     * {@link OutputStream}.
     * 
     * The method generates a string representation of the custom computer build, including 
     * the customer name and email, a list of computer parts with quantity, name, manufacturer and unit price,
     * and the total price for this build.
     * 
     * Each attribute is separated by a semicolon, and each section
     * (customer info, computer parts, total price) is separated by a blank line.
     * The generated string is then written to the provided OutputStream.
     * 
     * The format of the output should be as follows:
     * 
     * <pre>
     *  customerName;customerEmail
     *  
     *  quantity1;productName1;manufacturer1;unitPrice1
     *  quantity2;productName2;manufacturer2;unitPrice2
     *  quantity3;productName3;manufacturer3;unitPrice3
     * 
     * totalPrice
     * </pre>
     * 
     * The file resources/output_example.txt contains an example of how the output
     * should look.
     * 
     * @param build        The {@link ICustomBuild} object whose details are to be
     *                     written. You can assume that this object will not be
     *                     null.
     * @param outputStream The {@link OutputStream} to which the computer build details
     *                     to be written.
     * @throws IOException If an I/O error occurs when writing to the stream.
     * 
     * @see ICustomBuild
     * @see Customer
     * @see IComputerPart
     * @see ComputerPart
     */

    public static void write(ICustomBuild build, OutputStream outputStream) throws IOException {

        String customerInfo = String.format("%1$;%2$", build.getCustomer().name(), build.getCustomer().email());

        ArrayList<String> buildParts = new ArrayList<>();

        build.getParts().forEach((part, quantity) -> buildParts.add(String.format("%1$;%2$;%3$;%4$", quantity, part.getProductName(), part.getManufacturer(), part.getPrice())));

        String price = String.valueOf(build.getTotalPrice());

        outputStream.write((customerInfo + "\n\n").getBytes());

        for (int i = 0; i < buildParts.size(); i++) {
            outputStream.write((buildParts.get(i) + "\n").getBytes());
        }

        outputStream.write(("\n\n" + price).getBytes());

    }

}
