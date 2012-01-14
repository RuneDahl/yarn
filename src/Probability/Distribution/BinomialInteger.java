/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Probability.Distribution;

import Validation.*;
import java.util.LinkedHashMap;

/**
 * Implementation of the
 * <a href="http://en.wikipedia.org/wiki/Binomial_distribution">binomial</a>
 * {@see Distribution distribution} on {@see Integer integer} values.
 * @author Rune Dahl Iversen
 */
public final class BinomialInteger
        implements DiscreteDensityFactor<Integer>, DistributionFunction<Integer>,
        LowerBound<Integer>, UpperBound<Integer>, Mean<Double, Integer>,
        MomentOfAnyOrder<Double, Integer>, QuantileFunction<Integer>,
        Variance<Double, Integer> {
    private int _upperBound;
    private double _p;
    private LinkedHashMap<Integer, Double> _densities =
            new LinkedHashMap<Integer, Double>();
    private LinkedHashMap<Integer, Double> _distributionFunction =
            new LinkedHashMap<Integer, Double>();
    private static final Validator<Double> __pValidator =
            Factory.BoundedReal(0.0, 1.0);
    private static final Validator<Integer> __boundValidator =
            Factory.PositiveInteger();

    /**
     * Create an instance of the binomial distribution on integer values
     * with the specified upper bound and probability of success.
     * @param upperBound Upper bound.
     * @param p          Probability of success in each separate trial.
     */
    public BinomialInteger(final Integer upperBound, final double p) {
        this.setUpperBound(upperBound);
        this.setP(p);
    }

    @Override
    public Double getCentralMoment(final int order) {
        if (order < 1)
            throw new IllegalArgumentException(
                    "Order must be a positive integer value.");
        double moment = 0.0;
        double mean = this.getMean();
        for (int value = 0; value <= this._upperBound; value++)
            moment += this.density(value) * Math.pow(value - mean, order);
        return moment;
    }

    @Override
    public Double getDeviance() {
        return Math.sqrt(this.getVariance());
    }

    @Override
    public Integer getLowerBound() {
        return 0;
    }

    @Override
    public Double getMean() {
        return this._upperBound * this._p;
    }

    @Override
    public Double getMoment(final int order) {
        if (order < 1)
            throw new IllegalArgumentException(
                    "Order must be a positive integer value.");
        double moment = 0.0;
        for (int value = 0; value <= this._upperBound; value++)
            moment += this.density(value) * Math.pow(value, order);
        return moment;
    }

    /**
     * Gets the probability of success in each separate trial.
     * @return The probability of success in each separate trial.
     */
    public double getP() {
        return this._p;
    }

    /**
     * Sets the probability of success in each separate trial.
     * @param p Probability of success in each separate trial.
     */
    public void setP(final double p) {
        if (!__pValidator.isValid(p))
            throw new IllegalArgumentException(__pValidator.message(p, "P"));
        this._p = p;
        this._densities.clear();
        this._distributionFunction.clear();
    }

    @Override
    public Double getVariance() {
        return this._upperBound * this._p * (1.0 - this._p);
    }

    @Override
    public Integer getUpperBound() {
        return this._upperBound;
    }

    /**
     * Sets the upper bound of this distribution to the specified value.
     * @param upperBound Upper bound.
     * @throws IllegalArgumentException Upper bound is not a finite
     *                                  positive integer value.
     */
    public void setUpperBound(final int upperBound) {
        if (!__boundValidator.isValid(upperBound))
            throw new IllegalArgumentException(
                    __boundValidator.message(upperBound, "Upper bound"));
        this._upperBound = upperBound;
        this._densities.clear();
        this._distributionFunction.clear();
    }

    @Override
    public double density(final Integer value) {
        if (!this._IsInsideSupport(value))
            return 0.0;
        else if (this._densities.containsKey(value))
            return this._densities.get(value);
        else {
            int start = this._densities.size() - 1;
            double d = this.densityFactor(0);
            if (start == -1) {
                start++;
                this._densities.put(start, d);
            }
            else
                d = this._densities.get(start);
            for (int i = start+1; i <= value; i++) {
                d *= this.densityFactor(i);
                this._densities.put(i, d);
            }
            return d;
        }
    }

    @Override
    public double densityFactor(final Integer value) {
        if (!this._IsInsideSupport(value))
            return 0.0;
        else if (value == 0)
            return Math.pow(1.0-this._p, this._upperBound);
        else
            return ((this._upperBound+1-value)*this._p) / (value*(1.0-this._p));
    }

    @Override
    public double distributionFunction(final Integer value) {
        if (value < 0)
            return 0.0;
        else if (this._upperBound < value)
            return 1.0;
        else if (this._distributionFunction.containsKey(value))
            return this._distributionFunction.get(value);
        else {
            int start = this._distributionFunction.size() - 1;
            double d = this.density(0);
            if (start == -1) {
                start++;
                this._distributionFunction.put(start, d);
            }
            else
                d = this._distributionFunction.get(start);
            for (int i = start+1; i <= value; i++) {
                d += this.density(i);
                d = this._TruncateDistributionFunctionValue(d);
                this._distributionFunction.put(i, d);
            }
            return d;
        }
    }

    @Override
    public Integer quantileFunction(final double value) {
        for (int q = 0; q <= this._upperBound; q++)
            if (value < this.distributionFunction(q))
                return q;
        return this._upperBound;
    }

    /**
     * Returns whether the specified integer value is within the
     * <a href="http://en.wikipedia.org/wiki/Support_%28mathematics%29">support</a>
     * of this binomial distribution.
     * @param value Value.
     * @return      True if the value is within the support, else false.
     */
    private boolean _IsInsideSupport(final Integer value) {
        return 0 <= value && value <= this._upperBound;
    }

    /**
     * Truncates a distribution function value to the interval 0.0 through 1.0.
     * Numerical issues (like rounding) can cause the computed value to be just
     * outside the unit interval.
     * @param value Distribution function value.
     * @return      Truncated distribution function value.
     */
    private double _TruncateDistributionFunctionValue(final double value) {
        if (value < 0.0)
            return 0.0;
        else if (1.0 < value)
            return 1.0;
        else
            return value;
    }
}
