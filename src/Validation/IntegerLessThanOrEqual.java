/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Validation;

/**
 * {@see Validator} allowing {@see Integer integers} less than or equal to the limit.
 * @author Rune Dahl Iversen
 */
public final class IntegerLessThanOrEqual extends LimitBased<Integer> {
    /**
     * Create an instance of an integer validation requiring a value less
     * than or equal to the default limit of 0.
     */
    public IntegerLessThanOrEqual() {
        super(0);
    }

    /**
     * Create an instance of an integer validation requiring a value less
     * than or equal to the specified limit.
     * @param limit Limit.
     */
    public IntegerLessThanOrEqual(final int limit) {
        super(limit);
    }

    @Override
    public String message(final Integer value, final String name) {
        if (this.isValid(value))
            return "";
        else
            return name + " must be less than or equal to " +
                    Integer.toString(this.getLimit()) + ".";
    }

    @Override
    public boolean isValid(final Integer value) {
        return (value != null && value <= this.getLimit());
    }
}
