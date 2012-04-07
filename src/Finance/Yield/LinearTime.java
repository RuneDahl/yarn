/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Finance.Yield;

/**
 * An implementation of a {@see Convention yield covention} using
 * <a href="http://en.wikipedia.org/wiki/Interest#Simple_interest">linear
 * interest</a>.
 * Linear interest is also known as "simple interest".
 * @author Rune Dahl Iversen
 */
public final class LinearTime implements Convention<Double, Double> {
    /**
     * Creates an instance of the linear yield convention.
     */
    public LinearTime() { }
    
    @Override
    public double discountFactor(final Double start, final Double end,
            final double yield) {
        return 1.0 / (1.0 + yield*(end-start));
    }

    @Override
    public String getName() {
        return "Linear";
    }

    @Override
    public Double time(final double discountFactor, final double yield) {
        return (1.0-discountFactor) / (discountFactor*yield);
    }

    @Override
    public double yield(final double discountFactor,
            final Double start, final Double end) {
        return (1.0-discountFactor) / (discountFactor*(end-start));
    }
}
