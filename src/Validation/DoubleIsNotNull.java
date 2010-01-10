/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Validation;

/**
 *
 * @author Rune Dahl Iversen
 */
public class DoubleIsNotNull implements Validator<Double> {
    public DoubleIsNotNull() {
    }

    public String Message(Double value, String name) {
        if (this.Validate(value))
            return "";
        else
            return name + " is null.";
    }

    public boolean Validate(Double value) {
        return value != null;
    }
}