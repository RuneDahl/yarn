/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics;

/**
 * Interface for a multiplicative class.
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of value.
 */
public interface Multiplicative<TypeOfValue> {
    /**
     * Computes the division of this value by the specified denominator.
     * @param denominator Denominator.
     * @return            Divided value.
     */
    public TypeOfValue Divide(final TypeOfValue denominator);

    /**
     * Computes the product of this value and the specified factor.
     * @param factor Factor.
     * @return       Product.
     */
    public TypeOfValue Multiply(final TypeOfValue factor);
}