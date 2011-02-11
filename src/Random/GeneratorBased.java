/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Random;

/**
 * Abstract implementation of a {@see Generator generator} using another generator.
 * @author Rune Dahl Iversen
 * @param <TypeOfSample> Type of sample from the internal generator.
 * @param <TypeOfOutput> Type of output from this generator.
 */
public abstract class GeneratorBased<TypeOfSample, TypeOfOutput>
        implements Generator<TypeOfOutput> {
    private Generator<TypeOfSample> _generator;

    protected GeneratorBased(final Generator<TypeOfSample> generator) {
        this.setGenerator(generator);
    }

    /**
     * Gets the {@see Generator generator} of this transformation.
     * @return Transformation.
     */
    public final Generator<TypeOfSample> getGenerator() {
        return this._generator;
    }

    /**
     * Sets the {@see Generator generator} of this transformation.
     * @param generator Generator.
     * @throws NullPointerException Generator not properly specified.
     */
    public final void setGenerator(final Generator<TypeOfSample> generator) {
        if (generator == null)
            throw new NullPointerException("Generator not properly specified.");
        this._generator = generator;
    }
}
