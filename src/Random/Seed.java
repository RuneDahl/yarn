/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Random;

/**
 * Interface for a {@see Generator random generator} based on a
 * <a href="http://en.wikipedia.org/wiki/Random_seed">seed</a>.
 * @author Rune Dahl Iversen
 * @param <TypeOfSeed>  Type of seed.
 * @param <TypeOfValue> Type of value.
 */
public interface Seed<TypeOfSeed, TypeOfValue>
        extends Generator<TypeOfValue> {
    /**
     * Set the seed of this random generator.
     * @param seed Seed.
     */
    public void setSeed(final TypeOfSeed seed);
}
