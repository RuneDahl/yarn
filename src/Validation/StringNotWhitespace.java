/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Validation;

/**
 * {@see Validator} not allowing a {@see String string} consisting solely of
 * <a href="http://en.wikipedia.org/wiki/Whitespace_character">whitespace</a>.
 * @author Rune Dahl Iversen
 */
public class StringNotWhitespace implements Validator<String> {
    /**
     * Create an instance of a validator not allowing a string consisting
     * solely of whitespace.
     */
    public StringNotWhitespace() {
    }
    
    @Override
    public boolean isValid(final String value) {
        return (value != null && !"".equals(value.trim()));
    }

    @Override
    public String message(final String value, final String name) {
        if (this.isValid(value))
            return "";
        else
            return name + " is entirely whitespace.";
    }
}
