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
 * jUnit test for the class Validation.StringNotEmpty.
 * @author Rune Dahl Iversen
 */
public class StringNotEmptyTest {
    private StringNotEmpty _instance;
    private ValidatorTest<String> _tester;
    
    public StringNotEmptyTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Validation.StringNotEmpty");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }
    
    @Before
    public void setUp() {
        this._instance = new StringNotEmpty();
        this._tester = new ValidatorTest<String>();
    }
    
    @After
    public void tearDown() {
        this._instance = null;
        this._tester = null;
    }

    /**
     * Test of isValid method, of class StringNotEmpty.
     */
    @Test
    public void testIsValid() {
        System.out.println("isValid");
        StringNotEmpty instance = this._instance;

        this._tester.testIsValid(instance, null, true);
        this._tester.testIsValid(instance, "", false);
        this._tester.testIsValid(instance, " ", true);
        this._tester.testIsValid(instance, "Valid", true);
    }

    /**
     * Test of message method, of class StringNotEmpty.
     */
    @Test
    public void testMessage() {
        System.out.println("message");
        StringNotEmpty instance = this._instance;
        
        this._tester.testMessage(instance, null, "Null", "");
        this._tester.testMessage(instance, "", "Empty string", "Empty string is empty.");
        this._tester.testMessage(instance, " ", "Whitespace", "");
        this._tester.testMessage(instance, "Valid", "Valid", "");
    }
}
