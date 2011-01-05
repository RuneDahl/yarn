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
 * jUnit-test for the class Mathematics.Result.SuccessWithValue.
 * @author Rune Dahl Iversen
 */
public class SuccessWithValueTest {
    private SuccessWithValue<Double> _result;

    public SuccessWithValueTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Mathematics.Result.SuccessWithValue");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._result = new SuccessWithValue<Double>(7.3);
    }

    @After
    public void tearDown() {
        this._result = null;
    }

    /**
     * Test of getResult method, of class SuccessWithValue.
     */
    @Test
    public void testGetResult() {
        System.out.println("getResult");
        SuccessWithValue<Double> instance = this._result;
        Double expResult = 7.3;
        Double result = instance.getResult();
        assertEquals(expResult, result, 0.0);
    }

}