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
public class PrimeNumber implements Function<Integer, Boolean> {
    private HashMap<Integer, Integer> _primes;
    
    public PrimeNumber() {
        // Initializes the cache with the first few prime numbers.
        // See Wikipedia article on Prime Numbers to verify:
        // <<< http://en.wikipedia.org/wiki/Prime_number >>>
        this._primes = new HashMap<Integer, Integer>();
        this._primes.put(1, 2);
        this._primes.put(2, 3);
        this._primes.put(3, 5);
        this._primes.put(4, 7);
        this._primes.put(5, 11);
        this._primes.put(6, 13);
        this._primes.put(7, 17);
        this._primes.put(8, 19);
        this._primes.put(9, 23);
        this._primes.put(10, 29);
        this._primes.put(11, 31);
        this._primes.put(12, 37);
    }

    public Boolean value(final Integer input) {
        if (input <= 2)
            return false;
        int largestKnownPrime = this._primes.get(this._primes.size());
        if (largestKnownPrime <= Math.sqrt((double)input)) {
            for (int pc = largestKnownPrime + 2; pc <= input + 1; pc += 2) {
                boolean isPrime = true;
                for (Entry<Integer, Integer> p: this._primes.entrySet()) {
                    isPrime &= !this._isDivisible(pc, p.getValue());
                    if (!isPrime)
                        break;
                }
                if (isPrime)
                    this._primes.put(this._primes.size() + 1, pc);
            }
        }
        return this._primes.containsValue(input);
    }

    /**
     * Returns whether the
     * <a href="http://en.wikipedia.org/wiki/Divisor">suggested divisor</a>
     * is a factor of the value.
     * @param value   Value.
     * @param divisor Suggested divisor.
     * @return        True if the suggested divisor is a factor of the value,
     *                else false.
     */
    private boolean _isDivisible(final int value, final int divisor) {
        if (divisor <= 0)
            return false;
        return (value / divisor == ((double)value)/((double)divisor));
    }
}