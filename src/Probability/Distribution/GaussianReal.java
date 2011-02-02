/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Probability.Distribution;

import Validation.*;

/**
 * Implementation of the
 * <a href="http://en.wikipedia.org/wiki/Normal_distribution">normal (Gaussian)
 * distribution</a> on {@see Double real} numbers.
 * @author Rune Dahl Iversen
 */
public final class GaussianReal implements Mean<Double, Double>, Location<Double>,
        Scale<Double, Double>, Variance<Double, Double> {
    private final Mathematics.Function.GaussianReal _gaussian;
    private double _mean;
    private double _deviance;
    private static Validator<Double> __meanValidator =
            Factory.FiniteReal();
    private static Validator<Double> __devianceValidator =
            Factory.FiniteRealGreaterThan(0.0);

    /**
     * Create a new normal (Gaussian) distribution on the real numbers
     * with the specified mean and deviation.
     * @param mean     Mean.
     * @param deviance Deviation.
     */
    public GaussianReal(double mean, double deviance) {
        this._gaussian = new Mathematics.Function.GaussianReal(
                0.0, 1.0, 1.0/Math.sqrt(2.0*Math.PI));
        this.setLocation(mean);
        this.setScale(deviance);
    }

    @Override
    public Double getDeviance() {
        return this._deviance;
    }

    @Override
    public Double getLocation() {
        return this._mean;
    }

    @Override
    public Double getMean() {
        return this._mean;
    }

    @Override
    public Double getScale() {
        return this._deviance;
    }

    @Override
    public Double getVariance() {
        return this._deviance * this._deviance;
    }

    @Override
    public void setLocation(final Double location) {
        if (!__meanValidator.isValid(location))
            throw new IllegalArgumentException(
                    __meanValidator.message(location, "Location"));
        this._mean = location;
    }

    @Override
    public void setScale(final Double scale) {
        if (!__devianceValidator.isValid(scale))
            throw new IllegalArgumentException(
                    __devianceValidator.message(scale, "Scale"));
        this._deviance = scale;
    }

    @Override
    public double density(final Double value) {
        double v = (value - this._mean)/this._deviance;
        return this._gaussian.value(v)/this._deviance;
    }
}