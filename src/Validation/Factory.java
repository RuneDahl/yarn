/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Validation;

import Mathematics.Complex;

/**
 * Factory class for often used validation setups.
 * @author Rune Dahl Iversen
 */
public final class Factory {
    private Factory()
    { }

    /**
     * Validator allowing not null, finite {@see Mathematics.Complex complex}
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
     * Validator allowing not null, finite {@see double double}
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
     * Validator allowing not null {@see Mathematics.Complex complex}
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
     * Validator allowing not null [@see Integer integer}
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
     * Validator allowing not null {@see double double}
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