/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Validation;

/**
 * {@see Validator} allowing {@see Long longs} greater than or eqaul to the limit.
 * @author Rune Dahl Iversen
 */
public final class LongGreaterThanOrEqual extends LimitBased<Long> {
    /**
     * Create an instance of a long validation requiring a value greater
     * than or equal to the default limit of 0.
     */
    public LongGreaterThanOrEqual() {
        super(0L);
    }

    /**
     * Create an instance of a long validation requiring a value greater
     * than or equal to the specified limit.
     * @param limit Limit.
     */
    public LongGreaterThanOrEqual(final long limit) {
        super(limit);
    }

    @Override
    public String message(final Long value, final String name) {
        if (this.isValid(value))
            return "";
        else
            return name + " must be greater than or equal to " +
                    Double.toString(this.getLimit()) + ".";
    }

    @Override
    public boolean isValid(final Long value) {
        return (value != null && this.getLimit() <= value);
    }
}