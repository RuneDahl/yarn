/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Probability.Distribution;

/**
 * Interface for a {@see Distribution probability distribution} with a
 * <a href="http://en.wikipedia.org/wiki/Cumulative_distribution_function">
 * cumulative distribution function</a>.
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of value.
 */
public interface DistributionFunction<TypeOfValue>
        extends Distribution<TypeOfValue> {
    /**
     * Returns the value of the cumulative distribution function
     * of this distribution at the specified value.
     * @param value Value.
     * @return      Cumulative distribution function.
     */
    public double distributionFunction(final TypeOfValue value);
}