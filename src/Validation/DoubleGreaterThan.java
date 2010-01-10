/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Validation;

/**
 * 
 * @author Rune Dahl Iversen
 */
public final class DoubleGreaterThan extends LimitBased<Double> {

    public DoubleGreaterThan(final double limit) {
        super(limit);
    }

    public String Message(final Double value, final String name) {
        if (this.Validate(value))
            return "";
        else
            return name + " must be greater than " +
                    Double.toString(this.getLimit()) + ".";
    }

    public boolean Validate(final Double value) {
        return (this.getLimit() < value);
    }
}