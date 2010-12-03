/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Function;

import Mathematics.Vector.*;
import Validation.*;
import java.util.Arrays;

/**
 * Implementation of a {@see Polynomial polynomial} with {@see Double real}
 * coefficients, input and scalar.
 * @author Rune Dahl Iversen
 */
public final class PolynomialReal implements Polynomial<Double, Double, Double> {
    private Validator<Double> _validator;
    private double[] _coefficients;

    /**
     * Creates a polynomial of the specified degree with all coefficients
     * set to 0.
     * @param degree Degree.
     */
    public PolynomialReal(final int degree) {
        this(new VectorReal(degree + 1));
    }

    /**
     * Creates a polynomial with the coefficients and degree determined by
     * the array of coefficients.
     * <br>- The degree will be the length of the array minus one.
     * <br>- The coefficient with index i will be the coefficient of the
     * polynomial degree i.
     * @param coefficients Array of coefficients.
     */
    public PolynomialReal(final Double[] coefficients) {
        this._validator = Factory.FiniteReal();
        this._setCoefficients(coefficients);
    }

    /**
     * Creates a polynomial with the coefficients and degree determined by
     * the array of coefficients.
     * <br>- The degree will be the length of the array minus one.
     * <br>- The coefficient with index i will be the coefficient of the
     * polynomial degree i.
     * @param coefficients Array of coefficients.
     */
    public PolynomialReal(final double[] coefficients) {
        this._validator = Factory.FiniteReal();
        Double[] c = new Double[coefficients.length];
        for (int d = 0; d < c.length; d++)
            c[d] = coefficients[d];
        this._setCoefficients(c);
    }

    /**
     * Creates a polynomial with the coefficients and degree determined by
     * the vector of coefficients.
     * <br>- The degree will be determined by the dimensions of the vector.
     * <br>- The value of dimension i will be the coefficient of the
     * polynomial degree i.
     * <br>- The first dimension of the vector must be zero.
     * @param coefficients Vector of coefficients.
     */
    public PolynomialReal(final Vector<Double> coefficients) {
        this(coefficients.toArray());
        if (coefficients.getFirstDimension() != 0)
            throw new IndexOutOfBoundsException("First dimension is not zero 0.");
    }

    public Double getCoefficient(final int degree) {
        return this._coefficients[degree];
    }

    public int getDegree() {
        return this._coefficients.length - 1;
    }

    public Polynomial<Double, Double, Double> setCoefficient(final int degree,
            final Double value) {
        if (degree < 0)
            throw new IllegalArgumentException("The specified degree must be " +
                    "non-negative.");
        if (this.getDegree() < degree)
            throw new IllegalArgumentException("The specified degree must be " +
                    "less than or equal to the degrees of this polynomial.");
        if (!this._validator.isValid(value))
            throw new IllegalArgumentException(
                    this._validator.Message(value, "Value"));
        Double[] coefficients = new Double[this._coefficients.length];
        for (int d = 0; d < this._coefficients.length; d++)
            if (d != degree)
                coefficients[d] = this._coefficients[d];
            else
                coefficients[d] = value;
        return new PolynomialReal(coefficients);
    }

    public Function<Double, Double> getDifferential() {
        Double[] coefficients = new Double[Math.max(this.getDegree() - 1, 1)];
        coefficients[0] = 0.0;
        for (int degree = 1; degree < this.getDegree(); degree++)
            coefficients[degree - 1] = ((double)degree) * this._coefficients[degree];
        return new PolynomialReal(coefficients);
    }

    public Double getDifferential(final Double input) {
        double output = 0.0;
        double value = 1.0;
        for (int degree = 1; degree < this._coefficients.length; degree++)
        {
            output += ((double)degree) * this._coefficients[degree] * value;
            value *= input;
        }
        return output;
    }

    public Double value(final Double input) {
        double value = 0.0;
        for (int degree = this._coefficients.length - 1; 0 <= degree; degree--)
        { // Following the technique on pp. 181-183 of
          // Forman, Acton S.: Numerical Methods That (Usually) Work
          // http://www.amazon.com/Numerical-Methods-that-Work-Spectrum/dp/0883854503/ref=sr_1_2?ie=UTF8&s=books&qid=1291226712&sr=8-2
            value *= input;
            value += this._coefficients[degree];
        }
        return value;
    }

    public Polynomial<Double, Double, Double> sum(
            final Polynomial<Double, Double, Double> value) {
        int degree = Math.max(this.getDegree(), value.getDegree());
        Double[] sums = new Double[degree + 1];
        for (int d = 0; d <= degree; d++)
        {
            sums[d] = 0.0;
            if (d <= this.getDegree())
                sums[d] += this.getCoefficient(d);
            if (d <= value.getDegree())
                sums[d] += value.getCoefficient(d);
        }
        return new PolynomialReal(sums);
    }

    public Polynomial<Double, Double, Double> subtract(
            final Polynomial<Double, Double, Double> value) {
        int degree = Math.max(this.getDegree(), value.getDegree());
        Double[] diffs = new Double[degree + 1];
        for (int d = 0; d <= degree; d++)
        {
            diffs[d] = 0.0;
            if (d <= this.getDegree())
                diffs[d] += this.getCoefficient(d);
            if (d <= value.getDegree())
                diffs[d] -= value.getCoefficient(d);
        }
        return new PolynomialReal(diffs);
    }

    public Polynomial<Double, Double, Double> product(
            final Polynomial<Double, Double, Double> factor) {
        int degree = this.getDegree() + factor.getDegree();
        Double[] products = new Double[degree + 1];
        for (int d = 0; d <= degree; d++)
            products[d] = 0.0;
        for (int d = 0; d <= this.getDegree(); d++)
            for (int i = 0; i <= factor.getDegree(); i++)
                products[d + i] +=
                        this.getCoefficient(d) * factor.getCoefficient(i);
        return new PolynomialReal(products);
    }

    public Polynomial<Double, Double, Double> scale(final Double scalar) {
        int degree = this.getDegree();
        Double[] scales = new Double[degree + 1];
        for (int d = 0; d <= degree; d++)
        {
            scales[d] = 0.0;
            if (d <= this.getDegree())
                scales[d] += this.getCoefficient(d) * scalar;
        }
        return new PolynomialReal(scales);
    }

    @Override
    public boolean equals(final Object o) {
        boolean equals;
        if (o == null)
            equals = false;
        else if (o == this)
            equals = true;
        else if (o instanceof PolynomialReal)
            equals = this.equals((PolynomialReal)o);
        else
            equals = false;
        return equals;
    }

    /**
     * Indicates whether some other PolynomialReal is equal to this.
     * @param function Polynomial.
     * @return         True if the polynomials are equal, else false.
     */
    public boolean equals(final PolynomialReal function) {
        boolean equals;
        if (function == null)
            equals = false;
        else if (function == this)
            equals = true;
        else if (function.getDegree() != this.getDegree())
            equals = false;
        else {
            equals = true;
            for (int degree = 0; degree <= this.getDegree(); degree++)
                equals &= (this.getCoefficient(degree) -
                        function.getCoefficient(degree) == 0);
        }
        return equals;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Arrays.hashCode(this._coefficients);
        return hash;
    }

    @Override
    public String toString() {
        String value = "{PolynomialReal[";
        for (int d = this.getDegree(); 0 <= d; d--) {
            value += (Math.signum(this.getCoefficient(d)) != 1 ? " -" : " +");
            value += Double.toString(Math.abs(this.getCoefficient(d)));
            if (d != 0) {
                value += "*x^" + Integer.toString(d);
            }
        }
        value += "]}";
        return value;
    }

    private void _setCoefficients(final Double[] values) {
        this._coefficients = new double[values.length];
        for (int dim = 0; dim < values.length; dim++)
        {
            if (this._validator.isValid(values[dim]))
                this._coefficients[dim] = values[dim];
            else
                throw new IllegalArgumentException(
                        this._validator.Message(values[dim],
                        "The value of dimension " + Integer.toString(dim)));
        }
    }
}