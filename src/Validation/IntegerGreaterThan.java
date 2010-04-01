/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Validation;

/**
 * {@see Validator} allowing integers greater than the limit.
 * @author Rune Dahl Iversen
 */
public final class IntegerGreaterThan extends LimitBased<Integer> {
    /**
     * Create an instance of an integer validation requiring a value greater
     * than or equal to the default limit of 0.
     */
    public IntegerGreaterThan() {
        super(0);
    }

    /**
     * Create an instance of an integer validation requiring a value greater
     * than or equal to the specified limit.
     * @param limit Limit.
     */
    public IntegerGreaterThan(final int limit) {
        super(limit);
    }

    public String Message(final Integer value, final String name) {
        if (this.isValid(value))
            return "";
        else
            return name + " must be greater than " +
                    Double.toString(this.getLimit()) + ".";
    }

    public boolean isValid(final Integer value) {
        return (value != null && this.getLimit() < value);
    }
}