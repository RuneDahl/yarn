/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Validation;

/**
 * Validator not allowing the value null.
 * @author Rune Dahl Iversen
 * @param TypeOfValue Type of value.
 */
public class NotNull<TypeOfValue> implements Validator<TypeOfValue> {
    public NotNull() {
    }

    public String Message(final TypeOfValue value, final String name) {
        if (this.Validate(value))
            return "";
        else
            return name + " is null.";
    }

    public boolean Validate(final TypeOfValue value) {
        return value != null;
    }
}