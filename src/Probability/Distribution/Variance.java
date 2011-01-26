/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Probability.Distribution;

/**
 * Interface for a <a href="http://en.wikipedia.org/wiki/Probability_distribution">
 * distribution</a> with a well-defined
 * <a href="http://en.wikipedia.org/wiki/Variance">variance</a>.
 * This implies that there is also a well-defined
 * <a href="http://en.wikipedia.org/wiki/Deviation_%28statistics%29">deviance</a>.
 * @author Rune Dahl Iversen
 * @param <TypeOfVariance> Type of variance.
 * @param <TypeOfValue>    Type of value.
 */
public interface Variance<TypeOfVariance, TypeOfValue>
        extends Distribution<TypeOfValue> {
    /**
     * Gets the deviance of this distribution.
     * @return Deviance.
     */
    public TypeOfVariance getDeviance();

    /**
     * Gets the variance of this distribution.
     * @return Variance.
     */
    public TypeOfVariance getVariance();
}