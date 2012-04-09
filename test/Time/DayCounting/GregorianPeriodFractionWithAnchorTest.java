/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Time.DayCounting;

import Time.Periods.*;
import java.util.GregorianCalendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit test for the class Time.DayCounting.GregorianPeriodFractionWithAnchor.
 * @author Rune Dahl Iversen
 */
public class GregorianPeriodFractionWithAnchorTest {
    private GregorianPeriodFractionWithAnchor _instance;
    private DayCount<GregorianCalendar> _numerator;
    private DayCount<GregorianCalendar> _denominator;
    
    public GregorianPeriodFractionWithAnchorTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Time.DayCounting.GregorianPeriodFractionWithAnchor");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }
    
    @Before
    public void setUp() {
        this._numerator = new GregorianActual();
        this._denominator = new GregorianEuro30();
        GregorianCalendar anchor = new GregorianCalendar(2000, 0, 1);
        Period<GregorianCalendar> period = new GregorianYear(1);
        this._instance = new GregorianPeriodFractionWithAnchor(
                this._numerator, this._denominator, period, anchor);
    }
    
    @After
    public void tearDown() {
        this._instance = null;
        this._numerator = null;
        this._denominator = null;
    }
    
    /**
     * Test of getAnchor method, of class GregorianPeriodFractionWithAnchor.
     */
    @Test
    public void testGetAnchor() {
        System.out.println("getAnchor");
        PeriodFractionWithAnchor<GregorianCalendar> instance = this._instance;
        GregorianCalendar expResult = new GregorianCalendar(2000, 0, 1);
        GregorianCalendar result = instance.getAnchor();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAnchor method, of class GregorianPeriodFractionWithAnchor.
     */
    @Test
    public void testSetAnchor() {
        System.out.println("setAnchor");
        GregorianCalendar expResult = new GregorianCalendar(2000, 0, 1);
        PeriodFractionWithAnchor<GregorianCalendar> instance = this._instance;
        assertFalse("Precondition for testing setAnchor is violated.", 
                expResult == instance.getAnchor());
        instance.setAnchor(expResult);
        GregorianCalendar result = instance.getAnchor();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAnchor method, of class GregorianPeriodFractionWithAnchor,
     * for the value null.
     */
    @Test (expected = NullPointerException.class)
    public void testSetAnchor_Null() {
        System.out.println("setAnchor(null)");
        PeriodFractionWithAnchor<GregorianCalendar> instance = this._instance;
        GregorianCalendar anchor = null;
        instance.setAnchor(anchor);
    }

    /**
     * Test of getDenominator method, of class GregorianPeriodFractionWithAnchor.
     */
    @Test
    public void testGetDenominator() {
        System.out.println("getDenominator");
        PeriodFractionWithAnchor<GregorianCalendar> instance = this._instance;
        DayCount<GregorianCalendar> result = instance.getDenominator();
        assertNotNull(result);
        assertTrue(result instanceof GregorianEuro30);
    }

    /**
     * Test of setDenominator method, of class GregorianPeriodFractionWithAnchor.
     */
    @Test
    public void testSetDenominator() {
        System.out.println("setDenominator");
        DayCount<GregorianCalendar> expResult = new GregorianActual();
        PeriodFractionWithAnchor<GregorianCalendar> instance = this._instance;
        assertFalse("Precondition for testing setDenominator is violated.", 
                instance.getDenominator() instanceof GregorianActual);
        instance.setDenominator(expResult);
        DayCount<GregorianCalendar> result = instance.getDenominator();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDenominator method, of class GregorianPeriodFractionWithAnchor,
     * for the value null.
     */
    @Test (expected = NullPointerException.class)
    public void testSetDenominator_Null() {
        System.out.println("setDenominator(null)");
        PeriodFractionWithAnchor<GregorianCalendar> instance = this._instance;
        DayCount<GregorianCalendar> denominator = null;
        instance.setDenominator(denominator);
    }

    /**
     * Test of getName method, of class GregorianPeriodFractionWithAnchor.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Fraction<GregorianCalendar> instance = this._instance;
        String expResult = "Act/360";
        String result = instance.getName();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getNumerator method, of class GregorianPeriodFractionWithAnchor.
     */
    @Test
    public void testGetNumerator() {
        System.out.println("getNumerator");
        PeriodFractionWithAnchor<GregorianCalendar> instance = this._instance;
        DayCount<GregorianCalendar> result = instance.getNumerator();
        assertNotNull(result);
        assertTrue(result instanceof GregorianActual);
    }

    /**
     * Test of setNumerator method, of class GregorianPeriodFractionWithAnchor.
     */
    @Test
    public void testSetNumerator() {
        System.out.println("setNumerator");
        DayCount<GregorianCalendar> expResult = new GregorianEuro30();
        PeriodFractionWithAnchor<GregorianCalendar> instance = this._instance;
        assertFalse("Precondition for testing setNumerator is violated.", 
                instance.getNumerator() instanceof GregorianEuro30);
        instance.setNumerator(expResult);
        DayCount<GregorianCalendar> result = instance.getNumerator();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNumerator method, of class GregorianPeriodFractionWithAnchor,
     * for the value null.
     */
    @Test (expected = NullPointerException.class)
    public void testSetNumerator_Null() {
        System.out.println("setNumerator(null)");
        PeriodFractionWithAnchor<GregorianCalendar> instance = this._instance;
        DayCount<GregorianCalendar> numerator = null;
        instance.setNumerator(numerator);
    }

    /**
     * Test of getPeriod method, of class GregorianPeriodFractionWithAnchor.
     */
    @Test
    public void testGetPeriod() {
        System.out.println("getPeriod");
        PeriodFractionWithAnchor<GregorianCalendar> instance = this._instance;
        Period<GregorianCalendar> result = instance.getPeriod();
        assertNotNull(result);
        assertTrue(result instanceof GregorianYear);
        GregorianYear gy = (GregorianYear)result;
        int expResult = 1;
        assertEquals(expResult, gy.getCount());
    }

    /**
     * Test of setPeriod method, of class GregorianPeriodFractionWithAnchor.
     */
    @Test
    public void testSetPeriod() {
        System.out.println("setPeriod");
        Period<GregorianCalendar> expResult = new GregorianMonth(1);
        PeriodFractionWithAnchor<GregorianCalendar> instance = this._instance;
        assertFalse("Precondition for testing setPeriod is violated.", 
                instance.getPeriod() instanceof GregorianMonth);
        instance.setPeriod(expResult);
        Period<GregorianCalendar> result = instance.getPeriod();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPeriod method, of class GregorianPeriodFractionWithAnchor,
     * for the value null.
     */
    @Test (expected = NullPointerException.class)
    public void testSetPeriod_Null() {
        System.out.println("setPeriod(null)");
        PeriodFractionWithAnchor<GregorianCalendar> instance = this._instance;
        Period<GregorianCalendar> period = null;
        instance.setPeriod(period);
    }

    /**
     * Test of getTime method, of class GregorianPeriodFractionWithAnchor.
     */
    @Test
    public void testGetTime() {
        System.out.println("getTime([2000, 0, 1] -> [2001, 0, 1])");
        GregorianCalendar start = new GregorianCalendar(2000, 0, 1);
        GregorianCalendar end = new GregorianCalendar(2001, 0 ,1);
        Fraction<GregorianCalendar> instance = this._instance;
        double expResult = 366.0 / 360;
        double result = instance.getTime(start, end);
        assertEquals(expResult, result, 0.0);
    }

   /**
     * Test of getTime method, of class GregorianPeriodFractionWithAnchor.
     */
    @Test
    public void testGetTime_Half() {
        System.out.println("getTime([2000, 0, 1] -> [2000, 5, 29])");
        GregorianCalendar start = new GregorianCalendar(2000, 0 ,1);
        GregorianCalendar end = new GregorianCalendar(2000, 5, 29);
        Fraction<GregorianCalendar> instance = this._instance;
        double expResult = 0.5;
        double result = instance.getTime(start, end);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getTime method, of class GregorianPeriodFractionWithAnchor.
     */
    @Test
    public void testGetTime_NegativeOne() {
        System.out.println("getTime([2001, 0, 1] -> [2000, 0, 1])");
        GregorianCalendar start = new GregorianCalendar(2001, 0 ,1);
        GregorianCalendar end = new GregorianCalendar(2000, 0, 1);
        Fraction<GregorianCalendar> instance = this._instance;
        double expResult = -366.0 / 360;
        double result = instance.getTime(start, end);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getTime method, of class GregorianPeriodFractionWithAnchor.
     */
    @Test
    public void testGetTime_Preceeding() {
        System.out.println("getTime([1995, 0, 1] -> [1996, 0, 1])");
        GregorianCalendar start = new GregorianCalendar(1995, 0 ,1);
        GregorianCalendar end = new GregorianCalendar(1996, 0, 1);
        Fraction<GregorianCalendar> instance = this._instance;
        double expResult = 365.0 / 360;
        double result = instance.getTime(start, end);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getTime method, of class GregorianPeriodFractionWithAnchor.
     */
    @Test
    public void testGetTime_Two() {
        System.out.println("getTime([2000, 0, 1] -> [2002, 0, 1])");
        GregorianCalendar start = new GregorianCalendar(2000, 0, 1);
        GregorianCalendar end = new GregorianCalendar(2002, 0 ,1);
        Fraction<GregorianCalendar> instance = this._instance;
        double expResult = 731.0 / 360.0;
        double result = instance.getTime(start, end);
        assertEquals(expResult, result, 0.0);
    }
}
