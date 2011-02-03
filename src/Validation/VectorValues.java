/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Validation;

import Mathematics.Vector.Vector;

/**
 * {@see Validator} of {@see Vector vector} of values that
 * validate each value in the vector.
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of vector value.
 */
public final class VectorValues<TypeOfValue>
        implements Validator<Vector<TypeOfValue>> {
    private Validator<TypeOfValue> _valueValidator;

    /**
     * Creates an instance of a vector value validator using the specified
     * validator for the values in the vector.
     * @param valueValidator Value validator.
     */
    public VectorValues(Validator<TypeOfValue> valueValidator) {
        this.setValueValidator(valueValidator);
    }

    /**
     * Gets the validator of the values in the vector.
     * @return Value validator.
     */
    public Validator<TypeOfValue> getValueValidator() {
        return this._valueValidator;
    }

    /**
     * Sets the validator of the values in the vector.
     * @param valueValidator Value validator.
     * @throws NullPointerException Value validator is not properly specified.
     */
    public void setValueValidator(final Validator<TypeOfValue> valueValidator) {
        if (valueValidator ==  null)
            throw new NullPointerException("Value validator is not properly specified.");
        this._valueValidator = valueValidator;
    }

    @Override
    public boolean isValid(final Vector<TypeOfValue> value) {
        boolean valid = true;
        if (value == null)
            valid = false;
        else
            for (int dim = value.getFirstDimension();
                    valid && dim <= value.getLastDimension(); dim++)
                valid &= this._valueValidator.isValid(value.getValue(dim));
        return valid;
    }

    @Override
    public String message(final Vector<TypeOfValue> value, String name) {
        StringBuilder mess = new StringBuilder();
        if (!this.isValid(value)) {
            mess.append(name);
            if (value == null)
                mess.append(" is null.");
            else {
                for (int dim = value.getFirstDimension();
                dim <= value.getLastDimension(); dim++)
                    if (!_valueValidator.isValid(value.getValue(dim)))
                        mess.append(" " + this._valueValidator.message(
                                value.getValue(dim),
                                "Dimension " + Integer.toString(dim)));
            }
        }
        return mess.toString();
    }
}
