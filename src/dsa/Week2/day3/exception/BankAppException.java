package dsa.Week2.day3.exception;

// This is a parent exception so that we can put exceptions common everywhere in the bank app here
public class BankAppException extends RuntimeException {
    public BankAppException(String message) {
        super(message);
    }
}
