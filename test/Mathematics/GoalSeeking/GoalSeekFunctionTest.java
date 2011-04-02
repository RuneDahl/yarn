/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.GoalSeeking;

import Mathematics.Equality.Equals;
import Mathematics.Function.Function;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit-test for the methods of Mathematics.GoalSeeking.GoalSeekFunction.
 * @author Rune Dahl Iversen
 */
public class GoalSeekFunctionTest<TypeOfInitialValue, TypeOfInput, TypeOfOutput> {
    public GoalSeekFunctionTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getCriterion method, of class GoalSeekFunction.
     */
    public void testGetCriterion(
            final GoalSeekFunction<TypeOfInitialValue, TypeOfInput, TypeOfOutput> instance,
            final Equals<TypeOfOutput> expResult) {
        Equals<TypeOfOutput> result = instance.getCriterion();
        assertEquals("Wrong Criterion from a " + instance.getClass().getName(),
                expResult, result);
    }

    /**
     * Test of getFunction method, of class GoalSeekFunction.
     */
    public void testGetFunction(
            final GoalSeekFunction<TypeOfInitialValue, TypeOfInput, TypeOfOutput> instance,
            final Function<TypeOfInput, TypeOfOutput> expResult) {
        Function<TypeOfInput, TypeOfOutput> result = instance.getFunction();
        assertEquals("Wrong Function from a " + instance.getClass().getName(),
                expResult, result);
    }

    /**
     * Test of getGoalValue method, of class GoalSeekFunction.
     */
    public void testGetGoalValue(
            final GoalSeekFunction<TypeOfInitialValue, TypeOfInput, TypeOfOutput> instance,
            final TypeOfOutput expResult) {
        TypeOfOutput result = instance.getGoalValue();
        assertEquals("Wrong Goal value from a " + instance.getClass().getName(),
                expResult, result);
    }

    /**
     * Test of getInitialValue method, of class GoalSeekFunction.
     */
    public void testGetInitialValue(
            final GoalSeekFunction<TypeOfInitialValue, TypeOfInput, TypeOfOutput> instance,
            final TypeOfInitialValue expResult) {
        TypeOfInitialValue result = instance.getInitialValue();
        assertEquals("Wrong Initial value from a " + instance.getClass().getName(),
                expResult, result);
    }

    /**
     * Test of setCriterion method, of class GoalSeekFunction.
     */
    public void testSetCriterion(
            final GoalSeekFunction<TypeOfInitialValue, TypeOfInput, TypeOfOutput> instance,
            final Equals<TypeOfOutput> criterion) {
        instance.setCriterion(criterion);
        this.testGetCriterion(instance, criterion);
    }

    /**
     * Test of setFunction method, of class GoalSeekFunction.
     */
    public void testSetFunction(
            final GoalSeekFunction<TypeOfInitialValue, TypeOfInput, TypeOfOutput> instance,
            final Function<TypeOfInput, TypeOfOutput> function) {
        instance.setFunction(function);
        this.testGetFunction(instance, function);
    }

    /**
     * Test of setGoalValue method, of class GoalSeekFunction.
     */
    public void testSetGoalValue(
            final GoalSeekFunction<TypeOfInitialValue, TypeOfInput, TypeOfOutput> instance,
            final TypeOfOutput goalValue) {
        instance.setGoalValue(goalValue);
        this.testGetGoalValue(instance, goalValue);
    }

    /**
     * Test of setInitialValue method, of class GoalSeekFunction.
     */
    public void testSetInitialValue(
            final GoalSeekFunction<TypeOfInitialValue, TypeOfInput, TypeOfOutput> instance,
            final TypeOfInitialValue initialValue) {
        instance.setInitialValue(initialValue);
        this.testGetInitialValue(instance, initialValue);
    }

    /**
     * Test of constructor, of class GoalSeekFunction for a GoalValidato null value.
     */
    @Test (expected=NullPointerException.class)
    public void testCtor_GoalValidator_Null() {
        GoalSeekFunction<Double, Double, Double> gsf =
                new GoalValidatorNull();
    }
}
