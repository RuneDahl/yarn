/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics;

/**
 * Interface for a value that can be
 * <a href="http://en.wikipedia.org/wiki/Conjugate#Mathematics">conjugated</a>.
 * This interface should only be implemented on classes that can be
 * conjugated in a simple and unique way.
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of value.
 */
public interface Conjugate<TypeOfValue> {
    /**
     * Returns the <a href="http://en.wikipedia.org/wiki/Conjugate#Mathematics">
     * conjugate</a> of this value.
     * @return The conjugate of this value.
     */
    public TypeOfValue conjugate();
}