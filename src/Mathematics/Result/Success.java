/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Result;

/**
 * Interface for a succesful {@see Result result}.
 * @author Rune Dahl Iversen
 * @param <TypeOfResult> Type of result.
 */
public interface Success<TypeOfResult> extends Result {
    /**
     * Returns the succesfully computed value.
     * @return The succesfully computed value.
     */
    public TypeOfResult getResult();
}