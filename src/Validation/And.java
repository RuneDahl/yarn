/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Validation;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Composition of {@see Validator} using logical And.
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of value.
 */
public final class And<TypeOfValue>
        extends ArrayList<Validator<TypeOfValue>>
        implements Validator<TypeOfValue> {
    /**
     * Create an empty logical And composition of {@see Validator}.
     */
    public And() {
        super();
    }

    /**
     * Create a logical And composition of {@see Validator} with
     * the specified collection of validators in.
     * @param c Collection of validators.
     */
    public And(Collection<? extends Validator<TypeOfValue>> c) {
        super(c);
    }

    public String Message(final TypeOfValue value, final String name) {
        StringBuilder messages = new StringBuilder("(");
        for (Validator<TypeOfValue> validator : this)
            if (!validator.isValid(value))
                messages.append(validator.Message(value, name) + " && ");
        if (1 < messages.length()) {
            messages.delete(messages.length() - 5, messages.length());
            messages.append(")");
        }
        else
            messages = new StringBuilder();
        return messages.toString();
    }

    public boolean isValid(final TypeOfValue value) {
        for (Validator<TypeOfValue> validator : this)
            if (!validator.isValid(value))
                return false;
        return true;
    }
}