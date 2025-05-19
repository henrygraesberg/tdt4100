/**
 * THIS IS SUPPLIED CODE - DO NOT MODIFY THE CODE 
 * 
 */

package no.ntnu.tdt4100.bytebadger;

/**
 * A record representing a customer in the computer build system.
 * A customer has an id, name, email, phone and address.
 */

public record Customer(int id, String name, String email, int phone, String address) {}

