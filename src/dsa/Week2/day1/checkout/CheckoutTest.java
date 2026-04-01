package dsa.Week2.day1.checkout;

import java.math.BigDecimal;

public class CheckoutTest {

    private static int passed = 0;
    private static int failed = 0;

    public static void main(String[] args) {
        testProductLineTotalIsCorrect();
        testProductRejectsNegativePrice();
        testProductRejectsZeroQuantity();
        testCartSubTotalSumsAllItems();
        testCartDiscountCalculation();
        testCartVATCalculation();
        testCartBillTotalIsSubTotalMinusDiscountPlusVAT();
        testCartBalanceAfterPayment();
        testCartThrowsWhenAmountPaidIsInsufficient();
        testCartIsEmptyInitially();
        testCartIsNotEmptyAfterAddingItem();

        System.out.println("\n=============================");
        System.out.println("Tests passed: " + passed);
        System.out.println("Tests failed: " + failed);
        System.out.println("=============================");
    }

    public static void testProductLineTotalIsCorrect() {
        Product p = new Product("Parfait", new BigDecimal("2100.00"), 2);
        assertEqual("lineTotal for Parfait",
                new BigDecimal("4200.00"), p.getLineTotal());
    }

    public static void testProductRejectsNegativePrice() {
        try {
            new Product("Bad", new BigDecimal("-1"), 1);
            fail("Should throw on negative price");
        } catch (IllegalArgumentException e) {
            pass("Negative price rejected");
        }
    }

    public static void testProductRejectsZeroQuantity() {
        try {
            new Product("Bad", new BigDecimal("100"), 0);
            fail("Should throw on zero quantity");
        } catch (IllegalArgumentException e) {
            pass("Zero quantity rejected");
        }
    }

    public static void testCartSubTotalSumsAllItems() {
        Cart cart = buildSampleCart();
        assertEqual("subTotal", new BigDecimal("5300.00"), cart.getSubTotal());
    }

    public static void testCartDiscountCalculation() {
        Cart cart = buildSampleCart();
        assertEqual("discount at 8%",
                new BigDecimal("424.00"),
                cart.getDiscount(new BigDecimal("8")));
    }

   public  static void testCartVATCalculation() {
        Cart cart = buildSampleCart();
        assertEqual("VAT", new BigDecimal("927.50"), cart.getVAT());
    }

    public static void testCartBillTotalIsSubTotalMinusDiscountPlusVAT() {
        Cart cart = buildSampleCart();
        assertEqual("billTotal",
                new BigDecimal("5803.50"),
                cart.getBillTotal(new BigDecimal("8")));
    }

    public static void testCartBalanceAfterPayment() {
        Cart cart = buildSampleCart();
        assertEqual("balance",
                new BigDecimal("196.50"),
                cart.getBalance(new BigDecimal("8"), new BigDecimal("6000")));
    }

    static void testCartThrowsWhenAmountPaidIsInsufficient() {
        Cart cart = buildSampleCart();
        try {
            cart.getBalance(new BigDecimal("8"), new BigDecimal("100"));
            fail("Should throw when amount paid is too low");
        } catch (IllegalArgumentException e) {
            pass("Insufficient payment rejected");
        }
    }

    static void testCartIsEmptyInitially() {
        Cart cart = new Cart();
        assertCondition("cart is empty on creation", cart.isEmpty());
    }

    static void testCartIsNotEmptyAfterAddingItem() {
        Cart cart = new Cart();
        cart.addItem(new Product("Snack", new BigDecimal("100"), 1));
        assertCondition("cart not empty after add", !cart.isEmpty());
    }

    private static Cart buildSampleCart() {
        Cart cart = new Cart();
        cart.addItem(new Product("Parfait", new BigDecimal("2100.00"), 2));
        cart.addItem(new Product("Rice",    new BigDecimal("550.00"),  2));
        return cart;
    }

    private static void assertEqual(String label,
                                    BigDecimal expected, BigDecimal actual) {
        if (expected.compareTo(actual) == 0) {
            pass(label + " → " + actual);
        } else {
            fail(label + " expected=" + expected + " but got=" + actual);
        }
    }

    private static void assertCondition(String label, boolean condition) {
        if (condition) pass(label);
        else           fail(label);
    }

    private static void pass(String msg) {
        passed++;
        System.out.println("[PASS] " + msg);
    }

    private static void fail(String msg) {
        failed++;
        System.out.println("[FAIL] " + msg);
    }
}
