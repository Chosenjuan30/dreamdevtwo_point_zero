package dsa.Week2.assignments.creditcard;


import java.util.Scanner;

public class CreditCardApp {

    private static final String SEPARATOR = "*".repeat(38);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello, Kindly Enter Card details to verify");
        long cardNumber = Long.parseLong(scanner.nextLine().trim());

        printResult(cardNumber);

        scanner.close();
    }

    public static void printResult(long cardNumber) {
        CreditCardValidator validator = new CreditCardValidator(cardNumber);

        System.out.println(SEPARATOR);
        System.out.println("**Credit Card Type: "            + validator.getCardType());
        System.out.println("**Credit Card Number: "          + cardNumber);
        System.out.println("**Credit Card Digit Length: "    + validator.getDigitLength());
        System.out.println("**Credit Card Validity Status: " + validator.getValidityStatus());
        System.out.println(SEPARATOR);
    }
}
