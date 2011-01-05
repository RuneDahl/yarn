/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Result;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit-test for the class Mathematics.Result.UnhandledExceptionThrown.
 * @author Rune Dahl Iversen
 */
public class UnhandledExceptionThrownTest {
    UnhandledExceptionThrown _result;

    public UnhandledExceptionThrownTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Mathematics.Result.UnhandledExceptionThrown");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._result = new UnhandledExceptionThrown(new NullPointerException());
    }

    @After
    public void tearDown() {
        this._result = null;
    }

    /**
     * Test of exception thrown when specifying a null value to the constructor
     * of class UnhandledExceptionThrown.
     */
    @Test (expected=NullPointerException.class)
    public void ctor_Null() {
        new UnhandledExceptionThrown(null);
    }

    /**
     * Test of getException method, of class UnhandledExceptionThrown.
     */
    @Test
    public void testGetException() {
        System.out.println("getException");
        UnhandledExceptionThrown instance = this._result;
        Exception result = instance.getException();
        if (result instanceof NullPointerException) {
        }
        else {
            fail("Wrong type of value from getException.");
        }
    }
}