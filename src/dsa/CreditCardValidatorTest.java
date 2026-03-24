package dsa;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CreditCardValidatorTest {

    @Test
    void shouldValidateVisaCardCorrectly() {
        String card = "4111111111111111";

        assertTrue(CreditCardValidator.isValidCard(card));
        assertEquals("Visa", CreditCardValidator.getCardType(card));
    }

    @Test
    void shouldValidateMasterCardCorrectly() {
        String card = "5555555555554444";

        assertTrue(CreditCardValidator.isValidCard(card));
        assertEquals("MasterCard", CreditCardValidator.getCardType(card));
    }

    @Test
    void shouldValidateAmericanExpressCorrectly() {
        String card = "378282246310005";

        assertTrue(CreditCardValidator.isValidCard(card));
        assertEquals("American Express", CreditCardValidator.getCardType(card));
    }

    @Test
    void shouldValidateDiscoverCardCorrectly() {
        String card = "6011111111111117";

        assertTrue(CreditCardValidator.isValidCard(card));
        assertEquals("Discover", CreditCardValidator.getCardType(card));
    }

    @Test
    void shouldReturnInvalidForWrongCardNumber() {
        String card = "4388576018402626";

        assertFalse(CreditCardValidator.isValidCard(card));
        assertEquals("Visa", CreditCardValidator.getCardType(card));
    }

    @Test
    void shouldReturnInvalidEvenIfTypeIsCorrect() {
        String card = "4111111111111121"; // Visa format but invalid

        assertFalse(CreditCardValidator.isValidCard(card));
        assertEquals("Visa", CreditCardValidator.getCardType(card));
    }
}