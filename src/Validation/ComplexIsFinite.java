/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Validation;

import Mathematics.Complex;

/**
 * {@see Validator} of {@see Complex complex} numbers only allowing
 * finite values so Complex.Infinity is not allowed.
 * @author Rune Dahl Iversen
 */
public final class ComplexIsFinite implements Validator<Complex> {
    /**
     * Create an instance of a complex validator requiring finite values.
     */
    public ComplexIsFinite() {
    }

    public String Message(final Complex value, final String name) {
        if (this.isValid(value))
            return "";
        else
            return name + " is not finite.";
    }

    public boolean isValid(final Complex value) {
        return value != null && !Complex.isInfinite(value);
    }
}