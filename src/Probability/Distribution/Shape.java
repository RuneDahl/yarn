/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Probability.Distribution;

/**
 * Interface for a <a href="http://en.wikipedia.org/wiki/Probability_distribution">
 * distribution</a> with a shape parameter. Often the shape parameter is called
 * <a href="http://en.wikipedia.org/wiki/Degrees_of_freedom_%28statistics%29">
 * degrees of freedom</a>.
 * @author Rune Dahl Iversen
 * @param <TypeOfShape> Type of shape.
 * @param <TypeOfValue> Type of value.
 */
public interface Shape<TypeOfShape, TypeOfValue>
        extends Distribution<TypeOfValue> {
    /**
     * Gets the shape of this distribution.
     * @return Shape.
     */
    public TypeOfShape getShape();

    /**
     * Sets the shape of this distribution.
     * @param shape Shape.
     */
    public void setShape(final TypeOfShape shape);
}