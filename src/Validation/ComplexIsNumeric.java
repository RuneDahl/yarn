/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Validation;

import Mathematics.Complex;

/**
 * {@see Validator} of {@see Complex complex} numbers only allowing
 * numeric values. That is Complex.NaN is not allowed.
 * @author Rune Dahl Iversen
 */
public final class ComplexIsNumeric implements Validator<Complex> {
    /**
     * Create an instance of a double validator requiring numeric values,
     * i.e. disallowing Complex.NaN.
     */
    public ComplexIsNumeric() { // Intentional
    }

    @Override
    public String Message(final Complex value, final String name) {
        if (this.isValid(value))
            return "";
        else
            return name + " is not a number (Complex.NaN).";
    }

    @Override
    public boolean isValid(final Complex value) {
        return value != null && !Complex.isNaN(value);
    }
}