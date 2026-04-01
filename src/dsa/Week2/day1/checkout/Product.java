package dsa.Week2.day1.checkout;


import java.math.BigDecimal;

public class Product {
    private String name;
    private BigDecimal price;
    private int quantity;

    public Product(String name, BigDecimal price, int quantity) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Product name cannot be empty");
        if (price == null || price.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("Price must be greater than zero");
        if (quantity <= 0)
            throw new IllegalArgumentException("Quantity must be greater than zero");

        this.name     = name;
        this.price    = price;
        this.quantity = quantity;
    }

    public BigDecimal getLineTotal() {
        return price.multiply(BigDecimal.valueOf(quantity));
    }

    public String getName()          { return name; }
    public BigDecimal getPrice()     { return price; }
    public int getQuantity()         { return quantity; }
}
