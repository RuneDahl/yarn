/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Validation;

/**
 * {@see Validator} not allowing the value null.
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> TypeOfValue Type of value.
 */
public class NotNull<TypeOfValue> implements Validator<TypeOfValue> {
    /**
     * Create an instance of a validator not allowing the value null.
     */
    public NotNull() { // Intentional
    }

    public String Message(final TypeOfValue value, final String name) {
        if (this.isValid(value))
            return "";
        else
            return name + " is null.";
    }

    public boolean isValid(final TypeOfValue value) {
        return value != null;
    }
}