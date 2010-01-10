/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Validation;

/**
 * Validator allowing doubles less than the limit.
 * @author Rune Dahl Iversen
 */
public final class DoubleLessThan extends LimitBased<Double> {
    public DoubleLessThan() {
        super(0.0);
    }

    public DoubleLessThan(final double limit) {
        super(limit);
    }

    public String Message(final Double value, final String name) {
        if (this.Validate(value))
            return "";
        else
            return name + " must be less than " +
                    Double.toString(this.getLimit()) + ".";
    }

    public boolean Validate(final Double value) {
        return (value != null && value < this.getLimit());
    }
}