/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Finance.Yield;

import Time.DayCounting.*;
import Time.Periods.*;
import java.util.GregorianCalendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit test of Finance.Yield.FractionAndConvention.
 * @author Rune Dahl Iversen
 */
public class FractionAndConventionTest {
    private Convention<Double, Double> _convention;
    private Fraction<GregorianCalendar> _fraction;
    private FractionAndConvention<GregorianCalendar> _instance;
    private double _delta;

    public FractionAndConventionTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Finance.Yield.FractionAndConvention");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }
    
    @Before
    public void setUp() {
        this._convention = new ContinuousTime();
        GregorianCalendar anchor = new GregorianCalendar(2000, 0, 1);
        DayCount<GregorianCalendar> denominator = new GregorianActual();
        DayCount<GregorianCalendar> numerator = new GregorianActual();
        Period<GregorianCalendar> period = new GregorianYear(1);
        this._fraction = new GregorianPeriodFractionWithAnchor(
                numerator, denominator, period, anchor);
        this._instance = new FractionAndConvention<GregorianCalendar>(
                this._convention, this._fraction);

        this._delta = Math.pow(10.0, -12.0);
    }
    
    @After
    public void tearDown() {
        this._convention = null;
        this._fraction = null;
        this._instance = null;
    }

    /**
     * Test of getConvention method, of class FractionAndConvention.
     */
    @Test
    public void testGetConvention() {
        System.out.println("getConvention");
        FractionAndConvention<GregorianCalendar> instance = this._instance;
        Convention result = instance.getConvention();
        assertTrue(result instanceof ContinuousTime);
    }

    /**
     * Test of setConvention method, of class FractionAndConvention.
     */
    @Test
    public void testSetConvention() {
        System.out.println("setConvention");
        Convention<Double, Double> convention = new CompoundTime(1.0);
        FractionAndConvention instance = this._instance;
        assertNotSame("Pre-condition for testing setConvention is violated.",
                convention, instance.getConvention());
        instance.setConvention(convention);
        Convention<Double, Double> result = instance.getConvention();
        assertEquals(convention, result);
    }

    /**
     * Test of setConvention method, of class FractionAndConvention,
     * for the value null.
     */
    @Test (expected=NullPointerException.class)
    public void testSetConvention_Null() {
        System.out.println("setConvention(null)");
        Convention<Double, Double> convention = null;
        FractionAndConvention instance = this._instance;
        instance.setConvention(convention);
    }

    /**
     * Test of getFraction method, of class FractionAndConvention.
     */
    @Test
    public void testGetFraction() {
        System.out.println("getFraction");
        FractionAndConvention instance = this._instance;
        Fraction result = instance.getFraction();
        assertTrue(result instanceof GregorianPeriodFractionWithAnchor);
    }

    /**
     * Test of setFraction method, of class FractionAndConvention.
     */
    @Test
    public void testSetFraction() {
        System.out.println("setFraction");
        GregorianCalendar anchor = new GregorianCalendar(2000, 0, 1);
        DayCount<GregorianCalendar> denominator = new GregorianActual();
        DayCount<GregorianCalendar> numerator = new GregorianUS30();
        Period<GregorianCalendar> period = new GregorianYear(1);
        Fraction<GregorianCalendar> fraction = new GregorianPeriodFractionWithAnchor(
                numerator, denominator, period, anchor);
        FractionAndConvention instance = this._instance;
        assertNotSame("Pre-codition for testing setFration is violated.",
                fraction, instance.getFraction());
        instance.setFraction(fraction);
        Fraction<GregorianCalendar> result = instance.getFraction();
        assertSame(fraction, result);
    }

    /**
     * Test of setFraction method, of class FractionAndConvention,
     * for the value null.
     */
    @Test (expected=NullPointerException.class)
    public void testSetFraction_Null() {
        System.out.println("setFraction(null)");
        Fraction<GregorianCalendar> fraction = null;
        FractionAndConvention instance = this._instance;
        instance.setFraction(fraction);
    }

    /**
     * Test of getName method, of class FractionAndConvention.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        FractionAndConvention instance = this._instance;
        String expResult = "Continuous(Act/Act)";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class FractionAndConvention.
     */
    @Test
    public void testGetName_2() {
        System.out.println("getName");
        FractionAndConvention instance = this._instance;
        PeriodFractionWithAnchor<GregorianCalendar> fraction =
                (PeriodFractionWithAnchor)instance.getFraction();
        fraction.setDenominator(new GregorianActual());
        String expResult = "Continuous(Act/Act)";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class FractionAndConvention.
     */
    @Test
    public void testGetName_3() {
        System.out.println("getName");
        FractionAndConvention instance = this._instance;
        instance.setConvention(new CompoundTime(1.0));
        String expResult = "Compound(1.0)(Act/Act)";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of discountFactor method, of class FractionAndConvention.
     */
    @Test
    public void testDiscountFactor() {
        System.out.println("discountFactor");
        GregorianCalendar start = new GregorianCalendar(2000, 0, 1);
        GregorianCalendar end = new GregorianCalendar(2010, 0, 1);
        double yield = 0.01;
        FractionAndConvention instance = this._instance;
        double expResult = Math.exp(-0.1);
        double result = instance.discountFactor(start, end, yield);
        assertEquals(expResult, result, this._delta);
    }

    /**
     * Test of time method, of class FractionAndConvention.
     */
    @Test
    public void testTime() {
        System.out.println("time");
        double discountFactor = Math.exp(-0.1);
        double yield = 0.01;
        FractionAndConvention instance = this._instance;
        Double expResult = 10.0;
        Double result = instance.time(discountFactor, yield);
        assertEquals(expResult, result, this._delta);
    }

    /**
     * Test of yield method, of class FractionAndConvention.
     */
    @Test
    public void testYield() {
        System.out.println("yield");
        double discountFactor = Math.exp(-0.1);
        GregorianCalendar start = new GregorianCalendar(2000, 0, 1);
        GregorianCalendar end = new GregorianCalendar(2010, 0, 1);
        FractionAndConvention instance = this._instance;
        double expResult = 0.01;
        double result = instance.yield(discountFactor, start, end);
        assertEquals(expResult, result, this._delta);
    }
}
