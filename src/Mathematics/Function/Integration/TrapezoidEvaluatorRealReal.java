/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Function.Integration;

import Mathematics.Function.*;
import Mathematics.Interval;

/**
 * {@see Evaluator Evaluates} the
 * <a href="http://en.wikipedia.org/wiki/Integral">integral</a> of a specified
 * {@see Function real function into reals} over some
 * {@see Interval real interval} using the
 * <a href="http://en.wikipedia.org/wiki/Trapezoidal_rule">trapezoidal rule</a>.
 * <br>This is also known as the
 * <a href="http://en.wikipedia.org/wiki/Newton%E2%80%93Cotes_formulas#Closed_Newton.E2.80.93Cotes_formulae">
 * closed Newton-Cotes formula of the first degree</a>.
 * @author Rune Dahl Iversen
 */
public class TrapezoidEvaluatorRealReal implements
        Evaluator<Function<Double, Double>, Interval<Double>, Double> {
    /**
     * Creates an instance of a trapezoid evaluator.
     */
    public TrapezoidEvaluatorRealReal() {
    }

    public Double value(final Function<Double, Double> function,
            final Interval<Double> interval) {
        return (function.value(interval.getLowerBound()) + function.value(interval.getUpperBound())) *
                (interval.getUpperBound()-interval.getLowerBound()) / 2.0;
    }
}