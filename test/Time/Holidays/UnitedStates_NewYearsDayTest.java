/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Time.Holidays;

import Time.Holidays.UnitedStates.NewYearsDay;
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
 * jUnit test for the class Time.Holidays.UnitedStates.NewYearsDay.
 * @author Rune Dahl Iversen
 */
public class UnitedStates_NewYearsDayTest {
    private NewYearsDay _instance;
    private LinkedList<Integer> _years;
    private HashMap<Integer, GregorianCalendar> _newYearsDayUnitedStates;

    public UnitedStates_NewYearsDayTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Time.Holidays.UnitedStates.NewYearsDay");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._instance = new NewYearsDay();
        this._years = new LinkedList<Integer>();
        for (int year = 1974; year < 2021; year++)
            this._years.add(year);
        this._newYearsDayUnitedStates = new HashMap<Integer, GregorianCalendar>();
        for (int year : this._years) {
            GregorianCalendar christmasDayUnitedStates = new GregorianCalendar(year, 0, 1);
            switch (year){
                case 1978:
                case 1984:
                case 1989:
                case 1995:
                case 2006:
                case 2012:
                case 2017:
                    christmasDayUnitedStates.add(GregorianCalendar.DATE, 1);
            }
            this._newYearsDayUnitedStates.put(year, christmasDayUnitedStates);
        }
    }

    @After
    public void tearDown() {
        this._instance = null;
        this._years = null;
        this._newYearsDayUnitedStates = null;
    }

    /**
     * Test of getHoliday method, of class NewYearsDayUnitedStates.
     */
    @Test
    public void testGetHoliday() {
        System.out.println("getHoliday");
        AnnuallyRecurring<GregorianCalendar> instance = this._instance;
        for (int year : this._years)
        {
            GregorianCalendar expResult = this._newYearsDayUnitedStates.get(year);
            GregorianCalendar result = instance.getHoliday(year);
            assertEquals("Wrong New Year's day computed for the year " +
                    Integer.toString(year), expResult, result);
        }
    }

    /**
     * Test of occurs method, of class NewYearsDayUnitedStates.
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
     * Test of isHoliday method, of class NewYearsDayUnitedStates.
     */
    @Test
    public void testIsHoliday() {
        System.out.println("isHoliday");
        Holiday<GregorianCalendar> instance = this._instance;
        for (GregorianCalendar dateTime = new GregorianCalendar(1974, 0, 1);
        dateTime.get(GregorianCalendar.YEAR) < 2021;
        dateTime.add(GregorianCalendar.DATE, 1)) {
            boolean expResult = this._newYearsDayUnitedStates.containsValue(dateTime);
            boolean result = instance.isHoliday(dateTime);
            assertEquals("Wrong result from isHoliday(" + dateTime.toString() + ")",
                    expResult, result);
        }
    }

    /**
     * Test of isHoliday method, of class NewYearsDayUnitedStates, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testIsHoliday_Null() {
        System.out.println("isHoliday(null)");
        GregorianCalendar dateTime = null;
        Holiday<GregorianCalendar> instance = this._instance;
        instance.isHoliday(dateTime);
    }
}
