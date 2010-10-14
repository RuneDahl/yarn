/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics;

/**
 * Interface for a
 * <a href="http://en.wikipedia.org/wiki/Division_%28mathematics%29">divisible</a>
 * class.
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of value.
 */
public interface Divisible<TypeOfValue> {
    /**
     * Computes the
     * <a href="http://en.wikipedia.org/wiki/Division_%28mathematics%29">division</a>
     * of this value by the specified
     * <a href="http://en.wikipedia.org/wiki/Denominator">denominator</a>.<br>
     * The implementation should throw a NullPointerException
     * if the specified denominator is null.
     * @param denominator Denominator.
     * @return            Divided value.
     * @throws NullPointerException The denominator is not properly specified.
     */
    public TypeOfValue divide(final TypeOfValue denominator);
}