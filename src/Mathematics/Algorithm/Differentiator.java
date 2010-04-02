/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Algorithm;

/**
 *
 * @author Rune Dahl Iversen
 * @param <TypeOfDifferentiator> Type of differentiator.
 */
public interface Differentiator<TypeOfDifferentiator> {
    public TypeOfDifferentiator getDifferentiator();

    public void setDifferentiator(final TypeOfDifferentiator differentiator);
}