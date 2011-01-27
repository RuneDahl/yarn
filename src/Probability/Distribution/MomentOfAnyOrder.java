/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Probability.Distribution;

/**
 * Interface for a {@see Distribution probability distribution} with a well-defined
 * <a href="http://en.wikipedia.org/wiki/Moment_%28mathematics%29">moment</a>
 * of any order. Thus the distrbution also has well-defined
 * <a href="http://en.wikipedia.org/wiki/Central_moment">central moments</a>
 * of any order.
 * @author Rune Dahl Iversen
 * @param <TypeOfMoment> Type of moment.
 * @param <TypeOfValue>  Type of value.
 */
public interface MomentOfAnyOrder<TypeOfMoment, TypeOfValue>
        extends Distribution<TypeOfValue>,
        Mean<TypeOfMoment, TypeOfValue>, Variance<TypeOfMoment, TypeOfValue> {
    /**
     * Returns the central moment of the specified order of this distribution.
     * @param order Order of moment.
     * @return      Central moment.
     */
    public TypeOfMoment getCentralMoment(final int order);

    /**
     * Returns the moment of the specified order of this distribution.
     * @param order Order.
     * @return      Moment.
     */
    public TypeOfMoment getMoment(final int order);
}