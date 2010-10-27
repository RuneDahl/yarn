/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Function.Integration;

import Mathematics.Function.Operator;

/**
 * Interface for an evaluator of of an integral of a function over a region.<br>
 * An evaluator returns the computed value directly as opposed to an
 * {@see Integrator integrator} that can return a
 * {@see Mathematics.Result.Result result}.<br>
 * As a design-decision the evaluator is implemented as an
 * {@see Operator operator} of the {@see Mathematics.Function.Function function}
 * and the region.
 * @author Rune Dahl Iversen
 * @param <TypeOfFunction> Type of function.
 * @param <TypeOfRegion>   Type of region.
 * @param <TypeOfValue>    Type of output value.
 */
public interface Evaluator<TypeOfFunction, TypeOfRegion, TypeOfValue> extends 
        Operator<TypeOfFunction, TypeOfRegion, TypeOfValue> {
}