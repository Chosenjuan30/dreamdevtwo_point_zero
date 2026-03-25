package dsa.Week2.day2.mylogic.logic2;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class TelevisionTest {

    private Television tv;

    @BeforeEach
    void setUp() {
        tv = new Television();
        tv.turnOn();
    }


    @Test
    void tvIsOffByDefault() {
        Television newTv = new Television();
        assertFalse(newTv.isOn());
    }

    @Test
    void tvCanTurnOnAndOff() {
        tv.turnOff();
        assertFalse(tv.isOn());

        tv.turnOn();
        assertTrue(tv.isOn());
    }


    @Test
    void volumeIncreases() {
        int initial = tv.getVolume();
        tv.volumeUp();
        assertEquals(initial + 1, tv.getVolume());
    }

    @Test
    void volumeDoesNotExceedMax() {
        for (int i = 0; i < 200; i++) {
            tv.volumeUp();
        }
        assertEquals(100, tv.getVolume());
    }

    @Test
    void volumeDoesNotGoBelowZero() {
        for (int i = 0; i < 200; i++) {
            tv.volumeDown();
        }
        assertEquals(0, tv.getVolume());
    }


    @Test
    void channelCanBeSet() {
        tv.setChannel(50);
        assertEquals(50, tv.getChannel());
    }

    @Test
    void channelDoesNotExceedLimit() {
        tv.setChannel(2000);
        assertNotEquals(2000, tv.getChannel());
    }

    @Test
    void nextChannelWorks() {
        tv.setChannel(10);
        tv.nextChannel();
        assertEquals(11, tv.getChannel());
    }

    @Test
    void previousChannelWorks() {
        tv.setChannel(10);
        tv.previousChannel();
        assertEquals(9, tv.getChannel());
    }



    @Test
    void canSwitchToNetflix() {
        tv.switchInput(InputSource.NETFLIX);
        assertEquals(InputSource.NETFLIX, tv.getInputSource());
    }

    @Test
    void canSwitchToYouTube() {
        tv.switchInput(InputSource.YOUTUBE);
        assertEquals(InputSource.YOUTUBE, tv.getInputSource());
    }

    @Test
    void canSwitchToFirestick() {
        tv.switchInput(InputSource.FIRESTICK);
        assertEquals(InputSource.FIRESTICK, tv.getInputSource());
    }



    @Test
    void tvDoesNothingWhenOff() {
        tv.turnOff();

        int volume = tv.getVolume();
        tv.volumeUp();
        assertEquals(volume, tv.getVolume());

        tv.setChannel(50);
        assertNotEquals(50, tv.getChannel());
    }
}
