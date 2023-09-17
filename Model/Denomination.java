package mc02final.mc02.Model;
/**
 * The Denomination class represents a currency denomination used in a vending machine.
 * It stores the value and quantity of a specific denomination.
 */
public class Denomination {
    private double denomValue;
    private int denomQuantity;

    /**
     * Constructs a Denomination object with the specified value and a quantity of 0.
     *
     * @param value the value of the denomination
     */
    public Denomination(double value) {
        this.denomValue = value;
        this.denomQuantity = 0;
    }

    /**
     * Constructs a Denomination object with the specified value and quantity.
     *
     * @param value    the value of the denomination
     * @param quantity the quantity of the denomination
     */
    public Denomination(double value, int quantity) {
        this.denomValue = value;
        this.denomQuantity = quantity;
    }

    /**
     * This method sets the quantity of the denomination.
     *
     * @param newQuantity the new quantity of the denomination
     */
    public void setQuantity(int newQuantity) {
        this.denomQuantity = newQuantity;
    }

    /**
     * This method adds the specified quantity to the current quantity of the denomination.
     *
     * @param quantity the quantity to add
     */
    public void addQuantity(int quantity) {
        this.denomQuantity += quantity;
    }

    /**
     * This method returns the total value of the denomination (value multiplied by quantity).
     *
     * @return the total value of the denomination
     */
    public double getTotalValue() {
        return denomValue * denomQuantity;
    }

    /**
     * This method returns the value of the denomination.
     *
     * @return the value of the denomination
     */
    public double getValue() {
        return denomValue;
    }

    /**
     * This method returns a new Denomination object with a quantity of 1 and reduces the current quantity by 1.
     *
     * @return a new Denomination object with a quantity of 1
     */
    public Denomination getOneDenomination() {
        Denomination dReturn = new Denomination(this.denomValue, 1);
        this.denomQuantity--;
        return dReturn;
    }

    /**
     * This method returns the value of the quantity
     *
     * @return the value of the Quantity
     */
    public int getQuantity(){
      return this.denomQuantity;
    }
    /**
     * This method returns a string representation of the denomination.
     *
     * @return a string representation of the denomination
     */
    @Override
    public String toString() {
      return "$" + denomValue;
      }
}

