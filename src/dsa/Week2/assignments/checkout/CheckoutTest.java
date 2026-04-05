package dsa.Week2.assignments.checkout;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

public class CheckoutTest {

    private Cart cart;

    @BeforeEach
    public void setUp() {
        cart = new Cart();
        cart.addItem(new Product("Parfait", new BigDecimal("2100.00"), 2));
        cart.addItem(new Product("Rice",    new BigDecimal("550.00"),  2));
    }

    @Test
    public void testProductLineTotalIsCorrect() {
        Product p = new Product("Parfait", new BigDecimal("2100.00"), 2);
        assertEquals(new BigDecimal("4200.00"), p.getLineTotal());
    }

    @Test
    void testProductRejectsNegativePrice() {
        assertThrows(IllegalArgumentException.class,
                () -> new Product("Bad", new BigDecimal("-1"), 1));
    }

    @Test
    public void testProductRejectsZeroQuantity() {
        assertThrows(IllegalArgumentException.class,
                () -> new Product("Bad", new BigDecimal("100"), 0));
    }

    @Test
    public void testCartSubTotalSumsAllItems() {
        assertEquals(new BigDecimal("5300.00"), cart.getSubTotal());
    }

    @Test
    public void testCartDiscountCalculation() {
        assertEquals(new BigDecimal("424.00"),
                cart.getDiscount(new BigDecimal("8")));
    }

    @Test
    public void testCartVATCalculation() {
        assertEquals(new BigDecimal("927.50"), cart.getVAT());
    }

    @Test
    public void testCartBillTotalIsSubTotalMinusDiscountPlusVAT() {
        assertEquals(new BigDecimal("5803.50"),
                cart.getBillTotal(new BigDecimal("8")));
    }

    @Test
    public void testCartBalanceAfterPayment() {
        assertEquals(new BigDecimal("196.50"),
                cart.getBalance(new BigDecimal("8"), new BigDecimal("6000")));
    }

    @Test
    public void testCartThrowsWhenAmountPaidIsInsufficient() {
        assertThrows(IllegalArgumentException.class,
                () -> cart.getBalance(new BigDecimal("8"), new BigDecimal("100")));
    }

    @Test
    public void testCartIsEmptyInitially() {
        assertTrue(new Cart().isEmpty());
    }

    @Test
    public void testCartIsNotEmptyAfterAddingItem() {
        Cart freshCart = new Cart();
        freshCart.addItem(new Product("Snack", new BigDecimal("100"), 1));
        assertFalse(freshCart.isEmpty());
    }
}