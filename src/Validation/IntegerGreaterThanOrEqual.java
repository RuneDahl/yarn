/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Validation;

/**
 * {@see Validator} allowing {@see Integer integers} greater than or equal to the limit.
 * @author Rune Dahl Iversen
 */
public final class IntegerGreaterThanOrEqual extends LimitBased<Integer> {
    /**
     * Create an instance of an integer validation requiring a value greater
     * than or equal to the default limit of 0.
     */
    public IntegerGreaterThanOrEqual() {
        super(0);
    }

    /**
     * Create an instance of an integer validation requiring a value greater
     * than or equal to the specified limit.
     * @param limit Limit.
     */
    public IntegerGreaterThanOrEqual(final int limit) {
        super(limit);
    }

    @Override
    public String message(final Integer value, final String name) {
        if (this.isValid(value))
            return "";
        else
            return name + " must be greater than or equal to " +
                    Integer.toString(this.getLimit()) + ".";
    }

    @Override
    public boolean isValid(final Integer value) {
        return (value != null && this.getLimit() <= value);
    }
}
