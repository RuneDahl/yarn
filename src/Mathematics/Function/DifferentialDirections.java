/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Function;

/**
 * Possible values for the direction to use in computing the
 * <a href="http://en.wikipedia.org/wiki/Derivative#Definition_via_difference_quotients">differential</a>.
 */
public enum DifferentialDirections {
    /**
     * Step is taken in the opposite direction of the step specified.
     */
    Negative(-1),
    /**
     * Both positive and negative steps are taken.
     */
    Central(0),
    /**
     * Step is taken in the direction of the step specified.
     */
    Positive(1);
    
    private final int _value;
    
    private DifferentialDirections(final int value) {
        this._value = value;
    }

    /**
     * Gets the value of this differential direction.
     * @return Value.
     */
    public int getValue() {
        return this._value;
    }
}
