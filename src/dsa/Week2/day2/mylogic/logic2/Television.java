package dsa.Week2.day2.mylogic.logic2;
public class Television {

    private boolean isOn;
    private int volume = 10; // default
    private int channel = 1;
    private InputSource inputSource = InputSource.TV;


    public void turnOn() {
        isOn = true;
    }

    public void turnOff() {
        isOn = false;
    }

    public boolean isOn() {
        return isOn;
    }


    public int getVolume() {
        return volume;
    }

    public void volumeUp() {
        if (!isOn) return;
        if (volume < 100) volume++;
    }

    public void volumeDown() {
        if (!isOn) return;
        if (volume > 0) volume--;
    }


    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        if (!isOn) return;
        if (channel >= 1 && channel <= 1000) {
            this.channel = channel;
        }
    }

    public void nextChannel() {
        if (!isOn) return;
        if (channel < 1000) channel++;
    }

    public void previousChannel() {
        if (!isOn) return;
        if (channel > 1) channel--;
    }


    public InputSource getInputSource() {
        return inputSource;
    }

    public void switchInput(InputSource inputSource) {
        if (!isOn) return;
        this.inputSource = inputSource;
    }
}

