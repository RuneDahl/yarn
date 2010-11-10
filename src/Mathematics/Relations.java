/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics;

/**
 * Enumeration of numeric relations between {@see Double real numbers}.
 * @author Rune Dahl Iversen
 */
public enum Relations {
    /**
     * Less than and not equal to.
     */
    LessThan(-2),
    /**
     * Less than or equal to.
     */
    LessThanOrEqualTo(-1),
    /**
     * Equal to.
     */
    EqualTo(0),
    /**
     * Greater than or equal to.
     */
    GreaterThanOrEqualTo(1),
    /**
     * Greater than and not equal to.
     */
    GreaterThan(2);

    private int _value;

    /**
     * Creates a new relation with the specified value.
     * @param value Value.
     */
    Relations(final int value) {
        this._value = value;
    }

    /**
     * Gets the value of this relation.
     * @return The value.
     */
    public int getValue() {
        return this._value;
    }
}