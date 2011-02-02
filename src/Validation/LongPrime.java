/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Validation;

import Mathematics.Function.PrimeNumber;

/**
 * {@see Validator} allowing {@see Long longs} that are prime numbers.
 * @author Rune Dahl Iversen
 */
public final class LongPrime implements Validator<Long> {
    private final static PrimeNumber __isPrime = new PrimeNumber();

    /**
     * Create an instance of a long validation requiring a prime number.
     */
    public LongPrime() {
        super();
    }

    @Override
    public String message(final Long value, final String name) {
        if (this.isValid(value))
            return "";
        else
            return name + " must be prime.";
    }

    @Override
    public boolean isValid(final Long value) {
        return (value != null && __isPrime.value(value));
    }
}