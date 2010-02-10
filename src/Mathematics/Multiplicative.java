/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics;

/**
 * Interface for a
 * <a href="http://en.wikipedia.org/wiki/Multiplication">multiplicative</a>
 * class.
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of value.
 */
public interface Multiplicative<TypeOfValue> {
    /**
     * Computes the
     * <a href="http://en.wikipedia.org/wiki/Division_%28mathematics%29">division</a>
     * of this value by the specified
     * <a href="http://en.wikipedia.org/wiki/Denominator">denominator</a>.
     * @param denominator Denominator.
     * @return            Divided value.
     */
    public TypeOfValue Divide(final TypeOfValue denominator);

    /**
     * Computes the
     * <a href="http://en.wikipedia.org/wiki/Multiplication">product</a>
     * of this value and the specified factor.
     * @param factor Factor.
     * @return       The product.
     */
    public TypeOfValue Multiply(final TypeOfValue factor);
}