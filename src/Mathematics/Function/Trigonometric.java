/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Function;

import Validation.Validator;

/**
 * Abstract class containing the values
 * <a href="http://en.wikipedia.org/wiki/Amplitude">Amplitude</a>,
 * <a href="http://en.wikipedia.org/wiki/Frequency">Frequency</a>,
 * and <a href="http://en.wikipedia.org/wiki/Phase_%28waves%29">Phase</a>.<br>
 * These values are commonly used in
 * <a href="http://en.wikipedia.org/wiki/Trignometry">Trigonometric</a>
 * {@see Function functions}.
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of value.
 */
public abstract class Trigonometric<TypeOfValue> {
    private TypeOfValue _amplitude;
    private TypeOfValue _frequency;
    private TypeOfValue _phase;
    private Validation.Validator<TypeOfValue> _validation;

    /**
     * Creates a new instance of a trigonometric function with the
     * specified validation, amplitude, frequency and phase.
     * @param validation Validation.
     * @param amplitude  Amplitude.
     * @param frequency  Frequency.
     * @param phase      Phase.
     */
    protected Trigonometric(
            final Validation.Validator<TypeOfValue> validation,
            final TypeOfValue amplitude,
            final TypeOfValue frequency,
            final TypeOfValue phase) {
        this._validation = validation;
        this.setAmplitude(amplitude);
        this.setFrequency(frequency);
        this.setPhase(phase);
    }

    /**
     * Gets the amplitude.
     * @return The amplitude.
     */
    public final TypeOfValue getAmplitude() {
        return _amplitude;
    }

    /**
     * Sets the amplitude.
     * @param amplitude The amplitude.
     */
    public final void setAmplitude(final TypeOfValue amplitude) {
        if (!this._validation.isValid(amplitude))
            throw new IllegalArgumentException(
                    this._validation.Message(amplitude, "Amplitude"));
        this._amplitude = amplitude;
    }

    /**
     * Gets the frequency.
     * @return The frequency.
     */
    public final TypeOfValue getFrequency() {
        return _frequency;
    }

    /**
     * Sets the frequency.
     * @param frequency The frequency.
     */
    public final void setFrequency(final TypeOfValue frequency) {
        if (!this._validation.isValid(frequency))
            throw new IllegalArgumentException(
                    this._validation.Message(frequency, "Frequency"));
        this._frequency = frequency;
    }

    /**
     * Gets the phase.
     * @return The phase.
     */
    public final TypeOfValue getPhase() {
        return _phase;
    }

    /**
     * Sets the phase.
     * @param phase The phase.
     */
    public final void setPhase(final TypeOfValue phase) {
        if (!this._validation.isValid(phase))
            throw new IllegalArgumentException(
                    this._validation.Message(phase, "Phase"));
        this._phase = phase;
    }
}