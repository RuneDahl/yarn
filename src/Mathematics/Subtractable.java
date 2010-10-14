/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics;

/**
 * Interface for a
 * <a href="http://en.wikipedia.org/wiki/Subtraction">subtractable</a> class.
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of value.
 */
public interface Subtractable<TypeOfValue> {
    /**
     * Compute the specified value
     * <a href="http://en.wikipedia.org/wiki/Subtraction">subtracted</a>
     * from this value.<br>
     * The implementation should throw a NullPointerException
     * if the specified value is null.
     * @param value Value to subtract.
     * @return      The difference.
     * @throws NullPointerException The value is not properly specified.
     */
    public TypeOfValue subtract(final TypeOfValue value);
}