/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Interpolation.Weighting;

import Mathematics.Interval;
import java.util.*;

/**
 * Computes the weigths to apply to the values of an interval
 * to attain the <a href="http://en.wikipedia.org/wiki/Linear_interpolation">linear</a>
 * {@see Mathematics.Interpolation.Interpolator interpolation} of the target value.
 * @author Rune Dahl Iversen
 */
public final class LinearReal implements RealIntervalWeights {
    private static final Validation.Validator<Double> __validator =
            Validation.Factory.FiniteReal();

    @Override
    public Map<Double, Double> getWeights(final double target,
            final Interval<Double> interval) {
        if (interval == null)
            throw new NullPointerException("Interval not properly specified.");
        if (!__validator.isValid(target))
            throw new IllegalArgumentException(
                    __validator.message(target, "Target"));
        Map<Double, Double> weights = new HashMap<Double, Double>(2);
        double before = interval.getLowerBound();
        double after = interval.getUpperBound();
        if (after < before)
            throw new ArithmeticException("Wrong ordering of the bounds " +
                    "specifying the interval.");
        else if (before == after) {
            weights.put(before, 1.0);
        }
        else {
            weights.put(before, (after-target) / (after-before));
            weights.put(after, (target-before) / (after-before));
        }
        return weights;
    }
}
