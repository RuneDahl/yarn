/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Function;

import Validation.*;

/**
 * Implementation of a {@see Differential differential} numerical approximation
 * to the {@see Derivative derivative} value when the function is from
 * {@see Double real} values into real values.
 * @author Rune Dahl Iversen
 */
public class DifferentialReal extends Differential<Double, Double> {
    private final static Validator<Double> __stepValidator = Factory.FiniteReal();

    /**
     * Creates an instance of the differential with the specified step size and direction.
     * @param step      Step size.
     * @param direction Direction.
     */
    public DifferentialReal(final Double step,
            final DifferentialDirections direction) {
        super(__stepValidator, step, direction);
    }

    @Override
    public Double value(final Double value, Function<Double, Double> function) {
        double v;
        double w;
        if (this.getDirection() == DifferentialDirections.Central) {
            v = value + this.getStep();
            w = value - this.getStep();
        }
        else {
            v = value;
            w = value + this.getDirection().getValue()*this.getStep();
        }
        double fv = function.value(v);
        double fw = function.value(w);
        return (fv-fw) / (v-w);
    }
}
