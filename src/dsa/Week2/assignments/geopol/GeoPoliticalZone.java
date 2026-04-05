package dsa.Week2.assignments.geopol;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class GeoPoliticalZone {

    private static final Map<String, String> STATE_TO_ZONE;

    static {
        Map<String, String> map = new HashMap<>();

        map.put("benue",     "North Central");
        map.put("fct",       "North Central");
        map.put("kogi",      "North Central");
        map.put("kwara",     "North Central");
        map.put("nasarawa",  "North Central");
        map.put("niger",     "North Central");
        map.put("plateau",   "North Central");

        map.put("adamawa",   "North East");
        map.put("bauchi",    "North East");
        map.put("borno",     "North East");
        map.put("gombe",     "North East");
        map.put("taraba",    "North East");
        map.put("yobe",      "North East");

        map.put("kaduna",    "North West");
        map.put("katsina",   "North West");
        map.put("kano",      "North West");
        map.put("kebbi",     "North West");
        map.put("sokoto",    "North West");
        map.put("jigawa",    "North West");
        map.put("zamfara",   "North West");

        map.put("abia",      "South East");
        map.put("anambra",   "South East");
        map.put("ebonyi",    "South East");
        map.put("enugu",     "South East");
        map.put("imo",       "South East");

        map.put("akwa-ibom", "South South");
        map.put("bayelsa",   "South South");
        map.put("cross-river","South South");
        map.put("delta",     "South South");
        map.put("edo",       "South South");
        map.put("rivers",    "South South");

        map.put("ekiti",     "South West");
        map.put("lagos",     "South West");
        map.put("osun",      "South West");
        map.put("ondo",      "South West");
        map.put("ogun",      "South West");
        map.put("oyo",       "South West");

        STATE_TO_ZONE = Collections.unmodifiableMap(map);
    }

    public String getZone(String state) {
        if (state == null || state.isBlank()) {
            throw new IllegalArgumentException("State name cannot be null or empty");
        }
        return STATE_TO_ZONE.get(state.trim().toLowerCase());
    }

    public boolean isValidState(String state) {
        if (state == null || state.isBlank()) return false;
        return STATE_TO_ZONE.containsKey(state.trim().toLowerCase());
    }

    public Map<String, String> getAllStatesAndZones() {
        return STATE_TO_ZONE;
    }

    public long countStatesInZone(String zone) {
        if (zone == null || zone.isBlank()) {
            throw new IllegalArgumentException("Zone name cannot be null or empty");
        }
        return STATE_TO_ZONE.values().stream()
                .filter(z -> z.equalsIgnoreCase(zone))
                .count();
    }
}