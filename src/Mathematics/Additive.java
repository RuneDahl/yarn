/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics;

/**
 * Interface for an <a href="http://en.wikipedia.org/wiki/Addition">additive</a>
 * class.
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of value.
 */
public interface Additive<TypeOfValue> {
    /**
     * Compute the  <a href="http://en.wikipedia.org/wiki/Addition">sum</a>
     * of this value and the specified value.
     * @param value Value to add.
     * @return      The sum.
     */
    public TypeOfValue Add(final TypeOfValue value);

    /**
     * Compute the specified value
     * <a href="http://en.wikipedia.org/wiki/Subtraction">subtracted</a>
     * from this value.
     * @param value Value to subtract.
     * @return      The difference.
     */
    public TypeOfValue Subtract(final TypeOfValue value);
}