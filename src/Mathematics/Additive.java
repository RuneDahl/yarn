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
     * of this value and the specified value.<br>
     * The implementation should throw a NullPointerException
     * if the specified value is null.
     * @param value Value to add.
     * @return      The sum.
     * @throws NullPointerException The value is not properly specified.
     */
    public TypeOfValue sum(final TypeOfValue value);
}