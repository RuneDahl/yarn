/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Graph.Tree;

import Mathematics.Result.*;
import Validation.*;
import java.util.Iterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Methods to facilitate jUnit tests for implementations of the
 * abstract class Mathematics.Graph.Tree.StateValueBased.
 * @author Rune Dahl Iversen
 */
public class StateValueBasedTest<TypeOfState, TypeOfValue> {
    public StateValueBasedTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception { // Intentional
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() { // Intentional
    }

    @After
    public void tearDown() { // Intentional
    }

    /**
     * Test of getState method, of class StateValueBased.
     */
    public void testGetState(
            final StateValueBased<TypeOfState, TypeOfValue> instance,
            final TypeOfState expResult) {
        TypeOfState result = instance.getState();
        assertEquals(expResult, result);
    }

    /**
     * Test of getValue method, of class StateValueBased.
     */
    public void testGetValue(
            final StateValueBased<TypeOfState, TypeOfValue> instance,
            final TypeOfValue expResult) {
        Object result = instance.getValue();
        assertEquals(expResult, result);
    }

    /**
     * Test of setState method, of class StateValueBased.
     */
    public void testSetState(
            final StateValueBased<TypeOfState, TypeOfValue> instance,
            final TypeOfState state) {
        instance.setState(state);
        this.testGetState(instance, state);
    }

    /**
     * Test of setValue method, of class StateValueBased.
     */
    public void testSetValue(
            final StateValueBased<TypeOfState, TypeOfValue> instance,
            final TypeOfValue value) {
        instance.setValue(value);
        this.testGetValue(instance, value);
    }

    /**
     * Test of setValue method, of class StateValueBased,
     * for a null stateValidator.
     */
    @Test (expected=NullPointerException.class)
    public void testCtor_StateValidatorNull() {
        System.out.println("Ctor(...) stateValidator as null.");
        new StateValueBasedImpl();
    }

    /**
     * Test of setValue method, of class StateValueBased,
     * for a null valueValidator.
     */
    @Test (expected=NullPointerException.class)
    public void testCtor_ValueValidatorNull() {
        System.out.println("Ctor(...) valueValidator as null.");
        new StateValueBasedImpl(Factory.FiniteReal());
    }

    public class StateValueBasedImpl extends StateValueBased {

        public StateValueBasedImpl() {
            super(null, null, null);
        }

        public StateValueBasedImpl(final Validator<Double> stateValidator) {
            super(stateValidator, null, null);
        }

        @Override
        public Result computeValue() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public Node getChild(int index) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public int getChildren() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public boolean hasChild(Node node) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public Iterator iterator() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
}
