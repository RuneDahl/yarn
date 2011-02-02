/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Graph.Builder;

import java.util.LinkedHashSet;

/**
 * Implementation of a set of {@see StateShifter shifts} that are
 * applied succesively to form the combined shift.
 * @author Rune Dahl Iversen
 * @param <TypeOfState> Type of state.
 */
public final class StateShifts<TypeOfState>
        extends LinkedHashSet<StateShift<TypeOfState>>
        implements StateShift<TypeOfState> {

    @Override
    public TypeOfState value(final TypeOfState input) {
        TypeOfState state = input;
        for (StateShift<TypeOfState> shift : this)
            state = shift.value(state);
        return state;
    }
}
