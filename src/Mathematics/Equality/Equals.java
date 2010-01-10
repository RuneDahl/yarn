/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Equality;

/**
 * Interface for comparison of values.
 * The declaration of this interface allows all comparison of values to
 * be implemented using the design pattern Strategy.
 * Further it allows the design pattern Composite.
 * @author Rune Dahl Iversen
 */
public interface Equals<TypeOfValue> {
    /**
     * Determines if the 2 specified values can be considered equal.
     * @param a Value.
     * @param b Value.
     * @return  True if the 2 values are equal, else false.
     */
    public boolean Equal(TypeOfValue a, TypeOfValue b);
}