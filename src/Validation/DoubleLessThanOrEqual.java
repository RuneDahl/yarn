/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Validation;

/**
 * {@see Validator} allowing doubles less than or equal to the limit.
 * @author Rune Dahl Iversen
 */
public final class DoubleLessThanOrEqual extends LimitBased<Double> {
    /**
     * Creates an instance of a double validator requiring values less than
     * or equal to the default limit of 0.
     */
    public DoubleLessThanOrEqual() {
        super(0.0);
    }

    /**
     * Creates an instance of a double validator requiring values less than
     * or equal to the specified limit.
     * @param limit Limit.
     */
    public DoubleLessThanOrEqual(final double limit) {
        super(limit);
    }

    @Override
    public String message(final Double value, final String name) {
        if (this.isValid(value))
            return "";
        else
            return name + " must be less than or equal to " +
                    Double.toString(this.getLimit()) + ".";
    }

    @Override
    public boolean isValid(final Double value) {
        return (value != null && value <= this.getLimit());
    }
}