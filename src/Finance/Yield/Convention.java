/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Finance.Yield;

/**
 * Interface for a yield convention, the specific implementation of the relation
 * between <a href="http://en.wikipedia.org/wiki/Discount_factor#Discount_factor">
 * discount factor</a>, <a href="http://en.wikipedia.org/wiki/Time">time</a> and
 * <a href="http://en.wikipedia.org/wiki/Yield_%28finance%29">yield</a>.
 * Conventions are implemented assuming a single future payment and a specific way of 
 * <a href="http://en.wikipedia.org/wiki/Compounding_of_interest">compounding</a>
 * as well as way to specify time.
 * @author Rune Dahl Iversen
 * @param <TypeOfTime>           Type of time.
 * @param <TypeOfTimeDifference> Type of difference in time.
 */
public interface Convention<TypeOfTime, TypeOfTimeDifference> {
    /**
     * Computes the discount factor from the specified date/times and yield
     * assuming this yield convention.
     * @param start Starting date/time.
     * @param end   End date/time.
     * @param yield Yield.
     * @return      The discount factor.
     */
    public double discountFactor(final TypeOfTime start, final TypeOfTime end,
            final double yield);
    
    /**
     * Gets the name, a string-representation, of this yield convention.
     * @return 
     */
    public String getName();
    
    /**
     * Computes the period of time to the future payment from the specified
     * discount factor and yield assuming this yield convention.
     * @param discountFactor Discount factor.
     * @param yield          Yield.
     * @return               Period of time.
     */
    public TypeOfTimeDifference time(
            final double discountFactor, final double yield);
    
    /**
     * Computes the yield from the specified date/times and discount factor
     * assuming this yield convention.
     * @param discountFactor Discount factor.
     * @param start          Starting date/time.
     * @param end            End date/time.
     * @return               Yield.
     */
    public double yield(final double discountFactor, 
            final TypeOfTime start, final TypeOfTime end);
}
