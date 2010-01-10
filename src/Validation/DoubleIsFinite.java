/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Validation;

/**
 *
 * @author Rune Dahl Iversen
 */
public final class DoubleIsFinite implements Validator<Double> {
    public DoubleIsFinite() {
    }

    public String Message(final Double value, final String name) {
        if (this.Validate(value))
            return "";
        else
            return name + " is not finite.";
    }

    public boolean Validate(final Double value) {
        return !Double.isInfinite(value);
    }
}