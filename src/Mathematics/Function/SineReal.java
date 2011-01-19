/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Function;

/**
 * An implementation of the {@see Trigonometric trigonometric}
 * {@see Function function} <a href="http://en.wikipedia.org/wiki/Sine">Sine</a>
 * of {@see Double real} values.
 * @author Rune Dahl Iversen
 */
public final class SineReal
        extends Trigonometric<Double>
        implements Function<Double, Double> {

    /**
     * Creates an instance of the function Sine for real values with
     * default values for amplitude (1.0), frequency (1.0) and phase (0.0).
     */
    public SineReal() {
        this(1.0, 1.0, 0.0);
    }

    /**
     * Creates an instance of the function Sine for real values
     * with the specified amplitude, frequency and phase.
     * @param amplitude Amplitude.
     * @param frequency Frequency.
     * @param phase     Phase.
     */
    public SineReal(final double amplitude, final double frequency, final double phase) {
        super(Validation.Factory.FiniteReal(), amplitude, frequency, phase);
    }

    @Override
    public Double value(final Double input) {
        return this.getAmplitude() *
                Math.sin(input*this.getFrequency() + this.getPhase());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SineReal) {
            return this._equals((SineReal)obj);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this._hashCode();
    }

    @Override
    public String toString() {
        return this._toString();
    }
}