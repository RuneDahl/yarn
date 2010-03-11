/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Validation;

/**
 * Validator allowing doubles greater than or equal to the limit.
 * @author Rune Dahl Iversen
 */
public final class DoubleGreaterThanOrEqual extends LimitBased<Double> {
    /**
     * Create an instance of a double validator requiring values greater than
     * or equal to the default limit of 0.
     */
    public DoubleGreaterThanOrEqual() {
        super(0.0);
    }

    /**
     * Create an instance of a double validator requiring values greater than
     * or equal to the specified limit.
     * @param limit Limit.
     */
    public DoubleGreaterThanOrEqual(final double limit) {
        super(limit);
    }

    public String Message(final Double value, final String name) {
        if (this.isValid(value))
            return "";
        else
            return name + " must be greater than or equal to " +
                    Double.toString(this.getLimit()) + ".";
    }

    public boolean isValid(final Double value) {
        return (value != null && this.getLimit() <= value);
    }
}