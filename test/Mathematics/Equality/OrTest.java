/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Equality;

import java.util.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit test for the class Mathematics.Equality.Or.
 * @author Rune Dahl Iversen
 */
public class OrTest {
    private Or<Double> _instance;
    private Double[] _values;

    public OrTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Mathematics.Equality.Or<T>");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._instance = new Or<Double>();

        this._instance.add(new DoubleAbsolute(Math.pow(10.0, -6.0)));
        this._instance.add(new DoubleRelative(Math.pow(10.0, -6.0)));

        this._values = new Double[13];
        this._values[0] = 0.0;
        this._values[1] = Math.pow(10.0, -10.0);
        this._values[2] = Math.pow(10.0, -4.0);
        this._values[3] = -Math.pow(10.0, -4.0);
        this._values[4] = 1.0;
        this._values[5] = 1.0 + Math.pow(10.0, -4.0);
        this._values[6] = 1.0 + Math.pow(10.0, -8.0);
        this._values[7] = 1.0 - Math.pow(10.0, -8.0);
        this._values[8] = 1000.0;
        this._values[9] = 1000.0 + Math.pow(10.0, -4.0);
        this._values[10] = 1000.0 + Math.pow(10.0, -0.0);
        this._values[11] = 1000.0 - Math.pow(10.0, -0.0);
        this._values[12] = null;
    }

    @After
    public void tearDown() {
        this._instance = null;
        this._values = null;
    }

    /**
     * Test of constructor, of class Or, that take a collection.
     */
    @Test
    public void testCtor_Collection() {
        System.out.println("Or(Collection)");
        Collection<Equals<Double>> c = new LinkedList<Equals<Double>>();
        c.add(new DoubleAbsolute(Math.pow(10.0, -6.0)));
        c.add(new DoubleRelative(Math.pow(10.0, -6.0)));
        Or<Double> instance = new Or<Double>(c);
        assertNotNull("Null result from ctor.", c);
        assertEquals("Wrong size.", 2, instance.size());
    }

    /**
     * Test of constructor, of class Or, that take a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testCtor_Null() {
        System.out.println("Or(null)");
        Collection<Equals<Double>> c = null;
        new Or<Double>(c);
    }

    /**
     * Test of value method, of class Or.
     */
    @Test
    public void testValue() {
        System.out.println("value");
        Equals<Double> instance = this._instance;
        for (int i = 0; i < this._values.length; i++)
            for (int j = 0; j < this._values.length; j++) {
                boolean expResult = false;
                for (Equals<Double> e : this._instance)
                    expResult |= e.value(this._values[i], this._values[j]);
                Boolean result = instance.value(this._values[i], this._values[j]);
                String first = (this._values[i] == null ? "null" : this._values[i].toString());
                String second = (this._values[j] == null ? "null" : this._values[j].toString());
                assertEquals(first + " compared to " + second,
                        expResult, result);
            }
    }

    /**
     * Test of value method, of class Or, for an empty collection.
     */
    @Test
    public void testValue_EmptyCollection() {
        System.out.println("value for an empty collection");
        Equals<Double> instance = new Or<Double>();
        for (int i = 0; i < this._values.length; i++)
            for (int j = 0; j < this._values.length; j++) {
                boolean expResult = true;
                Boolean result = instance.value(this._values[i], this._values[j]);
                String first = (this._values[i] == null ? "null" : this._values[i].toString());
                String second = (this._values[j] == null ? "null" : this._values[j].toString());
                assertEquals(first + " compared to " + second,
                        expResult, result);
            }
    }

    /**
     * Test of value method, of class Or, with a null instance inside.
     */
    @Test (expected=NullPointerException.class)
    public void testValue_ContainingNull() {
        System.out.println("value for an instance with a null reference in");
        Or<Double> instance = this._instance;
        instance.add(null);
        instance.value(this._values[0], this._values[7]);
    }
}