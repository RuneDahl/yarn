/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Probability.Distribution;

/**
 * Interface declaring a < a href="http://en.wikipedia.org/wiki/Lower_bound">
 * lower bound</a> for a distribution.
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of value.
 */
public interface LowerBound<TypeOfValue> extends Distribution<TypeOfValue> {
    /**
     * Gets the lower bound of this distribution.
     * @return Lower bound.
     */
    public TypeOfValue getLowerBound();
}
