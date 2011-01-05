/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Norm;

import Mathematics.Complex;

/**
 * An implementation of the
 * <a href="http://en.wikipedia.org/wiki/Maximum_norm">maximum norm</a>
 * for a {@see Complex complex number}.
 * @author Rune Dahl Iversen
 */
public class ComplexMaximum implements Norm<Complex>{
    /**
     * Creates an instance of the
     * <a href="http://en.wikipedia.org/wiki/Maximum_norm">maximum norm</a>
     * for a {@see Complex complex number}.
     */
    public ComplexMaximum() { // Intentional
    }

    @Override
    public Double value(final Complex input) {
        return Math.max(Math.abs(input.getReal()),
                Math.abs(input.getImaginary()));
    }
}