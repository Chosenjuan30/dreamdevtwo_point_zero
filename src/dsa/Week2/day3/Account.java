package dsa.Week2.day3;



import dsa.Week2.day3.exception.InsufficientBalanceException;
import dsa.Week2.day3.exception.InvalidAmountException;
import dsa.Week2.day3.exception.InvalidPinException;

import java.math.BigDecimal;

public class Account {
    private String pin;
    private BigDecimal balance = new BigDecimal(0);

    public Account(String pin) {
        this.pin = pin;
    }

    public BigDecimal checkBalance(String pin) {
        validate(pin);
        return balance;
    }

    public void deposit(BigDecimal amount, String pin) {
        validate(amount);
        this.balance = balance.add(amount);
    }

    private void validate(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new InvalidAmountException("Amount must be positive");
        }
    }

    public void withdraw(BigDecimal amount, String pin) {
        validate(pin);
        validateWithdraw(amount);
        this.balance = balance.subtract(amount);
    }

    public void validate(String pin){
        if(!this.pin.equals(pin)){
            throw new InvalidPinException("Invalid Pin");
        }
    }

    private void validateWithdraw(BigDecimal amount) {
        validate(amount);
        if (amount.compareTo(balance) > 0) {
            throw new InsufficientBalanceException("Insufficient funds");
        }
    }
}
