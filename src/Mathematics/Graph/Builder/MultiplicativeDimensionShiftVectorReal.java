/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Graph.Builder;

import Mathematics.Vector.Vector;
import Validation.*;

/**
 * Implementation of an <a href="http://en.wikipedia.org/wiki/Multiplication">
 * multiplicative</a> {@see StateShifter shift} in the value of a dimension in a
 * {@see Vector vector} of {@see Double real} values.
 * @author Rune Dahl Iversen
 */
public final class MultiplicativeDimensionShiftVectorReal
        extends VectorDimensionShiftBased<Double> {
    private final static Validator<Double> __shiftValidator = Factory.FiniteReal();

    /**
     * Creates an instance of the multiplicative shift i nthe value of a
     * dimension in a vector of real values with the specified dimension and
     * shift value.
     * @param dimension Dimension.
     * @param shift     Shift value.
     */
    public MultiplicativeDimensionShiftVectorReal(
            final int dimension,
            final double shift) {
        super(dimension, __shiftValidator, shift);
    }

    @Override
    public Vector<Double> value(Vector<Double> input) {
        return input.setValue(this.getDimension(),
                input.getValue(this.getDimension())*this.getShift());
    }
}
