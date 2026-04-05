package dsa.Week2.assignments.arraykata;


import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("ArrayKata Test Suite")
public class ArrayKataTest {

    private int[] numbers;

    @BeforeEach
   public void setUp() {
        numbers = new int[]{1, 4, 7, 9, 16, 25, 8, 3};
    }

    @Nested
    @DisplayName("Maximum tests")
    public class MaximumTests {

        @Test
        @DisplayName("returns largest number from array")
        public void testMaximumInReturnsLargestNumber() {
            assertEquals(25, ArrayKata.maximumIn(numbers));
        }

        @Test
        @DisplayName("returns correct max from all negative numbers")
        void testMaximumInWithAllNegativeNumbers() {
            assertEquals(-1, ArrayKata.maximumIn(new int[]{-5, -3, -1, -9}));
        }

        @Test
        @DisplayName("returns element itself when array has single element")
        public void testMaximumInWithSingleElement() {
            assertEquals(7, ArrayKata.maximumIn(new int[]{7}));
        }

        @Test
        @DisplayName("returns correct max when duplicates exist")
        public void testMaximumInWithDuplicates() {
            assertEquals(9, ArrayKata.maximumIn(new int[]{9, 9, 3, 1}));
        }
    }

    @Nested
    @DisplayName("Minimum tests")
    public class MinimumTests {

        @Test
        @DisplayName("returns smallest number from array")
        public void testMinimumInReturnsSmallestNumber() {
            assertEquals(1, ArrayKata.minimumIn(numbers));
        }

        @Test
        @DisplayName("returns correct min from all negative numbers")
        public void testMinimumInWithAllNegativeNumbers() {
            assertEquals(-9, ArrayKata.minimumIn(new int[]{-5, -3, -1, -9}));
        }

        @Test
        @DisplayName("returns element itself when array has single element")
        public void testMinimumInWithSingleElement() {
            assertEquals(3, ArrayKata.minimumIn(new int[]{3}));
        }

        @Test
        @DisplayName("returns correct min when duplicates exist")
        public void testMinimumInWithDuplicates() {
            assertEquals(1, ArrayKata.minimumIn(new int[]{1, 1, 5, 9}));
        }
    }

    @Nested
    @DisplayName("Sum tests")
    public class SumTests {

        @Test
        @DisplayName("returns correct sum of all elements")
        public void testSumOfReturnsCorrectTotal() {
            assertEquals(73, ArrayKata.sumOf(numbers));
        }

        @Test
        @DisplayName("returns zero when all elements are zero")
        public void testSumOfWithAllZeros() {
            assertEquals(0, ArrayKata.sumOf(new int[]{0, 0, 0}));
        }

        @Test
        @DisplayName("returns element itself when array has single element")
        public void testSumOfWithSingleElement() {
            assertEquals(5, ArrayKata.sumOf(new int[]{5}));
        }

        @Test
        @DisplayName("returns correct sum with negative numbers")
        public void testSumOfWithNegativeNumbers() {
            assertEquals(-3, ArrayKata.sumOf(new int[]{-5, -3, 5}));
        }
    }

    @Nested
    @DisplayName("Sum of even numbers tests")
    public class SumOfEvenTests {

        @Test
        @DisplayName("returns correct sum of even numbers")
        public void testSumOfEvenNumbersInReturnsCorrectSum() {
            assertEquals(28, ArrayKata.sumOfEvenNumbersIn(numbers));
        }

        @Test
        @DisplayName("returns zero when no even numbers exist")
        public void testSumOfEvenNumbersInWithNoEvens() {
            assertEquals(0, ArrayKata.sumOfEvenNumbersIn(new int[]{1, 3, 5, 7}));
        }

        @Test
        @DisplayName("returns correct sum when all numbers are even")
        public void testSumOfEvenNumbersInWithAllEvens() {
            assertEquals(12, ArrayKata.sumOfEvenNumbersIn(new int[]{2, 4, 6}));
        }

        @ParameterizedTest(name = "sum of evens in [{0}] = {1}")
        @CsvSource({
                "2,       2",
                "4,       4",
                "6,       6",
                "8,       8"
        })
        @DisplayName("returns correct sum for single even number")
        public void testSumOfEvenWithSingleEvenNumber(int input, int expected) {
            assertEquals(expected, ArrayKata.sumOfEvenNumbersIn(new int[]{input}));
        }
    }

    @Nested
    @DisplayName("Sum of odd numbers tests")
    public class SumOfOddTests {

        @Test
        @DisplayName("returns correct sum of odd numbers")
        public void testSumOfOddNumbersInReturnsCorrectSum() {
            assertEquals(45, ArrayKata.sumOfOddNumbersIn(numbers));
        }

        @Test
        @DisplayName("returns zero when no odd numbers exist")
        public void testSumOfOddNumbersInWithNoOdds() {
            assertEquals(0, ArrayKata.sumOfOddNumbersIn(new int[]{2, 4, 6}));
        }

        @Test
        @DisplayName("returns correct sum when all numbers are odd")
        public void testSumOfOddNumbersInWithAllOdds() {
            assertEquals(9, ArrayKata.sumOfOddNumbersIn(new int[]{1, 3, 5}));
        }

        @ParameterizedTest(name = "sum of odds in [{0}] = {1}")
        @CsvSource({
                "1, 1",
                "3, 3",
                "5, 5",
                "7, 7"
        })
        @DisplayName("returns correct sum for single odd number")
        public void testSumOfOddWithSingleOddNumber(int input, int expected) {
            assertEquals(expected, ArrayKata.sumOfOddNumbersIn(new int[]{input}));
        }
    }

    @Nested
    @DisplayName("Maximum and minimum tests")
    public class MaxAndMinTests {

        @Test
        @DisplayName("returns correct min and max pair")
        public void testMaximumAndMinimumOfReturnsCorrectPair() {
            assertArrayEquals(new int[]{1, 25}, ArrayKata.maximumAndMinimumOf(numbers));
        }

        @Test
        @DisplayName("returns same value for both min and max when single element")
        public void testMaximumAndMinimumOfWithSingleElement() {
            assertArrayEquals(new int[]{5, 5}, ArrayKata.maximumAndMinimumOf(new int[]{5}));
        }

        @Test
        @DisplayName("returns correct pair when only two elements exist")
        public void testMaximumAndMinimumOfWithTwoElements() {
            assertArrayEquals(new int[]{2, 8}, ArrayKata.maximumAndMinimumOf(new int[]{8, 2}));
        }

        @Test
        @DisplayName("returns correct pair with negative numbers")
        public void testMaximumAndMinimumOfWithNegativeNumbers() {
            assertArrayEquals(new int[]{-9, -1},
                    ArrayKata.maximumAndMinimumOf(new int[]{-1, -9, -4}));
        }
    }

    @Nested
    @DisplayName("Count of odd numbers tests")
    public class CountOddTests {

        @Test
        @DisplayName("returns correct count of odd numbers")
        public void testNoOfOddNumbersInReturnsCorrectCount() {
            assertEquals(5, ArrayKata.noOfOddNumbersIn(numbers));
        }

        @Test
        @DisplayName("returns zero when no odd numbers exist")
        public void testNoOfOddNumbersInWithNoOdds() {
            assertEquals(0, ArrayKata.noOfOddNumbersIn(new int[]{2, 4, 6}));
        }

        @Test
        @DisplayName("returns correct count when all numbers are odd")
        public void testNoOfOddNumbersInWithAllOdds() {
            assertEquals(3, ArrayKata.noOfOddNumbersIn(new int[]{1, 3, 5}));
        }
    }

    @Nested
    @DisplayName("Count of even numbers tests")
   public class CountEvenTests {

        @Test
        @DisplayName("returns correct count of even numbers")
        public void testNoOfEvenNumbersInReturnsCorrectCount() {
            assertEquals(3, ArrayKata.noOfEvenNumbersIn(numbers));
        }

        @Test
        @DisplayName("returns zero when no even numbers exist")
        public void testNoOfEvenNumbersInWithNoEvens() {
            assertEquals(0, ArrayKata.noOfEvenNumbersIn(new int[]{1, 3, 5}));
        }

        @Test
        @DisplayName("returns correct count when all numbers are even")
        public void testNoOfEvenNumbersInWithAllEvens() {
            assertEquals(3, ArrayKata.noOfEvenNumbersIn(new int[]{2, 4, 6}));
        }
    }

    @Nested
    @DisplayName("Even numbers extraction tests")
   public class EvenNumbersExtractionTests {

        @Test
        @DisplayName("returns only even numbers from mixed array")
        public void testEvenNumbersInReturnsOnlyEvenNumbers() {
            assertArrayEquals(new int[]{4, 16, 8}, ArrayKata.evenNumbersIn(numbers));
        }

        @Test
        @DisplayName("returns empty array when no even numbers exist")
        public void testEvenNumbersInWithNoEvens() {
            assertArrayEquals(new int[]{}, ArrayKata.evenNumbersIn(new int[]{1, 3, 5}));
        }

        @Test
        @DisplayName("returns all elements when all numbers are even")
        public void testEvenNumbersInWithAllEvens() {
            assertArrayEquals(new int[]{2, 4, 6}, ArrayKata.evenNumbersIn(new int[]{2, 4, 6}));
        }

        @Test
        @DisplayName("preserves order of even numbers")
        void testEvenNumbersInPreservesOrder() {
            assertArrayEquals(new int[]{8, 4, 2},
                    ArrayKata.evenNumbersIn(new int[]{8, 3, 4, 7, 2}));
        }
    }

    @Nested
    @DisplayName("Odd numbers extraction tests")
    class OddNumbersExtractionTests {

        @Test
        @DisplayName("returns only odd numbers from mixed array")
        void testOddNumbersInReturnsOnlyOddNumbers() {
            assertArrayEquals(new int[]{1, 7, 9,25, 3}, ArrayKata.oddNumbersIn(numbers));
        }

        @Test
        @DisplayName("returns empty array when no odd numbers exist")
        void testOddNumbersInWithNoOdds() {
            assertArrayEquals(new int[]{}, ArrayKata.oddNumbersIn(new int[]{2, 4, 6}));
        }

        @Test
        @DisplayName("returns all elements when all numbers are odd")
        void testOddNumbersInWithAllOdds() {
            assertArrayEquals(new int[]{1, 3, 5}, ArrayKata.oddNumbersIn(new int[]{1, 3, 5}));
        }

        @Test
        @DisplayName("preserves order of odd numbers")
        void testOddNumbersInPreservesOrder() {
            assertArrayEquals(new int[]{7, 3, 5},
                    ArrayKata.oddNumbersIn(new int[]{7, 2, 3, 4, 5}));
        }
    }

    @Nested
    @DisplayName("Square numbers extraction tests")
    class SquareNumbersExtractionTests {

        @Test
        @DisplayName("returns only perfect squares from array")
        void testSquareNumbersInReturnsOnlyPerfectSquares() {
            assertArrayEquals(new int[]{1, 4, 9, 16, 25}, ArrayKata.squareNumbersIn(numbers));
        }

        @Test
        @DisplayName("returns empty array when no perfect squares exist")
        void testSquareNumbersInWithNoSquares() {
            assertArrayEquals(new int[]{}, ArrayKata.squareNumbersIn(new int[]{2, 3, 5, 7}));
        }

        @Test
        @DisplayName("returns all elements when all are perfect squares")
        void testSquareNumbersInWithAllSquares() {
            assertArrayEquals(new int[]{4, 9, 25},
                    ArrayKata.squareNumbersIn(new int[]{4, 9, 25}));
        }

        @Test
        @DisplayName("includes zero as a valid perfect square")
        void testSquareNumbersInIncludesZeroAsSquare() {
            assertArrayEquals(new int[]{0, 4},
                    ArrayKata.squareNumbersIn(new int[]{0, 3, 4}));
        }

        @ParameterizedTest(name = "{0} is a perfect square")
        @CsvSource({
                "0,  0",
                "1,  1",
                "4,  4",
                "9,  9",
                "16, 16",
                "25, 25",
                "36, 36"
        })
        @DisplayName("correctly identifies individual perfect squares")
        void testIndividualPerfectSquares(int input, int expected) {
            assertArrayEquals(new int[]{expected},
                    ArrayKata.squareNumbersIn(new int[]{input}));
        }
    }
}
