/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Probability.Distribution;

/**
 * Interface for <a href="http://en.wikipedia.org/wiki/Probability_distribution">
 * distribution</a> with a
 * <a href="http://en.wikipedia.org/wiki/Scale_parameter">scale</a> parameter.
 * @author Rune Dahl Iversen
 * @param <TypeOfScale> Type of scale.
 * @param <TypeOfValue> Type of value.
 */
public interface Scale<TypeOfScale, TypeOfValue>
        extends Distribution<TypeOfValue> {
    /**
     * Gets the scale of this distribution.
     * @return Scale.
     */
    public TypeOfScale getScale();

    /**
     * Sets the scale of this distribution.
     * @param scale Scale.
     */
    public void setScale(final TypeOfScale scale);
}