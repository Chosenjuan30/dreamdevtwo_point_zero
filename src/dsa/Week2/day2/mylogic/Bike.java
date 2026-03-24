package dsa.Week2.day2.mylogic;

public class Bike {

    private boolean isOn;
    private int speed;

    public boolean isOn() {
        return isOn;
    }

    public void turnOn() {
        isOn = true;
    }

    public void turnOff() {
        isOn = false;
        speed = 0;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        if (isOn && speed >= 0) {
            this.speed = speed;
        }
    }

    public Gear getGear() {
        return Gear.fromSpeed(speed);
    }

    public void accelerate() {
        if (!isOn) return;

        speed += getGear().getIncrement();
    }

    public void decelerate() {
        if (!isOn) return;

        speed -= getGear().getIncrement();

        if (speed < 0) speed = 0;
    }
}