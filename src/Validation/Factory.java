/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Validation;

import Mathematics.Complex;

/**
 * Factory class for often used {@see Validator validation} setups.
 * @author Rune Dahl Iversen
 */
public final class Factory {
    private Factory()
    { /* Intentional */ }

    /**
     * Validator allowing not null, finite {@see Complex complex}
     * values that are not Complex.NaN.
     * @return New validator.
     */
    public static Validator<Complex> FiniteComplex()
    {
        And<Complex> validator = new And<Complex>();
        validator.add(new NotNull<Complex>());
        validator.add(new ComplexIsNumeric());
        validator.add(new ComplexIsFinite());
        return validator;
    }

    /**
     * Validator allowing not null, finite {@see Double double}
     * values that are not Double.NaN.
     * @return New validator.
     */
    public static Validator<Double> FiniteReal() {
        And<Double> validator = new And<Double>();
        validator.add(new NotNull<Double>());
        validator.add(new DoubleIsNumeric());
        validator.add(new DoubleIsFinite());
        return validator;
    }

    /**
     * Validator allowing not null, finite {@see Double double} values that are
     * not Double.NaN and are greater than the specified limit.
     * @param limit Limit.
     * @return      New validator.
     */
    public static Validator<Double> FiniteRealGreaterThan(final double limit) {
        And<Double> validator = new And<Double>();
        validator.add(new NotNull<Double>());
        validator.add(new DoubleIsNumeric());
        validator.add(new DoubleIsFinite());
        validator.add(new DoubleGreaterThan(limit));
        return validator;
    }

    /**
     * Validator allowing not null, finite {@see Double double} values that are
     * not Double.NaN and are greater than or equal to the specified limit.
     * @param limit Limit.
     * @return      New validator.
     */
    public static Validator<Double> FiniteRealGreaterThanOrEqual(final double limit) {
        And<Double> validator = new And<Double>();
        validator.add(new NotNull<Double>());
        validator.add(new DoubleIsNumeric());
        validator.add(new DoubleIsFinite());
        validator.add(new DoubleGreaterThanOrEqual(limit));
        return validator;
    }

    /**
     * Validator allowing not null, finite {@see Double double} values that are
     * not Double.NaN and are less than the specified limit.
     * @param limit Limit.
     * @return      New validator.
     */
    public static Validator<Double> FiniteRealLessThan(final double limit) {
        And<Double> validator = new And<Double>();
        validator.add(new NotNull<Double>());
        validator.add(new DoubleIsNumeric());
        validator.add(new DoubleIsFinite());
        validator.add(new DoubleLessThan(limit));
        return validator;
    }

    /**
     * Validator allowing not null, finite {@see Double double} values that are
     * not Double.NaN and are less than or equal to the specified limit.
     * @param limit Limit.
     * @return      New validator.
     */
    public static Validator<Double> FiniteRealLessThanOrEqual(final double limit) {
        And<Double> validator = new And<Double>();
        validator.add(new NotNull<Double>());
        validator.add(new DoubleIsNumeric());
        validator.add(new DoubleIsFinite());
        validator.add(new DoubleLessThanOrEqual(limit));
        return validator;
    }

    /**
     * Validator allowing not null {@see Complex complex}
     * values that are not Complex.NaN.
     * @return New validator.
     */
    public static Validator<Complex> Complex() {
        And<Complex> validator = new And<Complex>();
        validator.add(new NotNull<Complex>());
        validator.add(new ComplexIsNumeric());
        return validator;
    }

    /**
     * Validator allowing not null {@see Integer integer}
     * values that are positive.
     * @return New validator.
     */
    public static Validator<Integer> PositiveInteger() {
        And<Integer> validator = new And<Integer>();
        validator.add(new NotNull<Integer>());
        validator.add(new IntegerGreaterThan(0));
        return validator;
    }

    /**
     * Validator allowing not null {@see Long long} values
     * that are limited by the specified lower and upper bound.
     * @param lowerBound Lower bound.
     * @param upperBound Upper bound.
     * @return
     */
    public static Validator<Long> BoundedLong(
            final long lowerBound,
            final long upperBound) {
        And<Long> validator = new And<Long>();
        validator.add(new NotNull<Long>());
        validator.add(new LongGreaterThanOrEqual(lowerBound));
        validator.add(new LongLessThanOrEqual(upperBound));
        return validator;
    }

    /**
     * Validator allowing not null {@see Long long}
     * values that are non-negative.
     * @return New validator.
     */
    public static Validator<Long> NonNegativeLong() {
        And<Long> validator = new And<Long>();
        validator.add(new NotNull<Long>());
        validator.add(new LongGreaterThanOrEqual(0));
        return validator;
    }

    /**
     * Validator allowing not null {@see Long long}
     * values that are positive.
     * @return New validator.
     */
    public static Validator<Long> PositiveLong() {
        And<Long> validator = new And<Long>();
        validator.add(new NotNull<Long>());
        validator.add(new LongGreaterThan(0));
        return validator;
    }

    /**
     * Validator allowing not null {@see Long long}
     * values that are positive and prime numbers.
     * @return New validator.
     */
    public static Validator<Long> PrimeLong() {
        And<Long> validator = new And<Long>();
        validator.add(new NotNull<Long>());
        validator.add(new LongGreaterThan(0));
        validator.add(new LongPrime());
        return validator;
    }

    /**
     * Validator allowing not null {@see Double double}
     * values that are not Double.NaN.
     * @return New validator.
     */
    public static Validator<Double> Real() {
        And<Double> validator = new And<Double>();
        validator.add(new NotNull<Double>());
        validator.add(new DoubleIsNumeric());
        return validator;
    }
}