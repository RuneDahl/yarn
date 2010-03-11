/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Validation;

/**
 * {@see Validator} allowing doubles less than the limit.
 * @author Rune Dahl Iversen
 */
public final class DoubleLessThan extends LimitBased<Double> {
    /**
     * Creates an instance of a double validator requiring values less than
     * the default limit of 0.
     */
    public DoubleLessThan() {
        super(0.0);
    }

    /**
     * Creates an instance of a double validator requiring values less than
     * the specified limit.
     * @param limit Limit
     */
    public DoubleLessThan(final double limit) {
        super(limit);
    }

    public String Message(final Double value, final String name) {
        if (this.isValid(value))
            return "";
        else
            return name + " must be less than " +
                    Double.toString(this.getLimit()) + ".";
    }

    public boolean isValid(final Double value) {
        return (value != null && value < this.getLimit());
    }
}