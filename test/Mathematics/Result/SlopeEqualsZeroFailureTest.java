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
 * jUnit test of the class Mathematics.Result.SlopeEqualsZeroFailure.
 * @author Rune Dahl Iversen
 */
public class SlopeEqualsZeroFailureTest {
    SlopeEqualsZeroFailure<Double> _result;

    public SlopeEqualsZeroFailureTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Mathematics.Result.SlopeEqualsZeroFailure");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._result = new SlopeEqualsZeroFailure<Double>(1.3);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getValue method, of class SlopeEqualsZeroFailure.
     */
    @Test
    public void testgetValue() {
        Double expResult = 1.3;
        SlopeEqualsZeroFailure<Double> instance = this._result;
        Double result = instance.getValue();
        assertEquals(expResult, result, 0.0);
    }
}