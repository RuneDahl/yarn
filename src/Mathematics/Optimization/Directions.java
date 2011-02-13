/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Optimization;

/**
 * Enumeration of the different possible
 * <a href="http://en.wikipedia.org/wiki/Optimization_%28mathematics%29">
 * optimizations</a> of an objective function.
 * @author Rune Dahl Iversen
 */
public enum Directions {
    /**
     * Minimize the objective function.
     */
    Minimize(-1),
    /**
     * Maximize the objective function.
     */
    Maximize(1);

    private final int _value;

    /**
     * Creates an instance of direction with the specified value.
     * @param value Value.
     */
    private Directions(final int value) {
        this._value = value;
    }

    /**
     * Gets the value of this direction.
     * @return The value.
     */
    public int getValue() {
        return this._value;
    }
}