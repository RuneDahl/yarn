/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Equality;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Composition of {@see Equals} using logical And.
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of value.
 */
public class And<TypeOfValue>
        extends ArrayList<Equals<TypeOfValue>>
        implements Equals<TypeOfValue> {
    /**
     * Create an empty logical And composition of {@see Equals}.
     */
    public And() {
        super();
    }

    /**
     * Create a logical And composition of {@see Equals} with
     * the specified collection of operators in.
     * @param c Collection of operators.
     */
    public And(Collection<? extends Equals<TypeOfValue>> c) {
        super(c);
    }

    @Override
    public Boolean value(final TypeOfValue a, final TypeOfValue b) {
        for (Equals<TypeOfValue> equals : this)
            if (!equals.value(a, b))
                return false;
        return true;
    }
}