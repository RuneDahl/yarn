/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Vector;

import Mathematics.Function.*;

/**
 * Implementation of the
 * <a href="http://en.wikipedia.org/wiki/Matrix_product#Hadamard_product">
 * Hadamard product</a> of two {@see Vector vectors} of {@see Double real} values. <br>
 * This function result in a vector containing the multiplies the individual
 * entries in the 2 vectors, that must be the of the same dimensions.
 * @author Rune Dahl Iversen
 */
public final class HadamardProductReal
        implements Operator<Vector<Double>, Vector<Double>, Vector<Double>> {
    public Vector<Double> Value(final Vector<Double> firstInput,
            final Vector<Double> secondInput) {
        if (!firstInput.hasSameDimensions(secondInput))
            throw new IllegalArgumentException("The vectors are not conforming" +
                    " in dimensions.");
        int start = firstInput.getFirstDimension();
        int end = firstInput.getFirstDimension() + firstInput.getDimensions();
        Vector<Double> ep = new VectorReal(start, end - start);
        for (int dim = start; dim < end; dim++)
            ep.setValue(dim, firstInput.getValue(dim) * secondInput.getValue(dim));
        return ep;
    }
}
