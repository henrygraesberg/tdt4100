/**
 * THIS IS SUPPLIED CODE - DO NOT MODIFY THE CODE BELOW
 */
 
package no.ntnu.tdt4100.bytebadger;

/**
 * 
 * This class represents the code for a computer part.
 *
 * The class must implements the interface {@link no.ntnu.tdt4100.bytebadger.IComputerPart}
 * Read the documentation in the interface for detailed description of the behaviour of
 * the methods.
 * 
 * @see no.ntnu.tdt4100.bytebadger.IComputerPart
 */

public class ComputerPart implements IComputerPart {

    private int productId;
    private String productName;
    private String manufacturer;
    private double unitPrice;

    /**
     * Constructor for the class ComputerPart.
     * 
     * @param id is the product ID as a value of type int
     * @param name is the name of the product as a value of type String
     * @param manufacturer is the name of the manufacturer as a value of type String
     * @param price is the unit price of the product as a value of type double
     */

    public ComputerPart(int id, String name, String manufacturer, double price) {
   
        // validation
        if (price < 0) {
            throw new IllegalArgumentException("Error: Negative product price");
        }
        
        if (name.length() == 0 || manufacturer.length() == 0) {
            throw new IllegalArgumentException("Error: Product name or manufacturer is not defined");
        }

        this.productId = id;
        this.productName = name;
        this.manufacturer = manufacturer;
        this.unitPrice = price;

    }

    @Override
    public int getProductId() {
        return productId;
    }

    @Override
    public String getProductName() {
        return productName;
    }

    @Override
    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public double getPrice() {
        return unitPrice;
    }

}
