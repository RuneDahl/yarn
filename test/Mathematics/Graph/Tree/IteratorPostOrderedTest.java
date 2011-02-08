/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Graph.Tree;

import Mathematics.Function.Function;
import Mathematics.Vector.*;
import java.util.Iterator;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit test of the class Mathematics.Graph.Tree.IteratorPostOrdered.
 * @author Rune Dahl Iversen
 */
public class IteratorPostOrderedTest {
    private IteratorPostOrdered<Vector<Double>, Vector<Double>> _instance;
    private VectorRealFunctionAndChildren _node;
    private VectorRealFunctionAndChildren[] _childNodes;

    public IteratorPostOrderedTest() { // Intentional
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
        this._node = new VectorRealFunctionAndChildren(state, children, function);
        this._instance = new IteratorPostOrdered<Vector<Double>, Vector<Double>>(this._node);
    }

    @After
    public void tearDown() {
        this._instance = null;
        this._node = null;
        this._childNodes = null;
    }

    /**
     * Test of constructor, of class TreeIteratorPostOrdered, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testCtor_Null() {
        System.out.println("IteratorPostOrdered(null)");
        new IteratorPostOrdered<Vector<Double>, Vector<Double>>(null);
    }

    /**
     * Test of hasNext method, of class TreeIteratorPostOrdered.
     */
    @Test
    public void testHasNext() {
        System.out.println("hasNext");
        Iterator<Node<Vector<Double>, Vector<Double>>> instance = this._instance;
        boolean expResult = true;
        boolean result = instance.hasNext();
        assertEquals(expResult, result);

        while (instance.hasNext()) {
            Node<Vector<Double>, Vector<Double>> node = instance.next();
            assertNotNull(node);
        }

        expResult = false;
        result = instance.hasNext();
        assertEquals(expResult, result);
    }

    /**
     * Test of next method, of class TreeIteratorPostOrdered.
     */
    @Test
    public void testNext() {
        System.out.println("next");
        IteratorPostOrdered<Vector<Double>, Vector<Double>> instance = this._instance;
        Node<Vector<Double>, Vector<Double>> expResult = this._childNodes[2];
        Node<Vector<Double>, Vector<Double>> result = instance.next();
        assertEquals(expResult, result);

        expResult = this._childNodes[1];
        result = instance.next();
        assertEquals(expResult, result);

        expResult = this._childNodes[0];
        result = instance.next();
        assertEquals(expResult, result);

        expResult = this._node;
        result = instance.next();
        assertEquals(expResult, result);
    }

    /**
     * Test of next method, of class TreeIteratorPostOrdered,
     * once the iteration is done.
     */
    @Test (expected=NoSuchElementException.class)
    public void testNext_WhenNotHasNext() {
        System.out.println("next(when !hasNext)");
        IteratorPostOrdered<Vector<Double>, Vector<Double>> instance = this._instance;
        while (instance.hasNext()) {
            instance.next();
        }
        instance.next();
    }

    /**
     * Test of remove method, of class TreeIteratorPostOrdered.
     */
    @Test (expected=UnsupportedOperationException.class)
    public void testRemove() {
        System.out.println("remove");
        IteratorPostOrdered instance = this._instance;
        instance.remove();
    }

    private class Identity implements Function<Vector<Double>, Vector<Double>> {
        @Override
        public Vector<Double> value(Vector<Double> input) {
            return input;
        }
    }
}
