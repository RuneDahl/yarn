/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Graph.Builder;

import Mathematics.Function.Function;

/**
 * Interface for a funtion to shift a state from one value to another.
 * @author Rune Dahl Iversen
 * @param <TypeOfState> Type of state.
 */
public interface StateShifter<TypeOfState>
        extends Function<TypeOfState, TypeOfState> {
}
