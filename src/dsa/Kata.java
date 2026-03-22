package dsa;

public class Kata {


    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static boolean isPrimeNumber(int number) {
        if (number <= 1) return false;

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }


    public static int subtract(int a, int b) {
        return Math.abs(a - b);
    }

    public static float divide(int a, int b) {
        if (b == 0) {
            return 0;
        }
        return (float) a / b;
    }

    // 5. Number of factors
    public static int factorOf(int number) {
        int count = 0;

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }

        return count;
    }

    // 6. Check if square number
    public static boolean isSquare(int number) {
        if (number < 0) return false;

        int sqrt = (int) Math.sqrt(number);
        return sqrt * sqrt == number;
    }

    // 7. Check if 5-digit palindrome
    public static boolean isPalindrome(int number) {
        if (number < 10000 || number > 99999) {
            return false; // ensure it's a 5-digit number
        }

        int original = number;
        int reversed = 0;

        while (number > 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }

        return original == reversed;
    }

    // 8. Factorial
    public static long factorialOf(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number must be non-negative");
        }

        long result = 1;

        for (int i = 1; i <= number; i++) {
            result *= i;
        }

        return result;
    }

    // 9. Square of a number
    public static long squareOf(int number) {
        return (long) number * number;
    }

    // Main method for testing
    public static void main(String[] args) {
        System.out.println("isEven(4): " + isEven(4));
        System.out.println("isPrimeNumber(7): " + isPrimeNumber(7));
        System.out.println("subtract(3,7): " + subtract(3,7));
        System.out.println("divide(10,2): " + divide(10,2));
        System.out.println("factorOf(10): " + factorOf(10));
        System.out.println("isSquare(25): " + isSquare(25));
        System.out.println("isPalindrome(54145): " + isPalindrome(54145));
        System.out.println("factorialOf(5): " + factorialOf(5));
        System.out.println("squareOf(5): " + squareOf(5));
    }
}
