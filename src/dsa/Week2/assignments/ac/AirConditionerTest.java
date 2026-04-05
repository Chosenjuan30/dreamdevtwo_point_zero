package dsa.Week2.assignments.ac;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("AirConditioner")
class AirConditionerTest {

    private AirConditioner ac;

    @BeforeEach
    void setUp() {
        ac = new AirConditioner();
    }


    @Nested
    @DisplayName("Power controls")
    class PowerTests {

        @Test
        @DisplayName("AC should be OFF by default when created")
        void acIsOffByDefault() {
            assertFalse(ac.isOn());
        }

        @Test
        @DisplayName("turnOn() should set isOn to true")
        void turnOnSetsIsOnTrue() {
            ac.turnOn();
            assertTrue(ac.isOn());
        }

        @Test
        @DisplayName("turnOff() should set isOn to false")
        void turnOffSetsIsOnFalse() {
            ac.turnOn();
            ac.turnOff();
            assertFalse(ac.isOn());
        }
    }



    @Nested
    @DisplayName("Default state")
    class DefaultStateTests {

        @Test
        @DisplayName("default temperature should be 24°C")
        void defaultTemperatureIs24() {
            assertEquals(24, ac.getTemperature());
        }

        @Test
        @DisplayName("default fan speed should be 1 (low)")
        void defaultFanSpeedIs1() {
            assertEquals(1, ac.getFanSpeed());
        }

        @Test
        @DisplayName("default mode should be COOL")
        void defaultModeIsCool() {
            assertEquals(ACMode.COOL, ac.getMode());
        }
    }


    @Nested
    @DisplayName("Temperature controls")
    class TemperatureTests {

        @Test
        @DisplayName("increaseTemperature() should raise temperature by 1 when AC is on")
        void increaseTemperatureWhenOn() {
            ac.turnOn();
            ac.increaseTemperature();
            assertEquals(25, ac.getTemperature());
        }

        @Test
        @DisplayName("decreaseTemperature() should lower temperature by 1 when AC is on")
        void decreaseTemperatureWhenOn() {
            ac.turnOn();
            ac.decreaseTemperature();
            assertEquals(23, ac.getTemperature());
        }

        @Test
        @DisplayName("increaseTemperature() should NOT exceed 30°C (max limit)")
        void temperatureCannotExceed30() {
            ac.turnOn();
            ac.setTemperature(30);
            ac.increaseTemperature();
            assertEquals(30, ac.getTemperature());
        }

        @Test
        @DisplayName("decreaseTemperature() should NOT go below 16°C (min limit)")
        void temperatureCannotGoBelowl6() {
            ac.turnOn();
            ac.setTemperature(16);
            ac.decreaseTemperature();
            assertEquals(16, ac.getTemperature());
        }

        @Test
        @DisplayName("setTemperature() should set a valid temperature between 16 and 30")
        void setTemperatureWithValidValue() {
            ac.turnOn();
            ac.setTemperature(20);
            assertEquals(20, ac.getTemperature());
        }

        @Test
        @DisplayName("setTemperature() should REJECT values below 16")
        void setTemperatureRejectsValueBelow16() {
            ac.turnOn();
            ac.setTemperature(10);
            assertEquals(24, ac.getTemperature(), "Temperature should remain at default 24");
        }

        @Test
        @DisplayName("setTemperature() should REJECT values above 30")
        void setTemperatureRejectsValueAbove30() {
            ac.turnOn();
            ac.setTemperature(35);
            assertEquals(24, ac.getTemperature(), "Temperature should remain at default 24");
        }

        @Test
        @DisplayName("increaseTemperature() should do NOTHING when AC is off")
        void increaseTemperatureDoesNothingWhenOff() {
            ac.increaseTemperature();
            assertEquals(24, ac.getTemperature());
        }

        @Test
        @DisplayName("decreaseTemperature() should do NOTHING when AC is off")
        void decreaseTemperatureDoesNothingWhenOff() {
            ac.decreaseTemperature();
            assertEquals(24, ac.getTemperature());
        }

        @Test
        @DisplayName("setTemperature() should do NOTHING when AC is off")
        void setTemperatureDoesNothingWhenOff() {
            ac.setTemperature(18);
            assertEquals(24, ac.getTemperature());
        }
    }


    @Nested
    @DisplayName("Fan speed controls")
    class FanSpeedTests {

        @Test
        @DisplayName("fanSpeedUp() should increase fan speed by 1 when AC is on")
        void fanSpeedUpWhenOn() {
            ac.turnOn();
            ac.fanSpeedUp();
            assertEquals(2, ac.getFanSpeed());
        }

        @Test
        @DisplayName("fanSpeedDown() should decrease fan speed by 1 when AC is on")
        void fanSpeedDownWhenOn() {
            ac.turnOn();
            ac.fanSpeedUp();
            ac.fanSpeedDown();
            assertEquals(1, ac.getFanSpeed());
        }

        @Test
        @DisplayName("fanSpeedUp() should NOT exceed max speed of 3")
        void fanSpeedCannotExceed3() {
            ac.turnOn();
            ac.fanSpeedUp();
            ac.fanSpeedUp();
            ac.fanSpeedUp();
            assertEquals(3, ac.getFanSpeed());
        }

        @Test
        @DisplayName("fanSpeedDown() should NOT go below min speed of 1")
        void fanSpeedCannotGoBelowl() {
            ac.turnOn();
            ac.fanSpeedDown();
            assertEquals(1, ac.getFanSpeed());
        }

        @Test
        @DisplayName("fanSpeedUp() should do NOTHING when AC is off")
        void fanSpeedUpDoesNothingWhenOff() {
            ac.fanSpeedUp();
            assertEquals(1, ac.getFanSpeed());
        }

        @Test
        @DisplayName("fanSpeedDown() should do NOTHING when AC is off")
        void fanSpeedDownDoesNothingWhenOff() {
            ac.turnOn();
            ac.fanSpeedUp();
            ac.turnOff();
            ac.fanSpeedDown();
            assertEquals(2, ac.getFanSpeed());
        }
    }


    @Nested
    @DisplayName("Mode switching")
    class ModeTests {

        @Test
        @DisplayName("switchMode() should change mode to HEAT when AC is on")
        void switchModeToHeat() {
            ac.turnOn();
            ac.switchMode(ACMode.HEAT);
            assertEquals(ACMode.HEAT, ac.getMode());
        }

        @Test
        @DisplayName("switchMode() should change mode to FAN when AC is on")
        void switchModeToFan() {
            ac.turnOn();
            ac.switchMode(ACMode.FAN);
            assertEquals(ACMode.FAN, ac.getMode());
        }

        @Test
        @DisplayName("switchMode() should change mode to DRY when AC is on")
        void switchModeToDry() {
            ac.turnOn();
            ac.switchMode(ACMode.DRY);
            assertEquals(ACMode.DRY, ac.getMode());
        }

        @Test
        @DisplayName("switchMode() should change mode to AUTO when AC is on")
        void switchModeToAuto() {
            ac.turnOn();
            ac.switchMode(ACMode.AUTO);
            assertEquals(ACMode.AUTO, ac.getMode());
        }

        @Test
        @DisplayName("switchMode() should do NOTHING when AC is off — mirrors Television.switchInput() behaviour")
        void switchModeDoesNothingWhenOff() {
            ac.switchMode(ACMode.HEAT); // AC is off
            assertEquals(ACMode.COOL, ac.getMode(),
                    "Mode should remain COOL (default) when AC is off");
        }
    }


    @Nested
    @DisplayName("Combined behaviour scenarios")
    class ScenarioTests {

        @Test
        @DisplayName("full usage flow: turn on, set temp, change mode, increase fan, turn off")
        void fullUsageScenario() {
            ac.turnOn();
            assertTrue(ac.isOn());

            ac.setTemperature(22);
            assertEquals(22, ac.getTemperature());

            ac.switchMode(ACMode.DRY);
            assertEquals(ACMode.DRY, ac.getMode());

            ac.fanSpeedUp();
            ac.fanSpeedUp();
            assertEquals(3, ac.getFanSpeed());

            ac.turnOff();
            assertFalse(ac.isOn());


            ac.increaseTemperature();
            ac.fanSpeedDown();
            ac.switchMode(ACMode.HEAT);

            assertEquals(22, ac.getTemperature(), "Temp should not change after turn off");
            assertEquals(3, ac.getFanSpeed(),     "Fan speed should not change after turn off");
            assertEquals(ACMode.DRY, ac.getMode(), "Mode should not change after turn off");
        }

        @Test
        @DisplayName("temperature should stay within bounds after multiple increases")
        void temperatureStaysWithinBoundsAfterManyIncreases() {
            ac.turnOn();
            for (int i = 0; i < 20; i++) {
                ac.increaseTemperature();
            }
            assertEquals(30, ac.getTemperature(),
                    "Temperature must never exceed 30°C no matter how many times increased");
        }

        @Test
        @DisplayName("temperature should stay within bounds after multiple decreases")
        void temperatureStaysWithinBoundsAfterManyDecreases() {
            ac.turnOn();
            for (int i = 0; i < 20; i++) {
                ac.decreaseTemperature();
            }
            assertEquals(16, ac.getTemperature(),
                    "Temperature must never go below 16°C no matter how many times decreased");
        }
    }
}

