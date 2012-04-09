/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Validation;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * jUnit test for the class Validation.StringNotWhitespace.
 * @author Rune Dahl Iversen
 */
public class StringNotWhitespaceTest {
    private StringNotWhitespace _instance;
    private ValidatorTest<String> _tester;
    
    public StringNotWhitespaceTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Validation.StringNotWhitespace");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }
    
    @Before
    public void setUp() {
        this._instance = new StringNotWhitespace();
        this._tester = new ValidatorTest<String>();
    }
    
    @After
    public void tearDown() {
        this._instance = null;
        this._tester = null;
    }

    /**
     * Test of isValid method, of class StringNotWhitespace.
     */
    @Test
    public void testIsValid() {
        System.out.println("isValid");
        Validator<String> instance = this._instance;

        this._tester.testIsValid(instance, null, false);
        this._tester.testIsValid(instance, "", false);
        this._tester.testIsValid(instance, " ", false);
        this._tester.testIsValid(instance, "\t", false);
        this._tester.testIsValid(instance, "Valid", true);
    }

    /**
     * Test of message method, of class StringNotWhitespace.
     */
    @Test
    public void testMessage() {
        System.out.println("message");
        Validator<String> instance = this._instance;
        
        this._tester.testMessage(instance, null, "Null", "Null is entirely whitespace.");
        this._tester.testMessage(instance, "", "Empty string", "Empty string is entirely whitespace.");
        this._tester.testMessage(instance, " ", "Whitespace", "Whitespace is entirely whitespace.");
        this._tester.testMessage(instance, "\t", "Tab", "Tab is entirely whitespace.");
        this._tester.testMessage(instance, "Valid", "Valid", "");
    }
}
