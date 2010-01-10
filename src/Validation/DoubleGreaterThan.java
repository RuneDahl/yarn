/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Validation;

/**
 * 
 * @author Rune Dahl Iversen
 */
public class DoubleGreaterThan extends LimitBased<Double> {

    public DoubleGreaterThan(double limit) {
        super(limit);
    }

    public String Message(Double value, String name) {
        if (this.Validate(value))
            return "";
        else
            return name + " must be greater than " +
                    Double.toString(this.getLimit()) + ".";
    }

    public boolean Validate(Double value) {
        return (this.getLimit() < value);
    }
}