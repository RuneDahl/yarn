/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Validation;

/**
 * {@see Validator} allowing {@see Long longs} less than or eqaul to the limit.
 * @author Rune Dahl Iversen
 */
public final class LongLessThanOrEqual extends LimitBased<Long> {
    /**
     * Create an instance of a long validation requiring a value less
     * than or equal to the default limit of 0.
     */
    public LongLessThanOrEqual() {
        super(0L);
    }

    /**
     * Create an instance of a long validation requiring a value less
     * than or equal to the specified limit.
     * @param limit Limit.
     */
    public LongLessThanOrEqual(final long limit) {
        super(limit);
    }

    @Override
    public String message(final Long value, final String name) {
        if (this.isValid(value))
            return "";
        else
            return name + " must be less than or equal to " +
                    Double.toString(this.getLimit()) + ".";
    }

    @Override
    public boolean isValid(final Long value) {
        return (value != null && value <= this.getLimit());
    }
}