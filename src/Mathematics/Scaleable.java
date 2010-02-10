/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics;

/**
 * Interface for a scaleable class.
 * @author Rune Dahl Iversen
 * @param <TypeOfScalar> Type of scalar.
 * @param <TypeOfOutput> Type of output.
 *                       Typically the class implementing this interface.
 */
public interface Scaleable<TypeOfScalar, TypeOfOutput> {
    /**
     * This value scaled by the specified scalar value.
     * @param scalar Scalar value.
     * @return       The scaled value.
     */
    public TypeOfOutput Scale(final TypeOfScalar scalar);
}