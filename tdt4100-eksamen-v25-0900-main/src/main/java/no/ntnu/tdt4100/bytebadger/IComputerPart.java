/**
 * THIS IS SUPPLIED CODE - DO NOT MODIFY THE CODE BELOW
 */

package no.ntnu.tdt4100.bytebadger;

/**
 * The supplied code represents the interface for the computer parts in the 
 * computer build system.
 *
 * The interface provides methods to get and set information for the computer parts
 * represented by product id, product name, manufacturer and unit price.
 */

public interface IComputerPart {

    /**
     * Method for getting the product ID.
     * 
     * @return the product ID.
     */

    int getProductId();

    /**
     * Method for getting the name of the product.
     * 
     * @return the name of the product.
     */

    String getProductName();

    /**
     * Method for getting the name of the manufacturer of the product.
     * 
     * @return the name of the manufacturer.
     */

    String getManufacturer();

    /**
     * Method for getting the unit price of the product.
     * 
     * @return the unit price of the product.
     */

    double getPrice();

}
