/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Function.Integration;

import Mathematics.Function.Function;
import Mathematics.Result.Result;

/**
 * Interface for a integrator, that computes/estimates the {@see Result result}
 * of an <a href="http://en.wikipedia.org/wiki/Integral">integral</a>
 * of a specified {@see Function function} over a region.
 * @author Rune Dahl Iversen
 * @param <TypeOfFunction>  Type of function.
 * @param <TypeOfRegion>    Type of region.
 */
public interface Integrator<TypeOfFunction, TypeOfRegion> extends
        Function<TypeOfFunction, Result> {
    /**
     * Gets the region to integrate over.
     * @return The region.
     */
    public TypeOfRegion getRegion();

    /**
     * Sets the region to integrate over.
     * @param region The region.
     */
    public void setRegion(final TypeOfRegion region);
}