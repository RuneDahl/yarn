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
     * <a href="http://en.wikipedia.org/wiki/Multiplication">product</a>
     * of this value and the specified factor.
     * @param factor Factor.
     * @return       The product.
     */
    public TypeOfValue Multiply(final TypeOfValue factor);
}