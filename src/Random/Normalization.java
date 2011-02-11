/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Random;

/**
 * Interface for a {@see Generator generator} that has a normalizing factor.<br>
 * The idea is that the samples of this generator can be divided by the factor
 * to them into samples in a unit interval.<br>
 * For {@see Double real} values think of the interval: [0.0 ; 1.0].
 * @author Rune Dahl Iversen
 * @param <TypeOfSample> Type of sample.
 * @param <TypeOfFactor> Type of factor.
 */
public interface Normalization<TypeOfSample, TypeOfFactor>
        extends Generator<TypeOfSample> {
    /**
     * Gets the normalizing factor of this generator.
     * @return Normalizing factor.
     */
    public TypeOfFactor getFactor();
}
