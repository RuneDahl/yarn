/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Interpolation.Weighting;

import Mathematics.Interval;
import java.util.Map;

/**
 * Computes the weigths to apply to the values of an interval
 * to attain the <a href="http://en.wikipedia.org/wiki/Sine">sinoid</a>
 * {@see Mathematics.Interpolation.Interpolator interpolation} of the target value.
 * @author Rune Dahl Iversen
 */
public class SinoidReal implements RealIntervalWeights {
    private static final LinearReal __linear = new LinearReal();

    @Override
    public Map<Double, Double> getWeights(final double target,
            final Interval<Double> interval) {
        Map<Double, Double> weights = __linear.getWeights(target, interval);
        double before = interval.getLowerBound();
        double after = interval.getUpperBound();
        double weightBefore = (Math.cos(weights.get(after)*Math.PI) + 1.0) / 2.0;
        weights.put(before, weightBefore);
        weights.put(after, 1.0 - weightBefore);
        return weights;
    }
}
