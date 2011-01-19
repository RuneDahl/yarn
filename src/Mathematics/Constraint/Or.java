/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Constraint;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Implementation of a collection of {@see Constraint constraints}
 * using 'logical or' to compose the constraints.
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of value.
 */
public class Or<TypeOfValue>
        extends ArrayList<Constraint<TypeOfValue>>
        implements Constraint<TypeOfValue> {
    /**
     * Creates an empty collection of constraints.
     */
    public Or() {
        super();
    }

    /**
     * Creates a collection of the specified constraints.
     * @param constraints Constraints.
     */
    public Or(final Collection<? extends Constraint<TypeOfValue>> constraints) {
        super(constraints);
    }

    @Override
    public boolean isBinding(TypeOfValue value) {
        for (Constraint<TypeOfValue> c: this)
            if (c != null && !c.isBinding(value))
                return false;
        return true;
    }

    @Override
    public boolean isFeasible(TypeOfValue value) {
        for (Constraint<TypeOfValue> c: this)
            if (c != null && c.isFeasible(value))
                return true;
        return false;
    }
}