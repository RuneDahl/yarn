/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Graph.Tree;

import java.util.Iterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Methods to facilitate jUnit tests for implementations of the
 * abstract class Mathematics.Graph.Tree.StateValueWeightedChildrenBased.
 * @author Rune Dahl Iversen
 */
public class StateValueWeightedChildrenBasedTest<TypeOfState, TypeOfValue> {
    public StateValueWeightedChildrenBasedTest() { // Intentional
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
     * Test of getChild method, of class StateValueWeightedChildrenBased.
     */
    public void testGetChild(
            final StateValueWeightedChildrenBased<TypeOfState, TypeOfValue> instance,
            final int index,
            final Node<TypeOfState, TypeOfValue> expResult) {
        Node<TypeOfState, TypeOfValue> result = instance.getChild(index);
        assertEquals("Child node with index " + Integer.toString(index),
                expResult, result);
    }

    /**
     * Test of getChildren method, of class StateValueWeightedChildrenBased.
     */
    public void testGetChildren(
            final StateValueWeightedChildrenBased<TypeOfState, TypeOfValue> instance,
            final int expResult) {
        int result = instance.getChildren();
        assertEquals(expResult, result);
    }

    /**
     * Test of getWeight method, of class StateValueWeightedChildrenBased,
     * for an integer value.
     */
    public void testGetWeight_Int(
            final StateValueWeightedChildrenBased<TypeOfState, TypeOfValue> instance,
            final int index,
            final double expResult) {
        double result = instance.getWeight(index);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getWeight method, of class StateValueWeightedChildrenBased,
     * for a node.
     */
    public void testGetWeight_Node(
            final StateValueWeightedChildrenBased<TypeOfState, TypeOfValue> instance,
            final Node<TypeOfState, TypeOfValue> child,
            final double expResult) {
        double result = instance.getWeight(child);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of addChild method, of class StateValueWeightedChildrenBased.
     */
    public void testAddChild(
            final StateValueWeightedChildrenBased<TypeOfState, TypeOfValue> instance,
            final Node<TypeOfState, TypeOfValue> child,
            final double weight) {
        System.out.println("addChild");
        int children = instance.getChildren();
        assertFalse("Violated pre-condition to test addChild(...): Node already a child node.",
                instance.hasChild(child));
        instance.addChild(child, weight);
        assertEquals("Wrong count of child nodes after addChild(...)",
                children + 1, instance.getChildren());
        assertTrue("Not in child nodes after addChild(...)",
                instance.hasChild(child));
    }

    /**
     * Test of hasChild method, of class StateValueWeightedChildrenBased.
     */
    public void testHasChild(
            final StateValueWeightedChildrenBased<TypeOfState, TypeOfValue> instance,
            final Node<TypeOfState, TypeOfValue> node,
            final boolean expResult) {
        boolean result = instance.hasChild(node);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeChild method, of class StateValueWeightedChildrenBased.
     */
    public void testRemoveChild_int(
            final StateValueWeightedChildrenBased<TypeOfState, TypeOfValue> instance,
            final int index) {
        Node<TypeOfState, TypeOfValue> node = instance.getChild(index);
        int childCount = instance.getChildren();
        instance.removeChild(index);
        assertEquals("Wrong count after removeChild(int)",
                childCount - 1, instance.getChildren());
        this.testHasChild(instance, node, false);
    }

    /**
     * Test of removeChild method, of class StateValueWeightedChildrenBased.
     */
    public void testRemoveChild_Node(
            final StateValueWeightedChildrenBased<TypeOfState, TypeOfValue> instance,
            final Node<TypeOfState, TypeOfValue> child) {
        int childCount = instance.getChildren();
        instance.removeChild(child);
        assertEquals("Wrong count after removeChild(node)",
                childCount - 1, instance.getChildren());
        this.testHasChild(instance, child, false);
    }

    /**
     * Test of iterator method, of class StateValueWeightedChildrenBased.
     */
    public void testIterator(
            final StateValueWeightedChildrenBased<TypeOfState, TypeOfValue> instance,
            final Node<TypeOfState, TypeOfValue>[] expResult) {
        Iterator iter = instance.iterator();
        Object[] result = new Object[instance.getChildren()];
        int index = 0;
        while (iter.hasNext()) {
            result[index] = iter.next();
            index++;
        }
        assertArrayEquals(expResult, result);
    }

    /**
     * Blank test to allow this setup.
     */
    @Test
    public void testBlank() {
        assertTrue(true);
    }
}
