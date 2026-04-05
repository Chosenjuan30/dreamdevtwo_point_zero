package dsa.Week2.assignments.pizzawahala;



import java.util.Scanner;

public class PizzaWahalaApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Iya Moses Pizza Joint!");
        System.out.println("Available pizza types: Sapa size, Small Money, Big boys, Odogwu");
        System.out.print("Enter pizza type: ");
        String pizzaInput = scanner.nextLine().trim();

        System.out.print("Enter number of guests: ");
        int guests = Integer.parseInt(scanner.nextLine().trim());

        try {
            PizzaOrderCalculator.PizzaType pizzaType = PizzaOrderCalculator.PizzaType.fromString(pizzaInput);

            int boxes     = PizzaOrderCalculator.calculateBoxesNeeded(guests, pizzaType);
            int leftover  = PizzaOrderCalculator.calculateLeftoverSlices(guests, pizzaType);
            int price     = PizzaOrderCalculator.calculateTotalPrice(guests, pizzaType);

            System.out.println("\n========================================");
            System.out.println("         ORDER SUMMARY");
            System.out.println("========================================");
            System.out.println("Pizza Type         : " + pizzaType.getDisplayName());
            System.out.println("Slices per box     : " + pizzaType.getSlicesPerBox());
            System.out.println("Guests to serve    : " + guests);
            System.out.println("----------------------------------------");
            System.out.println("Number of boxes to buy : " + boxes + " boxes");
            System.out.println("Leftover slices        : " + leftover + " slices");
            System.out.println("Total price            : ₦" + price);
            System.out.println("========================================");

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}
