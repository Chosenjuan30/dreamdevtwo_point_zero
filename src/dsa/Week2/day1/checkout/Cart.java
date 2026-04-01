package dsa.Week2.day1.checkout;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cart {

    private static final BigDecimal VAT_RATE = new BigDecimal("0.175");
    private static final BigDecimal HUNDRED  = new BigDecimal("100");

    private final List<Product> items = new ArrayList<>();

    public void addItem(Product product) {
        if (product == null)
            throw new IllegalArgumentException("Product cannot be null");
        items.add(product);
    }

    public List<Product> getItems() {
        return Collections.unmodifiableList(items);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public BigDecimal getSubTotal() {
        return items.stream()
                .map(Product::getLineTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getDiscount(BigDecimal discountPercent) {
        return getSubTotal()
                .multiply(discountPercent)
                .divide(HUNDRED, 2, RoundingMode.HALF_UP);
    }

    public BigDecimal getVAT() {
        return getSubTotal()
                .multiply(VAT_RATE)
                .setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getBillTotal(BigDecimal discountPercent) {
        return getSubTotal()
                .subtract(getDiscount(discountPercent))
                .add(getVAT())
                .setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getBalance(BigDecimal discountPercent, BigDecimal amountPaid) {
        BigDecimal billTotal = getBillTotal(discountPercent);
        if (amountPaid.compareTo(billTotal) < 0)
            throw new IllegalArgumentException(
                    "Amount paid is less than bill total of " + billTotal);
        return amountPaid.subtract(billTotal).setScale(2, RoundingMode.HALF_UP);
    }
}
