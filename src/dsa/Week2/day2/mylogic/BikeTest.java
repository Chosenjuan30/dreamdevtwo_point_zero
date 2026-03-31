package dsa.Week2.day2.mylogic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class BikeTest {

    private Bike bike;

    @BeforeEach
    void setUp() {
        bike = new Bike();
        bike.turnOn();
    }

    @Test
    @DisplayName("Bike should be OFF by default")
    void bikeIsOffByDefault() {
        Bike newBike = new Bike();
        assertFalse(newBike.isOn());
    }

    @Test
    @DisplayName("Bike turns ON correctly")
    void bikeTurnsOn() {
        assertTrue(bike.isOn());
    }

    @Test
    @DisplayName("Bike turns OFF and resets speed")
  public  void bikeTurnsOff() {
        bike.setSpeed(25);
        bike.turnOff();

        assertFalse(bike.isOn());
        assertEquals(0, bike.getSpeed());
    }


    @ParameterizedTest(name = "Speed {0} -> {1} (Gear {2})")
    @CsvSource({
            "15, 16, 1",
            "25, 27, 2",
            "35, 38, 3",
            "45, 49, 4"
    })
    @DisplayName("Bike accelerates correctly based on gear ranges")
   public void bikeAccelerates(int initialSpeed, int expectedSpeed, int expectedGear) {
        bike.setSpeed(initialSpeed);

        bike.accelerate();

        assertEquals(expectedSpeed, bike.getSpeed());
        assertEquals(expectedGear, bike.getGear().ordinal() + 1);
    }


    @ParameterizedTest(name = "Speed {0} -> {1} (Gear {2})")
    @CsvSource({
            "15, 14, 1",
            "25, 23, 2",
            "35, 32, 3",
            "45, 41, 4"
    })
    @DisplayName("Bike decelerates correctly based on gear ranges")
   public void bikeDecelerates(int initialSpeed, int expectedSpeed, int expectedGear) {
        bike.setSpeed(initialSpeed);

        bike.decelerate();

        assertEquals(expectedSpeed, bike.getSpeed());
        assertEquals(expectedGear, bike.getGear().ordinal() + 1);
    }



    @Test
    @DisplayName("Speed should never go below 0")
    public void speedNeverNegative() {
        bike.setSpeed(1);

        bike.decelerate();
        bike.decelerate();

        assertEquals(0, bike.getSpeed());
    }

    @Test
    @DisplayName("Bike does not accelerate when OFF")
    public void noAccelerationWhenOff() {
        bike.turnOff();

        bike.accelerate();

        assertEquals(0, bike.getSpeed());
    }

    @Test
    @DisplayName("Bike does not decelerate when OFF")
    void noDecelerationWhenOff() {
        bike.turnOff();

        bike.decelerate();

        assertEquals(0, bike.getSpeed());
    }


    @Test
    @DisplayName("Gear transitions correctly at boundary values")
    void gearTransitionsCorrectly() {


        bike.setSpeed(20);
        bike.accelerate();
        assertEquals(2, bike.getGear().ordinal() + 1);


        bike.setSpeed(30);
        bike.accelerate();
        assertEquals(3, bike.getGear().ordinal() + 1);


        bike.setSpeed(40);
        bike.accelerate();
        assertEquals(4, bike.getGear().ordinal() + 1);
    }
}