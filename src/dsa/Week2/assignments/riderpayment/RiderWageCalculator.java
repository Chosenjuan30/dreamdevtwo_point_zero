package dsa.Week2.assignments.riderpayment;



public class RiderWageCalculator {

    public static final int TOTAL_PACKAGES = 100;
    public static final int BASE_PAY       = 5_000;

    public static final int RATE_BELOW_50  = 160;
    public static final int RATE_50_TO_59  = 200;
    public static final int RATE_60_TO_69  = 250;
    public static final int RATE_70_PLUS   = 500;

    public static int calculateWage(int successfulDeliveries) {
        if (successfulDeliveries < 0 || successfulDeliveries > TOTAL_PACKAGES) {
            throw new IllegalArgumentException(
                    "Deliveries must be between 0 and " + TOTAL_PACKAGES +
                            ". Received: " + successfulDeliveries
            );
        }

        int ratePerParcel = getRatePerParcel(successfulDeliveries);
        return (successfulDeliveries * ratePerParcel) + BASE_PAY;
    }

    public static int getRatePerParcel(int successfulDeliveries) {
        int percentage = successfulDeliveries;

        if (percentage >= 70) return RATE_70_PLUS;
        if (percentage >= 60) return RATE_60_TO_69;
        if (percentage >= 50) return RATE_50_TO_59;
        return RATE_BELOW_50;
    }
}