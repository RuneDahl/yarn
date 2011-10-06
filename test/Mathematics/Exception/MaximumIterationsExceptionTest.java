/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Exception;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit-test of the class Mathematics.Exception.MaximumIterationsException.
 * @author Rune Dahl Iversen
 */
public class MaximumIterationsExceptionTest {
    private MaximumIterationsException _instance;

    public MaximumIterationsExceptionTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Mathematics.Exception.MaximumIterationsException");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._instance = new MaximumIterationsException("Test message.", 7);
    }

    @After
    public void tearDown() {
        this._instance = null;
    }

    /**
     * Test of empty constructor, of class MaximumIterationsException.
     */
    @Test
    public void testCtor_Empty() {
        System.out.println("ctor()");
        MaximumIterationsException instance = new MaximumIterationsException();
        int expResult = -1;
        int result = instance.getIterations();
        assertEquals("Wrong number of iterations.", expResult, result);

        String expMessage = null;
        String message = instance.getMessage();
        assertEquals("Wrong message.", expMessage, message);
    }

    /**
     * Test of constructor taking only an integer,
     * of class MaximumIterationsException.
     */
    @Test
    public void testCtor_Int() {
        System.out.println("ctor(int)");
        MaximumIterationsException instance = new MaximumIterationsException(7);
        int expResult = 7;
        int result = instance.getIterations();
        assertEquals("Wrong number of iterations.", expResult, result);

        String expMessage = null;
        String message = instance.getMessage();
        assertEquals("Wrong message.", expMessage, message);
    }

    /**
     * Test of constructor taking only a string,
     * of class MaximumIterationsException.
     */
    @Test
    public void testCtor_String() {
        System.out.println("ctor(String)");
        MaximumIterationsException instance = new MaximumIterationsException("Test message.");
        int expResult = -1;
        int result = instance.getIterations();
        assertEquals("Wrong number of iterations.", expResult, result);

        String expMessage = "Test message.";
        String message = instance.getMessage();
        assertEquals("Wrong message.", expMessage, message);
    }

    /**
     * Test of constructor taking only a string,
     * of class MaximumIterationsException.
     */
    @Test
    public void testCtor_String_Int() {
        System.out.println("ctor(String, int)");
        MaximumIterationsException instance = this._instance;
        int expResult = 7;
        int result = instance.getIterations();
        assertEquals("Wrong number of iterations.", expResult, result);

        String expMessage = "Test message.";
        String message = instance.getMessage();
        assertEquals("Wrong message.", expMessage, message);
    }

    /**
     * Test of getIterations method, of class MaximumIterationsException.
     */
    @Test
    public void testGetIterations() {
        System.out.println("getIterations");
        MaximumIterationsException instance = this._instance;
        int expResult = 7;
        int result = instance.getIterations();
        assertEquals(expResult, result);
    }
}
