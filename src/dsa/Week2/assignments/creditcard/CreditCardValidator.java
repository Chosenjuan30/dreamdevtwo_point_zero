package dsa.Week2.assignments.creditcard;


public class CreditCardValidator {

    private final long cardNumber;
    private final String cardNumberString;

    public CreditCardValidator(long cardNumber) {
        this.cardNumber       = cardNumber;
        this.cardNumberString = String.valueOf(cardNumber);
    }

    public CardType getCardType() {
        int length = cardNumberString.length();
        if (length < 13 || length > 16) return CardType.INVALID_CARD;

        if (cardNumberString.startsWith("37"))  return CardType.AMERICAN_EXPRESS;
        if (cardNumberString.startsWith("4"))   return CardType.VISA;
        if (cardNumberString.startsWith("5"))   return CardType.MASTERCARD;
        if (cardNumberString.startsWith("6"))   return CardType.DISCOVER;

        return CardType.INVALID_CARD;
    }

    public int getDigitLength() {
        return cardNumberString.length();
    }

    public boolean isValid() {
        if (getCardType() == CardType.INVALID_CARD) return false;
        return luhnCheck();
    }

    public String getValidityStatus() {
        return isValid() ? "Valid" : "Invalid";
    }

    private boolean luhnCheck() {
        int[] digits = toDigitArray();
        int sumOfDoubled = sumOfDoubledSecondDigits(digits);
        int sumOfOdd     = sumOfOddPositionDigits(digits);
        return (sumOfDoubled + sumOfOdd) % 10 == 0;
    }

    private int[] toDigitArray() {
        int[] digits = new int[cardNumberString.length()];
        for (int i = 0; i < cardNumberString.length(); i++) {
            digits[i] = cardNumberString.charAt(i) - '0';
        }
        return digits;
    }

    private int sumOfDoubledSecondDigits(int[] digits) {
        int sum = 0;
        for (int i = digits.length - 2; i >= 0; i -= 2) {
            int doubled = digits[i] * 2;
            if (doubled > 9) doubled = doubled / 10 + doubled % 10;
            sum += doubled;
        }
        return sum;
    }

    private int sumOfOddPositionDigits(int[] digits) {
        int sum = 0;
        for (int i = digits.length - 1; i >= 0; i -= 2) {
            sum += digits[i];
        }
        return sum;
    }
}
