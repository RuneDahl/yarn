/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Probability.Distribution;

/**
 * Interface declaring a <a href="http://en.wikipedia.org/wiki/Lower_bound">
 * lower bound</a> for the <a href="http://en.wikipedia.org/wiki/Support_%28mathematics%29">
 * support</a> of a distribution.
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of value.
 */
public interface LowerBound<TypeOfValue> extends Distribution<TypeOfValue> {
    /**
     * Gets the lower bound from the support of this distribution.
     * @return Lower bound.
     */
    public TypeOfValue getLowerBound();
}
