/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Random;

import Validation.*;

/**
 * Implementation of a
 * <a href="http://en.wikipedia.org/wiki/Inversive_congruential_generator">
 * inversive congruential</a> pseudo {@see Generator random number generator}.
 * @author Rune Dahl Iversen
 */
public final class InversiveCongruential
        implements Seed<Long, Long>, Normalization<Long, Double> {
    private final static Validator<Long> __validator =
            Factory.NonNegativeLong();
    private final static Validator<Long> __powerValidator =
            Factory.PositiveLong();
    private long _increment;
    private long _modulus;
    private long _multiplier;
    private long _power;
    private long _seed;

    /**
     * Creates an instance of the inversive congruential pseudo random number
     * generator with the specified increment, modulus, multiplier, power and seed.
     * @param increment  Increment.
     * @param modulus    Modulus.
     * @param multiplier Multiplier.
     * @param power      Power.
     * @param seed       Seed.
     */
    public InversiveCongruential(
            final long increment,
            final long modulus,
            final long multiplier,
            final long power,
            final long seed) {
        this.setIncrement(increment);
        this.setModulus(modulus);
        this.setMultiplier(multiplier);
        this.setPower(power);
        this.setSeed(seed);
    }

    @Override
    public Double getFactor() {
        return (double)this._modulus;
    }

    /**
     * Gets the increment of this inversive congruential pseudo random number generator.
     * @return Increment.
     */
    public long getIncrement() {
        return this._increment;
    }

    /**
     * Gets the modulus of this inversive congruential pseudo random number generator.
     * @return Modulus.
     */
    public long getModulus() {
        return this._modulus;
    }

    /**
     * Gets the multiplier of this inversive congruential pseudo random number generator.
     * @return Multiplier.
     */
    public long getMultiplier() {
        return this._multiplier;
    }

    /**
     * Gets the power of this inversive congruential pseudo random number generator.
     * @return Power.
     */
    public long getPower() {
        return this._power;
    }

    /**
     * Gets the seed of this inversive congruential pseudo random number generator.
     * @return Seed.
     */
    public Long getSeed() {
        return this._seed;
    }

    /**
     * Sets the increment of this inversive congruential pseudo random number generator.
     * @param increment Increment.
     */
    public void setIncrement(final long increment) {
        if (!__validator.isValid(increment))
            throw new IllegalArgumentException(
                    __validator.message(increment, "Increment"));
        this._increment = increment;
    }

    /**
     * Sets the modulus of this inversive congruential pseudo random number generator.
     * @param modulus Modulus.
     */
    public void setModulus(final long modulus) {
        if (!__validator.isValid(modulus))
            throw new IllegalArgumentException(
                    __validator.message(modulus, "Modulus"));
        this._modulus = modulus;
    }

    /**
     * Sets the multiplier of this inversive congruential pseudo random number generator.
     * @param multiplier Multiplier.
     */
    public void setMultiplier(final long multiplier) {
        if (!__validator.isValid(multiplier))
            throw new IllegalArgumentException(
                    __validator.message(multiplier, "Multiplier"));
        this._multiplier = multiplier;
    }

    /**
     * Sets the power of this inversive congruential pseudo random number generator.
     * @param power Power.
     */
    public void setPower(final long power) {
        if (!__powerValidator.isValid(power))
            throw new IllegalArgumentException(
                    __powerValidator.message(power, "Power"));
        this._power = power;
    }

    @Override
    public void setSeed(final Long seed) {
        if (!__validator.isValid(seed))
            throw new IllegalArgumentException(
                    __validator.message(seed, "Seed"));
        this._seed = seed;
    }

    @Override
    public Long getSample() {
        if (this._seed == 0)
            this._seed = this._increment;
        else
            this._seed = (long)((this._multiplier*Math.pow(this._seed, -this._power) +
                    this._increment) % this._modulus);
        return this._seed;
    }

    @Override
    public Long[] getSample(final int count) {
        Long[] simulations = new Long[count];
        for (int i = 0; i < count; i++) {
            simulations[i] = this.getSample();
        }
        return simulations;
    }
}