/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Random;

/**
 * Implementation of the polar form
 * <a href="http://en.wikipedia.org/wiki/Box%E2%80%93Muller_transform">
 * Box-Muller</a> {@see Generator generator} of pseudo random unit
 * {@see Probability.Distribution.GaussianReal Gaussian/normal} samples.<br>
 * This implementation makes use of a generator that must generate
 * {@see Double real} samples in the unit {@see Mathematics.Interval interval}.
 * @author Rune Dahl Iversen
 */
public final class BoxMullerPolar extends GeneratorBased<Generator<Double>, Double> {
    private double _cache = Double.NaN;

    /**
     * Creates an instance of the polar form Box-Muller
     * generator using the specified generator.
     * @param generator Generator.
     */
    public BoxMullerPolar(final Generator<Double> generator) {
        super(generator);
    }

    @Override
    public Double getSample() {
        double sample;
        if (!Double.isNaN(this._cache)) {
            sample = this._cache;
            this._cache = Double.NaN;
        }
        else {
            double u1 = 0.0;
            double u2 = 0.0;
            double s = 0.0;
            while (s <= 0.0 || 1.0 < s) {
                u1 = this.getGenerator().getSample()*2.0 - 1.0;
                u2 = this.getGenerator().getSample()*2.0 - 1.0;
                s = u1*u1 + u2*u2;
            }
            s = Math.sqrt(-2*Math.log(s)/s);
            sample = u1 * s;
            this._cache = u2 * s;
        }
        return sample;
    }

    @Override
    public Double[] getSample(final int count) {
        Double[] samples = new Double[count];
        for (int index = 0; index < count; index++)
            samples[index] = this.getSample();
        return samples;
    }
}
