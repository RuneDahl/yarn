/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Vector;

import Validation.*;
import java.util.Arrays;

/**
 * Implementation of a {@see Vector vector} of real numbers (doubles).
 * VectorReal is implemented as an immutable class.
 * @author Rune Dahl Iversen
 */
public class VectorReal implements Vector<Double> {
    private Validator<Double> _validator;
    private double[] _values;

    /**
     * Creates a real vector with the specified number of dimensions.
     * The vector will be initiated with the value 0.0 in all dimensions/values.
     * @param dimensions Number of dimensions of this vector.
     */
    public VectorReal(final int dimensions) {
        this(dimensions, 0.0);
    }

    /**
     * Creates a real vector with the specified number of dimensions
     * and the specified value in all dimensions/values.
     * @param dimensions Number of dimensions of this vector.
     * @param value      Value.
     */
    public VectorReal(final int dimensions, final double value) {
        this._validator = this._setValidator();
        double[] values = new double[dimensions];
        for (int dim = 0; dim < dimensions; dim++)
            values[dim] = value;
        this._setValues(values);
    }

    /**
     * Creates a real vector with the specified array of values.
     * @param values    Array of values.
     */
    public VectorReal(final double[] values) {
        this._validator = this._setValidator();
        this._setValues(values);
    }

    public int getDimensions() {
        return this._values.length;
    }

    public Double getValue(int dimension) {
        return this._values[dimension];
    }

    public Vector<Double> setValue(int dimension, Double value) {
        VectorReal v = new VectorReal(this._values);
        v._values[dimension] = value;
        return v;
    }

    public Vector<Double> Add(Vector<Double> value) {
        if (value.getDimensions() != this.getDimensions())
            throw new IllegalArgumentException("The vectors are not conforming.");
        double[] sums = new double[this.getDimensions()];
        for (int dim = 0; dim < this._values.length; dim++)
            sums[dim] = this._values[dim] + value.getValue(dim);
        return new VectorReal(sums);
    }

    @Override
    public boolean equals(Object obj) {
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
        if (this.hashCode() != vector.hashCode())
            return false;
        if (this.getDimensions() != vector.getDimensions())
            return false;
        for (int d = 0; d < this.getDimensions(); d++)
            if (this._values[d] != vector._values[d])
                return false;
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Arrays.hashCode(this._values);
        return hash;
    }

    public Vector<Double> Subtract(Vector<Double> value) {
        if (value.getDimensions() != this.getDimensions())
            throw new IllegalArgumentException("The vectors are not conforming.");
        double[] diffs = new double[this.getDimensions()];
        for (int dim = 0; dim < this._values.length; dim++)
            diffs[dim] = this._values[dim] - value.getValue(dim);
        return new VectorReal(diffs);
    }

    public Vector<Double> Scale(Double scalar) {
        double[] values = new double[this.getDimensions()];
        for (int dim = 0; dim < this._values.length; dim++)
            values[dim] = this._values[dim] * scalar;
        return new VectorReal(values);
    }

    public Double[] ToArray() {
        Double[] values = new Double[this._values.length];
        for (int dim = 0; dim < this._values.length; dim++)
            values[dim] = this._values[dim];
        return values;
    }

    private Validator<Double> _setValidator() {
        And<Double> validator = new And<Double>();
        validator.add(new NotNull<Double>());
        validator.add(new DoubleIsNumeric());
        validator.add(new DoubleIsFinite());
        return validator;
    }

    private void _setValues(double[] values) {
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
}