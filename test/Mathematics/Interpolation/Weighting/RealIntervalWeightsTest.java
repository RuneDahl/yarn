/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Interpolation.Weighting;

import Mathematics.Interval;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Methods to facilitate jUnit testing of implementations of
 * Mathematics.Interpolation.Weighting.RealIntervalWeights.
 * @author Rune Dahl Iversen
 */
public class RealIntervalWeightsTest {
    public RealIntervalWeightsTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getWeights method, of class RealIntervalWeights.
     */
    public void testGetWeights(final RealIntervalWeights instance,
            final double target, final Interval<Double> interval,
            Map<Double, Double> expResult) {
        Map<Double, Double> result = instance.getWeights(target, interval);
        assertEquals("Wrong result from instance of " + instance.getClass().getName() +
                " for the value " + Double.toString(target) + " from the interval " +
                interval.toString(), expResult, result);
    }

    /**
     * Blank test to allow this setup.
     */
    @Test
    public void testBlank() {
        assertTrue(true);
    }
}
