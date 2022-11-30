package com.amdocs.webapp;
import static org.junit.Assert.*;
import org.junit.Test;

public class BasicCalculatorTest {
    @Test
    public void testAdd() throws Exception {

        int k= new BasicCalculator().add(5,5);
        assertEquals("Add", 10, k);
        
    }
    @Test   
    public void testSub() throws Exception {

        int k= new BasicCalculator().sub(8,7);
        assertEquals("Sub", 1, k);

    }
}
