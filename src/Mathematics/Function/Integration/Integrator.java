/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Function.Integration;

import Mathematics.Function.Function;

/**
 * Interface for a integrator, that computes/estimates the value of the
 * <a href="http://en.wikipedia.org/wiki/Integral">integral</a>
 * of a specified function over an interval/area.
 * @author Rune Dahl Iversen
 * @param <TypeOfFunction>  Type of function.
 * @param <TypeOfValue>     Type of output value.
 */
public interface Integrator<TypeOfFunction, TypeOfValue> extends
        Function<TypeOfFunction, TypeOfValue> {
}