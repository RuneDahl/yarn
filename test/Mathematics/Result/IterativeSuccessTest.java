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
 * jUnit-test of the class Mathematics.Result.IterativeSuccess.
 * @author Rune Dahl Iversen
 */
public class IterativeSuccessTest {
    private IterativeSuccess<Double> _double;
    private IterativeSuccess<Integer> _int;

    public IterativeSuccessTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception { // Intentional
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._double = new IterativeSuccess<Double>(3, 7.0);
        this._int = new IterativeSuccess<Integer>(3, 7);
    }

    @After
    public void tearDown() {
        this._double = null;
        this._int = null;
    }

    /**
     * Test of the constructor for IterativeSucces.
     */
    @Test
    public void testIterativeSucces() {
        System.out.println("IterativeSuccess constructor");

        assertNotNull(this._double);
        assertNotNull(this._int);
    }

    /**
     * Test of getIterations method, of class IterativeSuccess.
     */
    @Test
    public void testGetIterations() {
        System.out.println("getIterations");

        IterativeTest.getIterationsTest(this._double, 3);
        IterativeTest.getIterationsTest(this._int, 3);
    }

    /**
     * Test of getResult method, of class IterativeSuccess.
     */
    @Test
    public void testGetResult() {
        System.out.println("getResult");

        double expectedDouble = 7.0;
        assertEquals(expectedDouble, this._double.getResult(), 0.0);

        int expectedInt = 7;
        assertEquals(expectedInt, (int)this._int.getResult());
    }
}