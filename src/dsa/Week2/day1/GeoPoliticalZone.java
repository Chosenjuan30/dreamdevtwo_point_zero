package dsa.Week2.day1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GeoPoliticalZone {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);


        Map<String, String> stateToZone = new HashMap<>();


        stateToZone.put("benue", "North Central");
        stateToZone.put("fct", "North Central");
        stateToZone.put("kogi", "North Central");
        stateToZone.put("kwara", "North Central");
        stateToZone.put("nasarawa", "North Central");
        stateToZone.put("niger", "North Central");
        stateToZone.put("plateau", "North Central");


        stateToZone.put("adamawa", "North East");
        stateToZone.put("bauchi", "North East");
        stateToZone.put("borno", "North East");
        stateToZone.put("gombe", "North East");
        stateToZone.put("taraba", "North East");
        stateToZone.put("yobe", "North East");


        stateToZone.put("kaduna", "North West");
        stateToZone.put("katsina", "North West");
        stateToZone.put("kano", "North West");
        stateToZone.put("kebbi", "North West");
        stateToZone.put("sokoto", "North West");
        stateToZone.put("jigawa", "North West");
        stateToZone.put("zamfara", "North West");


        stateToZone.put("abia", "South East");
        stateToZone.put("anambra", "South East");
        stateToZone.put("ebonyi", "South East");
        stateToZone.put("enugu", "South East");
        stateToZone.put("imo", "South East");


        stateToZone.put("akwa-ibom", "South South");
        stateToZone.put("bayelsa", "South South");
        stateToZone.put("cross-river", "South South");
        stateToZone.put("delta", "South South");
        stateToZone.put("edo", "South South");
        stateToZone.put("rivers", "South South");


        stateToZone.put("ekiti","lagos");
        stateToZone.put("lagos", "South West");
        stateToZone.put("Osun", "South West");
        stateToZone.put("Ondo", "South West");
        stateToZone.put("Ogun", "South West");
        stateToZone.put("Oyo", "South West");


        System.out.print("Enter a state: ");
        String state = input.nextLine().toLowerCase();


        String zone = stateToZone.get(state);

        if (zone != null) {
            System.out.println("Geo-political zone: " + zone);
        } else {
            System.out.println("Invalid state entered");
        }
    }
}
