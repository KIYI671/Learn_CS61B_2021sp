package flik;

import org.junit.Test;

import static flik.Flik.isSameNumber;
import static org.junit.Assert.*;

public class HorribleSteveTest {

    @Test
    public void equalsTest() {
        int a = 200;
        int b = 200;
        assertTrue(isSameNumber(a, b));
    }

    @Test
    public void equalsTest2() {
        int a = 127;
        int b = 127;
        assertTrue(isSameNumber(a, b));
    }

}
