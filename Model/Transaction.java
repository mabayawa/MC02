package mc02final.mc02.Model;

import java.util.ArrayList;
/**
 * The Transaction class represents a transaction made for purchasing an item in a vending machine.
 * It contains information about the item, user payment, change given, total value, and transaction ID.
 */
public abstract class Transaction {
    private ArrayList<Denomination> userPayment;
    private ArrayList<Denomination> changeGiven;
    private double totalValue;
    private int transactionId;

    /**
     * Constructs a new Transaction object with the specified item and total value.
     *
     * @param item       stores the item being purchased in the transaction
     * @param totalValue stores the total value of the transaction
     */
    public Transaction(double totalValue) {
        userPayment = new ArrayList<Denomination>();
        changeGiven = new ArrayList<Denomination>();
        this.totalValue = totalValue;
    }

    /**
     * This method retrieves the total value of the transaction.
     *
     * @return the total value of the transaction
     */
    public double getTotalValue() {
        return totalValue;
    }

    /**
     * This method retrieves the unique transaction ID.
     *
     * @return the transaction ID
     */
    public int getTransactionId() {
        return transactionId;
    }

    /**
     * This method sets the user payment for the transaction.
     *
     * @param payment the user payment made using denominations
     */
    public void setUserPayment(ArrayList<Denomination> payment) {
        this.userPayment = payment;
    }

    /**
     * This method sets the change given to the user in the transaction.
     *
     * @param change the change given to the user in denominations
     */
    public void setChangeGiven(ArrayList<Denomination> change) {
        this.changeGiven = change;
    }

    public ArrayList<Denomination> getChangeGiven(){
      return this.changeGiven;
    }

    public ArrayList<Denomination> getUserPayment(){
      return this.userPayment;
    }
}

