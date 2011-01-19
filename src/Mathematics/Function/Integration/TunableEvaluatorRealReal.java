/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Function.Integration;

import Mathematics.Function.*;
import Mathematics.Interval;

/**
 * {@see Evaluator Evaluates} the
 * <a href="http://en.wikipedia.org/wiki/Integral">integral</a> of a specified
 * {@see Function real function into reals} over some {@see Interval real interval} using
 * <a href="http://en.wikipedia.org/wiki/T-integration">tunable integration</a>.
 * @author Rune Dahl Iversen
 */
public final class TunableEvaluatorRealReal implements
        Evaluator<Function<Double, Double>, Interval<Double>, Double> {
    private double _gain;
    private double _phase;

    Validation.Validator<Double> _validator = Validation.Factory.FiniteReal();

    /**
     * Creates an instance of a tunable evaluator with the specified
     * gain and phase.
     * @param gain  The gain.
     * @param phase The phase.
     */
    public TunableEvaluatorRealReal(final double gain, final double phase) {
        this.setGain(gain);
        this.setPhase(phase);
    }

    /**
     * Gets the gain of this tunable evaluator.
     * @return The gain.
     */
    public double getGain() {
        return this._gain;
    }

    /**
     * Gets the phase of this tunable evaluator.
     * @return The phase.
     */
    public double getPhase() {
        return this._phase;
    }

    /**
     * Set the gain of this tunable evaluator.
     * @param gain The gain.
     */
    public void setGain(final double gain) {
        if (!this._validator.isValid(gain))
            throw new IllegalArgumentException(
                    this._validator.message(gain, "Gain"));
        this._gain = gain;
    }

    /**
     * Set the phase of this tunable evaluator.
     * @param phase The phase.
     */
    public void setPhase(final double phase) {
        if (!this._validator.isValid(phase))
            throw new IllegalArgumentException(
                    this._validator.message(phase, "Phase"));
        this._phase = phase;
    }

    @Override
    public Double value(final Function<Double, Double> function,
            final Interval<Double> interval) {
        return this._gain * (interval.getUpperBound()-interval.getLowerBound()) *
            (this._phase * function.value(interval.getLowerBound()) +
                (1.0-this._phase) * function.value(interval.getUpperBound()));
    }
}