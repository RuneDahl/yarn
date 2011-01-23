/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Random;

import Validation.*;

/**
 * Implementation of a
 * <a href="http://en.wikipedia.org/wiki/Linear_congruential_generator">
 * linear congruential pseudo random number generator</a>.<br>
 * List of parameters in frequent use:
 * <a href="http://en.wikipedia.org/wiki/Linear_congruential_generator#Parameters_in_common_use">
 * Wikipedia</a>.
 * @author Rune Dahl Iversen
 */
public final class LinearCongruential implements Seed<Long, Long> {
    private long _increment;
    private long _modulus;
    private long _multiplier;
    private long _seed;
    private final static Validator<Long> __validator = Factory.NonNegativeLong();

    /**
     * Creates an instance of the linear congruential pseudo random number
     * generator with the specified modulus, multiplier, increment and seed.
     * @param modulus    Modulus.
     * @param multiplier Multiplier.
     * @param increment  Increment.
     * @param seed       Seed.
     */
    public LinearCongruential(
            final long modulus,
            final long multiplier,
            final long increment,
            final long seed) {
        this.setIncrement(increment);
        this.setModulus(modulus);
        this.setMultiplier(multiplier);
        this.setSeed(seed);
    }

    /**
     * Gets the increment of this linear congruential pseudo random number generator.
     * @return Increment.
     */
    public long getIncrement() {
        return this._increment;
    }

    /**
     * Gets the modulus of this linear congruential pseudo random number generator.
     * @return Modulus.
     */
    public long getModulus() {
        return this._modulus;
    }

    /**
     * Gets the multiplier of this linear congruential pseudo random number generator.
     * @return Multiplier.
     */
    public long getMultiplier() {
        return this._multiplier;
    }

    /**
     * Gets the seed of this linear congruential pseudo random number generator.
     * @return Seed.
     */
    public long getSeed() {
        return this._seed;
    }

    /**
     * Sets the increment of this linear congruential pseudo random number generator.
     * @param increment Increment.
     */
    public void setIncrement(final long increment) {
        if (!__validator.isValid(increment))
            throw new IllegalArgumentException(
                    __validator.message(increment, "Increment"));
        this._increment = increment;
    }

    /**
     * Sets the modulus of this linear congruential pseudo random number generator.
     * @param modulus Modulus.
     */
    public void setModulus(final long modulus) {
        if (!__validator.isValid(modulus))
            throw new IllegalArgumentException(
                    __validator.message(modulus, "Modulus"));
        this._modulus = modulus;
    }

    /**
     * Sets the multiplier of this linear congruential pseudo random number generator.
     * @param multiplier Multiplier.
     */
    public void setMultiplier(final long multiplier) {
        if (!__validator.isValid(multiplier))
            throw new IllegalArgumentException(
                    __validator.message(multiplier, "Multiplier"));
        this._multiplier = multiplier;
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
        this._seed = (this._multiplier*this._seed + this._increment) %
                this._modulus;
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