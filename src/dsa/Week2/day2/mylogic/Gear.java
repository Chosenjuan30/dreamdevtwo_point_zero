package dsa.Week2.day2.mylogic;

public enum Gear {

    GEAR_ONE(0, 20, 1),
    GEAR_TWO(21, 30, 2),
    GEAR_THREE(31, 40, 3),
    GEAR_FOUR(41, Integer.MAX_VALUE, 4); // 41 and above

    private final int minSpeed;
    private final int maxSpeed;
    private final int increment;

    Gear(int minSpeed, int maxSpeed, int increment) {
        this.minSpeed = minSpeed;
        this.maxSpeed = maxSpeed;
        this.increment = increment;
    }

    public int getIncrement() {
        return increment;
    }

    public static Gear fromSpeed(int speed) {
        if (speed >= 0 && speed <= 20) return GEAR_ONE;
        if (speed >= 21 && speed <= 30) return GEAR_TWO;
        if (speed >= 31 && speed <= 40) return GEAR_THREE;
        return GEAR_FOUR; // 41 and above
    }
}