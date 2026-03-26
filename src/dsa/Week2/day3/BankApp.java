package dsa.Week2.day3;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BankApp {

    private final Map<String,Account> accounts = new HashMap<>();

    public String createAccount(String pin){
        String accountNumber = generateAccountNumber();
        accounts.put(accountNumber, new Account(pin));
        return accountNumber;
    }
    public void deposit(String accountNumber, BigDecimal amount, String pin){
        Account account = findAccount(accountNumber);
        account.deposit(amount, pin);
    }

    public void withdraw(String accountNumber, BigDecimal amount, String pin){
        Account account = findAccount(accountNumber);
        account.withdraw(amount, pin);
    }

    public BigDecimal checkBalance(String accountNumber, String pin){
        Account account = findAccount(accountNumber);
        return account.checkBalance(pin);
    }

    private Account findAccount(String accountNumber){
        Account account = accounts.get(accountNumber);
        if(account == null){
            throw new IllegalArgumentException("Account not found");
        }
        return account;
    }
    private String generateAccountNumber(){
        return UUID.randomUUID().toString().substring(0,8);
    }
}