/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Probability.Distribution;

/**
 * Interface for a {@see Distribution distribution} that has a factorial
 * relationship between succesive density values.<br>
 * Implementing this interface requires an ordered
 * <a href="http://en.wikipedia.org/wiki/Discrete_probability_distribution">
 * discrete</a> distribution.
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of value.
 */
public interface DiscreteDensityFactor<TypeOfValue>
        extends Distribution<TypeOfValue> {
    /**
     * Returns the factor to multiply probility density of the previous value
     * with to obtain the probability density of the specified value.<br>
     * For the initial value of this relation the method returns the
     * probability density of the value.
     * @param value Value.
     * @return      Density factor.
     */
    double densityFactor(final TypeOfValue value);
}
