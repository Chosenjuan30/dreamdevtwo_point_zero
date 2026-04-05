package dsa.Week2.assignments.creditcard;

public enum CardType {
    VISA,
    MASTERCARD,
    AMERICAN_EXPRESS,
    DISCOVER,
    INVALID_CARD;

    @Override
    public String toString() {
        return switch (this) {
            case VISA             -> "Visa";
            case MASTERCARD       -> "MasterCard";
            case AMERICAN_EXPRESS -> "American Express";
            case DISCOVER         -> "Discover";
            case INVALID_CARD     -> "Invalid Card";
        };
    }
}
