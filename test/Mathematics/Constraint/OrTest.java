/*
 * To change this template, choose Tools | Templates
 * Or open the template in the editor.
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
 * jUnit test for the class Mathematics.Constraint.Or.
 * @author Rune Dahl Iversen
 */
public class OrTest {
    private ConstraintTest<Double> _constraint;
    private Or<Double> _instance;

    public OrTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Mathematics.Constraint.Or<T>");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._constraint = new ConstraintTest<Double>();
        this._instance = new Or<Double>();
        this._instance.add(new LessThanOrEqualReal(1.2));
        this._instance.add(new GreaterThanOrEqualReal(2.6));
    }

    @After
    public void tearDown() {
        this._constraint = null;
        this._instance = null;
    }

    /**
     * Test of constructor, of class Or, that takes a collection.
     */
    @Test
    public void testCtor_Collection() {
        System.out.println("Or(collection)");
        Collection<Constraint<Double>> c = new LinkedList<Constraint<Double>>();
        for (Constraint<Double> cc : this._instance)
            c.add(cc);
        Or<Double> instance = new Or<Double>(c);
        assertNotNull("Null returned from ctor with collection.", instance);
        assertEquals("Wrong size from ctor with collection.", 2, instance.size());
    }

    /**
     * Test of constructor, of class Or, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testCtor_null() {
        System.out.println("Or(null)");
        Collection<Constraint<Double>> c = null;
        new Or<Double>(c);
    }

    /**
     * Test of isBinding method, of class Or.
     */
    @Test
    public void testIsBinding() {
        System.out.println("isBinding");
        Or<Double> instance = this._instance;
        Double value = 0.9;
        boolean expResult = false;
        this._constraint.testIsBinding(instance, value, expResult);

        value = 1.2;
        expResult = false;
        this._constraint.testIsBinding(instance, value, expResult);

        value = 1.9;
        expResult = false;
        this._constraint.testIsBinding(instance, value, expResult);

        value = 2.6;
        expResult = false;
        this._constraint.testIsBinding(instance, value, expResult);

        value = 2.9;
        expResult = false;
        this._constraint.testIsBinding(instance, value, expResult);

        Constraint<Double> c = instance.get(1);
        LimitBased<Double, Double> l = (LimitBased)c;
        l.setLimit(1.2);

        value = 0.9;
        expResult = false;
        this._constraint.testIsBinding(instance, value, expResult);

        value = 1.2;
        expResult = true;
        this._constraint.testIsBinding(instance, value, expResult);

        value = 1.9;
        expResult = false;
        this._constraint.testIsBinding(instance, value, expResult);
    }

    /**
     * Test of isBinding method, of class Or, with a null reference inside.
     */
    @Test (expected=NullPointerException.class)
    public void testIsBinding_ContainingNull() {
        System.out.println("isBinding(with a null reference inside)");
        Or<Double> instance = new Or<Double>();
        Constraint<Double> c = null;
        instance.add(c);
        Double value = 0.9;
        boolean expResult = true;
        this._constraint.testIsBinding(instance, value, expResult);
    }
    /**
     * Test of isFeasible method, of class Or.
     */
    @Test
    public void testIsFeasible() {
        System.out.println("isFeasible");
        Or<Double> instance = this._instance;
        Double value = 0.9;
        boolean expResult = true;
        this._constraint.testIsFeasible(instance, value, expResult);

        value = 1.2;
        expResult = true;
        this._constraint.testIsFeasible(instance, value, expResult);

        value = 1.9;
        expResult = false;
        this._constraint.testIsFeasible(instance, value, expResult);

        value = 2.6;
        expResult = true;
        this._constraint.testIsFeasible(instance, value, expResult);

        value = 2.9;
        expResult = true;
        this._constraint.testIsFeasible(instance, value, expResult);
    }

    /**
     * Test of isFeasible method, of class Or, with a null reference inside.
     */
    @Test (expected=NullPointerException.class)
    public void testIsFeasible_ContainingNull() {
        System.out.println("isFeasible(with a null reference inside)");
        Or<Double> instance = new Or<Double>();
        Constraint<Double> c = null;
        instance.add(c);
        Double value = 0.9;
        boolean expResult = true;
        this._constraint.testIsFeasible(instance, value, expResult);
    }
}