/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Probability.Distribution;

/**
 * Interface declaring an <a href="http://en.wikipedia.org/wiki/Upper_bound">
 * upper bound</a> for the <a href="http://en.wikipedia.org/wiki/Support_%28mathematics%29">
 * support</a> of a distrbution.
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of value.
 */
public interface UpperBound<TypeOfValue> extends Distribution<TypeOfValue> {
    /**
     * Gets the upper bound from the support of this distribution.
     * @return Upper bound.
     */
    public TypeOfValue getUpperBound();
}
