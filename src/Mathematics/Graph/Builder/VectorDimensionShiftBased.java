/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Graph.Builder;

import Mathematics.Vector.Vector;
import Validation.Validator;

/**
 * Abstract implementation of a {@see StateShifter state shifter} having
 * the dimension and shift value to apply to a vector.
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of vector value.
 */
public abstract class VectorDimensionShiftBased<TypeOfValue>
        implements StateShifter<Vector<TypeOfValue>> {
    private int _dimension;
    private TypeOfValue _shift;
    private Validator<TypeOfValue> _shiftValidator;

    /**
     * Creates an instance of the vector state shifter
     * based on dimension and shift value.
     * @param dimension      Dimension.
     * @param shiftValidator Validator for the shift value.
     * @param shift          Shift value.
     */
    protected VectorDimensionShiftBased(
            final int dimension,
            final Validator<TypeOfValue> shiftValidator,
            final TypeOfValue shift) {
        if (shiftValidator == null)
            throw new NullPointerException("Shift validator not specified.");
        else
            this._shiftValidator = shiftValidator;
        this.setDimension(dimension);
        this.setShift(shift);
    }

    /**
     * Gets the vector dimension of this state shifter.
     * @return Vector dimension.
     */
    public final int getDimension() {
        return this._dimension;
    }

    /**
     * Gets the shift value of this state shifter.
     * @return Shift value.
     */
    public final TypeOfValue getShift() {
        return this._shift;
    }

    /**
     * Sets the vector dimension of this state shifter.
     * @param dimension Vector dimension.
     */
    public final void setDimension(final int dimension) {
        this._dimension = dimension;
    }

    /**
     * Sets the shift value of this state shifter.
     * @param shift Shift value.
     */
    public final void setShift(final TypeOfValue shift) {
        if (!this._shiftValidator.isValid(shift))
            throw new IllegalArgumentException(
                    this._shiftValidator.message(shift, "Shift"));
        this._shift = shift;
    }
}
