package dsa.Week2.day1;

public class AirConditioner {

    private boolean isOn;
    private int temperature = 24;
    private int fanSpeed    = 1;
    private ACMode mode     = ACMode.COOL;



    public void turnOn() {
        isOn = true;
    }

    public void turnOff() {
        isOn = false;
    }

    public boolean isOn() {
        return isOn;
    }



    public int getTemperature() {
        return temperature;
    }

    public void increaseTemperature() {
        if (!isOn) return;
        if (temperature < 30) temperature++;
    }

    public void decreaseTemperature() {
        if (!isOn) return;
        if (temperature > 16) temperature--;
    }

    public void setTemperature(int temperature) {
        if (!isOn) return;
        if (temperature >= 16 && temperature <= 30) {
            this.temperature = temperature;
        }
    }



    public int getFanSpeed() {
        return fanSpeed;
    }

    public void fanSpeedUp() {
        if (!isOn) return;
        if (fanSpeed < 3) fanSpeed++;
    }

    public void fanSpeedDown() {
        if (!isOn) return;
        if (fanSpeed > 1) fanSpeed--;
    }


    public ACMode getMode() {
        return mode;
    }

    public void switchMode(ACMode mode) {
        if (!isOn) return;
        this.mode = mode;
    }
}

