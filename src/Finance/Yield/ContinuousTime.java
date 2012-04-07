/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Finance.Yield;

/**
 * Implementation of a {@see Convention yield convention} with
 * <a href="http://en.wikipedia.org/wiki/Compounding_of_interest#Continuous_compounding">
 * continuous compounding</a>. Continuously compounding is also referred to as
 * "exponential interest".
 * @author Rune Dahl Iversen
 */
public class ContinuousTime implements Convention<Double, Double> {
    /**
     * Creates a new instance of the continuously compounding yield convention.
     */
    public ContinuousTime() { }
    
    @Override
    public double discountFactor(final Double start, final Double end,
            final double yield) {
        return Math.exp(-yield * (end-start));
    }

    @Override
    public String getName() {
        return "Continuous";
    }

    @Override
    public Double time(final double discountFactor, final double yield) {
        return -Math.log(discountFactor) / yield;
    }

    @Override
    public double yield(final double discountFactor,
            final Double start, final Double end) {
        return -Math.log(discountFactor) / (end-start);
    }
}
