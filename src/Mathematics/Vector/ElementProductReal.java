/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Vector;

import Mathematics.Function.*;

/**
 * Implementation of the element-by-element product (Corresponds to the MatLab
 * Dot Star operator) of two {@see Vector vectors} of real values.
 * @author Rune Dahl Iversen
 */
public final class ElementProductReal
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
