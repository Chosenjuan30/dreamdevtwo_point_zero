package dsa.Week2.day1;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static dsa.Week2.day1.PizzaOrderCalculator.PizzaType.*;
import static org.junit.jupiter.api.Assertions.*;


@DisplayName("PizzaOrderCalculator")
public class PizzaOrderCalculatorTest {



    @Nested
    @DisplayName("PizzaType enum")
    public class PizzaTypeTests {

        @Test
        @DisplayName("Sapa size should have 4 slices and cost ₦2500 per box")
        void sapaSizeAttributes() {
            assertEquals(4,     SAPA_SIZE.getSlicesPerBox());
            assertEquals(2_500, SAPA_SIZE.getPricePerBox());
        }

        @Test
        @DisplayName("Small Money should have 6 slices and cost ₦2900 per box")
        void smallMoneyAttributes() {
            assertEquals(6,     SMALL_MONEY.getSlicesPerBox());
            assertEquals(2_900, SMALL_MONEY.getPricePerBox());
        }

        @Test
        @DisplayName("Big boys should have 8 slices and cost ₦4000 per box")
        void bigBoysAttributes() {
            assertEquals(8,     BIG_BOYS.getSlicesPerBox());
            assertEquals(4_000, BIG_BOYS.getPricePerBox());
        }

        @Test
        @DisplayName("Odogwu should have 12 slices and cost ₦5200 per box — matches PDF")
        void odogwuAttributes() {
            assertEquals(12,    ODOGWU.getSlicesPerBox());
            assertEquals(5_200, ODOGWU.getPricePerBox());
        }

        @Test
        @DisplayName("fromString() should be case-insensitive and accept 'odogwu'")
        void fromStringIsCaseInsensitive() {
            assertEquals(ODOGWU, PizzaOrderCalculator.PizzaType.fromString("odogwu"));
        }

        @Test
        @DisplayName("fromString() should throw for an unrecognised pizza type")
        void fromStringThrowsForUnknownType() {
            assertThrows(IllegalArgumentException.class,
                    () -> PizzaOrderCalculator.PizzaType.fromString("Pepperoni Supreme"));
        }
    }


    @Nested
    @DisplayName("calculateBoxesNeeded()")
    class BoxesNeededTests {

        @Test
        @DisplayName("45 guests, Odogwu → 4 boxes (⌈45/12⌉ = 4) — exact PDF sample")
        void pdfSampleOdogwu45Guests() {
            assertEquals(4, PizzaOrderCalculator.calculateBoxesNeeded(45, ODOGWU));
        }

        @Test
        @DisplayName("12 guests, Odogwu → 1 box (perfect fit, no rounding needed)")
        void exactFitOneBox() {
            assertEquals(1, PizzaOrderCalculator.calculateBoxesNeeded(12, ODOGWU));
        }

        @Test
        @DisplayName("13 guests, Odogwu → 2 boxes (one over the limit, must round up)")
        void justOverOneBucketRoundsUp() {
            assertEquals(2, PizzaOrderCalculator.calculateBoxesNeeded(13, ODOGWU));
        }

        @Test
        @DisplayName("10 guests, Sapa size → 3 boxes (⌈10/4⌉ = 3)")
        void sapaSizeTenGuests() {
            assertEquals(3, PizzaOrderCalculator.calculateBoxesNeeded(10, SAPA_SIZE));
        }

        @Test
        @DisplayName("6 guests, Small Money → 1 box (exact fit)")
        void smallMoneyExactFit() {
            assertEquals(1, PizzaOrderCalculator.calculateBoxesNeeded(6, SMALL_MONEY));
        }

        @Test
        @DisplayName("1 guest, Big boys → 1 box (minimum order)")
        void oneGuestMinimumOrder() {
            assertEquals(1, PizzaOrderCalculator.calculateBoxesNeeded(1, BIG_BOYS));
        }

        @Test
        @DisplayName("should throw IllegalArgumentException for 0 guests")
        void zeroGuestsThrows() {
            assertThrows(IllegalArgumentException.class,
                    () -> PizzaOrderCalculator.calculateBoxesNeeded(0, ODOGWU));
        }

        @Test
        @DisplayName("should throw IllegalArgumentException for negative guests")
        void negativeGuestsThrows() {
            assertThrows(IllegalArgumentException.class,
                    () -> PizzaOrderCalculator.calculateBoxesNeeded(-5, ODOGWU));
        }
    }



    @Nested
    @DisplayName("calculateLeftoverSlices()")
    class LeftoverSlicesTests {

        @Test
        @DisplayName("45 guests, Odogwu → 3 leftover slices (4×12=48, 48-45=3) — exact PDF sample")
        void pdfSampleOdogwu45Guests() {
            assertEquals(3, PizzaOrderCalculator.calculateLeftoverSlices(45, ODOGWU));
        }

        @Test
        @DisplayName("12 guests, Odogwu → 0 leftover slices (perfect fit)")
        void perfectFitNoLeftovers() {
            assertEquals(0, PizzaOrderCalculator.calculateLeftoverSlices(12, ODOGWU));
        }

        @Test
        @DisplayName("7 guests, Sapa size → 1 leftover (⌈7/4⌉=2 boxes, 8-7=1)")
        void sapaSizeSevenGuests() {
            assertEquals(1, PizzaOrderCalculator.calculateLeftoverSlices(7, SAPA_SIZE));
        }

        @Test
        @DisplayName("5 guests, Small Money → 1 leftover (1 box=6 slices, 6-5=1)")
        void smallMoneyFiveGuests() {
            assertEquals(1, PizzaOrderCalculator.calculateLeftoverSlices(5, SMALL_MONEY));
        }
    }



    @Nested
    @DisplayName("calculateTotalPrice()")
    class TotalPriceTests {

        @Test
        @DisplayName("45 guests, Odogwu → ₦20800 (4 boxes × ₦5200) — exact PDF sample")
        void pdfSampleOdogwu45Guests() {
            assertEquals(20_800, PizzaOrderCalculator.calculateTotalPrice(45, ODOGWU));
        }

        @Test
        @DisplayName("12 guests, Odogwu → ₦5200 (1 box × ₦5200)")
        void odogwuOneBox() {
            assertEquals(5_200, PizzaOrderCalculator.calculateTotalPrice(12, ODOGWU));
        }

        @Test
        @DisplayName("4 guests, Sapa size → ₦2500 (1 box × ₦2500)")
        void sapaSizeOneBox() {
            assertEquals(2_500, PizzaOrderCalculator.calculateTotalPrice(4, SAPA_SIZE));
        }

        @Test
        @DisplayName("10 guests, Sapa size → ₦7500 (3 boxes × ₦2500)")
        void sapaSizeThreeBoxes() {
            assertEquals(7_500, PizzaOrderCalculator.calculateTotalPrice(10, SAPA_SIZE));
        }

        @Test
        @DisplayName("16 guests, Big boys → ₦8000 (2 boxes × ₦4000)")
        void bigBoysTwoBoxes() {
            assertEquals(8_000, PizzaOrderCalculator.calculateTotalPrice(16, BIG_BOYS));
        }
    }



    @Nested
    @DisplayName("End-to-end order scenarios")
    class EndToEndTests {

        @ParameterizedTest(name = "{0} guests, {1} → {2} boxes, {3} leftover, ₦{4}")
        @CsvSource({
                "45, ODOGWU,      4, 3,  20800",
                "12, ODOGWU,      1, 0,   5200",
                "10, SAPA_SIZE,   3, 2,   7500",
                "6,  SMALL_MONEY, 1, 0,   2900",
                "9,  BIG_BOYS,    2, 7,   8000"
        })
        @DisplayName("parameterised order scenarios should all return correct results")
        void allOrderScenarios(int guests, String typeStr, int expectedBoxes,
                               int expectedLeftover, int expectedPrice) {
            PizzaOrderCalculator.PizzaType type = PizzaOrderCalculator.PizzaType.valueOf(typeStr);
            assertAll(
                    () -> assertEquals(expectedBoxes,   PizzaOrderCalculator.calculateBoxesNeeded(guests, type),    "boxes"),
                    () -> assertEquals(expectedLeftover, PizzaOrderCalculator.calculateLeftoverSlices(guests, type), "leftover"),
                    () -> assertEquals(expectedPrice,    PizzaOrderCalculator.calculateTotalPrice(guests, type),     "price")
            );
        }
    }
}
