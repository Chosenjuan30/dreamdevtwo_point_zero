package dsa.Week2.day1.checkout;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Receipt {

    private static final String STORE_NAME = "SEMICOLON STORES";
    private static final String BRANCH     = "MAIN BRANCH";
    private static final String LOCATION   = "LOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS.";
    private static final String TEL        = "TEL: 03293828343";
    private static final String SEPARATOR  = "=".repeat(52);
    private static final String DIVIDER    = "-".repeat(52);

    private final Cart       cart;
    private final String     customerName;
    private final String     cashierName;
    private final BigDecimal discountPercent;

    public Receipt(Cart cart, String customerName,
                   String cashierName, BigDecimal discountPercent) {
        this.cart            = cart;
        this.customerName    = customerName;
        this.cashierName     = cashierName;
        this.discountPercent = discountPercent;
    }

    public void printInvoice() {
        printHeader();
        printItemTable();
        printSummary();
        System.out.println(SEPARATOR);
        System.out.printf(" THIS IS NOT A RECEIPT KINDLY PAY %.2f%n",
                cart.getBillTotal(discountPercent));
        System.out.println(SEPARATOR);
    }

    public void printFinalReceipt(BigDecimal amountPaid) {
        printHeader();
        printItemTable();
        printSummary();
        System.out.printf("%20s  %10.2f%n", "Amount Paid:", amountPaid);
        System.out.printf("%20s  %10.2f%n", "Balance:",
                cart.getBalance(discountPercent, amountPaid));
        System.out.println(SEPARATOR);
        System.out.printf("%25s%n", "THANK YOU FOR YOUR PATRONAGE");
        System.out.println(SEPARATOR);
    }

    private void printHeader() {
        String date = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("d-MMM-yy h:mm:ss a"));
        System.out.println(STORE_NAME);
        System.out.println(BRANCH);
        System.out.println(LOCATION);
        System.out.println(TEL);
        System.out.println("Date : " + date);
        System.out.println("Cashier: " + cashierName);
        System.out.println("Customer Name: " + customerName);
        System.out.println(SEPARATOR);
    }

    private void printItemTable() {
        System.out.printf("%20s %5s %10s %14s%n",
                "ITEM", "QTY", "PRICE", "TOTAL(NGN)");
        System.out.println(DIVIDER);
        for (Product p : cart.getItems()) {
            System.out.printf("%20s %5d %10.2f %14.2f%n",
                    p.getName(),
                    p.getQuantity(),
                    p.getPrice(),
                    p.getLineTotal());
        }
        System.out.println(DIVIDER);
    }

    private void printSummary() {
        System.out.printf("%20s  %10.2f%n", "Sub Total:",    cart.getSubTotal());
        System.out.printf("%20s  %10.2f%n", "Discount:",     cart.getDiscount(discountPercent));
        System.out.printf("%19s  %10.2f%n", "VAT @ 17.50%:", cart.getVAT());
        System.out.println(SEPARATOR);
        System.out.printf("%20s  %10.2f%n", "Bill Total:",   cart.getBillTotal(discountPercent));
    }
}
