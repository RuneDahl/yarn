/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Random;

/**
 * Implementation of a {@see Normalization normalizing} {@see Generator generator}
 * of {@see Double real} value samples from an {@see Long integer} value
 * samples generator.
 * @author Rune Dahl Iversen
 */
public final class NormalizerLongToReal extends GeneratorBased<Normalization<Long, Double>, Double> {

    /**
     * Creates an instance of this real value sample generator using the
     * specified normalizable integer values sample generator.
     * @param generator
     */
    public NormalizerLongToReal(Normalization<Long, Double> generator) {
        super(generator);
    }

    @Override
    public Double getSample() {
        return this.getGenerator().getSample() / this.getGenerator().getFactor();
    }

    @Override
    public Double[] getSample(int count) {
        Long[] s = this.getGenerator().getSample(count);
        Double[] samples = new Double[s.length];
        double factor = this.getGenerator().getFactor();
        for (int index = 0; index < s.length; index++)
            samples[index] = s[index] / factor;
        return samples;
    }
}
