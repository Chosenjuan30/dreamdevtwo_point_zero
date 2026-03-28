package dsa.Week2.day3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class BankAppTest {

    private BankApp bankApp;
    private String accountNumber;
    private final String VALID_PIN = "1234";

    @BeforeEach
    void setUp() {
        bankApp = new BankApp();
        accountNumber = bankApp.createAccount(VALID_PIN);
    }

    @Test
    @DisplayName("Should create account with valid 10-digit account number")
    void shouldCreateAccountSuccessfully() {
        assertNotNull(accountNumber);
        assertEquals(10, accountNumber.length());
        assertTrue(accountNumber.matches("\\d{10}"));
    }

    @Test
    @DisplayName("Should deposit successfully with correct PIN")
    void shouldDepositSuccessfully() {
        bankApp.deposit(accountNumber, new BigDecimal("1000"), VALID_PIN);

        BigDecimal balance = bankApp.checkBalance(accountNumber, VALID_PIN);
        assertEquals(new BigDecimal("1000"), balance);
    }

    @Test
    @DisplayName("Should withdraw successfully when sufficient balance exists")
    void shouldWithdrawSuccessfully() {
        bankApp.deposit(accountNumber, new BigDecimal("600"), VALID_PIN);
        bankApp.withdraw(accountNumber, new BigDecimal("400"), VALID_PIN);

        BigDecimal balance = bankApp.checkBalance(accountNumber, VALID_PIN);
        assertEquals(new BigDecimal("200"), balance);
    }

    @Test
    @DisplayName("Should throw exception when account not found")
    void shouldThrowExceptionWhenAccountNotFound() {
        assertThrows(IllegalArgumentException.class, () ->
                bankApp.deposit("9999999999", new BigDecimal("100"), VALID_PIN));
    }

    @Test
    @DisplayName("Should reject access with invalid PIN")
    void shouldRejectInvalidPin() {
        bankApp.deposit(accountNumber, new BigDecimal("500"), VALID_PIN);

        assertThrows(RuntimeException.class, () ->
                bankApp.checkBalance(accountNumber, "0000"));
    }

    @Test
    @DisplayName("Should not allow withdrawal greater than balance")
    void shouldNotAllowOverWithdrawal() {
        bankApp.deposit(accountNumber, new BigDecimal("300"), VALID_PIN);

        assertThrows(RuntimeException.class, () ->
                bankApp.withdraw(accountNumber, new BigDecimal("500"), VALID_PIN));
    }

    @Test
    @DisplayName("Should not allow negative deposit")
    void shouldRejectNegativeDeposit() {
        assertThrows(IllegalArgumentException.class, () ->
                bankApp.deposit(accountNumber, new BigDecimal("-100"), VALID_PIN));
    }

    @Test
    @DisplayName("Should reject negative withdrawal and not change balance")
    void shouldRejectNegativeWithdrawal() {
        bankApp.deposit(accountNumber, new BigDecimal("500"), VALID_PIN);

        BigDecimal initialBalance = bankApp.checkBalance(accountNumber, VALID_PIN);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> bankApp.withdraw(accountNumber, new BigDecimal("-50"), VALID_PIN)
        );

        assertEquals("Amount must be greater than zero", exception.getMessage());

        BigDecimal balanceAfter = bankApp.checkBalance(accountNumber, VALID_PIN);
        assertEquals(initialBalance, balanceAfter);
    }

    @Test
    @DisplayName("Balance should remain unchanged after failed transaction")
    void balanceShouldRemainUnchangedAfterFailure() {
        bankApp.deposit(accountNumber, new BigDecimal("500"), VALID_PIN);

        try {
            bankApp.withdraw(accountNumber, new BigDecimal("1000"), VALID_PIN);
        } catch (Exception ignored) {}

        BigDecimal balance = bankApp.checkBalance(accountNumber, VALID_PIN);
        assertEquals(new BigDecimal("500"), balance);
    }
}