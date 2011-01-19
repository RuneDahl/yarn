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
 * Methods to facilitate testing of Polynomial.
 * @author Rune Dahl Iversen
 */
public class PolynomialTest<TypeOfCoefficient, TypeOfInput, TypeOfOutput> {
    public PolynomialTest() { // Intentional
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
     * Test of getCoefficient method, of class Polynomial.
     */
    public void testGetCoefficient(
            final Polynomial<TypeOfCoefficient, TypeOfInput, TypeOfOutput> instance,
            final int degree,
            final TypeOfCoefficient expResult) {
        TypeOfCoefficient result = instance.getCoefficient(degree);
        assertEquals(instance.toString() + "Wrong coefficient for degree: " + Integer.toString(degree),
                expResult, result);
    }

    /**
     * Test of getDegree method, of class Polynomial.
     */
    public void testGetDegree(
            final Polynomial<TypeOfCoefficient, TypeOfInput, TypeOfOutput> instance,
            final int expResult) {
        int result = instance.getDegree();
        assertEquals(instance.toString(), expResult, result);
    }

    /**
     * Test of setCoefficient method, of class Polynomial.
     */
    public void testSetCoefficient(
            final Polynomial<TypeOfCoefficient, TypeOfInput, TypeOfOutput> instance,
            final int degree,
            final TypeOfCoefficient value,
            final Polynomial<TypeOfCoefficient, TypeOfInput, TypeOfOutput> expResult) {
        Polynomial result = instance.setCoefficient(degree, value);
        assertEquals(expResult, result);
    }

    /**
     * Test of getDifferential method, of class Polynomial.
     */
    public void testGetDifferential(
            final Polynomial<TypeOfCoefficient, TypeOfInput, TypeOfOutput> instance,
            final Function<TypeOfInput, TypeOfOutput> expResult) {
        Function<TypeOfInput, TypeOfOutput> result = instance.getDifferential();
        assertEquals(instance.toString() + " differential", expResult, result);
    }

    /**
     * Test of getDifferential method, of class Polynomial.
     */
    public void testGetDifferential_Value(
            final Polynomial<TypeOfCoefficient, TypeOfInput, TypeOfOutput> instance,
            final TypeOfInput value,
            final TypeOfOutput expResult) {
        TypeOfOutput result = instance.getDifferential(value);
        String v = (value == null ? "null" : value.toString());
        assertEquals(instance.toString() + " differential at " + v, expResult, result);
    }

    /**
     * Test of product method, of class Polynomial.
     */
    public void testProduct(
            final Polynomial<TypeOfCoefficient, TypeOfInput, TypeOfOutput> instance,
            final Polynomial<TypeOfCoefficient, TypeOfInput, TypeOfOutput> value,
            final Polynomial<TypeOfCoefficient, TypeOfInput, TypeOfOutput> expResult) {
        Polynomial<TypeOfCoefficient, TypeOfInput, TypeOfOutput> result = instance.product(value);
        String v = (value == null ? "null" : value.toString());
        assertEquals(instance.toString() + " * " + v, expResult, result);
    }

    /**
     * Test of scale method, of class Polynomial.
     */
    public void testScale(
            final Polynomial<TypeOfCoefficient, TypeOfInput, TypeOfOutput> instance,
            final TypeOfCoefficient value,
            final Polynomial<TypeOfCoefficient, TypeOfInput, TypeOfOutput> expResult) {
        Polynomial<TypeOfCoefficient, TypeOfInput, TypeOfOutput> result = instance.scale(value);
        String v = (value == null ? "null" : value.toString());
        assertEquals(instance.toString() + " scaled by " + v, expResult, result);
    }

    /**
     * Test of subtract method, of class Polynomial.
     */
    public void testSubtract(
            final Polynomial<TypeOfCoefficient, TypeOfInput, TypeOfOutput> instance,
            final Polynomial<TypeOfCoefficient, TypeOfInput, TypeOfOutput> value,
            final Polynomial<TypeOfCoefficient, TypeOfInput, TypeOfOutput> expResult) {
        Polynomial<TypeOfCoefficient, TypeOfInput, TypeOfOutput> result = instance.subtract(value);
        String v = (value == null ? "null" : value.toString());
        assertEquals(instance.toString() + " - " + v, expResult, result);
    }

    /**
     * Test of sum method, of class Polynomial.
     */
    public void testSum(
            final Polynomial<TypeOfCoefficient, TypeOfInput, TypeOfOutput> instance,
            final Polynomial<TypeOfCoefficient, TypeOfInput, TypeOfOutput> value,
            final Polynomial<TypeOfCoefficient, TypeOfInput, TypeOfOutput> expResult) {
        Polynomial<TypeOfCoefficient, TypeOfInput, TypeOfOutput> result = instance.sum(value);
        String v = (value == null ? "null" : value.toString());
        assertEquals(instance.toString() + " + " + v, expResult, result);
    }

    /**
     * Test of value method, of class Polynomial.
     */
    public void testValue(
            final Polynomial<TypeOfCoefficient, TypeOfInput, TypeOfOutput> instance,
            final TypeOfInput value,
            final TypeOfOutput expResult) {
        TypeOfOutput result = instance.value(value);
        String v = (value == null ? "null" : value.toString());
        assertEquals(instance.toString() + " at " + v, expResult, result);
    }

    /**
     * Test of equals method, of class Polynomial.
     */
    public void testEquals(
            final Polynomial<TypeOfCoefficient, TypeOfInput, TypeOfOutput> instance,
            final Object value,
            final boolean expResult) {
        boolean result = instance.equals(value);
        String v = (value == null ? "null" : value.toString());
        assertEquals(instance.toString() + " equals " + v, expResult, result);
    }

    /**
     * Test of hashCode method, of class Polynomial.
     */
    public void testHashCode(
            final Polynomial<TypeOfCoefficient, TypeOfInput, TypeOfOutput> instance,
            final int expResult) {
        int result = instance.hashCode();
        assertEquals(instance.toString(), expResult, result);
    }

    /**
     * Test of toString method, of class Polynomial.
     */
    public void testToString(
            final Polynomial<TypeOfCoefficient, TypeOfInput, TypeOfOutput> instance,
            final String expResult) {
        String result = instance.toString();
        assertEquals(result, expResult, result);
    }

    /**
     * A blank test to allow this setup.
     */
    @Test
    public void testBlank() {
        assertTrue(true);
    }
}