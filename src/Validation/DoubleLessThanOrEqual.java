/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Validation;

/**
 * Validator allowing doubles less than or equal to the limit.
 * @author Rune Dahl Iversen
 */
public final class DoubleLessThanOrEqual extends LimitBased<Double>  {
    public DoubleLessThanOrEqual() {
        super(0.0);
    }

    public DoubleLessThanOrEqual(final double limit) {
        super(limit);
    }

    public String Message(final Double value, final String name) {
        if (this.Validate(value))
            return "";
        else
            return name + " must be less than or equal to " +
                    Double.toString(this.getLimit()) + ".";
    }

    public boolean Validate(final Double value) {
        return (value != null && value <= this.getLimit());
    }
}