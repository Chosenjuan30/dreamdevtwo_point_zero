package dsa.Week2.day2;

public class Lcm {

    public static long gcd(long a, long b) {
        a = Math.abs(a);
        b = Math.abs(b);

        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static long lcm(long a, long b) {
        if (a == 0 || b == 0) return 0;
        return Math.abs((a / gcd(a, b)) * b);
    }

    public static long lcm(long... numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Numbers cannot be empty");
        }

        long result = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            result = lcm(result, numbers[i]);
        }

        return result;
    }

    public static void main(String[] args) {

        // Test GCD
        System.out.println("gcd(12, 18): " + gcd(12, 18)); // 6

        // Test LCM of two numbers
        System.out.println("lcm(4, 6): " + lcm(4, 6)); // 12

        // Test LCM of multiple numbers
        System.out.println("lcm(4, 6, 8): " + lcm(4, 6, 8)); // 24

        // Edge cases
        System.out.println("lcm(0, 5): " + lcm(0, 5)); // 0
        System.out.println("lcm(-4, 6): " + lcm(-4, 6)); // 12
    }
}