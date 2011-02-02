/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Graph.Builder;

import Mathematics.Function.Function;

/**
 * Interface for a {@see Function function}
 * to compute a shifted state from another.
 * @author Rune Dahl Iversen
 * @param <TypeOfState> Type of state.
 */
public interface StateShift<TypeOfState>
        extends Function<TypeOfState, TypeOfState> {
}
