/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.GoalSeeking;

import Mathematics.Equality.*;
import Mathematics.Function.*;
import Mathematics.Result.Result;

/**
 *
 * @author Rune Dahl Iversen
 */
public class GoalValidatorNull extends GoalSeekFunction<Double, Double, Double> {
    private static final Equals<Double> __criterion = new DoubleAbsolute(0.00001);
    private static final Function<Double, Double> __function =
            new PolynomialReal(3);

    public GoalValidatorNull() {
        super(__criterion, __function, null, 0.0, 0.0);
    }

    @Override
    public Result run() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
