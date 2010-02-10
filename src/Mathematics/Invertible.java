/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics;

/**
 * Interface for a invertible class.
 * This interface should only be implemented on classes that are
 * invertible in a simple and unique way.
 * @author Rune Dahl Iversen
 * @param <TypeOfOutput> Type of output.
 *                       Typically the class implementing this interface.
 */
public interface Invertible<TypeOfOutput> {
    /**
     * Returns the inverse value of the current instance.
     * @return The inverse value.
     */
    public TypeOfOutput Inverse();
}