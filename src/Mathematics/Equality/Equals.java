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
 * <br>Even though Equals can be seen as an Mathematics.Operator I have for now
 * chosen not to implement it that way.
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of value.
 */
public interface Equals<TypeOfValue> {
    /**
     * Determines if the 2 specified values can be considered equal.
     * @param a Value.
     * @param b Value.
     * @return  True if the 2 values are equal, else false.
     */
    public boolean Equal(final TypeOfValue a, final TypeOfValue b);
}