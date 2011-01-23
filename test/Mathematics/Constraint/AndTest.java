/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Constraint;

import java.util.Collection;
import java.util.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit test for the class Mathematics.Constraint.And.
 * @author Rune Dahl Iversen
 */
public class AndTest {
    private ConstraintTest<Double> _constraint;
    private And<Double> _instance;

    public AndTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Mathematics.Constraint.And<T>");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._constraint = new ConstraintTest<Double>();
        this._instance = new And<Double>();
        this._instance.add(new GreaterThanOrEqualReal(1.2));
        this._instance.add(new LessThanOrEqualReal(2.6));
    }

    @After
    public void tearDown() {
        this._constraint = null;
        this._instance = null;
    }

    /**
     * Test of constructor, of class And, that takes a collection.
     */
    @Test
    public void testCtor_Collection() {
        System.out.println("And(collection)");
        Collection<Constraint<Double>> c = new LinkedList<Constraint<Double>>();
        for (Constraint<Double> cc : this._instance)
            c.add(cc);
        And<Double> instance = new And<Double>(c);
        assertNotNull("Null returned from ctor with collection.", instance);
        assertEquals("Wrong size from ctor with collection.", 2, instance.size());
    }

    /**
     * Test of constructor, of class And, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testCtor_null() {
        System.out.println("And(null)");
        Collection<Constraint<Double>> c = null;
        new And<Double>(c);
    }

    /**
     * Test of isBinding method, of class And.
     */
    @Test
    public void testIsBinding() {
        System.out.println("isBinding");
        And<Double> instance = this._instance;
        Double value = 0.9;
        boolean expResult = false;
        this._constraint.testIsBinding(instance, value, expResult);

        value = 1.2;
        expResult = true;
        this._constraint.testIsBinding(instance, value, expResult);

        value = 1.9;
        expResult = false;
        this._constraint.testIsBinding(instance, value, expResult);

        value = 2.6;
        expResult = true;
        this._constraint.testIsBinding(instance, value, expResult);

        value = 2.9;
        expResult = false;
        this._constraint.testIsBinding(instance, value, expResult);
    }

    /**
     * Test of isBinding method, of class And, with a null reference inside.
     */
    @Test (expected=NullPointerException.class)
    public void testIsBinding_ContainingNull() {
        System.out.println("isBinding(with a null reference inside)");
        And<Double> instance = new And<Double>();
        Constraint<Double> c = null;
        instance.add(c);
        Double value = 0.9;
        boolean expResult = true;
        this._constraint.testIsBinding(instance, value, expResult);
    }
    /**
     * Test of isFeasible method, of class And.
     */
    @Test
    public void testIsFeasible() {
        System.out.println("isFeasible");
        And<Double> instance = this._instance;
        Double value = 0.9;
        boolean expResult = false;
        this._constraint.testIsFeasible(instance, value, expResult);

        value = 1.2;
        expResult = true;
        this._constraint.testIsFeasible(instance, value, expResult);

        value = 1.9;
        expResult = true;
        this._constraint.testIsFeasible(instance, value, expResult);

        value = 2.6;
        expResult = true;
        this._constraint.testIsFeasible(instance, value, expResult);

        value = 2.9;
        expResult = false;
        this._constraint.testIsFeasible(instance, value, expResult);
    }

    /**
     * Test of isFeasible method, of class And, with a null reference inside.
     */
    @Test (expected=NullPointerException.class)
    public void testIsFeasible_ContainingNull() {
        System.out.println("isFeasible(with a null reference inside)");
        And<Double> instance = new And<Double>();
        Constraint<Double> c = null;
        instance.add(c);
        Double value = 0.9;
        boolean expResult = true;
        this._constraint.testIsFeasible(instance, value, expResult);
    }
}