/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Convergence;

import Mathematics.Function.Function;

/**
 * Interface for a
 * <a href="http://en.wikipedia.org/wiki/Series_acceleration">series/sequence
 * convergence accelerator</a>.<br>
 * An example of an accelerator is the
 * <a href="http://en.wikipedia.org/wiki/Richardson_extrapolation">Richardson
 * extrapolation</a>.
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of value.
 */
public interface Accelerator<TypeOfValue>
        extends Function<TypeOfValue[], TypeOfValue[]> {
    /**
     * Computes the accelerated series/sequence of the
     * specified sequence/series using this accelerator.
     * @param sequence Series/Sequence.
     * @return         Accelerated series/sequence.
     */
    public TypeOfValue[] value(final TypeOfValue[] sequence);
}