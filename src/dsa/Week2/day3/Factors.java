package dsa.Week2.day3;

import java.util.ArrayList;
import java.util.List;

public class Factors {

    public static List<Integer> getFactors(int number) {


        if (number <= 0) {
            throw new IllegalArgumentException("Number must be greater than zero");
        }

        List<Integer> factors = new ArrayList<>();

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors.add(i);
            }
        }

        return factors;
    }

    public static void main(String[] args) {
        System.out.println(getFactors(20));
    }
}