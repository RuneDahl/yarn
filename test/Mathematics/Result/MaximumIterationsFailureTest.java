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
 * jUnit-test for the class Mathematics.Result.MaximumIterationsFailure.
 * @author Rune Dahl Iversen
 */
public class MaximumIterationsFailureTest {
    private MaximumIterationsFailure _result;

    public MaximumIterationsFailureTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        this._result = new MaximumIterationsFailure(3);
    }

    @After
    public void tearDown() {
        this._result = null;
    }

    @Test
    public void testMaximumIterationsFailure() {
        System.out.println("Iterations");

        assertNotNull(this._result);
    }

    @Test
    public void testIterations() {
        System.out.println("Iterations");

        IterativeTest.getIterationsTest(_result, 3);
    }
}