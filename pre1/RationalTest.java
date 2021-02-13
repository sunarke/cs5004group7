package hw4;
/**
 * A Junit test for the Rational class.
 */

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RationalTest {
    Rational r1;
    Rational r2;
    Rational r3;
    Rational r4;
    Rational r5;

    @Before
    public void setUp() throws Exception {
        r1 = new Rational(3, 7);
        r2 = new Rational(2, -9);
        r3 = new Rational(6, 14);
        r4 = new Rational(3);
        r5 = new Rational();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalObject(){
        Rational r6 = new Rational(11, 0);
    }

    @Test
    public void staticAddition() {
        assertEquals(13, Rational.addition(r1, r2).getNumerator());
        assertEquals(63, Rational.addition(r1, r2).getDenominator());
    }

    @Test
    public void nonStaticAddition() {
        assertEquals(13, r1.addition(r2).getNumerator());
        assertEquals(63, r1.addition(r2).getDenominator());
    }

    @Test
    public void staticSubtraction() {
        assertEquals(41, Rational.subtraction(r1, r2).getNumerator());
        assertEquals(63, Rational.subtraction(r1, r2).getDenominator());
    }

    @Test
    public void nonStaticSubtraction(){
        assertEquals(41, r1.subtraction(r2).getNumerator());
        assertEquals(63, r1.subtraction(r2).getDenominator());
    }

    @Test
    public void staticMultiplication() {
        assertEquals(-6, Rational.multiplication(r1, r2).getNumerator());
        assertEquals(63, Rational.multiplication(r1, r2).getDenominator());
    }

    @Test
    public void nonStaticMultiplication(){
        assertEquals(-6, r1.multiplication(r2).getNumerator());
        assertEquals(63, r1.multiplication(r2).getDenominator());
    }

    @Test
    public void staticDivision()  {
        assertEquals(-27, Rational.division(r1, r2).getNumerator());
        assertEquals(14, Rational.division(r1, r2).getDenominator());

        assertEquals(3, Rational.division(r1, r4).getNumerator());
        assertEquals(21, Rational.division(r1, r4).getDenominator());
    }

    @Test
    public void nonStaticDivision(){
        assertEquals(-27, r1.division(r2).getNumerator());
        assertEquals(14, r1.division(r2).getDenominator());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalStaticDivision(){
        Rational.division(r1, r5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalNonStaticDivision(){
        r1.division(r5);
    }

    @Test
    public void getNumerator() {
        assertEquals(3, r1.getNumerator());
    }

    @Test
    public void setNumerator() {
        r2.setNumerator(5);
        assertEquals(5, r2.getNumerator());
    }

    @Test
    public void getDenominator() {
        assertEquals(7, r1.getDenominator());

    }

    @Test
    public void setDenominator() {
        r2.setDenominator(11);
        assertEquals(11, r2.getDenominator());
        r2.setDenominator(-9);
        assertEquals(9, r2.getDenominator());

    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalDominator() {
        r2.setDenominator(0);
    }

    @Test
    public void testEquals() {
        assertTrue(r1.equals(r3));
        assertFalse(r1.equals(r2));
    }

    @Test
    public void testToString() {
        assertEquals("3/7", r1.toString());
        assertEquals("3/1", r4.toString());
    }

    @Test
    public void normalization() {
        assertEquals(-2, r2.getNumerator());
        assertEquals(9, r2.getDenominator());
    }
}