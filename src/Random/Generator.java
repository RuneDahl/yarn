/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Random;

/**
 * Interface for a
 * <a href="http://en.wikipedia.org/wiki/Pseudorandom_number_generator">
 * (pseudo)</a> <a href="http://en.wikipedia.org/wiki/Random_number_generation">
 * random generator</a>.
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of value.
 */
public interface Generator<TypeOfValue> {
    /**
     * Gets a single sample value.
     * @return Sample value.
     */
    public TypeOfValue getSample();

    /**
     * Gets an array of the specified number of sample values.
     * @param count Number of samples to get.
     * @return      Array with the sample values.
     */
    public TypeOfValue[] getSample(final int count);
}