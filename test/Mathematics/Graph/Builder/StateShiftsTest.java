/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Graph.Builder;

import Mathematics.Vector.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit test of the class Mathematics.Graph.Builder.StateShifts.
 * @author Rune Dahl Iversen
 */
public class StateShiftsTest {
    private StateShifts<Vector<Double>> _instance;

    public StateShiftsTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Mathematics.Graph.Builder.StateShifts");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._instance = new StateShifts<Vector<Double>>();
        StateShift<Vector<Double>> additive = new AdditiveDimensionShiftVectorReal(2, 1.0);
        this._instance.add(additive);
        StateShift<Vector<Double>> multiplicative = new MultiplicativeDimensionShiftVectorReal(1, 1.2);
        this._instance.add(multiplicative);
    }

    @After
    public void tearDown() {
        this._instance = null;
    }

    /**
     * Test of value method, of class StateShifts.
     */
    @Test
    public void testValue() {
        System.out.println("value");
        StateShifts<Vector<Double>> instance = this._instance;
        Vector<Double> input = new VectorReal(4, 1.0);
        Vector<Double> expResult = new VectorReal(4, 1.0);
        expResult = expResult.setValue(1, 1.2);
        expResult = expResult.setValue(2, 2.0);
        Vector<Double> result = instance.value(input);
        assertEquals(input.toString(), expResult, result);
    }

    /**
     * Test of value method, of class StateShifts, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testValue_Null() {
        System.out.println("value(null)");
        StateShifts<Vector<Double>> instance = this._instance;
        Vector<Double> input = null;
        instance.value(input);
    }
}
