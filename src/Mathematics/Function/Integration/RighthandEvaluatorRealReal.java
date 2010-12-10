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
 * with the right-hand point for function evaluation.
 * @author Rune Dahl Iversen
 */
public class RighthandEvaluatorRealReal implements
        Evaluator<Function<Double, Double>, Interval<Double>, Double> {
    /**
     * Creates an instance of a right-hand evaluator.
     */
    public RighthandEvaluatorRealReal() { // Intentional
    }

    public Double value(final Function<Double, Double> function,
            final Interval<Double> interval) {
        return function.value(interval.getUpperBound()) *
                (interval.getUpperBound()-interval.getLowerBound());
    }
}