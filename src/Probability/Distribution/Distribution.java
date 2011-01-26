/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Probability.Distribution;

/**
 * Interface for a <a href="http://en.wikipedia.org/wiki/Probability_distribution">
 * probability distribution</a>. It is assumed that any probability distribution
 * have a <a href="http://en.wikipedia.org/wiki/Probability_density_function">
 * density</a> relative to some relevant
 * <a href="http://en.wikipedia.org/wiki/Measure_%28mathematics%29">measure</a>.
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of value.
 */
public interface Distribution<TypeOfValue> {
    /**
     * Returns the value of the probability density
     * of this distribution at the specified value.
     * @param value Value.
     * @return      Probability density.
     */
    public double density(final TypeOfValue value);
}