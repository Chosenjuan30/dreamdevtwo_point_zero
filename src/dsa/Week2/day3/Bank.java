//package dsa.Week2.day3;
//
//import dsa.Week2.day3.exception.BankAppException;
//import dsa.Week2.day3.exception.InvalidAmountException;
//
//import javax.security.auth.login.AccountNotFoundException;
//import java.math.BigDecimal;
//import java.util.HashMap;
//import java.util.Map;
//
//public class Bank {
//
//    private final Map<String, BankApp> registeredBanks = new HashMap<>();
//
//    public void registerBank(String bankCode, BankApp bankApp) {
//        if (bankCode == null || bankCode.isBlank()) {
//            throw new BankAppException("Bank code must not be blank.");
//        }
//        if (registeredBanks.containsKey(bankCode)) {
//            throw new BankAppException("Bank code '" + bankCode + "' is already registered.");
//        }
//        registeredBanks.put(bankCode, bankApp);
//    }
//
//    public void intraTransfer(String bankCode,
//                              String senderAccountNumber,
//                              String senderPin,
//                              String receiverAccountNumber,
//                              BigDecimal amount) throws AccountNotFoundException {
//
//        validateNotSelfTransfer(senderAccountNumber, receiverAccountNumber);
//
//        BankApp bank = findBankOrThrow(bankCode);
//
//        validateAccountExists(bank, senderAccountNumber);
//        validateAccountExists(bank, receiverAccountNumber);
//        validateAmount(amount);
//
//        bank.checkBalance(senderAccountNumber, senderPin);
//
//        bank.debit(senderAccountNumber, amount, senderPin);
//        bank.credit(receiverAccountNumber, amount);
//    }
//
//    public void interTransfer(String senderBankCode,
//                              String senderAccountNumber,
//                              String senderPin,
//                              String receiverBankCode,
//                              String receiverAccountNumber,
//                              BigDecimal amount) throws AccountNotFoundException {
//
//        if (senderBankCode.equals(receiverBankCode)) {
//            throw new BankAppException(
//                    "Both accounts are in the same bank. Use intraTransfer() instead.");
//        }
//
//        validateNotSelfTransfer(senderAccountNumber, receiverAccountNumber);
//
//        BankApp senderBank = findBankOrThrow(senderBankCode);
//        BankApp receiverBank = findBankOrThrow(receiverBankCode);
//
//        validateAccountExists(senderBank, senderAccountNumber);
//        validateAccountExists(receiverBank, receiverAccountNumber);
//        validateAmount(amount);
//
//        senderBank.checkBalance(senderAccountNumber, senderPin);
//
//        senderBank.debit(senderAccountNumber, amount, senderPin);
//        receiverBank.credit(receiverAccountNumber, amount);
//    }
//
//    public BigDecimal checkBalance(String bankCode, String accountNumber, String pin) {
//        BankApp bank = findBankOrThrow(bankCode);
//        return bank.checkBalance(accountNumber, pin);
//    }
//
//    private BankApp findBankOrThrow(String bankCode) {
//        BankApp bank = registeredBanks.get(bankCode);
//        if (bank == null) {
//            throw new BankNotFoundException(bankCode);
//        }
//        return bank;
//    }
//
//    private void validateAccountExists(BankApp bank, String accountNumber) throws AccountNotFoundException {
//        if (!bank.hasAccount(accountNumber)) {
//            throw new AccountNotFoundException(accountNumber);
//        }
//    }
//
//    private void validateNotSelfTransfer(String senderAccount, String receiverAccount) {
//        if (senderAccount.equals(receiverAccount)) {
//            throw new SelfTransferException();
//        }
//    }
//
//    private void validateAmount(BigDecimal amount) {
//        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
//            throw new InvalidAmountException();
//        }
//    }
//}