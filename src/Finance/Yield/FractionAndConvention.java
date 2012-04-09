/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Finance.Yield;

import Time.DayCounting.Fraction;

/**
 * Implementation of a {@see Convention yield convention} using a
 * {@see Fraction fraction} to convert the date/times into time
 * measured using {@see Double real numbers} and then using this
 * combined with a {@see Convention convention} using
 * {@see Double real numbers} to measure time.
 * @author Rune Dahl Iversen
 * @param <TypeOfCalendar> Type of calendar.
 */
public final class FractionAndConvention<TypeOfCalendar>
        implements Convention<TypeOfCalendar, Double> {
    private Time.DayCounting.Fraction<TypeOfCalendar> _fraction;
    private Convention<Double, Double> _convention;
    
    /**
     * Creates a new instance of this convention using the specified
     * real number convention and fraction.
     * @param convention   The convention using real numbers.
     * @param fraction     The fraction.
     */
    public FractionAndConvention(final Convention<Double, Double> convention,
            final Time.DayCounting.Fraction<TypeOfCalendar> fraction) {
        this.setConvention(convention);
        this.setFraction(fraction);
    }

    /**
     * Gets the real number convention of this convention.
     * @return The convention using real numbers.
     */
    public Convention<Double, Double> getConvention() {
        return this._convention;
    }

    /**
     * Sets the real number convention of this convention.
     * @param convention The convention using real numbers.
     */
    public void setConvention(final Convention<Double, Double> convention) {
        if (convention == null)
            throw new NullPointerException("Convention is not properly specified.");
        this._convention = convention;
    }

    /**
     * Gets the fraction of this convention.
     * @return The fraction.
     */
    public Fraction<TypeOfCalendar> getFraction() {
        return this._fraction;
    }

    /**
     * Sets the fraction of this convention.
     * @param fraction The fraction.
     */
    public void setFraction(final Fraction<TypeOfCalendar> fraction) {
        if (fraction == null)
            throw new NullPointerException("Fraction not properly specified.");
        this._fraction = fraction;
    }

    @Override
    public String getName() {
        return this._convention.getName()+"("+this._fraction.getName()+")";
    }

    @Override
    public double discountFactor(
            final TypeOfCalendar start, final TypeOfCalendar end,
            final double yield) {
        double time = this._fraction.getTime(start, end);
        return this._convention.discountFactor(0.0, time, yield);
    }

    @Override
    public Double time(final double discountFactor, final double yield) {
        return this._convention.time(discountFactor, yield);
    }

    @Override
    public double yield(final double discountFactor, 
            final TypeOfCalendar start, final TypeOfCalendar end) {
        double time = this._fraction.getTime(start, end);
        return this._convention.yield(discountFactor, 0.0, time);
    }
}
