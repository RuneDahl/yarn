/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Algorithm;

/**
 * Interface declaring an algorithm with a differentiatior as property.
 * @author Rune Dahl Iversen
 * @param <TypeOfDifferentiator> Type of differentiator.
 */
public interface Differentiator<TypeOfDifferentiator> {
    /**
     * Returns the differentiator.
     * @return The differentiator.
     */
    public TypeOfDifferentiator getDifferentiator();

    /**
     * Sets the differentiator to the specified value.
     * @param differentiator Differentiator.
     */
    public void setDifferentiator(final TypeOfDifferentiator differentiator);
}