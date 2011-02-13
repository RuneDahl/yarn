/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Random;

/**
 * Implementation of the basic form
 * <a href="http://en.wikipedia.org/wiki/Box%E2%80%93Muller_transform">
 * Box-Muller</a> {@see Generator generator} of pseudo random unit
 * {@see Probability.Distribution.GaussianReal Gaussian/normal} samples.<br>
 * This implementation makes use of a generator that must generate
 * {@see Double real} samples in the unit {@see Mathematics.Interval interval}.
 * @author Rune Dahl Iversen
 */
public final class BoxMullerBasic extends GeneratorBased<Generator<Double>, Double> {
    private double _cache = Double.NaN;

    /**
     * Creates an instance of the basic form Box-Muller
     * generator using the specified generator.
     * @param generator Generator.
     */
    public BoxMullerBasic(final Generator<Double> generator) {
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
            double u1 = this.getGenerator().getSample();
            while (u1 <= 0.0) // Prevent exceptions when computing the natural logarithm.
                u1 = this.getGenerator().getSample();
            u1 = Math.sqrt(-2*Math.log(u1));
            double u2 = this.getGenerator().getSample()*2*Math.PI;
            sample = u1 * Math.cos(u2);
            this._cache = u1 * Math.sin(u2);
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
