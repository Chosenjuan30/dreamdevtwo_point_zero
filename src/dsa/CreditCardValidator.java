package dsa;

public class CreditCardValidator {

    public static void main(String[] args) {
        String cardNumber = "4388576018410707";

        System.out.println("Card Type: " + getCardType(cardNumber));
        System.out.println("Valid: " + isValidCard(cardNumber));
    }

    public static boolean isValidCard(String number) {
        return isValidLength(number) && luhnCheck(number);
    }

    public static boolean isValidLength(String number) {
        return number.length() >= 13 && number.length() <= 16;
    }

    public static String getCardType(String number) {
        if (number.startsWith("4")) return "Visa";
        if (number.startsWith("5")) return "MasterCard";
        if (number.startsWith("37")) return "American Express";
        if (number.startsWith("6")) return "Discover";
        return "Unknown";
    }

    public static boolean luhnCheck(String number) {
        int sum = 0;
        boolean doubleDigit = false;

        for (int i = number.length() - 1; i >= 0; i--) {
            int digit = number.charAt(i) - '0';

            if (doubleDigit) {
                digit *= 2;
                if (digit > 9) {
                    digit = digit / 10 + digit % 10;
                }
            }

            sum += digit;
            doubleDigit = !doubleDigit;
        }

        return sum % 10 == 0;
    }
}