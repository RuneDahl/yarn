/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Constraint;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit test for the class Mathematics.Constraint.GreaterThanOrEqualReal.
 * @author Rune Dahl Iversen
 */
public class GreaterThanOrEqualRealTest {
    private ConstraintTest<Double> _constraint;
    private GreaterThanOrEqualReal _instance;
    private LimitBasedTest<Double, Double> _limit;

    public GreaterThanOrEqualRealTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Mathematics.Constraint.GreaterThanOrEqualReal");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._constraint = new ConstraintTest<Double>();
        this._instance = new GreaterThanOrEqualReal(1.4);
        this._limit = new LimitBasedTest<Double, Double>();
    }

    @After
    public void tearDown() {
        this._constraint = null;
        this._instance = null;
        this._limit = null;
    }

    /**
     * Test of getLimit method, of class GreaterThanOrEqualReal.
     */
    @Test
    public void testGetLimit() {
        System.out.println("getLimit");
        GreaterThanOrEqualReal instance = this._instance;
        this._limit.testGetLimit(instance, 1.4);
    }

    /**
     * Test of setLimit method, of class GreaterThanOrEqualReal.
     */
    @Test
    public void testSetLimit() {
        System.out.println("setLimit");
        GreaterThanOrEqualReal instance = this._instance;
        this._limit.testSetLimit(instance, 1.6);
    }

    /**
     * Test of setLimit method, of class GreaterThanOrEqualReal,
     * for the value Double.NaN.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetLimit_NaN() {
        System.out.println("setLimit(Double.NaN)");
        GreaterThanOrEqualReal instance = this._instance;
        this._limit.testSetLimit(instance, Double.NaN);
    }

    /**
     * Test of setLimit method, of class GreaterThanOrEqualReal,
     * for the value Double.NEGATIVE_INFINITY.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetLimit_NegativeInfinity() {
        System.out.println("setLimit(Double.NEGATIVE_INFINITY)");
        GreaterThanOrEqualReal instance = this._instance;
        this._limit.testSetLimit(instance, Double.NEGATIVE_INFINITY);
    }

    /**
     * Test of setLimit method, of class GreaterThanOrEqualReal,
     * for the value Double.POSITIVE_INFINITY.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetLimit_PositiveInfinity() {
        System.out.println("setLimit(Double.POSITIVE_INFINITY)");
        GreaterThanOrEqualReal instance = this._instance;
        this._limit.testSetLimit(instance, Double.POSITIVE_INFINITY);
    }

    /**
     * Test of setLimit method, of class GreaterThanOrEqualReal,
     * for the value null.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetLimit_Null() {
        System.out.println("setLimit(null)");
        GreaterThanOrEqualReal instance = this._instance;
        this._limit.testSetLimit(instance, null);
    }

    /**
     * Test of isBinding method, of class GreaterThanOrEqualReal.
     */
    @Test
    public void testIsBinding() {
        System.out.println("isBinding");
        GreaterThanOrEqualReal instance = this._instance;

        Double value = 1.2;
        boolean expResult = false;
        this._constraint.testIsBinding(instance, value, expResult);
        
        value = 1.4;
        expResult = true;
        this._constraint.testIsBinding(instance, value, expResult);

        value = 1.6;
        expResult = false;
        this._constraint.testIsBinding(instance, value, expResult);
    }

    /**
     * Test of isBinding method, of class GreaterThanOrEqualReal, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testIsBinding_Null() {
        System.out.println("isBinding(null)");
        Double value = null;
        GreaterThanOrEqualReal instance = this._instance;
        this._constraint.testIsBinding(instance, value, false);
    }

    /**
     * Test of isFeasible method, of class GreaterThanOrEqualReal.
     */
    @Test
    public void testIsFeasible() {
        System.out.println("isFeasible");
        GreaterThanOrEqualReal instance = this._instance;

        Double value = 1.2;
        boolean expResult = false;
        this._constraint.testIsFeasible(instance, value, expResult);

        value = 1.4;
        expResult = true;
        this._constraint.testIsFeasible(instance, value, expResult);

        value = 1.6;
        expResult = true;
        this._constraint.testIsFeasible(instance, value, expResult);
    }

    /**
     * Test of isFeasible method, of class GreaterThanOrEqualRealm, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testIsFeasible_Null() {
        System.out.println("isFeasible(null)");
        Double value = null;
        GreaterThanOrEqualReal instance = this._instance;
        this._constraint.testIsFeasible(instance, value, false);
    }
}