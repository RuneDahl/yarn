/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Finance.Yield;

import Validation.*;

/**
 * Abstract implementation of a {@see Convention yield convention} that uses an
 * attached frequency in the calculations.
 * @author Rune Dahl Iversen
 * @param <TypeOfTime>           Type of time.
 * @param <TypeOfTimeDifference> Type of difference in time.
 */
public abstract class HasCompoundingFrequency<TypeOfTime, TypeOfTimeDifference>
        implements Convention<TypeOfTime, TypeOfTimeDifference> {
    private static Validator<Double> __validator = 
            Factory.FiniteRealGreaterThan(0.0);
    private double _frequency;

    /**
     * Creates a yield convention with the specified compounding frequency.
     * @param frequency The compounding frequency.
     */
    protected HasCompoundingFrequency(final double frequency) {
        this.setFrequency(frequency);
    }
    
    /**
     * Gets the compounding frequency of this yield convention.
     * @return The compounding frequency.
     */
    public final double getFrequency() {
        return this._frequency;
    }
    
    /**
     * Sets the compounding frequency of this yield convention.
     * @param frequency The compounding frequency.
     */
    public final void setFrequency(final double frequency) {
        if (!__validator.isValid(frequency))
            throw new IllegalArgumentException(
                    __validator.message(frequency, "Frequency"));
        this._frequency = frequency;
    }
}
