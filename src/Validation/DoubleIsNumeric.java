/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Validation;

/**
 *
 * @author Rune Dahl Iversen
 */
public class DoubleIsNumeric implements Validator<Double> {
    public DoubleIsNumeric() {
    }

    public String Message(Double value, String name) {
        if (this.Validate(value))
            return "";
        else
            return name + " is not a number (Double.NaN).";
    }

    public boolean Validate(Double value) {
        return !Double.isNaN(value);
    }
}