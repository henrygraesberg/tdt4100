/**
 * THIS IS SUPPLIED CODE - DO NOT MODIFY THE CODE BELOW
 */

package no.ntnu.tdt4100.bytebadger;

import java.util.Map;

/**
 * The supplied code represents the interface for a computer build.
 *
 * This interface provides methods to get information about the customer, 
 * the total price and the computer parts.
 */

public interface ICustomBuild {

    /**
     * This method should return the customer associated with the computer build.
     * 
     * @return The customer of type {@link Customer}
     */

    Customer getCustomer();

    /** 
     * This method should return the total price for the computer build.
     * 
     * The total price should be the sum of all unit prices of all parts in the build.
     * 
     * @return The total price as a value of type double.
     * 
     */

    double getTotalPrice();

    /** 
     * This method should return a map of all the computer parts in the computer build 
     * with their cooresponding quantities.
     * 
     * The keys in the map should be the computer parts, and these must be unique.
     * The values of the map should be the quantities of the parts added to the computer build,
     * and must be positive integers.
     * 
     * @return A {@link Map} of all computer parts as keys of type {@link IComputerPart}
     * and the quantities of parts as values of type {@link Integer}.
     */

    Map<IComputerPart, Integer> getParts();


    

}
