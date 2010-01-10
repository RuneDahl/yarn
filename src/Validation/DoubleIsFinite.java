/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Validation;

/**
 *
 * @author Rune Dahl Iversen
 */
public class DoubleIsFinite implements Validator<Double> {
    public DoubleIsFinite() {
    }

    public String Message(Double value, String name) {
        if (this.Validate(value))
            return "";
        else
            return name + " is not finite.";
    }

    public boolean Validate(Double value) {
        return !Double.isInfinite(value);
    }
}