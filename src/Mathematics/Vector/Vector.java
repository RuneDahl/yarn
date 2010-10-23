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
 * <br>- Any implementation of Vector should have values for the following
 * dimensions: getFirstDimension(), ..., getLastDimension().
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of value.
 */
public interface Vector<TypeOfValue>
        extends Additive<Vector<TypeOfValue>>,
        Scaleable<TypeOfValue, Vector<TypeOfValue>>,
        Subtractable<Vector<TypeOfValue>> {
    /**
     * Gets the number of
     * <a href="http://en.wikipedia.org/wiki/Dimension_%28vector_space%29">dimensions</a>
     * of this vector.
     * @return The number of dimensions.
     */
    public int getDimensions();

    /**
     * Gets the index of the first dimension of this vector.
     * @return The index of the first dimension of this vector.
     */
    public int getFirstDimension();

    /**
     * Gets the index of the last dimension of this vector.
     * @return The index of the last dimension of this vector.
     */
    public int getLastDimension();

    /**
     * Gets the value from this vector of the specified dimension.
     * @param dimension The dimension.
     * @return          The dimensional value.
     */
    public TypeOfValue getValue(final int dimension);

    /**
     * Indicates whether the specified vector has the same dimensions
     * (getFirstDimension() and getDimensions()) as this vector.
     * @param vector Vector.
     * @return       True for the same dimensions, else false.
     */
    public boolean hasSameDimensions(final Vector<TypeOfValue> vector);

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
     * The values filled with the coefficients of this vector are
     * determined by its dimensions.
     * @return Array of the values of this vector.
     */
    public TypeOfValue[] ToArray();
}