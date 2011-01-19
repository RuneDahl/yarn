/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Validation;

/**
 * {@see Validator} of doubles only allowing numeric doubles.
 * That is Double.NaN is not allowed.
 * @author Rune Dahl Iversen
 */
public final class DoubleIsNumeric implements Validator<Double> {
    /**
     * Create an instance of a double validator requiring numeric values,
     * i.e. disallowing Double.NaN.
     */
    public DoubleIsNumeric() { // Intentional
    }

    @Override
    public String Message(final Double value, final String name) {
        if (this.isValid(value))
            return "";
        else
            return name + " is not a number (Double.NaN).";
    }

    @Override
    public boolean isValid(final Double value) {
        return value != null && !Double.isNaN(value);
    }
}