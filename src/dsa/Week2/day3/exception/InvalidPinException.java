package dsa.Week2.day3.exception;

public class InvalidPinException extends BankAppException {
    public InvalidPinException(String message) {
        super(message);
    }
}
