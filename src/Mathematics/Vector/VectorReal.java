/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Vector;

import Validation.*;
import java.util.Arrays;

/**
 * Implementation of a {@see Vector vector} of {@see Double real} numbers.
 * VectorReal is implemented as an immutable class.
 * @author Rune Dahl Iversen
 */
public class VectorReal implements Vector<Double> {
    private Validator<Double> _validator;
    private double[] _values;
    private int _firstDimension;

    /**
     * Creates a real vector with the specified number of dimensions.
     * The vector will be initiated with the value 0.0 in all dimensions/values.
     * @param dimensions Number of dimensions of this vector.
     */
    public VectorReal(final int dimensions) {
        this(0, dimensions);
    }

    /**
     * Creates a real vector with the specified first dimension and number of
     * dimensions. The vector will be initiated with the value 0.0 in all
     * dimensions/values.
     * @param firstDimension First dimension of this vector.
     * @param dimensions     Number of dimensions of this vector.
     */
    public VectorReal(final int firstDimension, final int dimensions) {
        this(firstDimension, dimensions, 0.0);
    }

    /**
     * Creates a real vector with the specified number of dimensions
     * and the specified value in all dimensions/values.
     * @param dimensions Number of dimensions of this vector.
     * @param value      Value.
     */
    public VectorReal(final int dimensions, final double value) {
        this(0, dimensions, value);
    }

    /**
     * Creates a real vector with the specified first dimension, number of
     * dimensions and the specified value in all dimensions/values.
     * @param firstDimension First dimension of this vector.
     * @param dimensions     Number of dimensions of this vector.
     * @param value          Value.
     */
    public VectorReal(final int firstDimension, final int dimensions,
            final double value) {
        this._validator = this._setValidator();
        this._firstDimension = firstDimension;
        double[] values = new double[dimensions];
        for (int dim = 0; dim < dimensions; dim++)
            values[dim] = value;
        this._setValues(values);
    }

    /**
     * Creates a real vector with the specified array of values.
     * @param values Zero-based array of values.
     */
    public VectorReal(final double[] values) {
        this(0, values);
    }

    /**
     * Creates a real vector with the specified first dimension
     * and zero-based array of values.
     * @param firstDimension First dimension of this vector.
     * @param values         Zero-based array of values.
     */
    public VectorReal(final int firstDimension, final double[] values) {
        this._validator = this._setValidator();
        this._firstDimension = firstDimension;
        this._setValues(values);
    }

    public int getDimensions() {
        return this._values.length;
    }

    public int getFirstDimension() {
        return this._firstDimension;
    }

    public int getLastDimension() {
        return this._firstDimension + this.getDimensions() - 1;
    }

    public Double getValue(final int dimension) {
        return this._values[dimension - this._firstDimension];
    }

    public boolean hasSameDimensions(Vector<Double> vector) {
        return this.getFirstDimension() == vector.getFirstDimension() &&
                this.getDimensions() == vector.getDimensions();
    }

    public Vector<Double> setValue(final int dimension, final Double value) {
        VectorReal v = new VectorReal(this._values);
        v._values[dimension - this._firstDimension] = value;
        return v;
    }

    public Vector<Double> Add(final Vector<Double> value) {
        if (!this.hasSameDimensions(value))
            throw new IllegalArgumentException("The vectors are not " +
                    "conforming in dimensions.");
        double[] sums = new double[this.getDimensions()];
        for (int dim = 0; dim < this._values.length; dim++)
            sums[dim] = this._values[dim] +
                    value.getValue(dim + this._firstDimension);
        return new VectorReal(this._firstDimension, sums);
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof VectorReal)
            return this.equals((VectorReal) obj);
        else
            return false;
    }

    /**
     * Indicates whether some {@see VectorReal vector} of real values
     * is equal to this vector.
     * @param vector Vector of real values.
     * @return       True if the vectors have the same values.
     */
    public boolean equals(final VectorReal vector) {
        if (vector == null)
            return false;
        if (vector == this)
            return true;
      //if (this.hashCode() != vector.hashCode())
      //    return false;
        if (!this.hasSameDimensions(vector))
            return false;
        for (int d = 0; d < this.getDimensions(); d++)
            if (this._values[d] != vector._values[d])
                return false;
        return true;
    }

    @Override
    public int hashCode() {
        int hash = this._firstDimension;
        hash = 97 * hash + Arrays.hashCode(this._values);
        return hash;
    }

    public Vector<Double> Subtract(final Vector<Double> value) {
        if (!this.hasSameDimensions(value))
            throw new IllegalArgumentException("The vectors are not " +
                    "conforming in dimensions.");
        double[] diffs = new double[this.getDimensions()];
        for (int dim = 0; dim < this._values.length; dim++)
            diffs[dim] = this._values[dim] -
                    value.getValue(dim + this._firstDimension);
        return new VectorReal(this._firstDimension, diffs);
    }

    public Vector<Double> Scale(final Double scalar) {
        double[] values = new double[this.getDimensions()];
        for (int dim = 0; dim < this._values.length; dim++)
            values[dim] = this._values[dim] * scalar;
        return new VectorReal(this._firstDimension, values);
    }

    public Double[] ToArray() {
        Double[] values = new Double[this._firstDimension + this._values.length - 1];
        for (int dim = 0; dim < this._firstDimension; dim++)
            values[dim] = 0.0;
        for (int dim = this._firstDimension;
        dim < this._firstDimension + this._values.length; dim++)
            values[dim] = this.getValue(dim);
        return values;
    }

    private Validator<Double> _setValidator() {
        And<Double> validator = new And<Double>();
        validator.add(new NotNull<Double>());
        validator.add(new DoubleIsNumeric());
        validator.add(new DoubleIsFinite());
        return validator;
    }

    private void _setValues(final double[] values) {
        this._values = new double[values.length];
        for (int dim = 0; dim < values.length; dim++)
        {
            if (this._validator.isValid(values[dim]))
                this._values[dim] = values[dim];
            else
                throw new IllegalArgumentException(
                        this._validator.Message(values[dim],
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
    public static VectorReal Unit(final int dimensions,
            final int unitDimension) {
        VectorReal unit = new VectorReal(dimensions);
        unit.setValue(unitDimension, 1.0);
        return unit;
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
    public static VectorReal Unit(final int firstDimension,
            final int dimensions, final int unitDimension) {
        VectorReal unit = new VectorReal(firstDimension, dimensions);
        unit.setValue(unitDimension, 1.0);
        return unit;
    }
}