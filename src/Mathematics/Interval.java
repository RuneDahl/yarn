/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics;

/**
 * Interface defining an
 * <a href="http://en.wikipedia.org/wiki/Interval_%28mathematics%29">interval</a>
 * of values of the specified type.
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of value.
 */
public interface Interval<TypeOfValue> {
    /**
     * Returns the value of the lower bound of this interval.
     * @return The value of the lower bound.
     */
    public TypeOfValue getLowerBound();

    /**
     * Returns the type of the lower bound of this interval.
     * @return The type of the lower bound.
     */
    public EndType getLowerType();

    /**
     * Returns the value of the upper bound of this interval.
     * @return The value of the upper bound.
     */
    public TypeOfValue getUpperBound();

    /**
     * Returns the type of the upper bound of this interval.
     * @return The type of the upper bound.
     */
    public EndType getUpperType();

    /**
     * Sets the value of the lower bound of this interval.
     * @param lowerBound The value of the lower bound.
     */
    public void setLowerBound(final TypeOfValue lowerBound);

    /**
     * Sets the type of the lower bound of this interval.
     * @param lowerType The type of the lower bound.
     */
    public void setLowerType(final EndType lowerType);

    /**
     * Sets the value of the upper bound of this interval.
     * @param upperBound The value of the upper bound.
     */
    public void setUpperBound(final TypeOfValue upperBound);

    /**
     * Sets the type of the upper bound of this interval.
     * @param upperType The type of the upper bound.
     */
    public void setUpperType(final EndType upperType);

    /**
     * Indicates whether this interval contains the specified value.
     * @param value Value.
     * @return      True if this interval contains the value, else false.
     */
    public boolean contains(final TypeOfValue value);

    /**
     * Types for end-points of intervals.
     */
    public enum EndType {
        /**
         * Excludes means that the interval is "to, but excluding the value".
         */
        Excludes,
        /**
         * Includes means that the interval is "to and including the value".
         */
        Includes
    }
}