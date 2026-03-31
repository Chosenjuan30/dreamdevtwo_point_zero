package dsa.Week2.day1;


public class PizzaOrderCalculator {

    public enum PizzaType {
        SAPA_SIZE("Sapa size",   4, 2_500),
        SMALL_MONEY("Small Money", 6, 2_900),
        BIG_BOYS("Big boys",    8, 4_000),
        ODOGWU("Odogwu",      12, 5_200);

        private final String displayName;
        private final int slicesPerBox;
        private final int pricePerBox;

        PizzaType(String displayName, int slicesPerBox, int pricePerBox) {
            this.displayName  = displayName;
            this.slicesPerBox = slicesPerBox;
            this.pricePerBox  = pricePerBox;
        }

        public String getDisplayName() { return displayName; }
        public int getSlicesPerBox()   { return slicesPerBox; }
        public int getPricePerBox()    { return pricePerBox; }

        public static PizzaType fromString(String input) {
            for (PizzaType type : values()) {
                if (type.displayName.equalsIgnoreCase(input.trim())) return type;
            }
            throw new IllegalArgumentException("Unknown pizza type: " + input +
                    ". Valid types: Sapa size, Small Money, Big boys, Odogwu");
        }
    }

    public static int calculateBoxesNeeded(int numberOfGuests, PizzaType pizzaType) {
        if (numberOfGuests <= 0) {
            throw new IllegalArgumentException("Number of guests must be greater than 0");
        }
        return (int) Math.ceil((double) numberOfGuests / pizzaType.getSlicesPerBox());
    }

    public static int calculateLeftoverSlices(int numberOfGuests, PizzaType pizzaType) {
        int boxes       = calculateBoxesNeeded(numberOfGuests, pizzaType);
        int totalSlices = boxes * pizzaType.getSlicesPerBox();
        return totalSlices - numberOfGuests;
    }

    public static int calculateTotalPrice(int numberOfGuests, PizzaType pizzaType) {
        int boxes = calculateBoxesNeeded(numberOfGuests, pizzaType);
        return boxes * pizzaType.getPricePerBox();
    }
}