/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Function;

import Validation.*;

/**
 * An implementation of the {@see Double real}
 * <a href="http://en.wikipedia.org/wiki/Gaussian_function">Gaussian function</a>.
 * <br> The formula is: scale * exp( -((x - center)^2 / (2 * spread^2))).
 * @author Rune Dahl Iversen
 */
public final class GaussianReal implements Function<Double, Double> {
    private double _center;
    private double _spread;
    private double _scale;
    private static final Validator<Double> __validator = Factory.FiniteReal();

    /**
     * Creates an instance of the GaussianReal function with the specified
     * center, spread and scale.
     * @param center The center.
     * @param spread The spread.
     * @param scale  The scale.
     */
    public GaussianReal(
            final double center,
            final double spread,
            final double scale) {
        this.setCenter(center);
        this.setSpread(spread);
        this.setScale(scale);
    }

    /**
     * Returns the center of this Gaussian function.
     * @return The center.
     */
    public double getCenter() {
        return _center;
    }

    /**
     * Returns the scale of this Gaussian function.
     * @return The scale.
     */
    public double getScale() {
        return _scale;
    }

    /**
     * Returns the spread of this Gaussian function.
     * @return The spread.
     */
    public double getSpread() {
        return _spread;
    }

    /**
     * Sets the center of this Gaussian function.
     * @param center Center.
     * @exception IllegalArgumentException Center is not valid.
     */
    public void setCenter(final double center) {
        if (!__validator.isValid(center))
            throw new IllegalArgumentException(
                    __validator.Message(center, "Center"));
        this._center = center;
    }

    /**
     * Sets the scaled of this Gaussian function.
     * @param scale Scale.
     * @exception IllegalArgumentException Scale is not valid.
     */
    public void setScale(final double scale) {
        if (!__validator.isValid(scale))
            throw new IllegalArgumentException(
                    __validator.Message(scale, "Scale"));
        this._scale = scale;
    }

    /**
     * Sets the spread of this Gaussian function.
     * @param spread Spread.
     * @exception IllegalArgumentException Spread is not valid.
     */
    public void setSpread(final double spread) {
        if (!__validator.isValid(spread))
            throw new IllegalArgumentException(
                    __validator.Message(spread, "Spread"));
        this._spread = spread;
    }

    @Override
    public Double value(final Double input) {
        return this._scale * Math.exp(
                -(input - this._center) * (input - this._center) /
                (2 * this._spread * this._spread));
    }
}