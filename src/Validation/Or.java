/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Validation;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Composition of {@see Validator} using logical Or.
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of value.
 */
public final class Or<TypeOfValue>
        extends ArrayList<Validator<TypeOfValue>>
        implements Validator<TypeOfValue> {
    /**
     * Create an empty logical Or composition of {@see Validator}.
     */
    public Or() {
        super();
    }

    /**
     * Create a logical Or composition of {@see Validator} with
     * the specified collection of validators in.
     * @param c Collection of validators.
     */
    public Or(Collection<? extends Validator<TypeOfValue>> c) {
        super(c);
    }

    @Override
    public String message(final TypeOfValue value, final String name) {
        StringBuilder messages = new StringBuilder();
        if (this.isValid(value))
            return messages.toString();
        messages.append("(");
        for (Validator<TypeOfValue> validator : this)
            messages.append(validator.message(value, name) + " || ");
        messages.delete(messages.length() - 5, messages.length());
        messages.append(")");
        return messages.toString();
    }

    @Override
    public boolean isValid(final TypeOfValue value) {
        if (this.isEmpty())
            return true;
        for (Validator<TypeOfValue> validator : this)
            if (validator.isValid(value))
                return true;
        return false;
    }
}