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
 * <a href="http://en.wikipedia.org/wiki/Rectangle_method">rectangle method</a>
 * with the mid point for function evaluation.<br>
 * This is also known as the
 * <a href="http://en.wikipedia.org/wiki/Newton%E2%80%93Cotes_formulas#Open_Newton.E2.80.93Cotes_formulae">
 * open Newton-Cotes formula of the second degree</a>.
 * @author Rune Dahl Iversen
 */
public class MidPointEvaluatorRealReal implements
        Evaluator<Function<Double, Double>, Interval<Double>, Double> {
    /**
     * Creates an instance of a mid point evaluator.
     */
    public MidPointEvaluatorRealReal() {
    }

    public Double value(final Function<Double, Double> function,
            final Interval<Double> interval) {
        return function.value(this._MidPoint(interval)) *
                (interval.getUpperBound()-interval.getLowerBound());
    }

    private double _MidPoint(final Interval<Double> interval) {
        return (interval.getLowerBound() + interval.getUpperBound()) / 2.0;
    }
}