package dsa.Week2.assignments.geopol;


import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("GeoPoliticalZone Tests")
class GeoPoliticalZoneTest {

    private GeoPoliticalZone geoPoliticalZone;

    @BeforeEach
    void setUp() {
        geoPoliticalZone = new GeoPoliticalZone();
    }

    @Nested
    @DisplayName("North Central zone tests")
    class NorthCentralTests {

        @ParameterizedTest(name = "{0} belongs to North Central")
        @ValueSource(strings = {"benue", "fct", "kogi", "kwara", "nasarawa", "niger", "plateau"})
        @DisplayName("all North Central states return correct zone")
        void northCentralStates_ReturnNorthCentral(String state) {
            assertEquals("North Central", geoPoliticalZone.getZone(state));
        }

        @Test @DisplayName("North Central has exactly 7 states")
        void northCentral_HasSevenStates() {
            assertEquals(7, geoPoliticalZone.countStatesInZone("North Central"));
        }
    }

    @Nested
    @DisplayName("North East zone tests")
    class NorthEastTests {

        @ParameterizedTest(name = "{0} belongs to North East")
        @ValueSource(strings = {"adamawa", "bauchi", "borno", "gombe", "taraba", "yobe"})
        @DisplayName("all North East states return correct zone")
        void northEastStates_ReturnNorthEast(String state) {
            assertEquals("North East", geoPoliticalZone.getZone(state));
        }

        @Test @DisplayName("North East has exactly 6 states")
        void northEast_HasSixStates() {
            assertEquals(6, geoPoliticalZone.countStatesInZone("North East"));
        }
    }

    @Nested
    @DisplayName("North West zone tests")
    class NorthWestTests {

        @ParameterizedTest(name = "{0} belongs to North West")
        @ValueSource(strings = {"kaduna", "katsina", "kano", "kebbi", "sokoto", "jigawa", "zamfara"})
        @DisplayName("all North West states return correct zone")
        void northWestStates_ReturnNorthWest(String state) {
            assertEquals("North West", geoPoliticalZone.getZone(state));
        }

        @Test @DisplayName("North West has exactly 7 states")
        void northWest_HasSevenStates() {
            assertEquals(7, geoPoliticalZone.countStatesInZone("North West"));
        }
    }

    @Nested
    @DisplayName("South East zone tests")
    class SouthEastTests {

        @ParameterizedTest(name = "{0} belongs to South East")
        @ValueSource(strings = {"abia", "anambra", "ebonyi", "enugu", "imo"})
        @DisplayName("all South East states return correct zone")
        void southEastStates_ReturnSouthEast(String state) {
            assertEquals("South East", geoPoliticalZone.getZone(state));
        }

        @Test @DisplayName("South East has exactly 5 states")
        void southEast_HasFiveStates() {
            assertEquals(5, geoPoliticalZone.countStatesInZone("South East"));
        }
    }

    @Nested
    @DisplayName("South South zone tests")
    class SouthSouthTests {

        @ParameterizedTest(name = "{0} belongs to South South")
        @ValueSource(strings = {"akwa-ibom", "bayelsa", "cross-river", "delta", "edo", "rivers"})
        @DisplayName("all South South states return correct zone")
        void southSouthStates_ReturnSouthSouth(String state) {
            assertEquals("South South", geoPoliticalZone.getZone(state));
        }

        @Test @DisplayName("South South has exactly 6 states")
        void southSouth_HasSixStates() {
            assertEquals(6, geoPoliticalZone.countStatesInZone("South South"));
        }
    }

    @Nested
    @DisplayName("South West zone tests")
    class SouthWestTests {

        @ParameterizedTest(name = "{0} belongs to South West")
        @ValueSource(strings = {"ekiti", "lagos", "osun", "ondo", "ogun", "oyo"})
        @DisplayName("all South West states return correct zone")
        void southWestStates_ReturnSouthWest(String state) {
            assertEquals("South West", geoPoliticalZone.getZone(state));
        }

        @Test @DisplayName("South West has exactly 6 states")
        void southWest_HasSixStates() {
            assertEquals(6, geoPoliticalZone.countStatesInZone("South West"));
        }
    }

    @Nested
    @DisplayName("Case insensitivity tests")
    class CaseInsensitivityTests {

        @ParameterizedTest(name = "''{0}'' is case insensitive")
        @CsvSource({
                "LAGOS,     South West",
                "Lagos,     South West",
                "LaGoS,     South West",
                "KANO,      North West",
                "Kano,      North West",
                "BORNO,     North East",
                "RIVERS,    South South",
                "ENUGU,     South East",
                "PLATEAU,   North Central"
        })
        @DisplayName("returns correct zone regardless of input casing")
        void getZone_IsCaseInsensitive(String state, String expectedZone) {
            assertEquals(expectedZone.trim(), geoPoliticalZone.getZone(state));
        }
    }

    @Nested
    @DisplayName("Whitespace handling tests")
    class WhitespaceTests {

        @Test @DisplayName("trims leading and trailing whitespace")
        void getZone_TrimsWhitespace() {
            assertEquals("South West", geoPoliticalZone.getZone("  lagos  "));
        }

        @Test @DisplayName("trims whitespace with uppercase input")
        void getZone_TrimsWhitespaceUppercase() {
            assertEquals("North West", geoPoliticalZone.getZone("  KANO  "));
        }
    }

    @Nested
    @DisplayName("Invalid input tests")
    class InvalidInputTests {

        @Test @DisplayName("returns null for unknown state")
        void getZone_UnknownState_ReturnsNull() {
            assertNull(geoPoliticalZone.getZone("wakanda"));
        }

        @Test @DisplayName("returns null for random string")
        void getZone_RandomString_ReturnsNull() {
            assertNull(geoPoliticalZone.getZone("notastate"));
        }

        @Test @DisplayName("throws when state is null")
        void getZone_NullInput_ThrowsException() {
            assertThrows(IllegalArgumentException.class,
                    () -> geoPoliticalZone.getZone(null));
        }

        @Test @DisplayName("throws when state is blank")
        void getZone_BlankInput_ThrowsException() {
            assertThrows(IllegalArgumentException.class,
                    () -> geoPoliticalZone.getZone("   "));
        }

        @Test @DisplayName("throws when state is empty string")
        void getZone_EmptyString_ThrowsException() {
            assertThrows(IllegalArgumentException.class,
                    () -> geoPoliticalZone.getZone(""));
        }
    }

    @Nested
    @DisplayName("isValidState tests")
    class IsValidStateTests {

        @ParameterizedTest(name = "{0} is a valid state")
        @ValueSource(strings = {"lagos", "kano", "rivers", "enugu", "plateau", "borno"})
        @DisplayName("returns true for valid states")
        void isValidState_ValidStates_ReturnsTrue(String state) {
            assertTrue(geoPoliticalZone.isValidState(state));
        }

        @Test @DisplayName("returns false for invalid state")
        void isValidState_InvalidState_ReturnsFalse() {
            assertFalse(geoPoliticalZone.isValidState("wakanda"));
        }

        @Test @DisplayName("returns false for null input")
        void isValidState_NullInput_ReturnsFalse() {
            assertFalse(geoPoliticalZone.isValidState(null));
        }

        @Test @DisplayName("returns false for blank input")
        void isValidState_BlankInput_ReturnsFalse() {
            assertFalse(geoPoliticalZone.isValidState("   "));
        }

        @Test @DisplayName("is case insensitive for valid check")
        void isValidState_CaseInsensitive_ReturnsTrue() {
            assertTrue(geoPoliticalZone.isValidState("LAGOS"));
            assertTrue(geoPoliticalZone.isValidState("Lagos"));
        }
    }

    @Nested
    @DisplayName("countStatesInZone tests")
    class CountStatesInZoneTests {

        @ParameterizedTest(name = "{0} has {1} states")
        @CsvSource({
                "North Central, 7",
                "North East,    6",
                "North West,    7",
                "South East,    5",
                "South South,   6",
                "South West,    6"
        })
        @DisplayName("returns correct state count for each zone")
        void countStatesInZone_ReturnsCorrectCount(String zone, long expectedCount) {
            assertEquals(expectedCount, geoPoliticalZone.countStatesInZone(zone.trim()));
        }

        @Test @DisplayName("throws when zone is null")
        void countStatesInZone_NullZone_Throws() {
            assertThrows(IllegalArgumentException.class,
                    () -> geoPoliticalZone.countStatesInZone(null));
        }

        @Test @DisplayName("returns zero for non-existent zone")
        void countStatesInZone_NonExistentZone_ReturnsZero() {
            assertEquals(0, geoPoliticalZone.countStatesInZone("Middle Earth"));
        }
    }

    @Nested
    @DisplayName("getAllStatesAndZones tests")
    class GetAllStatesAndZonesTests {

        @Test @DisplayName("returns map with all 37 states including FCT")
        void getAllStatesAndZones_Returns37States() {
            assertEquals(37, geoPoliticalZone.getAllStatesAndZones().size());
        }

        @Test @DisplayName("returned map is unmodifiable")
        void getAllStatesAndZones_IsUnmodifiable() {
            assertThrows(UnsupportedOperationException.class,
                    () -> geoPoliticalZone.getAllStatesAndZones().put("newstate", "New Zone"));
        }

        @Test @DisplayName("returned map contains lagos")
        void getAllStatesAndZones_ContainsLagos() {
            assertTrue(geoPoliticalZone.getAllStatesAndZones().containsKey("lagos"));
        }
    }

    @Nested
    @DisplayName("Bug fix verification tests")
    class BugFixTests {

        @Test @DisplayName("ekiti correctly maps to South West not lagos")
        void ekiti_MapsToSouthWest_NotLagos() {
            assertEquals("South West", geoPoliticalZone.getZone("ekiti"));
            assertNotEquals("lagos", geoPoliticalZone.getZone("ekiti"));
        }

        @Test @DisplayName("osun is lowercase and maps to South West")
        void osun_LowercaseMapsToSouthWest() {
            assertEquals("South West", geoPoliticalZone.getZone("osun"));
        }

        @Test @DisplayName("ondo is lowercase and maps to South West")
        void ondo_LowercaseMapsToSouthWest() {
            assertEquals("South West", geoPoliticalZone.getZone("ondo"));
        }

        @Test @DisplayName("ogun is lowercase and maps to South West")
        void ogun_LowercaseMapsToSouthWest() {
            assertEquals("South West", geoPoliticalZone.getZone("ogun"));
        }

        @Test @DisplayName("oyo is lowercase and maps to South West")
        void oyo_LowercaseMapsToSouthWest() {
            assertEquals("South West", geoPoliticalZone.getZone("oyo"));
        }
    }
}
