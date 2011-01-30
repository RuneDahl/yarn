/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Vector;

import Validation.*;
import Mathematics.Complex;
import java.util.Arrays;

/**
 * Implementation of a {@see Vector vector} of {@see Complex complex} numbers.
 * VectorComplex is implemented as an immutable class.
 * @author Rune Dahl Iversen
 */
public final class VectorComplex implements Vector<Complex> {
    private static final Validator<Complex> __validator = Factory.FiniteComplex();
    private Complex[] _values;
    private int _firstDimension;

    /**
     * Creates a real vector with the specified number of dimensions.
     * The vector will be initiated with the value 0.0 in all dimensions/values.
     * @param dimensions Number of dimensions of this vector.
     */
    public VectorComplex(final int dimensions) {
        this(0, dimensions);
    }

    /**
     * Creates a real vector with the specified first dimension and number of
     * dimensions. The vector will be initiated with the value 0.0 in all
     * dimensions/values.
     * @param firstDimension First dimension of this vector.
     * @param dimensions     Number of dimensions of this vector.
     */
    public VectorComplex(final int firstDimension, final int dimensions) {
        this(firstDimension, dimensions, Complex.Origin);
    }

    /**
     * Creates a real vector with the specified number of dimensions
     * and the specified value in all dimensions/values.
     * @param dimensions Number of dimensions of this vector.
     * @param value      Value.
     */
    public VectorComplex(final int dimensions, final Complex value) {
        this(0, dimensions, value);
    }

    /**
     * Creates a finite real vector with the specified first dimension, number of
     * dimensions and the specified value in all dimensions/values.
     * @param firstDimension First dimension of this vector.
     * @param dimensions     Number of dimensions of this vector.
     * @param value          Value.
     */
    public VectorComplex(final int firstDimension, final int dimensions,
            final Complex value) {
        this._firstDimension = firstDimension;
        Complex[] values = new Complex[dimensions];
        for (int dim = 0; dim < dimensions; dim++)
            values[dim] = value;
        this._setValues(values);
    }

    /**
     * Creates a real vector with the specified array of values.
     * @param values Zero-based array of values.
     */
    public VectorComplex(final Complex[] values) {
        this(0, values);
    }

    /**
     * Creates a real vector with the specified first dimension
     * and zero-based array of values.
     * @param firstDimension First dimension of this vector.
     * @param values         Zero-based array of values.
     */
    public VectorComplex(final int firstDimension, final Complex[] values) {
        this._firstDimension = firstDimension;
        this._setValues(values);
    }

    @Override
    public int getDimensions() {
        return this._values.length;
    }

    @Override
    public int getFirstDimension() {
        return this._firstDimension;
    }

    @Override
    public int getLastDimension() {
        return this._firstDimension + this.getDimensions() - 1;
    }

    @Override
    public Complex getValue(final int dimension) {
        return this._values[dimension - this._firstDimension];
    }

    @Override
    public boolean hasSameDimensions(Vector<Complex> vector) {
        return this.getFirstDimension() == vector.getFirstDimension() &&
                this.getDimensions() == vector.getDimensions();
    }

    @Override
    public Vector<Complex> setValue(final int dimension, final Complex value) {
        if (!__validator.isValid(value))
            throw new IllegalArgumentException(
                    __validator.message(value, "Value"));
        VectorComplex v = new VectorComplex(this._firstDimension, this._values);
        v._values[dimension - this._firstDimension] = value;
        return v;
    }

    @Override
    public Vector<Complex> sum(final Vector<Complex> value) {
        if (!this.hasSameDimensions(value))
            throw new IllegalArgumentException("The vectors are not " +
                    "conforming in dimensions.");
        Complex[] sums = new Complex[this.getDimensions()];
        for (int dim = 0; dim < this._values.length; dim++)
            sums[dim] = this._values[dim].sum(
                    value.getValue(dim + this._firstDimension));
        return new VectorComplex(this._firstDimension, sums);
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof VectorComplex)
            return this.equals((VectorComplex) obj);
        else
            return false;
    }

    /**
     * Indicates whether some {@see VectorComplex vector} of real values
     * is equal to this vector.
     * @param vector Vector of real values.
     * @return       True if the vectors have the same values.
     */
    public boolean equals(final VectorComplex vector) {
        if (vector == null)
            return false;
        if (vector == this)
            return true;
      //if (this.hashCode() != vector.hashCode())
      //    return false;
        if (!this.hasSameDimensions(vector))
            return false;
        for (int d = 0; d < this.getDimensions(); d++)
            if (!this._values[d].equals(vector._values[d]))
                return false;
        return true;
    }

    @Override
    public int hashCode() {
        int hash = this._firstDimension;
        hash = 97 * hash + Arrays.hashCode(this._values);
        return hash;
    }

    @Override
    public Vector<Complex> subtract(final Vector<Complex> value) {
        if (!this.hasSameDimensions(value))
            throw new IllegalArgumentException("The vectors are not " +
                    "conforming in dimensions.");
        Complex[] diffs = new Complex[this.getDimensions()];
        for (int dim = 0; dim < this._values.length; dim++)
            diffs[dim] = this._values[dim].subtract(
                    value.getValue(dim + this._firstDimension));
        return new VectorComplex(this._firstDimension, diffs);
    }

    @Override
    public Vector<Complex> scale(final Complex scalar) {
        Complex[] values = new Complex[this.getDimensions()];
        for (int dim = 0; dim < this._values.length; dim++)
            values[dim] = this._values[dim].product(scalar);
        return new VectorComplex(this._firstDimension, values);
    }

    @Override
    public Complex[] toArray() {
        Complex[] values = new Complex[this._values.length];
        for (int dim = 0; dim < this._values.length; dim++)
            values[dim] = this._values[dim];
        return values;
    }

    @Override
    public String toString() {
        String text = "[";
        for (int dim = 0; dim < this.getDimensions(); dim++) {
            text += this._values[dim].toString();
            text += (dim < this.getDimensions() - 1 ? " ; " : "");
        }
        text += "]";
        return text;
    }

    private void _setValues(final Complex[] values) {
        this._values = new Complex[values.length];
        for (int dim = 0; dim < values.length; dim++)
        {
            if (__validator.isValid(values[dim]))
                this._values[dim] = values[dim];
            else
                throw new IllegalArgumentException(
                        __validator.message(values[dim],
                        "The value of dimension " + Integer.toString(dim)));
        }
    }

    /**
     * Returns an instance of a unit-vector of the specified dimensions
     * and unit-dimension.
     * @param dimensions    Number of dimensions of the vector.
     * @param unitDimension Unit-dimension of the vector. The dimension that has
     *                      the value 1.
     * @return              Unit-vector.
     */
    public static VectorComplex Unit(final int dimensions,
            final int unitDimension) {
        VectorComplex unit = new VectorComplex(dimensions);
        return (VectorComplex)unit.setValue(unitDimension, Complex.RealNumber(1.0));
    }

    /**
     * Returns an instance of a unit-vector of the specified dimensions
     * and unit-dimension.
     * @param firstDimension First dimension of the vector.
     * @param dimensions     Number of dimensions of the vector.
     * @param unitDimension  Unit-dimension of the vector. The dimension that
     *                       has the value 1.
     * @return               Unit-vector.
     */
    public static VectorComplex Unit(final int firstDimension,
            final int dimensions, final int unitDimension) {
        VectorComplex unit = new VectorComplex(firstDimension, dimensions);
        return (VectorComplex)unit.setValue(unitDimension, Complex.RealNumber(1.0));
    }
}