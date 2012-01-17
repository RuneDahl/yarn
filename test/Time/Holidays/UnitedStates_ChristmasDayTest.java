/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Time.Holidays;

import Time.Holidays.UnitedStates.ChristmasDay;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit test for the class Time.Holidays.UnitedStates.ChristmasDay.
 * @author Rune Dahl Iversen
 */
public class UnitedStates_ChristmasDayTest {
    private ChristmasDay _instance;
    private LinkedList<Integer> _years;
    private HashMap<Integer, GregorianCalendar> _christmasDayUnitedStates;

    public UnitedStates_ChristmasDayTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Time.Holidays.UnitedStates.ChristmasDay");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._instance = new ChristmasDay();
        this._years = new LinkedList<Integer>();
        for (int year = 1974; year < 2021; year++)
            this._years.add(year);
        this._christmasDayUnitedStates = new HashMap<Integer, GregorianCalendar>();
        for (int year : this._years) {
            GregorianCalendar christmasDayUnitedStates = new GregorianCalendar(year, 11, 25);
            switch (year){
                case 1977:
                case 1983:
                case 1988:
                case 1994:
                case 2005:
                case 2011:
                case 2016:
                    christmasDayUnitedStates.add(GregorianCalendar.DATE, 1);
            }
            this._christmasDayUnitedStates.put(year, christmasDayUnitedStates);
        }
    }

    @After
    public void tearDown() {
        this._instance = null;
        this._years = null;
        this._christmasDayUnitedStates = null;
    }

    /**
     * Test of getHoliday method, of class ChristmasDayUnitedStates.
     */
    @Test
    public void testGetHoliday() {
        System.out.println("getHoliday");
        AnnuallyRecurring<GregorianCalendar> instance = this._instance;
        for (int year : this._years)
        {
            GregorianCalendar expResult = this._christmasDayUnitedStates.get(year);
            GregorianCalendar result = instance.getHoliday(year);
            assertEquals("Wrong Christmas day computed for the year " +
                    Integer.toString(year), expResult, result);
        }
    }

    /**
     * Test of occurs method, of class ChristmasDayUnitedStates.
     */
    @Test
    public void testOccurs() {
        System.out.println("occurs");
        AnnuallyRecurring<GregorianCalendar> instance = this._instance;
        boolean expResult = true;
        for (int year : this._years) {
            boolean result = instance.occurs(year);
            assertEquals("Wrong answer from occurs(" +
                    Integer.toString(year) + ").", expResult, result);
        }
    }

    /**
     * Test of isHoliday method, of class ChristmasDayUnitedStates.
     */
    @Test
    public void testIsHoliday() {
        System.out.println("isHoliday");
        Holiday<GregorianCalendar> instance = this._instance;
        for (GregorianCalendar dateTime = new GregorianCalendar(1974, 0, 1);
        dateTime.get(GregorianCalendar.YEAR) < 2021;
        dateTime.add(GregorianCalendar.DATE, 1)) {
            boolean expResult = this._christmasDayUnitedStates.containsValue(dateTime);
            boolean result = instance.isHoliday(dateTime);
            assertEquals("Wrong result from isHoliday(" + dateTime.toString() + ")",
                    expResult, result);
        }
    }

    /**
     * Test of isHoliday method, of class ChristmasDayUnitedStates, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testIsHoliday_Null() {
        System.out.println("isHoliday(null)");
        GregorianCalendar dateTime = null;
        Holiday<GregorianCalendar> instance = this._instance;
        instance.isHoliday(dateTime);
    }
}
