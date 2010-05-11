/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Vector;

import Mathematics.Function.*;

/**
 * Implementation of the
 * <a href="http://en.wikipedia.org/wiki/Dot_product">inner product</a> of
 * two {@see Vector vectors} of real values.
 * @author Rune Dahl Iversen
 */
public final class InnerProductReal
        implements Operator<Vector<Double>, Vector<Double>, Double> {
    public Double Value(final Vector<Double> firstInput,
            final Vector<Double> secondInput) {
        if (!firstInput.hasSameDimensions(secondInput))
            throw new IllegalArgumentException("The vectors are not conforming" +
                    " in dimensions.");
        int start = firstInput.getFirstDimension();
        int end = start + firstInput.getDimensions();
        double ip = 0.0;
        for (int dim = start; dim < end; dim++)
            ip += firstInput.getValue(dim) * secondInput.getValue(dim);
        return ip;
    }
}