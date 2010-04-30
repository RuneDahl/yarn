/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Vector;

import Mathematics.*;

/**
 * Interface declaring a finite dimensional
 * <a href="http://en.wikipedia.org/wiki/Coordinate_vector">vector</a>.
 * <br>- It is implicitly assumed that the type of scalar that can be applied
 * to the vector is of the same type as the values of vector.
 * <br>- It is suggested that any classes implementing Vector be implemented
 * as <a href="http://en.wikipedia.org/wiki/Immutable_object">immutable</a>.
 * <br>- Any implementation of Vector should hve values for the following
 * dimensions: 0, 1, ..., getDimensions() - 1.
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of value.
 */
public interface Vector<TypeOfValue>
        extends Additive<Vector<TypeOfValue>>,
        Scaleable<TypeOfValue, Vector<TypeOfValue>> {
    /**
     * Gets the number of
     * <a href="http://en.wikipedia.org/wiki/Dimension_%28vector_space%29">dimensions</a>
     * of this vector.
     * @return The number of dimensions.
     */
    public int getDimensions();

    /**
     * Gets the value from this vector of the specified dimension.
     * @param dimension The dimension.
     * @return          The dimensional value.
     */
    public TypeOfValue getValue(final int dimension);

    /**
     * Returns a new vector with the specified dimension set to the value.
     * @param dimension Dimension.
     * @param value     Value.
     * @return          New vector.
     */
    public Vector<TypeOfValue> setValue(final int dimension,
            final TypeOfValue value);

    /**
     * Returns an array of the values from this vector.
     * @return Array of the values of this vector.
     */
    public TypeOfValue[] ToArray();
}