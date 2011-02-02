/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Random;

import Validation.*;

/**
 * An implementation of the <a href="http://en.wikipedia.org/wiki/Blum_Blum_Shub">
 * Blum Blum Shub</a> pseudo {@see Generator random number generator}.
 * @author Rune Dahl Iversen
 */
public final class BlumBlumShub implements Seed<Long, Long> {
    private long _seed;
    private long _p, _q;
    private long _filter;
    private final static Validator<Long> __intValidator = Factory.PositiveLong();
    private final static Validator<Long> __primeValidator = Factory.PrimeLong();

    /**
     * Creates an instance of the Blum Blum Shub pseudo random number generator
     * with the specified parameter values.
     * @param p      P.
     * @param q      Q.
     * @param filter Filter.
     * @param seed   Seed.
     */
    public BlumBlumShub(
            final long p,
            final long q,
            final long filter,
            final long seed) {
        this.setSeed(seed);
        this.setFilter(filter);
        this.setP(p);
        this.setQ(q);
    }

    /**
     * Gets the filter of this Blum Blum Shub random number generator.
     * @return Filter.
     */
    public long getFilter() {
        return this._filter;
    }

    /**
     * Gets the P value of this Blum Blum Shub random number generator.
     * @return P.
     */
    public long getP() {
        return this._p;
    }
    
    /**
     * Gets the Q value of this Blum Blum Shub random number generator.
     * @return Q.
     */
    public long getQ() {
        return this._q;
    }

    /**
     * Gets the seed of this Blum Blum Shub random number generator.
     * @return Seed.
     */
    public long getSeed() {
        return this._seed;
    }

    /**
     * Sets the filter of this Blum Blum Shub random number generator.
     * @param filter Filter.
     */
    public void setFilter(final long filter) {
        if (!__intValidator.isValid(filter))
            throw new IllegalArgumentException(
                    __intValidator.message(filter, "Filter"));
        this._filter = filter;
    }

    /**
     * Sets the P value of this Blum Blum Shub random number generator.
     * @param p P.
     */
    public void setP(final long p) {
        if (!__primeValidator.isValid(p))
            throw new IllegalArgumentException(
                    __primeValidator.message(p, "P"));
        this._p = p;
    }

    /**
     * Sets the Q value of this Blum Blum Shub random number generator.
     * @param q Q.
     */
    public void setQ(final long q) {
        if (!__primeValidator.isValid(q))
            throw new IllegalArgumentException(
                    __primeValidator.message(q, "Q"));
        this._q = q;
    }

    @Override
    public void setSeed(final Long seed) {
        if (!__intValidator.isValid(seed))
            throw new IllegalArgumentException(
                    __intValidator.message(seed, "Seed"));
        this._seed = seed;
    }

    @Override
    public Long getSample() {
        long product = this._getProduct();
        this._seed = (this._seed*this._seed) % product;
        return this._seed & this._filter;
    }

    @Override
    public Long[] getSample(int count) {
        Long[] samples = new Long[count];
        if (count > 0) {
            long product = this._getProduct();
            samples[0] = (this._seed*this._seed) % product;
            for (int i = 1; i < count; i++) {
                samples[i] = (samples[i-1]*samples[i-1]) % product;
                samples[i-1] = samples[i-1] & this._filter;
            }
            this._seed = samples[count-1];
            samples[count-1] = samples[count-1] & this._filter;
        }
        return samples;
    }

    private Long _getProduct() {
        if (this._p % 4 == this._q % 4)
            return this._p*this._q;
        else
            throw new IllegalStateException("The factors P and Q are not " +
                    "congruent modulo 4.");
    }
}