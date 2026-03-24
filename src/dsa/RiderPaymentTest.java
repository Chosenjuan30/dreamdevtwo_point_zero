package dsa;


import dsa.Week2.day1.RiderPayment;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RiderPaymentTest {

    @Test
    public void testLessThan50Percent() {
        assertEquals(11400, RiderPayment.calculateWage(40));
    }

    @Test
    public void testBetween50And59Percent() {
        assertEquals(16000, RiderPayment.calculateWage(55));
    }

    @Test
    public void testBetween60And69Percent() {
        assertEquals(21250, RiderPayment.calculateWage(65));
    }

    @Test
    public void testAbove70Percent() {
        assertEquals(45000, RiderPayment.calculateWage(80));
    }

    @Test
    public void testZeroDeliveries() {
        assertEquals(5000, RiderPayment.calculateWage(0));
    }

    @Test
    public void testFullDeliveries() {
        assertEquals(55000, RiderPayment.calculateWage(100));
    }
}
