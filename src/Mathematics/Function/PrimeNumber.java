/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Function;

import java.util.HashMap;
import java.util.Map.Entry;

/**
 * A {@see Function function} to determine if a specified
 * <a href="http://en.wikipedia.org/wiki/Natural_number">natural number</a>
 * is a <a href="http://en.wikipedia.org/wiki/Prime_number">prime number</a>.
 * <br>Any number outside the natural numbers cannot be considered prime.
 * @author Rune Dahl Iversen
 */
public final class PrimeNumber implements Function<Long, Boolean> {
    private final HashMap<Long, Long> _primes;

    /**
     * Creates an instance of this prime number function.
     */
    public PrimeNumber() {
        // Initializes the cache with the first few prime numbers.
        // See Wikipedia article on Prime Numbers to verify:
        // <<< http://en.wikipedia.org/wiki/Prime_number >>>
        this._primes = new HashMap<Long, Long>();
        this._primes.put(1L, 2L);
        this._primes.put(2L, 3L);
        this._primes.put(3L, 5L);
        this._primes.put(4L, 7L);
        this._primes.put(5L, 11L);
        this._primes.put(6L, 13L);
        this._primes.put(7L, 17L);
        this._primes.put(8L, 19L);
        this._primes.put(9L, 23L);
        this._primes.put(10L, 29L);
        this._primes.put(11L, 31L);
        this._primes.put(12L, 37L);
    }

    @Override
    public Boolean value(final Long input) {
        if (input < this._primes.get(1L))
            return false;
        long largestKnownPrime = this._primes.size();
        largestKnownPrime = this._primes.get(largestKnownPrime);
        if (largestKnownPrime <= input) {
            for (long pc = largestKnownPrime + 2; pc <= input + 1; pc += 2) {
                boolean isPrime = true;
                for (Entry<Long, Long> p: this._primes.entrySet()) {
                    isPrime &= pc % p.getValue() != 0;
                    if (!isPrime)
                        break;
                }
                if (isPrime)
                    this._primes.put(this._primes.size() + 1L, pc);
            }
        }
        return this._primes.containsValue(input);
    }
}