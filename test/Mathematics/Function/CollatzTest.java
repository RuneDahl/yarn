/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Function;

import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit test for the class Mathematics.Function.Collatz.
 * @author Rune Dahl Iversen
 */
public class CollatzTest {
    private Collatz _instance;
    private HashMap<Long, Long> _values;

    public CollatzTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Mathematics.Function.Collatz");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._instance = new Collatz();
        this._values = new HashMap<Long, Long>();
    }

    @After
    public void tearDown() {
        this._instance = null;
        this._values = null;
    }

    /**
     * Test of value method, of class Collatz.
     */
    @Test
    public void testValue() {
        System.out.println("value");
        Collatz instance = this._instance;
        for (long input = 1; input < 100000; input++) {
            Long expResult = (input % 2 == 0 ? input/2 : input*3 + 1);
            Long result = instance.value(input);
            assertEquals("Wrong result for " + Long.toString(input),
                    expResult, result);
        }
    }

    /**
     * Test of value method, of class Collatz, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testValue_Null() {
        System.out.println("value(null)");
        Collatz instance = this._instance;
        Long input = null;
        input = instance.value(input);
    }
}