/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Norm;

import Mathematics.Vector.*;

/**
 * An implementation of the
 * <a href="http://en.wikipedia.org/wiki/Maximum_norm">maximum norm</a>
 * for a {@see Vector vector} of {@see Double real} values.
 * @author Rune Dahl Iversen
 */
public class VectorDoubleMaximum implements Norm<Vector<Double>> {
    /**
     * Creates an instance of the
     * <a href="http://en.wikipedia.org/wiki/Maximum_norm">maximum norm</a>
     * for a {@see Vector vector} of {@see Double real} values.
     */
    public VectorDoubleMaximum() { // Intentional
    }

    public Double value(Vector<Double> input) {
        double norm = 0.0;
        for (int d = 0; d < input.getDimensions(); d++)
            norm = Math.max(norm, Math.abs(input.getValue(d)));
        return norm;
    }
}