/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Function;

/**
 * Implementation of the single step {@see Function function} in the
 * <a href="http://en.wikipedia.org/wiki/Collatz_conjecture">Collatz
 * conjecture</a>.
 * @author Rune Dahl Iversen
 */
public class Collatz implements Function<Long, Long> {
    public Long value(final Long input) {
        long value = input;
        if (value / 2.0 == value / 2)
            value = value / 2;
        else
            value = 3 * value + 1;
        return value;
    }
}