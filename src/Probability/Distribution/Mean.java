/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Probability.Distribution;

/**
 * Interface for a {@see Distribution probability distribution} with a well-defined
 * <a href="http://en.wikipedia.org/wiki/Expected_value">mean</a> value.
 * @author Rune Dahl Iversen
 * @param <TypeOfMean>  Type of mean.
 * @param <TypeOfValue> Type of value.
 */
public interface Mean<TypeOfMean, TypeOfValue>
        extends Distribution<TypeOfValue> {
    /**
     * Gets the mean of this distribution.
     * @return Mean.
     */
    public TypeOfMean getMean();
}
