/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Function;

import Mathematics.*;

/**
 * Interface for a
 * <a href="http://en.wikipedia.org/wiki/Polynomial">polynomial</a> of finite
 * <a href="http://en.wikipedia.org/wiki/Degree_of_a_polynomial">degree</a>.
 * <br>- It is suggested that any classes implementing Polynomial be implemented
 * as <a href="http://en.wikipedia.org/wiki/Immutable_object">immutable</a>.
 * @author Rune Dahl Iversen
 * @param <TypeOfCoefficient> Type of coefficients in the polynomial.
 * @param <TypeOfInput>       Type of input.
 * @param <TypeOfOutput>      Type of output.
 */
public interface Polynomial<TypeOfCoefficient, TypeOfInput, TypeOfOutput>
        extends Differentiable<TypeOfInput, TypeOfOutput, TypeOfOutput>,
        Additive<Polynomial<TypeOfCoefficient, TypeOfInput, TypeOfOutput>>,
        Multiplicative<Polynomial<TypeOfCoefficient, TypeOfInput, TypeOfOutput>>,
        Scaleable<TypeOfCoefficient,
        Polynomial<TypeOfCoefficient, TypeOfInput, TypeOfOutput>> {
    /**
     * Gets the
     * <a href="http://en.wikipedia.org/wiki/Coefficient">coefficient</a>
     * of this polynomial for the specified
     * <a href="http://en.wikipedia.org/wiki/Degree_of_a_polynomial">degree</a>.
     * @param degree Degree.
     * @return       The coefficient.
     */
    public TypeOfCoefficient getCoefficient(final int degree);

    /**
     * Gets the
     * <a href="http://en.wikipedia.org/wiki/Degree_of_a_polynomial">degree</a>
     * of this polynomial, i.e. the maximum power the input
     * is raised to during the computation of the value.
     * @return The degree of this polynomial.
     */
    public int getDegree();

    /**
     * Returns a polynomial of the same degree but with the coefficient of
     * the specified
     * <a href="http://en.wikipedia.org/wiki/Degree_of_a_polynomial">degree</a>
     * set to the value.
     * @param degree Degree.
     * @param value  Value
     * @return       Modified polynomial.
     */
    public Polynomial<TypeOfCoefficient, TypeOfInput, TypeOfOutput>
            setCoefficient(final int degree, TypeOfCoefficient value);
}