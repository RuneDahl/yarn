/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Function.Integration;

import Mathematics.Function.Function;
import Mathematics.Result.Result;

/**
 * Interface for a integrator, that computes/estimates the {@see Result result}
 * of an <a href="http://en.wikipedia.org/wiki/Integral">integral</a>
 * of a specified {@see Function function} over an interval/area.
 * @author Rune Dahl Iversen
 * @param <TypeOfFunction>  Type of function.
 */
public interface Integrator<TypeOfFunction> extends
        Function<TypeOfFunction, Result> {
}