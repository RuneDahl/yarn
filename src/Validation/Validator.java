/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Validation;

/**
 * Interface for a validator.
 * The declaration of this interface allows all validation of values to
 * be implemented using the design pattern Strategy.
 * Further it allows the design pattern Composite.
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of value.
 */
public interface Validator<TypeOfValue> {
    /**
     * Returns whether the specified value is valid.
     * @param value Value.
     * @return      True if the value satisfies this validator else false.
     */
    public boolean isValid(final TypeOfValue value);

    /**
     * Messages from the validation of the specified value.
     * @param value Value.
     * @param name  Name of the value. For use in the message.
     * @return      Message of how this value fails this validator.
     *              Empty string if it does satisfy the validator.
     */
    public String message(final TypeOfValue value, final String name);
}