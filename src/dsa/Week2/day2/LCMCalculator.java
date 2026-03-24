package dsa.Week2.day2;

public class LCMCalculator {

        /**
         * Calculates the Greatest Common Divisor (GCD) using the Euclidean algorithm.
         *
         * @param a The first number.
         * @param b The second number.
         * @return The GCD of a and b.
         */
        public static int calculateGCD(int a, int b) {
            while (b != 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        }

        /**
         * Calculates the Least Common Multiple (LCM) of two numbers using the GCD formula.
         *
         * @param num1 The first number.
         * @param num2 The second number.
         * @return The LCM of num1 and num2.
         */
        public static int calculateLCM(int num1, int num2) {
            // Ensure the numbers are positive for calculation, or handle potential overflow if extremely large
            int absoluteNum1 = Math.abs(num1);
            int absoluteNum2 = Math.abs(num2);

            if (absoluteNum1 == 0 || absoluteNum2 == 0) {
                return 0; // LCM is 0 if either number is 0
            }

            int gcd = calculateGCD(absoluteNum1, absoluteNum2);
            // Use long to prevent potential overflow during multiplication before division
            long lcm = (long) absoluteNum1 * absoluteNum2 / gcd;

            return (int) lcm;
        }

        public static void main(String[] args) {
            int number1 = 12;
            int number2 = 18;

            int lcmResult = calculateLCM(number1, number2);
            System.out.printf("The LCM of %d and %d is %d.%n", number1, number2, lcmResult); // Output: The LCM of 12 and 18 is 36.

            int number3 = 25;
            int number4 = 15;
            int lcmResult2 = calculateLCM(number3, number4);
            System.out.printf("The LCM of %d and %d is %d.%n", number3, number4, lcmResult2); // Output: The LCM of 25 and 15 is 75.
        }
    }


