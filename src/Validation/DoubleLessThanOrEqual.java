/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Validation;

/**
 *
 * @author Rune Dahl Iversen
 */
public class DoubleLessThanOrEqual extends LimitBased<Double>  {

    public DoubleLessThanOrEqual(double limit) {
        super(limit);
    }

    public String Message(Double value, String name) {
        if (this.Validate(value))
            return "";
        else
            return name + " must be less than or equal to " +
                    Double.toString(this.getLimit()) + ".";
    }

    public boolean Validate(Double value) {
        return (value <= this.getLimit());
    }
}