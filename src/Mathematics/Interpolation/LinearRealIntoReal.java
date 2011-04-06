/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Interpolation;

import Mathematics.Interpolation.DataIdentification.IntervalFinderReal;
import Mathematics.Interpolation.Weighting.LinearReal;
import Mathematics.Interval;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Implementation of a strategy using
 * <a href="http://en.wikipedia.org/wiki/Linear_interpolation">linear</a>
 * {@see Interpolator interpolation} in {@see Double real} values.
 * @author Rune Dahl Iversen
 */
public final class LinearRealIntoReal extends
        Interpolator<Map<Double, Double>, Double, Double> {
    private static final LinearReal __weights = new LinearReal();
    private static final IntervalFinderReal __dataFinder =
            new IntervalFinderReal();

    /**
     * Creates an instance of a linear interpolator based on the specified data.
     * @param data Data.
     */
    public LinearRealIntoReal(final Map<Double, Double> data) {
        super(data);
    }

    @Override
    public Double value(final Double input) {
        Set<Double> keys = this.getData().keySet();
        if (keys.size() == 0)
            return Double.NaN;
        Interval<Double> n = __dataFinder.getNeighbors(input, keys);
        Map<Double, Double> w = __weights.getWeights(input, n);
        double value = 0.0;
        for (Entry<Double, Double> weight : w.entrySet())
            value += weight.getValue() * this.getData().get(weight.getKey());
        return value;
    }
}
