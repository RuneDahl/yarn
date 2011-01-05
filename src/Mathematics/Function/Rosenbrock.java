/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Function;

import Mathematics.Vector.*;

/**
 * Implementation of the
 * <a href="http://en.wikipedia.org/wiki/Rosenbrock_function">Rosenbrock
 * function</a> in 2 dimensions. <br>
 * This function is useful in testing convergence properties of 2-dimensional
 * optimization algorithms.
 * @author Rune Dahl Iversen
 */
public class Rosenbrock implements Function<Vector<Double>, Double> {
    @Override
    public Double value(Vector<Double> input) {
        if (input.getDimensions() != 2)
            throw new IllegalArgumentException("Input must be 2 dimensional.");
        double x = input.getValue(input.getFirstDimension());
        double y = input.getValue(input.getFirstDimension() + 1);
        double value = Math.pow(1.0 - x, 2.0);
        value += 100.0 * Math.pow(y - Math.pow(x, 2.0), 2.0);
        return value;
    }
}