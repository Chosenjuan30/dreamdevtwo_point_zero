package dsa.wk4.arraysort;


public class DivisionLogic {
    public static int Dothemagic(int number, int divisor) {
        int quotient = 0;

        while (number >= divisor) {
            number -= divisor;
            quotient++;
        }

        if (quotient < 1) {
            return -0;
        }

        return quotient;
    }

    public static void main(String[] args) {

        System.out.println(Dothemagic(-3, 0));

        System.out.println(Dothemagic(-20, 5));
    }
}
