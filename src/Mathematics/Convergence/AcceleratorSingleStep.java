/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Convergence;

import Mathematics.Function.Operator;

/**
 * {@see Accelerator} allowing single-step acceleration.
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of value.
 */
public interface AcceleratorSingleStep<TypeOfValue>
        extends Accelerator<TypeOfValue>,
        Operator<Integer, TypeOfValue[], TypeOfValue> {
    /**
     * Compute the accelerated value for the specified series/sequence
     * and iteration.<br>
     * This method will most likely be very highly state-dependent.
     * The internal state of this accelerator should essentially
     * be set to have finished computing the accelerated value
     * one step previous of this specified series/sequence.
     * @param iteration Iteration.
     * @param sequence  Sequence/Series.
     * @return          Accelerated value.
     */
    @Override
    public TypeOfValue value(
            final Integer iteration,
            final TypeOfValue[] sequence);
}
