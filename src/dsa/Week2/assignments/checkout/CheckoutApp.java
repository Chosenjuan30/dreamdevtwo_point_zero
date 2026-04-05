package dsa.Week2.assignments.checkout;


import java.math.BigDecimal;
import java.util.Scanner;

public class CheckoutApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("What is the customer's Name\n");
        String customerName = scanner.nextLine().trim();

        Cart cart = new Cart();
        boolean addMore = true;

        while (addMore) {
            System.out.print("What did the user buy?\n");
            String productName = scanner.nextLine().trim();

            System.out.print("How many pieces?\n");
            int quantity = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("How much per unit?\n");
            BigDecimal price = new BigDecimal(scanner.nextLine().trim());

            cart.addItem(new Product(productName, price, quantity));

            System.out.print("Add more Items?\n");
            String more = scanner.nextLine().trim().toLowerCase();
            addMore = more.equals("yes");
        }

        System.out.print("What is your name?\n");
        String cashierName = scanner.nextLine().trim();

        System.out.print("How much discount will he get\n");
        BigDecimal discountPercent = new BigDecimal(scanner.nextLine().trim());

        Receipt receipt = new Receipt(cart, customerName, cashierName, discountPercent);
        receipt.printInvoice();

        System.out.print("How much did the customer give to you?\n");
        BigDecimal amountPaid = new BigDecimal(scanner.nextLine().trim());

        receipt.printFinalReceipt(amountPaid);

        scanner.close();
    }
}
