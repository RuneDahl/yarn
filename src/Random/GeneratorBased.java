/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Random;

/**
 * Abstract implementation of a {@see Generator generator} using another generator.
 * @author Rune Dahl Iversen
 * @param <TypeOfGenerator> Type of generator.
 * @param <TypeOfSample> Type of output from this generator.
 */
public abstract class GeneratorBased<TypeOfGenerator, TypeOfSample>
        implements Generator<TypeOfSample> {
    private TypeOfGenerator _generator;

    protected GeneratorBased(final TypeOfGenerator generator) {
        this.setGenerator(generator);
    }

    /**
     * Gets the {@see Generator generator} of this transformation.
     * @return Transformation.
     */
    public final TypeOfGenerator getGenerator() {
        return this._generator;
    }

    /**
     * Sets the {@see Generator generator} of this transformation.
     * @param generator Generator.
     * @throws NullPointerException Generator not properly specified.
     */
    public final void setGenerator(final TypeOfGenerator generator) {
        if (generator == null)
            throw new NullPointerException("Generator not properly specified.");
        this._generator = generator;
    }
}
