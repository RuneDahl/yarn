/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Constraint;

import Mathematics.Matrix.Matrix;
import Mathematics.Vector.Vector;

/**
 * Abstract implementation of one or more
 * <a href="http://en.wikipedia.org/wiki/Affine_transformation">affine</a>
 * {@see Constraint constraint(s)} on a {@see Vector vector} of
 * {@see Double doubles}.
 * <br>The constraint(s) is/are defined by the function:<br>
 * Matrix*value + Vector, where<br>
 * * is the product of a {@see Matrix matrix} and a vector, and<br>
 * + is the sum operator for 2 vectors.<br>
 * @author Rune Dahl Iversen
 */
public abstract class Affine implements Constraint<Vector<Double>> {
    private Matrix<Double> _matrix;
    private Vector<Double> _vector;

    /**
     * Creates an instance of an affine constraint
     * using the specified matrix and vector.
     * @param matrix Matrix.
     * @param vector Vector.
     * @throws NullPointerException Matrix not properly specified.
     * @throws NullPointerException Vector not properly specified.
     */
    protected Affine(final Matrix<Double> matrix, final Vector<Double> vector) {
        this.setMatrix(matrix);
        this.setVector(vector);
    }

    /**
     * Gets the matrix from this affine constraint.
     * @return Matrix.
     */
    public final Matrix<Double> getMatrix() {
        return _matrix;
    }

    /**
     * Gets the vector from this affine constraint.
     * @return Vector.
     */
    public final Vector<Double> getVector() {
        return _vector;
    }

    /**
     * Sets the matrix for this affine constraint.
     * @param matrix Matrix.
     * @throws NullPointerException Matrix not properly specified.
     */
    public final void setMatrix(final Matrix<Double> matrix) {
        if (matrix == null)
            throw new NullPointerException("Matrix not properly specified.");
        this._matrix = matrix;
    }

    /**
     * Sets the vector for this affine constraint.
     * @param vector Vector.
     * @throws NullPointerException Vector not properly specified.
     */
    public final void setVector(final Vector<Double> vector) {
        if (vector == null)
            throw new NullPointerException("Vector not properly specified.");
        this._vector = vector;
    }

    protected final Vector<Double> _Evaluate(final Vector<Double> value) {
        return this._matrix.product(value).sum(this._vector);
    }
}