/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Validation;

/**
 * {@see Validator} allowing doubles greater than the limit.
 * @author Rune Dahl Iversen
 */
public final class DoubleGreaterThan extends LimitBased<Double> {
    /**
     * Create an instance of a double validator requiring values greater than
     * the default limit of 0.
     */
    public DoubleGreaterThan() {
        super(0.0);
    }

    /**
     * Create an instance of a double validator requiring values greater than
     * the specified limit.
     * @param limit Limit.
     */
    public DoubleGreaterThan(final double limit) {
        super(limit);
    }

    public String Message(final Double value, final String name) {
        if (this.isValid(value))
            return "";
        else
            return name + " must be greater than " +
                    Double.toString(this.getLimit()) + ".";
    }

    public boolean isValid(final Double value) {
        return (value != null && this.getLimit() < value);
    }
}