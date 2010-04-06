/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Validation;

/**
 * {@see Validator} of doubles only allowing finite values.
 * So Double.POSITIVE_INFINITY and Double.NEGATIVE_INFINITY are not allowed.
 * @author Rune Dahl Iversen
 */
public final class DoubleIsFinite implements Validator<Double> {
    /**
     * Create an instance of a double validator requiring finite values.
     */
    public DoubleIsFinite() {
    }

    public String Message(final Double value, final String name) {
        if (this.isValid(value))
            return "";
        else
            return name + " is not finite.";
    }

    public boolean isValid(final Double value) {
        return value != null && !Double.isInfinite(value);
    }
}