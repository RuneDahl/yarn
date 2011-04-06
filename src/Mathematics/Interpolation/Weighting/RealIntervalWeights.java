/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Interpolation.Weighting;

import Mathematics.Interval;
import java.util.Map;

/**
 * Interface of a weight-computation strategy used in
 * {@see Mathematics.Interpolation.Interpolator interpolation},
 * when interpolating in {see Double real} numbers based on the
 * values from an {@see Interval interval}.
 * @author Rune Dahl Iversen
 */
public interface RealIntervalWeights {
    /**
     * Returns a collection of values from the specified interval
     * and their respective weights to approximate the target value.
     * @param target   Target value.
     * @param interval Interval.
     * @return         Collection of values and their respective weights.
     */
    public Map<Double, Double> getWeights(final double target,
            final Interval<Double> interval);
}
