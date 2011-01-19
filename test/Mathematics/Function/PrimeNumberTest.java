/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Function;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit test for the class Mathematics.Function.PrimeNumber.
 * @author Rune Dahl Iversen
 */
public class PrimeNumberTest {
    private PrimeNumber _instance;

    public PrimeNumberTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Mathematics.Function.PrimeNumber");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._instance = new PrimeNumber();
    }

    @After
    public void tearDown() {
        this._instance = null;
    }

    /**
     * Test of value method, of class PrimeNumber.
     */
    @Test
    public void testValue() {
        System.out.println("value");

        Function<Integer, Boolean> instance = this._instance;
        for (Integer input = -100; input < 102; input++) {
            Boolean expResult = false;
            if (input == 2)
                expResult = true;
            else if (input == 3)
                expResult = true;
            else if (input == 5)
                expResult = true;
            else if (input == 7)
                expResult = true;
            else if (input == 11)
                expResult = true;
            else if (input == 13)
                expResult = true;
            else if (input == 17)
                expResult = true;
            else if (input == 19)
                expResult = true;
            else if (input == 23)
                expResult = true;
            else if (input == 29)
                expResult = true;
            else if (input == 31)
                expResult = true;
            else if (input == 37)
                expResult = true;
            else if (input == 41)
                expResult = true;
            else if (input == 43)
                expResult = true;
            else if (input == 47)
                expResult = true;
            else if (input == 53)
                expResult = true;
            else if (input == 59)
                expResult = true;
            else if (input == 61)
                expResult = true;
            else if (input == 67)
                expResult = true;
            else if (input == 71)
                expResult = true;
            else if (input == 73)
                expResult = true;
            else if (input == 79)
                expResult = true;
            else if (input == 83)
                expResult = true;
            else if (input == 89)
                expResult = true;
            else if (input == 97)
                expResult = true;
            else if (input == 101)
                expResult = true;
            Boolean result = instance.value(input);
            assertEquals("PrimeNumer(" + input.toString() + ")",
                    expResult, result);
        }
    }

    /**
     * Test of value method, of class PrimeNumber, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testValue_Null() {
        System.out.println("value(null)");

        Function<Integer, Boolean> instance = this._instance;
        instance.value(null);
    }
}