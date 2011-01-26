/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Probability.Distribution;

/**
 * Interface for a {@see Distribution probability distribution} with a
 * <a href="http://en.wikipedia.org/wiki/Location_parameter">location</a>
 * parameter.
 * @author Rune Dahl Iversen
 * @param <TypeOfLocation> Type of location.
 */
public interface Location<TypeOfLocation>
        extends Distribution<TypeOfLocation> {
    /**
     * Get the location of this distribution.
     * @return Location.
     */
    public TypeOfLocation getLocation();

    /**
     * Sets the location of this distribution.
     * @param location Location.
     */
    public void setLocation(final TypeOfLocation location);
}
