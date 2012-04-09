/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Validation;

/**
 * {@see Validator} not allowing an empty {@see String string}.
 * @author Rune Dahl Iversen
 */
public final class StringNotEmpty implements Validator<String> {
    /**
     * Create an instance of a validator not allowing an empty string.
     */
    public StringNotEmpty() {
    }
    
    @Override
    public boolean isValid(final String value) {
        return !"".equals(value);
    }

    @Override
    public String message(final String value, final String name) {
        if (this.isValid(value))
            return "";
        else
            return name + " is empty.";
    }
}
