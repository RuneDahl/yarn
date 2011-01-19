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
    @Override
    public Long value(final Long input) {
        return (input % 2 == 0 ? input/2 : input*3 + 1);
    }
}