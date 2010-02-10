/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics;

/**
 * Implementation of a
 * <a href="http://en.wikipedia.org/wiki/Complex_number">complex number</a>.
 * Complex is implemented as an immutable class.
 * @author Rune Dahl Iversen
 */
public class Complex
        implements Additive<Complex>, Conjugate<Complex>, Invertible<Complex>,
        Multiplicative<Complex> {
    private final double _real;
    private final double _imaginary;
    private final double _modulus;
    private final double _argument;

    /**
     * Create an instance of a {@see Complex} number
     * using cartesian coordinates.
     * @param real      Real part of the {@see Complex} number.
     * @param imaginary Imaginary part of the {@see Complex} number.
     */
    public Complex(final double real, final double imaginary) {
        this._real = real;
        this._imaginary = imaginary;
        this._modulus = this._getModulus(); // Compute the Modulus and Argument,
        this._argument = this._getArgument(); // for easier access.
    }

    /**
     * Returns the
     * <a href="http://en.wikipedia.org/wiki/Arg_(mathematics)#Principal_value">principal</a>
     * <a href="http://en.wikipedia.org/wiki/Arg_%28mathematics%29">argument</a>
     * of this complex value.
     * @return The principal argument of this complex value.
     */
    public double getArgument() {
        return this._argument;
    }

    /**
     * Returns the
     * <a href="http://en.wikipedia.org/wiki/Arg_(mathematics)#Principal_value">principal</a>
     * <a href="http://en.wikipedia.org/wiki/Arg_%28mathematics%29">argument</a>
     * of this complex value shifted by 2·Pi · the specified rotations.
     * @return The argument of this complex value.
     */
    public double getArgument(final int rotations) {
        return this._argument + 2.0 * Math.PI * rotations;
    }

    /**
     * Gets the
     * <a href="http://en.wikipedia.org/wiki/Imaginary_part">imaginary</a>
     * part of this {@see Complex} number.
     * @return The imaginary part.
     */
    public double getImaginary() {
        return this._imaginary;
    }

    /**
     * Gets the
     * <a href="http://en.wikipedia.org/wiki/Absolute_value#Complex_numbers">
     * modulus</a> of this {@see Complex} number.
     * @return The modulus.
     */
    public double getModulus() {
        return this._modulus;
    }

    /**
     * Gets the <a href="http://en.wikipedia.org/wiki/Real_part">real part</a>
     * of this {@see Complex} number.
     * @return The real part.
     */
    public double getReal() {
        return this._real;
    }

    /**
     * Returns this {@see Complex} number modified to have the specified
     * <a href="http://en.wikipedia.org/wiki/Arg_%28mathematics%29">argument</a>.
     * @param argument Argument.
     * @return         {@see Complex} number.
     */
    public Complex setArgument(final double argument) {
        return Complex.Polar(this._modulus, argument);
    }

    /**
     * Returns this {@see Complex} number modified by having the specified
     * <a href="http://en.wikipedia.org/wiki/Imaginary_part">imaginary</a> value.
     * @param imaginary Imaginary value.
     * @return          {@see Complex} number.
     */
    public Complex setImaginary(final double imaginary) {
        return new Complex(this._real, imaginary);
    }

    /**
     * Returns this {@see Complex} number modified to have the specified
     * <a href="http://en.wikipedia.org/wiki/Absolute_value#Complex_numbers">
     * modulus</a>.
     * @param modulus Modulus.
     * @return        {@see Complex} number.
     */
    public Complex setModulus(final double modulus) {
        return Complex.Polar(modulus, this._argument);
    }

    /**
     * Returns this {@see Complex} number modified by having the specified
     * <a href="http://en.wikipedia.org/wiki/Real_part">real</a> value.
     * @param real Real value.
     * @return     {@see Complex} number.
     */
    public Complex setReal(final double real) {
        return new Complex(real, this._imaginary);
    }

    public Complex Add(final Complex value) {
        return new Complex(this._real + value._real,
                this._imaginary + value._imaginary);
    }

    public Complex Conjugate() {
        return new Complex(this._real, -this._imaginary);
    }

    public Complex Divide(final Complex denominator) {
        if (Complex.isOrigin(denominator))
            throw new ArithmeticException("Attempt to divide by complex origo.");
        return this.Multiply(denominator.Inverse());
    }

    public Complex Inverse() {
        if (Complex.isNaN(this))
            return Complex.NaN;
        if (Complex.isInfinite(this))
            return Complex.Origin;
        if (Complex.isOrigin(this))
            return Complex.Infinity;
        return new Complex(Math.cos(this._argument) / this._modulus,
                -Math.sin(this._argument) / this._modulus);
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

    /**
     * The constant {@see Complex} value
     * <a href="http://en.wikipedia.org/wiki/Infinity#Complex_analysis">infinity</a>.
     */
    public static final Complex Infinity =
            new Complex(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);

    /**
     * The constant {@see Complex} value
     * <a href="http://en.wikipedia.org/wiki/Origin_%28mathematics%29">origin</a>.
     */
    public static final Complex Origin = new Complex(0.0, 0.0);

    /**
     * The constant {@see Complex} value
     * <a href="http://en.wikipedia.org/wiki/NaN">NaN (Not a Number)</a>.
     */
    public static final Complex NaN = new Complex(Double.NaN, Double.NaN);

    public static Complex Polar(final double modulus, final double argument) {
        return new Complex(modulus * Math.cos(argument),
                modulus * Math.sin(argument));
    }

    /**
     * Returns true if the {@see Complex} number is
     * <a href="http://en.wikipedia.org/wiki/Infinity#Complex_analysis">infinite</a>.
     * @param complex Complex number.
     * @return        True if the complex number is infinite.
     */
    public static boolean isInfinite(final Complex complex) {
        return complex != null &&
                !Complex.isNaN(complex) &&
                Double.isInfinite(complex._modulus);
    }

    /**
     * Returns true if the {@see Complex} number is the complex
     * <a href="http://en.wikipedia.org/wiki/Origin_%28mathematics%29">origin</a>.
     * @param complex Complex number.
     * @return        True if the complex number is the complex origin.
     */
    public static boolean isOrigin(final Complex complex) {
        return complex != null && complex._modulus == 0.0;
    }

    /**
     * Returns true if the {@see Complex} number is the complex
     * <a href="http://en.wikipedia.org/wiki/NaN">NaN</a>.
     * @param complex Complex number.
     * @return        True if the complex number is the complex NaN.
     */
    public static boolean isNaN(final Complex complex) {
        return complex != null &&
                (Double.isNaN(complex._real) ||
                Double.isNaN(complex._imaginary));
    }

    private double _getArgument() {
        if (Complex.isNaN(this) ||
                Complex.isInfinite(this) ||
                Complex.isOrigin(this))
            return Double.NaN;
        double argument = Math.atan2(this._real, this._imaginary);
        return argument;
    }

    private double _getModulus() {
        double value = Math.max(Math.abs(this._real), Math.abs(this._imaginary));
        if (Double.isNaN(value) || Double.isInfinite(value) || value == 0.0)
            return value;
        double real = this._real / value;
        double imaginary = this._imaginary / value;
        return Math.sqrt(real * real + imaginary * imaginary) * value;
    }
}