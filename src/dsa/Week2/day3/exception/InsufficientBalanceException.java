package dsa.Week2.day3.exception;

public class InsufficientBalanceException extends BankAppException {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
