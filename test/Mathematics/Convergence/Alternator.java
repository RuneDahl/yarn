/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Convergence;

/**
 * Mock class to help build a test related to convergence.
 * This criterion will change its mind about convergence each time it is asked.
 * @author Rune Dahl Iversen
 */
public class Alternator<TypeOfValue> implements Criterion<TypeOfValue> {
    private boolean _state;

    public Alternator() {
        this._state = false;
    }

    @Override
    public boolean converges(TypeOfValue[] series) {
        boolean converges = this._state;
        this._state = !this._state;
        return converges;
    }
}