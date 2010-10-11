/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics;

/**
 * Interface for a
 * <a href="http://en.wikipedia.org/wiki/Additive_inverse">reversible</a> class.
 * This interface should only be implemented on classes that are
 * reversible in a simple and unique way.
 * @author Rune Dahl Iversen
 * @param <TypeOfOutput> Type of output.
 *                       Typically the class implementing this interface.
 */
public interface Reversible<TypeOfOutput> {
    /**
     * Returns the
     * <a href="http://en.wikipedia.org/wiki/Additive_inverse">reverse</a>
     * value of this value.
     * @return The reverse value.
     */
    public TypeOfOutput reverse();
}