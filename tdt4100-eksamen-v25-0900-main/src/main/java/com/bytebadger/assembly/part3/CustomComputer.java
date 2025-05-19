package com.bytebadger.assembly.part3;

import java.util.HashMap;
import java.util.stream.DoubleStream;

import no.ntnu.tdt4100.bytebadger.Customer;
import no.ntnu.tdt4100.bytebadger.IComputerPart;
import no.ntnu.tdt4100.bytebadger.ICustomBuild;

/**
 * Implement the class CustomComputer which represents a custom computer build.
 * 
 * The class must implement the interface {@link no.ntnu.tdt4100.bytebadger.ICustomBuild}.
 * Read the documentation in the interface for detailed description of the behaviour of
 * the methods you need to implement.
 * 
 * In addition to the methods required by the interface, the class has a constructor and
 * some additional methods for managing the computer build.
 * 
 * The class should store a list of {@link no.ntnu.tdt4100.bytebadger.IComputerPart} computer part
 * objects and it should be able to add and remove a quantity of parts from
 * the custom build. 
 * 
 * @see no.ntnu.tdt4100.bytebadger.ICustomBuild
 * @see CustomComputerTest
*/

public class CustomComputer implements ICustomBuild {

    private Customer customer;
    private HashMap<IComputerPart, Integer> parts;

    /**
     * This is the constructor for the class CustomComputer
     * 
     * @param customer the customer of a custom computer build
     * 
     * @throws IllegalArgumentException if the customer is null.
     */
    
    public CustomComputer(Customer customer) {

        if(customer == null)
            throw new IllegalArgumentException();
        
        this.customer = customer;

        parts = new HashMap<>();
    }

    /**
     * This method adds a quantity of a specific computer part to the custom computer build.
     * 
     * @param part a computer part
     * @param quantity the number of parts to be added
     * 
     * @throws IllegalArgumentException if the quantity is not a positive integer.
     */
    
    public void addPart(IComputerPart part, int quantity) {

        if(quantity < 1)
            throw new IllegalArgumentException();
        
        parts.merge(part, quantity, (v, q) -> v + q);
    }

    /**
     * This method removes a quantity of a specific computer part from the custom computer build.
     * 
     * @param part a computer part
     * @param quantity the number of parts to be removed
     * 
     * @throws IllegalArgumentException if the part is not in the build or if the quantity is not a positive number.
     */
    public void removePart(IComputerPart part, int quantity) {

        if(!parts.containsKey(part) || parts.get(part) - quantity < 0)
            throw new IllegalArgumentException();
        
        parts.merge(part, quantity, (v, q) -> v - q);
    }

    @Override
    public Customer getCustomer() {
        return this.customer;
    }

    @Override
    public HashMap<IComputerPart, Integer> getParts() {
        return parts;
    }

    @Override
    public double getTotalPrice() {
        DoubleStream.Builder valuesBuilder = DoubleStream.builder();

        this.parts.forEach((k, v) -> valuesBuilder.add(k.getPrice() * v));

        return valuesBuilder.build().sum();
    }
}
