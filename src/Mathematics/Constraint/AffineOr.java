/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Constraint;

import Mathematics.Matrix.Matrix;
import Mathematics.Vector.Vector;

/**
 * Implementation of one or more
 * <a href="http://en.wikipedia.org/wiki/Affine_transformation">affine</a>
 * {@see Constraint constraint(s)} on a {@see Vector vector} of
 * {@see Double doubles} composed using 'logical or'.
 * <br>The constraint(s) is/are defined by the relation:<br>
 * Matrix*value + Vector >= 0, where<br>
 * * is the product of a {@see Matrix matrix} and a vector,<br>
 * + is the sum operator for 2 vectors, and<br>
 * >= is 'the at least one value in the vector must be greater than
 * or equal to the specified right-hand side value' operator.
 * @author Rune Dahl Iversen
 */
public final class AffineOr extends Affine {
    /**
     * Creates an instance of an affine or constraint
     * using the specified matrix and vector.
     * @param matrix Matrix.
     * @param vector Vector.
     */
    public AffineOr(final Matrix<Double> matrix, final Vector<Double> vector) {
        super(matrix, vector);
    }

    @Override
    public boolean isBinding(final Vector<Double> value) {
        Vector<Double> eval = this._Evaluate(value);
        for (int dim = eval.getFirstDimension(); dim <= eval.getLastDimension(); dim++)
            if (eval.getValue(dim) != 0.0)
                return false;
        return true;
    }

    @Override
    public boolean isFeasible(final Vector<Double> value) {
        Vector<Double> eval = this._Evaluate(value);
        for (int dim = eval.getFirstDimension(); dim <= eval.getLastDimension(); dim++)
            if (eval.getValue(dim) >= 0.0)
                return true;
        return false;
    }
}