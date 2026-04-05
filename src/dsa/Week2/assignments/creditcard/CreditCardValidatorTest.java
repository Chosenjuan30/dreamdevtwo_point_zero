package dsa.Week2.assignments.creditcard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CreditCardValidatorTest {

    @Test
    public void testVisaCardTypeDetected() {
        CreditCardValidator v = new CreditCardValidator(4388576018410707L);
        assertEquals(CardType.VISA, v.getCardType());
    }

    @Test
    public void testMasterCardTypeDetected() {
        CreditCardValidator v = new CreditCardValidator(5399831619690403L);
        assertEquals(CardType.MASTERCARD, v.getCardType());
    }

    @Test
    public void testAmericanExpressTypeDetected() {
        CreditCardValidator v = new CreditCardValidator(378282246310005L);
        assertEquals(CardType.AMERICAN_EXPRESS, v.getCardType());
    }

    @Test
    public void testDiscoverCardTypeDetected() {
        CreditCardValidator v = new CreditCardValidator(6011111111111117L);
        assertEquals(CardType.DISCOVER, v.getCardType());
    }

    @Test
    public void testInvalidCardTypeWhenWrongPrefix() {
        CreditCardValidator v = new CreditCardValidator(2345678901234567L);
        assertEquals(CardType.INVALID_CARD, v.getCardType());
    }

    @Test
    public void testInvalidCardTypeWhenTooShort() {
        CreditCardValidator v = new CreditCardValidator(411111111111L);
        assertEquals(CardType.INVALID_CARD, v.getCardType());
    }

    @Test
    public void testInvalidCardTypeWhenTooLong() {
        CreditCardValidator v = new CreditCardValidator(41111111111111111L);
        assertEquals(CardType.INVALID_CARD, v.getCardType());
    }

    @Test
    public void testDigitLengthIsCorrect() {
        CreditCardValidator v = new CreditCardValidator(5399831619690403L);
        assertEquals(16, v.getDigitLength());
    }

    @Test
    public void testKnownValidMasterCard() {
        CreditCardValidator v = new CreditCardValidator(5500005555555559L);
        assertTrue(v.isValid());
    }

    @Test
    public void testKnownInvalidMasterCard() {
        CreditCardValidator v = new CreditCardValidator(5500005555555558L);
        assertFalse(v.isValid());
    }

    @Test
    public void testKnownValidVisaCard() {
        CreditCardValidator v = new CreditCardValidator(4388576018410707L);
        assertTrue(v.isValid());
    }

    @Test
    public void testKnownInvalidVisaCard() {
        CreditCardValidator v = new CreditCardValidator(4388576018402626L);
        assertFalse(v.isValid());
    }

    @Test
    public void testLuhnFailsWhenCardTypeIsInvalid() {
        CreditCardValidator v = new CreditCardValidator(234319283049582L);
        assertFalse(v.isValid());
    }

    @Test
    public void testValidityStatusReturnsValid() {
        CreditCardValidator v = new CreditCardValidator(4388576018410707L);
        assertEquals("Valid", v.getValidityStatus());
    }

    @Test
    public void testValidityStatusReturnsInvalid() {
        CreditCardValidator v = new CreditCardValidator(4388576018402626L);
        assertEquals("Invalid", v.getValidityStatus());
    }

    @Test
    public void testSampleInputOneIsValidMasterCard() {
        CreditCardValidator v = new CreditCardValidator(5399831619690403L);
        assertEquals(CardType.MASTERCARD, v.getCardType());
        assertTrue(v.isValid());
        assertEquals(16, v.getDigitLength());
    }

    @Test
    public void testSampleInputTwoIsInvalidMasterCard() {
        CreditCardValidator v = new CreditCardValidator(5399831619690404L);
        assertEquals(CardType.MASTERCARD, v.getCardType());
        assertFalse(v.isValid());
        assertEquals(16, v.getDigitLength());
    }

    @Test
    public void testSampleInputThreeIsInvalidCard() {
        CreditCardValidator v = new CreditCardValidator(234319283049582L);
        assertEquals(CardType.INVALID_CARD, v.getCardType());
        assertFalse(v.isValid());
        assertEquals(15, v.getDigitLength());
    }
}