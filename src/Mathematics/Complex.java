/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics;

/**
 * Implementation of a
 * <a href="http://en.wikipedia.org/wiki/Complex_number">complex number</a>.
 * @author Rune Dahl Iversen
 */
public class Complex
        implements
        Additive<Complex>, Invertible<Complex>, Multiplicative<Complex> {
    private final double _real;
    private final double _imaginary;

    public Complex(final double real, final double imaginary) {
        this._real = real;
        this._imaginary = imaginary;
    }

    public double getImaginary() {
        return this._imaginary;
    }

    public double getLength() {
        double value = Math.max(Math.abs(this._real), Math.abs(this._imaginary));
        double real = this._real / value;
        double imaginary = this._imaginary / value;
        return Math.sqrt(real * real + imaginary * imaginary) * value;
    }

    public double getReal() {
        return this._real;
    }

    public Complex setImaginary(final double imaginary) {
        return new Complex(this._real, imaginary);
    }

    public Complex setReal(final double real) {
        return new Complex(real, this._imaginary);
    }

    public Complex Add(final Complex value) {
        return new Complex(this._real + value._real,
                this._imaginary + value._imaginary);
    }

    public Complex Divide(final Complex denominator) {
        if (Complex.isOrigo(denominator))
            throw new ArithmeticException("Attempt to divide by complex origo.");
        double lengthSquared = denominator.getLength();
        lengthSquared *= lengthSquared;
        return new Complex((this._real * denominator._real +
                this._imaginary * denominator._imaginary) / lengthSquared,
                (this._real * denominator._imaginary -
                this._imaginary * denominator._real) / lengthSquared) ;
    }

    public Complex Inverse() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Complex Multiply(final Complex factor) {
        if (factor == null)
            return null;
        return new Complex(this._real * factor._real -
                this._imaginary * factor._imaginary,
                this._real * factor._imaginary +
                this._imaginary * factor._real);
    }

    public Complex Subtract(final Complex value) {
        return new Complex(this._real - value._real,
                this._imaginary - value._imaginary);
    }

    public static boolean isInfinite(final Complex complex) {
        return complex != null &&
                !Complex.isNaN(complex) &&
                (Double.isInfinite(complex._real) ||
                Double.isInfinite(complex._imaginary));
    }

    public static boolean isOrigo(final Complex complex) {
        return complex != null &&
                complex._real == 0.0 &&
                complex._imaginary == 0.0;
    }

    public static boolean isNaN(final Complex complex) {
        return complex != null &&
                (Double.isNaN(complex._real) ||
                Double.isNaN(complex._imaginary));
    }

    public static Complex Origo() {
        return new Complex(0.0, 0.0);
    }
}