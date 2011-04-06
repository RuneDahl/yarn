/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Interpolation.DataIdentification;

import Mathematics.Interval;
import Mathematics.IntervalReal;
import java.util.HashSet;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit test for the class
 * Mathematics.Interpolation.DataIdentification.IntervalFinderReal.
 * @author Rune Dahl Iversen
 */
public class IntervalFinderRealTest {
    private Set<Double> _data;
    private Set<Double> _empty;
    private IntervalFinderReal _instance;

    public IntervalFinderRealTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Mathematics.Interpolation.DataIdentification.IntervalFinderReal");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._data = new HashSet<Double>();
        this._data.add(0.0);
        this._data.add(1.0);
        this._data.add(2.0);
        this._data.add(1.5);
        this._data.add(3.0);
        this._empty = new HashSet<Double>();
        this._instance = new IntervalFinderReal();
    }

    @After
    public void tearDown() {
        this._data = null;
        this._empty = null;
        this._instance = null;
    }

    /**
     * Test of getNeighbors method, of class IntervalFinderReal.
     */
    @Test
    public void testGetNeighbors() {
        System.out.println("getNeighbors");
        double value = 0.0;
        Iterable<Double> data = this._data;
        IntervalFinderReal instance = this._instance;
        Interval<Double> expResult = new IntervalReal(
                0.0, Interval.EndType.Includes, 0.0, Interval.EndType.Includes);
        Interval<Double> result = instance.getNeighbors(value, data);
        assertEquals("Wrong interval from method getNeighbors.",
                expResult, result);

        value = 2.5;
        expResult = new IntervalReal(
                2.0, Interval.EndType.Includes, 3.0, Interval.EndType.Includes);
        result = instance.getNeighbors(value, data);
        assertEquals("Wrong interval from method getNeighbors.",
                expResult, result);


        value = 3.5;
        expResult = new IntervalReal(
                2.0, Interval.EndType.Includes, 3.0, Interval.EndType.Includes);
        result = instance.getNeighbors(value, data);
        assertEquals("Wrong interval from method getNeighbors.",
                expResult, result);
    }

    /**
     * Test of getNeighbors method, of class IntervalFinderReal
     * for an empty dataset.
     */
    @Test (expected=ArithmeticException.class)
    public void testGetNeighbors_DataEmpty() {
        System.out.println("getNeighbors(v, empty dataset)");
        double value = 0.0;
        Iterable<Double> data = this._empty;
        IntervalFinderReal instance = this._instance;
        instance.getNeighbors(value, data);
    }

    /**
     * Test of getNeighbors method, of class IntervalFinderReal,
     * for a null dataset.
     */
    @Test (expected=NullPointerException.class)
    public void testGetNeighbors_DataNull() {
        System.out.println("getNeighbors(v, null)");
        double value = 0.0;
        Iterable<Double> data = null;
        IntervalFinderReal instance = this._instance;
        instance.getNeighbors(value, data);
    }
}
