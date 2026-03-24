package dsa.Week2.day1;

import java.util.Scanner;

public class PizzaWahala {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of people: ");
        int numberOfPeople = input.nextInt();
        input.nextLine();

        System.out.print("Enter pizza type (Sapa, Small Money, Big Boys, Odogwu): ");
        String pizzaType = input.nextLine().toLowerCase();

        int slicesPerBox = 0;
        int pricePerBox = 0;

        switch (pizzaType) {
            case "sapa":
                slicesPerBox = 4;
                pricePerBox = 2500;
                break;
            case "small money":
                slicesPerBox = 6;
                pricePerBox = 2900;
                break;
            case "big boys":
                slicesPerBox = 8;
                pricePerBox = 4000;
                break;
            case "odogwu":
                slicesPerBox = 12;
                pricePerBox = 5200;
                break;
            default:
                System.out.println("Invalid pizza type!");
                return;
        }


        int boxes = (numberOfPeople + slicesPerBox - 1) / slicesPerBox;


        int totalSlices = boxes * slicesPerBox;

        int leftOver = totalSlices - numberOfPeople;

        int totalPrice = boxes * pricePerBox;

        System.out.println("\nNumber of boxes of pizza to buy = " + boxes + " boxes");
        System.out.println("Number of leftover slices = " + leftOver + " slices");
        System.out.println("Total price = " + totalPrice);
    }
}
