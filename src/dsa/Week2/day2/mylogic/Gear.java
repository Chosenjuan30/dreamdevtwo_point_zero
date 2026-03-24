package dsa.Week2.day2.mylogic;

public enum Gear {

    GEAR_ONE(0,20,1),
    GEAR_TWO(21,30,2),
    GEAR_THREE(31,40,3),
    GEAR_FOUR(41, Integer.MAX_VALUE, 4);

    private final int minSpeed;
    private final int maxSpeed;
    private final int increment;

    Gear(int minSpeed, int maxSpeed,int increment){
        this.minSpeed = minSpeed;
        this.maxSpeed = maxSpeed;
        this.increment = increment;
    }
    public int getIncrement(){
        return  increment;
    }
    public static  Gear fromSpeed(int speed){
        for(Gear gear : Gear.values()){
            if(speed >= gear.minSpeed && speed <= gear.maxSpeed){
                return gear;
            }
        }

        return GEAR_ONE;
    }
}
