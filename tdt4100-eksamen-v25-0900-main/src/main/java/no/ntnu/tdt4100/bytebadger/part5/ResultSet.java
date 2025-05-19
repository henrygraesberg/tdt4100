/**
 * THIS IS SUPPLIED CODE - DO NOT MODIFY THE CODE BELOW
 * 
 */

package no.ntnu.tdt4100.bytebadger.part5;

import java.util.List;

import no.ntnu.tdt4100.bytebadger.ComputerPart;
import no.ntnu.tdt4100.bytebadger.IComputerPart;

/**
 * The <code>ResultSet</code> class contains a list of {@link ComputerPart}
 * objects, and a list of line numbers for errors.
 */

public record ResultSet(List<IComputerPart> parts, List<Integer> linesWithErrors) {
}
