/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Graph.Tree;

import Mathematics.Function.*;
import Mathematics.Result.*;
import Mathematics.Vector.*;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit test of the class Mathematics.Graph.Tree.VectorRealFunctionAndChildren.
 * @author Rune Dahl Iversen
 */
public class VectorRealFunctionAndChildrenTest {
    private VectorRealFunctionAndChildren _instance;
    private StateValueBasedTest<Vector<Double>, Vector<Double>> _stateValue;
    private StateValueWeightedChildrenBasedTest<Vector<Double>, Vector<Double>> _children;
    private FunctionOfStateAndChildrenTest<Vector<Double>, Vector<Double>> _function;

    private VectorRealFunctionAndChildren[] _childNodes;

    public VectorRealFunctionAndChildrenTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Mathematics.Graph.Tree.VectorRealFunctionAndChildren");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        Vector<Double> state = VectorReal.Unit(2, 1);
        Function<Vector<Double>, Vector<Double>> function = new Identity();
        Map<Node<Vector<Double>, Vector<Double>>, Double> children =
                new LinkedHashMap<Node<Vector<Double>, Vector<Double>>, Double>();
        this._childNodes = new VectorRealFunctionAndChildren[3];
        VectorRealFunctionAndChildren child =
                new VectorRealFunctionAndChildren(state.setValue(0, 1.0), function);
        children.put(child, 1.0/3.0);
        this._childNodes[0] = child;
        child = new VectorRealFunctionAndChildren(state.setValue(0, 1.0).setValue(1, 1.5), function);
        children.put(child, 2.0/3.0);
        this._childNodes[1] = child;
        child = new VectorRealFunctionAndChildren(state.setValue(0, 1.0).setValue(1, 0.5), function);
        children.put(child, 4.0/3.0);
        this._childNodes[2] = child;
        this._instance = new VectorRealFunctionAndChildren(state, children, function);
        this._stateValue = new StateValueBasedTest<Vector<Double>, Vector<Double>>();
        this._children = new StateValueWeightedChildrenBasedTest<Vector<Double>, Vector<Double>>();
        this._function = new FunctionOfStateAndChildrenTest<Vector<Double>, Vector<Double>>();
    }

    @After
    public void tearDown() {
        this._instance = null;
        this._childNodes = null;
        this._stateValue = null;
        this._children = null;
        this._function = null;
    }

    /**
     * Test of constructor, of class VectorRealFunctionAndChildren,
     * that take state, value and function inputs.
     */
    @Test
    public void testCtor_StateValueAndFunction() {
        Vector<Double> state = VectorReal.Unit(2, 1);
        Vector<Double> value = VectorReal.Unit(2, 0);
        Function<Vector<Double>, Vector<Double>> function = new Identity();
        VectorRealFunctionAndChildren instance = new VectorRealFunctionAndChildren(state, value, function);

        assertNotNull("null value from ctor(state, value, fucntion).", instance);

        assertEquals("Wrong count of child nodes from ctor(state, value, fucntion).",
                0, instance.getChildren());

        this._stateValue.testGetState(instance, VectorReal.Unit(2, 1));
        this._stateValue.testGetValue(instance, VectorReal.Unit(2, 0));
        this._function.testGetFunction(instance, function);

        instance.computeValue();
        this._stateValue.testGetValue(instance, VectorReal.Unit(2, 1));
    }

    /**
     * Test of constructor, of class VectorRealFunctionAndChildren,
     * that take state, value, children and function inputs.
     */
    @Test
    public void testCtor_StateValueChildrenAndFunction() {
        Vector<Double> state = VectorReal.Unit(2, 1);
        Vector<Double> value = VectorReal.Unit(2, 0);
        Map<Node<Vector<Double>, Vector<Double>>, Double> children =
                new LinkedHashMap<Node<Vector<Double>, Vector<Double>>, Double>();
        Function<Vector<Double>, Vector<Double>> function = new Identity();
        VectorRealFunctionAndChildren instance = new VectorRealFunctionAndChildren(state, value, children, function);

        assertNotNull("null value from ctor(state, value, fucntion).", instance);

        assertEquals("Wrong count of child nodes from ctor(state, value, fucntion).",
                0, instance.getChildren());

        this._stateValue.testGetState(instance, VectorReal.Unit(2, 1));
        this._stateValue.testGetValue(instance, VectorReal.Unit(2, 0));
        this._function.testGetFunction(instance, function);

        instance.computeValue();
        this._stateValue.testGetValue(instance, VectorReal.Unit(2, 1));
    }

    /**
     * Test of getChild method, of class VectorRealFunctionAndChildren,
     * for an integer value.
     */
    @Test
    public void testGetChild_Int() {
        System.out.println("getChild(int)");
        VectorRealFunctionAndChildren instance = this._instance;
        for (int index = 0; index < instance.getChildren(); index++)
            this._children.testGetChild(instance, index, this._childNodes[index]);
    }

    /**
     * Test of getChild method, of class VectorRealFunctionAndChildren,
     * for an integer value of -1.
     */
    @Test (expected=ArrayIndexOutOfBoundsException.class)
    public void testGetChild_NegativeOne() {
        System.out.println("getChild(-1)");
        VectorRealFunctionAndChildren instance = this._instance;
        int index = -1;
        this._children.testGetChild(instance, index, null);
    }

    /**
     * Test of getChild method, of class VectorRealFunctionAndChildren,
     * for a too high integer value.
     */
    @Test (expected=ArrayIndexOutOfBoundsException.class)
    public void testGetChild_TooHigh() {
        System.out.println("getChild(too high)");
        VectorRealFunctionAndChildren instance = this._instance;
        int index = instance.getChildren();
        this._children.testGetChild(instance, index, null);
    }

    /**
     * Test of getFunction method, of class VectorRealFunctionAndChildren.
     */
    @Test
    public void testGetFunction() {
        System.out.println("getFunction");
        VectorRealFunctionAndChildren instance = this._instance;
        Function<Vector<Double>, Vector<Double>> result = instance.getFunction();
        assertTrue(result instanceof Identity);
    }

    /**
     * Test of getState method, of class VectorRealFunctionAndChildren.
     */
    @Test
    public void testGetState() {
        System.out.println("getState");
        VectorRealFunctionAndChildren instance = this._instance;
        Vector<Double> expResult = VectorReal.Unit(2, 1);
        this._stateValue.testGetState(instance, expResult);
    }

    /**
     * Test of getValue method, of class VectorRealFunctionAndChildren.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        VectorRealFunctionAndChildren instance = this._instance;
        double[] values = new double[] { 2.333333333333333, 2.9999999999999996};
        Vector<Double> expResult = new VectorReal(values);
        this._stateValue.testGetValue(instance, expResult);
    }

    /**
     * Test of getChild method, of class VectorRealFunctionAndChildren,
     * for an integer value.
     */
    @Test
    public void testGetWeight_Int() {
        System.out.println("getWeight(int)");
        VectorRealFunctionAndChildren instance = this._instance;
        for (int index = 0; index < instance.getChildren(); index++)
            this._children.testGetWeight(instance, index, Math.pow(2.0, index) / 3.0);
    }

    /**
     * Test of setFunction method, of class VectorRealFunctionAndChildren.
     */
    @Test
    public void testSetFunction() {
        System.out.println("setFunction");
        VectorRealFunctionAndChildren instance = this._instance;
        Function<Vector<Double>, Vector<Double>> function = new Scale(0.5);
        this._function.testSetFunction(instance, function);
    }

    /**
     * Test of setFunction method, of class VectorRealFunctionAndChildren,
     * for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testSetFunction_Null() {
        System.out.println("setFunction(null)");
        VectorRealFunctionAndChildren instance = this._instance;
        Function<Vector<Double>, Vector<Double>> function = null;
        this._function.testSetFunction(instance, function);
    }

    /**
     * Test of setState method, of class VectorRealFunctionAndChildren.
     */
    @Test
    public void testSetState() {
        System.out.println("setState");
        VectorRealFunctionAndChildren instance = this._instance;
        Vector<Double> state = VectorReal.Unit(20, 17);
        this._stateValue.testSetState(instance, state);
    }

    /**
     * Test of setState method, of class VectorRealFunctionAndChildren,
     * for a null value.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetState_Null() {
        System.out.println("setState(null)");
        VectorRealFunctionAndChildren instance = this._instance;
        Vector<Double> state = null;
        this._stateValue.testSetState(instance, state);
    }

    /**
     * Test of setValue method, of class VectorRealFunctionAndChildren.
     */
    @Test
    public void testSetValue() {
        System.out.println("setValue");
        VectorRealFunctionAndChildren instance = this._instance;
        Vector<Double> value = VectorReal.Unit(20, 17);
        this._stateValue.testSetValue(instance, value);
    }

    /**
     * Test of setValue method, of class VectorRealFunctionAndChildren,
     * for a null value.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetValue_Null() {
        System.out.println("setValue(null, w)");
        VectorRealFunctionAndChildren instance = this._instance;
        Vector<Double> value = null;
        this._stateValue.testSetValue(instance, value);
    }

    /**
     * Test of addChild method, of class VectorRealFunctionAndChildren,
     * for a null value.
     */
    @Test
    public void testAddChild() {
        System.out.println("addChild()");
        VectorRealFunctionAndChildren instance = this._instance;
        double[] values = new double[]{1.0, 3.5};
        Vector<Double> state = new VectorReal(values);
        Function<Vector<Double>, Vector<Double>> function = new Scale(0.05);
        Node<Vector<Double>, Vector<Double>> child = new VectorRealFunctionAndChildren(state, function);
        this._children.testAddChild(instance, child, 0.4);
    }

    /**
     * Test of addChild method, of class VectorRealFunctionAndChildren,
     * for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testAddChild_Null() {
        System.out.println("addChild(null)");
        VectorRealFunctionAndChildren instance = this._instance;
        Node<Vector<Double>, Vector<Double>> child = null;
        this._children.testAddChild(instance, child, 0.4);
    }

    /**
     * Test of computeValue method, of class VectorRealFunctionAndChildren.
     */
    @Test
    public void testComputeValue() {
        System.out.println("computeValue");
        VectorRealFunctionAndChildren instance = this._instance;
        double[] values = new double[] { 2.333333333333333, 2.9999999999999996};
        Vector<Double> value = new VectorReal(values);
        Result result = instance.computeValue();
        assertTrue(result instanceof SuccessWithValue);
        SuccessWithValue<Vector<Double>> swv = (SuccessWithValue<Vector<Double>>)result;
        assertEquals(value, swv.getResult());

        result = instance.computeValue();
        assertTrue(result instanceof SuccessWithValue);
        swv = (SuccessWithValue<Vector<Double>>)result;
        assertEquals(value, swv.getResult());

        instance.setFunction(new Thrower());
        result = instance.computeValue();
        assertTrue(result instanceof UnhandledExceptionThrown);
        UnhandledExceptionThrown uet = (UnhandledExceptionThrown)result;
        Exception ee = uet.getException();
        assertTrue(ee instanceof IllegalStateException);
        IllegalStateException ise = (IllegalStateException) ee;
        assertEquals("Expected exception.", ise.getMessage());

    }

    /**
     * Test of hasChild method, of class VectorRealFunctionAndChildren.
     */
    @Test
    public void testHasChild() {
        System.out.println("hasChild");
        VectorRealFunctionAndChildren instance = this._instance;
        for (int index = instance.getChildren()-1; -1 < index; index--)
            this._children.testHasChild(instance, this._childNodes[index], true);
        this._children.testHasChild(instance, null, false);
        Vector<Double> state = new VectorReal(3, 2);
        Function<Vector<Double>, Vector<Double>> function =
                new Thrower();
        Node<Vector<Double>, Vector<Double>> node =
                new VectorRealFunctionAndChildren(state, function);
        this._children.testHasChild(instance, node, false);
    }

    /**
     * Test of removeChild method, of class VectorRealFunctionAndChildren,
     * for an integer value.
     */
    @Test
    public void testRemoveChild_Int() {
        System.out.println("removeChild(int)");
        VectorRealFunctionAndChildren instance = this._instance;
        for (int index = instance.getChildren()-1; -1 < index; index--)
            this._children.testRemoveChild_int(instance, index);
    }

    /**
     * Test of removeChild method, of class VectorRealFunctionAndChildren,
     * for a Node value.
     */
    @Test
    public void testRemoveChild_Node() {
        System.out.println("removeChild(node)");
        VectorRealFunctionAndChildren instance = this._instance;
        for (int index = instance.getChildren()-1; -1 < index; index--)
            this._children.testRemoveChild_Node(instance, this._childNodes[index]);
    }

    private class Identity implements Function<Vector<Double>, Vector<Double>> {
        @Override
        public Vector<Double> value(Vector<Double> input) {
            return input;
        }
    }

    private class Scale implements Function<Vector<Double>, Vector<Double>> {
        private double _scale;

        public Scale(final double scale) {
            this._scale = scale;
        }

        @Override
        public Vector<Double> value(Vector<Double> input) {
            return input.scale(this._scale);
        }
    }

    private class Thrower implements Function<Vector<Double>, Vector<Double>> {
        @Override
        public Vector<Double> value(Vector<Double> input) {
            throw new IllegalStateException("Expected exception.");
        }
    }
}
