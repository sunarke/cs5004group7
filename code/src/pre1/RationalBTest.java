package pre1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RationalBTest {
    RationalB r1;
    RationalB r2;
    RationalB r3;

    @Before
    public void setUp() throws Exception {
        r1 = new RationalB(3, 7);
        r2 = new RationalB(2, -9);
        r3 = new RationalB();
    }

    @Test
    public void selfChangingAddition() {
        r1.addition(r2);
        assertEquals(13, r1.getNumerator());
        assertEquals(63, r1.getDenominator());
    }

    @Test
    public void selfChangingSubtraction() {
        r1.subtraction(r2);
        assertEquals(41, r1.getNumerator());
        assertEquals(63, r1.getDenominator());
    }

    @Test
    public void selfChangingMultiplication() {
        r1.multiplication(r2);
        assertEquals(-6, r1.getNumerator());
        assertEquals(63, r1.getDenominator());
    }

    @Test
    public void selfChangingDivision() {
        r1.division(r2);
        assertEquals(-27, r1.getNumerator());
        assertEquals(14, r1.getDenominator());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalSelfChangingDivision(){
        r1.division(r3);
    }
}