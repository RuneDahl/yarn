/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Validation;

/**
 * {@see Validator} allowing longs greater than the limit.
 * @author Rune Dahl Iversen
 */
public final class LongGreaterThan extends LimitBased<Long> {
    /**
     * Create an instance of a long validation requiring a value greater
     * than or equal to the default limit of 0.
     */
    public LongGreaterThan() {
        super(0L);
    }

    /**
     * Create an instance of a long validation requiring a value greater
     * than or equal to the specified limit.
     * @param limit Limit.
     */
    public LongGreaterThan(final long limit) {
        super(limit);
    }

    @Override
    public String message(final Long value, final String name) {
        if (this.isValid(value))
            return "";
        else
            return name + " must be greater than " +
                    Double.toString(this.getLimit()) + ".";
    }

    @Override
    public boolean isValid(final Long value) {
        return (value != null && this.getLimit() < value);
    }
}