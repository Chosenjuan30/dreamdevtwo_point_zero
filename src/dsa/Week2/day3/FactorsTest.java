package dsa.Week2.day3;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FactorsTest {

    @Test
    void shouldReturnFactorsOf12() {
        List<Integer> result = Factors.getFactors(12);
        assertEquals(List.of(1, 2, 3, 4, 6, 12), result);
    }

    @Test
    void shouldReturnFactorsOf1() {
        List<Integer> result = Factors.getFactors(1);
        assertEquals(List.of(1), result);
    }

    @Test
    void shouldReturnPrimeNumberFactors() {
        List<Integer> result = Factors.getFactors(7);
        assertEquals(List.of(1, 7), result);
    }

    @Test
    void shouldReturnFactorsOfPerfectSquare() {
        List<Integer> result = Factors.getFactors(36);
        assertEquals(List.of(1, 2, 3, 4, 6, 9, 12, 18, 36), result);
    }

    @Test
    void shouldThrowExceptionForZeroOrNegativeNumbers() {
        assertThrows(IllegalArgumentException.class, () -> Factors.getFactors(0));
        assertThrows(IllegalArgumentException.class, () -> Factors.getFactors(-5));
    }
    }

