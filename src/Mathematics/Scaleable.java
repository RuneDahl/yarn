/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics;

/**
 * Interface for a
 * <a href="http://en.wikipedia.org/wiki/Scalar_%28mathematics%29"scaleable</a>
 * class.
 * @author Rune Dahl Iversen
 * @param <TypeOfScalar> Type of scalar.
 * @param <TypeOfOutput> Type of output.
 *                       Typically the class implementing this interface.
 */
public interface Scaleable<TypeOfScalar, TypeOfOutput> {
    /**
     * This value scaled by the specified
     * <a href="http://en.wikipedia.org/wiki/Scalar_%28mathematics%29>scalar</a>
     * value.
     * @param scalar Scalar value.
     * @return       The scaled value.
     */
    public TypeOfOutput Scale(final TypeOfScalar scalar);
}