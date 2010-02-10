/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics;

/**
 * Interface for an additive class.
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of value.
 */
public interface Additive<TypeOfValue> {
    /**
     * Compute the sum of this value and the specified value.
     * @param value Value to add.
     * @return      The sum.
     */
    public TypeOfValue Add(final TypeOfValue value);

    /**
     * Compute the specified value subtracted from this value.
     * @param value Value to subtract.
     * @return      The difference.
     */
    public TypeOfValue Subtract(final TypeOfValue value);
}