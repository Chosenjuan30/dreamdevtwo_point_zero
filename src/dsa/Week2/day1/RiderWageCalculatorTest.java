package dsa.Week2.day1;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

@DisplayName("RiderWageCalculator")
public class RiderWageCalculatorTest {

    @Nested
    @DisplayName("PDF sample verification")
    public class PDFSamplesTests {

        @Test
        @DisplayName("Sample 1: 80 deliveries should return ₦45000 — exact sample from PDF")
        void sample1_80DeliveriesReturns45000() {
            assertEquals(45_000, RiderWageCalculator.calculateWage(80));
        }

        @Test
        @DisplayName("Sample 2: 25 deliveries should return ₦9000 — exact sample from PDF")
        public void sample2_25DeliveriesReturns9000() {
            assertEquals(9_000, RiderWageCalculator.calculateWage(25));
        }
    }

    @Nested
    @DisplayName("Collection rate < 50% — rate is ₦160 per parcel")
   public class LessThan50PercentTests {

        @Test
        @DisplayName("0 deliveries → ₦5000 (base pay only, 0 × 160 + 5000)")
        void zeroDeliveries() {
            assertEquals(5_000, RiderWageCalculator.calculateWage(0));
        }

        @Test
        @DisplayName("25 deliveries → ₦9000 (25 × 160 + 5000) — PDF sample")
        public void twentyFiveDeliveries() {
            assertEquals(9_000, RiderWageCalculator.calculateWage(25));
        }

        @Test
        @DisplayName("49 deliveries → ₦12840 (49 × 160 + 5000) — boundary just below 50%")
        public void fortyNineDeliveries() {
            assertEquals(12_840, RiderWageCalculator.calculateWage(49));
        }

        @Test
        @DisplayName("rate for < 50% deliveries should be ₦160")
        public void rateIs160ForBelow50() {
            assertEquals(160, RiderWageCalculator.getRatePerParcel(30));
        }
    }

    @Nested
    @DisplayName("Collection rate 50–59% — rate is ₦200 per parcel")
    public class FiftyTo59PercentTests {

        @Test
        @DisplayName("50 deliveries → ₦15000 (50 × 200 + 5000) — boundary at exactly 50%")
        public void fiftyDeliveries() {
            assertEquals(15_000, RiderWageCalculator.calculateWage(50));
        }

        @Test
        @DisplayName("55 deliveries → ₦16000 (55 × 200 + 5000)")
        public void fiftyFiveDeliveries() {
            assertEquals(16_000, RiderWageCalculator.calculateWage(55));
        }

        @Test
        @DisplayName("59 deliveries → ₦16800 (59 × 200 + 5000) — boundary at top of range")
        public void fiftyNineDeliveries() {
            assertEquals(16_800, RiderWageCalculator.calculateWage(59));
        }

        @Test
        @DisplayName("rate for 50–59% deliveries should be ₦200")
        public void rateIs200For50To59() {
            assertEquals(200, RiderWageCalculator.getRatePerParcel(55));
        }
    }

    @Nested
    @DisplayName("Collection rate 60–69% — rate is ₦250 per parcel")
    public class SixtyTo69PercentTests {

        @Test
        @DisplayName("60 deliveries → ₦20000 (60 × 250 + 5000) — boundary at exactly 60%")
        public void sixtyDeliveries() {
            assertEquals(20_000, RiderWageCalculator.calculateWage(60));
        }

        @Test
        @DisplayName("65 deliveries → ₦21250 (65 × 250 + 5000)")
        public void sixtyFiveDeliveries() {
            assertEquals(21_250, RiderWageCalculator.calculateWage(65));
        }

        @Test
        @DisplayName("69 deliveries → ₦22250 (69 × 250 + 5000) — boundary at top of range")
        public void sixtyNineDeliveries() {
            assertEquals(22_250, RiderWageCalculator.calculateWage(69));
        }

        @Test
        @DisplayName("rate for 60–69% deliveries should be ₦250")
        public void rateIs250For60To69() {
            assertEquals(250, RiderWageCalculator.getRatePerParcel(65));
        }
    }

    @Nested
    @DisplayName("Collection rate >= 70% — rate is ₦500 per parcel")
    public class SeventyPlusPercentTests {

        @Test
        @DisplayName("70 deliveries → ₦40000 (70 × 500 + 5000) — boundary at exactly 70%")
        public void seventyDeliveries() {
            assertEquals(40_000, RiderWageCalculator.calculateWage(70));
        }

        @Test
        @DisplayName("80 deliveries → ₦45000 (80 × 500 + 5000) — PDF sample 1")
        public void eightyDeliveries() {
            assertEquals(45_000, RiderWageCalculator.calculateWage(80));
        }

        @Test
        @DisplayName("100 deliveries → ₦55000 (100 × 500 + 5000) — perfect delivery day")
        public void perfectDeliveryDay() {
            assertEquals(55_000, RiderWageCalculator.calculateWage(100));
        }

        @Test
        @DisplayName("rate for >= 70% deliveries should be ₦500")
        public void rateIs500For70Plus() {
            assertEquals(500, RiderWageCalculator.getRatePerParcel(80));
        }
    }

    @Nested
    @DisplayName("Edge cases and invalid input")
    public class EdgeCaseTests {

        @Test
        @DisplayName("should throw IllegalArgumentException for negative deliveries")
        public void negativeDeliveriesThrows() {
            assertThrows(IllegalArgumentException.class,
                    () -> RiderWageCalculator.calculateWage(-1));
        }

        @Test
        @DisplayName("should throw IllegalArgumentException for deliveries > 100")
        public void over100DeliveriesThrows() {
            assertThrows(IllegalArgumentException.class,
                    () -> RiderWageCalculator.calculateWage(101));
        }

        @Test
        @DisplayName("exception message should describe the invalid input clearly")
        public void exceptionMessageIsDescriptive() {
            IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                    () -> RiderWageCalculator.calculateWage(150));
            assertTrue(ex.getMessage().contains("150"),
                    "Exception message should include the invalid value");
        }
    }
}
