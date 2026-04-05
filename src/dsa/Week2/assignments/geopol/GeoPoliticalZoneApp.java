package dsa.Week2.assignments.geopol;

import java.util.Scanner;

public class GeoPoliticalZoneApp {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        GeoPoliticalZone geoPoliticalZone = new GeoPoliticalZone();

        System.out.print("Enter a state: ");
        String state = input.nextLine();

        String zone = geoPoliticalZone.getZone(state);

        if (zone != null) {
            System.out.println("Geo-political zone: " + zone);
        } else {
            System.out.println("Invalid state entered. Please enter a valid Nigerian state.");
        }

        input.close();
    }
}
