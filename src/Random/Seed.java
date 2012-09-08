/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Random;

/**
 * Interface for a {@see Generator random generator} based on a
 * <a href="http://en.wikipedia.org/wiki/Random_seed">seed</a>.
 * <br>The idea is that the user can specify the state of this
 * random generator by calling the method setSeed. <br>Seeds in
 * random generators are often specified as
 * <a href="http://en.wikipedia.org/wiki/Integer">integer numbers</a>
 * but this interface allows different specifications.
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
