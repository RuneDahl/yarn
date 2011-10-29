/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Time.Holidays;

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
 * jUnit test for the class Time.Holidays.boxingDay.
 * @author Rune Dahl Iversen
 */
public class BoxingDayTest {
    private BoxingDay _instance;
    private LinkedList<Integer> _years;
    private HashMap<Integer, GregorianCalendar> _boxingDays;

    public BoxingDayTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Time.Holidays.boxingDay");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._instance = new BoxingDay();
        this._years = new LinkedList<Integer>();
        for (int year = 1974; year < 2021; year++)
            this._years.add(year);
        this._boxingDays = new HashMap<Integer, GregorianCalendar>();
        for (int year : this._years) {
            GregorianCalendar boxingDay = new GregorianCalendar(year, 11, 26);
            switch (year){
                case 1976:
                case 1981:
                case 1982:
                case 1987:
                case 1992:
                case 1993:
                case 1998:
                case 1999:
                case 2004:
                case 2009:
                case 2010:
                case 2015:
                case 2020:
                    boxingDay.add(GregorianCalendar.DATE, 2);
            }
            this._boxingDays.put(year, boxingDay);
        }
    }

    @After
    public void tearDown() {
        this._instance = null;
        this._years = null;
        this._boxingDays = null;
    }

    /**
     * Test of getHoliday method, of class BoxingDay.
     */
    @Test
    public void testGetHoliday() {
        System.out.println("getHoliday");
        AnnuallyRecurring<GregorianCalendar> instance = this._instance;
        for (int year : this._years)
        {
            GregorianCalendar expResult = this._boxingDays.get(year);
            GregorianCalendar result = instance.getHoliday(year);
            assertEquals("Wrong Boxing Day computed for the year " +
                    Integer.toString(year), expResult, result);
        }
    }

    /**
     * Test of occurs method, of class BoxingDay.
     */
    @Test
    public void testOccurs() {
        System.out.println("occurs");
        AnnuallyRecurring<GregorianCalendar> instance = this._instance;
        boolean expResult = true;
        for (int year : this._years) {
            boolean result = instance.occurs(year);
            assertEquals("Wrong answer from BoxingDay.occurs(" +
                    Integer.toString(year) + ").", expResult, result);
        }
    }

    /**
     * Test of isHoliday method, of class BoxingDay.
     */
    @Test
    public void testIsHoliday() {
        System.out.println("isHoliday");
        Holiday<GregorianCalendar> instance = this._instance;
        for (GregorianCalendar dateTime = new GregorianCalendar(1974, 0, 1);
        dateTime.get(GregorianCalendar.YEAR) < 2021;
        dateTime.add(GregorianCalendar.DATE, 1)) {
            boolean expResult = this._boxingDays.containsValue(dateTime);
            boolean result = instance.isHoliday(dateTime);
            assertEquals("Wrong result from isHoliday(" + dateTime.toString() + ")",
                    expResult, result);
        }
    }

    /**
     * Test of isHoliday method, of class BoxingDay, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testIsHoliday_Null() {
        System.out.println("isHoliday(null)");
        GregorianCalendar dateTime = null;
        Holiday<GregorianCalendar> instance = this._instance;
        instance.isHoliday(dateTime);
    }
}
