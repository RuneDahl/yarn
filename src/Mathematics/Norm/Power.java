/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Norm;

import Validation.*;

/**
 * Abstract class allowing for easier implementation of the
 * <a href="http://en.wikipedia.org/wiki/Norm_%28mathematics%29#p-norm">P-norm</a>
 * for {@see Double real} numbers.
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of value.
 */
public abstract class Power<TypeOfValue> implements Norm<TypeOfValue> {
    private double _power;
    private static final Validator<Double> __powerValidator =
            Factory.FiniteRealGreaterThanOrEqual(1.0);

    /**
     * Creates a new instance of a P-norm.
     * @param power Power. Must be greater than or equal to 1 and finite.
     * @throws IllegalArgumentException Power is not finite.
     * @throws IllegalArgumentException Power must be greater than or equal to 1.
     */
    protected Power(double power) {
        this.setPower(power);
    }

    /**
     * Gets the power of this norm.
     * @return The power.
     */
    public final double getPower() {
        return this._power;
    }

    /**
     * Sets the power of this P-norm.
     * @param power Power. Must be greater than or equal to 1 and finite.
     * @throws IllegalArgumentException Power is not finite.
     * @throws IllegalArgumentException Power must be greater than or equal to 1.
     */
    public final void setPower(final double power) {
        if (!__powerValidator.isValid(power))
            throw new IllegalArgumentException(
                    __powerValidator.Message(power, "Power"));
        this._power = power;
    }

    @Override
    public String toString() {
        return "{" + this.getClass().getName() +
                "(" + Double.toString(this.getPower()) + ")}";
    }

    /**
     * Returns whether the specified power-based norm has a power that equals
     * the power of this norm. <br>
     * This method is meant to help implement equals(...).
     * @param p Power-based norm.
     * @return  True if the power values are the same, else false.
     */
    protected boolean _equals(Power<TypeOfValue> p) {
        boolean equals = (p == this);
        equals |= (this._power == p.getPower());
        return equals;
    }

    /**
     * Returns a hash code value that represents the values of this power norm.
     * <br> This method is meant to simplify the implementation/overriding of hashCode.
     * @return Vash code value.
     */
    protected int _hashCode() {
        return Double.valueOf(this._power).hashCode();
    }
}