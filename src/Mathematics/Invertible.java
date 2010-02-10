/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics;

/**
 * Interface for an
 * <a href="http://en.wikipedia.org/wiki/Inverse_element#Real_numbers">
 * invertible</a> class.
 * This interface should only be implemented on classes that are
 * invertible in a simple and unique way.
 * @author Rune Dahl Iversen
 * @param <TypeOfOutput> Type of output.
 *                       Typically the class implementing this interface.
 */
public interface Invertible<TypeOfOutput> {
    /**
     * Returns the
     * <a href="http://en.wikipedia.org/wiki/Inverse_element#Real_numbers">
     * inverse</a> value of this value.
     * @return The inverse value.
     */
    public TypeOfOutput Inverse();
}