package dsa.Week2.day1;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayKata {


    public static int maximumIn(int[] array) {
        int max = array[0];
        for (int num : array) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static int minimumIn(int[] array) {
        int min = array[0];
        for (int num : array) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    public static int sumOf(int[] array) {
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        return sum;
    }


    public static int sumOfEvenNumbersIn(int[] array) {
        int sum = 0;
        for (int num : array) {
            if (num % 2 == 0) {
                sum += num;
            }
        }
        return sum;
    }

    public static int sumOfOddNumbersIn(int[] array) {
        int sum = 0;
        for (int num : array) {
            if (num % 2 != 0) {
                sum += num;
            }
        }
        return sum;
    }

    public static int[] maximumAndMinimumOf(int[] array) {
        int min = minimumIn(array);
        int max = maximumIn(array);
        return new int[]{min, max};
    }

    public static int noOfOddNumbersIn(int[] array) {
        int count = 0;
        for (int num : array) {
            if (num % 2 != 0) {
                count++;
            }
        }
        return count;
    }

    public static int noOfEvenNumbersIn(int[] array) {
        int count = 0;
        for (int num : array) {
            if (num % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public static int[] evenNumbersIn(int[] array) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int num : array) {
            if (num % 2 == 0) {
                result.add(num);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static int[] oddNumbersIn(int[] array) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int num : array) {
            if (num % 2 != 0) {
                result.add(num);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static int[] squareNumbersIn(int[] array) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int num : array) {
            int sqrt = (int) Math.sqrt(num);
            if (sqrt * sqrt == num) {
                result.add(num);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] numbers = {1, 4, 7, 9, 16, 25, 8, 3};

        System.out.println("Max: " + maximumIn(numbers));
        System.out.println("Min: " + minimumIn(numbers));
        System.out.println("Sum: " + sumOf(numbers));
        System.out.println("Even Sum: " + sumOfEvenNumbersIn(numbers));
        System.out.println("Odd Sum: " + sumOfOddNumbersIn(numbers));
        System.out.println("Min & Max: " + Arrays.toString(maximumAndMinimumOf(numbers)));
        System.out.println("Odd Count: " + noOfOddNumbersIn(numbers));
        System.out.println("Even Count: " + noOfEvenNumbersIn(numbers));
        System.out.println("Even Numbers: " + Arrays.toString(evenNumbersIn(numbers)));
        System.out.println("Odd Numbers: " + Arrays.toString(oddNumbersIn(numbers)));
        System.out.println("Square Numbers: " + Arrays.toString(squareNumbersIn(numbers)));
    }
}
