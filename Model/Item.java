package mc02final.mc02.Model;
/**
 * The Item class represents an item available in a vending machine.
 * It stores the properties of an item including its name, calories, and price.
 */
public class Item {
    private String itemName;
    private int itemCalories;
    private double itemPrice;

    /**
     * Constructs a new Item object with the specified name, calories, and price.
     *
     * @param itemName     stores the name of the item
     * @param itemCalories stores the number of calories in the item
     * @param itemPrice    stores the price of the item
     */
    public Item(String itemName, int itemCalories, double itemPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemCalories = itemCalories;
    }

    /**
     * This method returns the name of the item.
     *
     * @return the name of the item
     */
    public String getName() {
        return this.itemName;
    }

    /**
     * This method sets the name of the item.
     *
     * @param itemName the new name of the item
     */
    public void setName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * This method returns the price of the item.
     *
     * @return the price of the item
     */
    public double getPrice() {
        return this.itemPrice;
    }

    /**
     * This method sets the price of the item.
     *
     * @param itemPrice the new price of the item
     */
    public void setPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    /**
     * This methos sets the number of calories in the item.
     *
     * @param itemCalories the new number of calories in the item
     */
    public void setCalories(int itemCalories) {
        this.itemCalories = itemCalories;
    }

    /**
     * This method returns the number of calories in the item.
     *
     * @return the number of calories in the item
     */
    public int getCalories() {
        return this.itemCalories;
    }
}
