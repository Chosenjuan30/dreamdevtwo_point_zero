package dsa;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CreditCardValidatorTest {

    @Test
    void shouldReturnValidCard() {
        assertTrue(CreditCardValidator.isValidCard("4388576018410707"));
    }

    @Test
    void shouldReturnInvalidCard() {
        assertFalse(CreditCardValidator.isValidCard("4388576018402626"));
    }

    @Test
    void shouldDetectVisa() {
        assertEquals("Visa", CreditCardValidator.getCardType("4388576018410707"));
    }

    @Test
    void shouldDetectMasterCard() {
        assertEquals("MasterCard", CreditCardValidator.getCardType("5123456789012345"));
    }

    @Test
    void shouldDetectAmericanExpress() {
        assertEquals("American Express", CreditCardValidator.getCardType("371234567890123"));
    }

    @Test
    void shouldDetectDiscover() {
        assertEquals("Discover", CreditCardValidator.getCardType("6011123456789012"));
    }
}