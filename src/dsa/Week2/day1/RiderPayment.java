package dsa.Week2.day1;

public class RiderPayment {

    public static int calculateWage(int successfulDeliveries) {
        int basePay = 5000;
        int totalPackages = 100;

        double percentage = (successfulDeliveries * 100.0) / totalPackages;

        int rate;

        if (percentage < 50) {
            rate = 160;
        } else if (percentage < 60) {
            rate = 200;
        } else if (percentage < 70) {
            rate = 250;
        } else {
            rate = 500;
        }

        return (successfulDeliveries * rate) + basePay;
    }
}
