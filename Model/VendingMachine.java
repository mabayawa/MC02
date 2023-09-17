package mc02final.mc02.Model;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The VendingMachine class represents a vending machine that sells items.
 * It handles the management of item slots, stock limits, transactions, denominations, and total sales.
 */
public class VendingMachine{
    protected ArrayList<ItemSlot> slotList;
    protected int stockLimit;
    protected ArrayList<ItemTransaction> itemTransactionList;
    protected ArrayList<Denomination> denomList;
    private double totalSales;

    /**
     * Constructs a new VendingMachine object.
     * It initializes the lists of item slots, stock limit, transactions, denominations, and total sales.
     */
    public VendingMachine(ArrayList<ItemSlot> slotList, int StockLimit, ArrayList<Denomination> denomList) {
        this.slotList = slotList;
        this.stockLimit = 8;
        this.itemTransactionList = new ArrayList<ItemTransaction>();
        this.denomList = denomList;
        this.totalSales = 0.0;
    }
    /**
    * Returns the array of item slots in the machine
    */
    public ArrayList<ItemSlot> getSlotList() {
        return this.slotList;
    }
    
    /**
    * Returns the array of denominations in the machine
    */
    public ArrayList<Denomination> getDenomList(){
        return this.denomList;
    }
    
    /**
    * This method adds a new item slot to the vending machine.
    *
    * @param itemSlot is an object ItemSlot to be added to the ArrayList of ItemSlot
    */
    public void addItemSlot(ItemSlot itemSlot){
        slotList.add(itemSlot);
    }

    
    
    
    
    /**
     * This method releases the item from the vending machine based on the item code.
     *
     * @param itemCode the code of the item to release
     * @return true if the item was successfully released, false otherwise
     */
    
    
    public void releaseItem(ArrayList<ItemSlot> selectedItems){
        for(ItemSlot s: selectedItems){
            int index = searchItem(s.getItemCode());
            slotList.get(index).setItemQuantity(slotList.get(index).getItemQuantity() - s.getItemQuantity());
        }
    }

    /**
     * This method receives the payment from the user for the current transaction.
     *
     * @param currentTransaction the current transaction
     */
    
    
    
    public void recievePayment(ArrayList <Denomination> payment){
        for(Denomination d: payment){
            for(int i=0;i<denomList.size();i++){
                if(denomList.get(i).getValue() == d.getValue()){
                    denomList.get(i).addQuantity(d.getQuantity());
                }
            }
        }
    }
    /**
     * This method generates the change for the current transaction based on the user's payment.
     *
     * @param currentTransaction the current transaction
     */
    
    public ArrayList<Denomination> generateChange(ItemTransaction currentTransaction) {
        ArrayList<Denomination> payment=currentTransaction.getUserPayment();
  
        double totalPayment = 0;
        for (Denomination denom : payment) {
            totalPayment += denom.getTotalValue();
        }
  
        double totalPrice = currentTransaction.getTotalValue();
        double changeAmount = totalPayment - totalPrice;
  
        ArrayList<Denomination> change = new ArrayList<Denomination>();
        int denomIndex = denomList.size() - 1;
  
        while (changeAmount > 0 && denomIndex >= 0) {
            Denomination denom = denomList.get(denomIndex);
            double denominationValue = denom.getValue();
            int quantity = (int) (changeAmount / denominationValue);
  
            if (quantity > 0 && denom.getQuantity() >= quantity) {
                change.add(new Denomination(denom.getValue(), quantity));
                changeAmount -= denominationValue * quantity;
                denom.setQuantity(denom.getQuantity() - quantity);
            } else {
                denomIndex--;
            }
        
        }
  
        if (changeAmount == 0) {
            currentTransaction.setChangeGiven(change);
        } else {
            payment.clear();
            
        }
        
        return change;
    }
    
    public ArrayList<Denomination> generateChange(ArrayList<Denomination> payment, double totalValue) {
        double totalPayment = 0;
        for (Denomination denom : payment) {
            totalPayment += denom.getTotalValue();
        }
  
        
        double changeAmount = totalPayment - totalValue;
  
        ArrayList<Denomination> change = new ArrayList<Denomination>();
        int denomIndex = denomList.size() - 1;
  
        while (changeAmount > 0 && denomIndex >= 0) {
            Denomination denom = denomList.get(denomIndex);
            double denominationValue = denom.getValue();
            int quantity = (int) (changeAmount / denominationValue);
  
            if (quantity > 0 && denom.getQuantity() >= quantity) {
                change.add(new Denomination(denom.getValue(), quantity));
                changeAmount -= denominationValue * quantity;
                denom.setQuantity(denom.getQuantity() - quantity);
            } else {
                denomIndex--;
            }
        
        }
  
        
        return change;
    }
    
    public boolean canGenerateChange(ArrayList<Denomination> payment, double totalValue) {
        ArrayList<Denomination> change = generateChange(payment,totalValue);
        double totalPayment = 0;
        double totalChange = 0;
        for (Denomination denom : payment) {
            totalPayment += denom.getTotalValue();
        }
        
        for(Denomination denom: change){
            totalChange += denom.getTotalValue();
        }
        
        return (totalChange + totalValue == totalPayment);
    }

    
    
    

      /**
     * This method searches for the item in the vending machine based on the item code.
     *
     * @param itemCode the code of the item to search for
     * @return the index of the item in the slotList, or -1 if not found
     */
    protected int searchItem(String itemCode) {
        int nReturn = -1;
        for (int i = 0; i < slotList.size(); i++) {
            if (itemCode.equals(slotList.get(i).getItemCode())) {
                nReturn = i;
                break;
            }
        }
        return nReturn;
    }

    /**
     * This method finds a denomination in the list of denominations based on its value.
     *
     * @param value the value of the denomination to find
     * @return the denomination object if found, null otherwise
     */
    protected Denomination findDenominationByValue(double value) {
        for (Denomination denomination : denomList) {
            if (denomination.getValue() == value) {
                return denomination;
            }
        }
        return null;
    }

    
    

    /**
     * This method updates the details of an item in the vending machine.
     */
    
    
    public void updateItem(ItemSlot itemSlot, String codeIndex){
        for(int i=0;i<slotList.size();i++){
            if(codeIndex.equals(slotList.get(i).getItemCode())){
                slotList.get(i).getItem().setName(itemSlot.getItem().getName());
                slotList.get(i).getItem().setPrice(itemSlot.getItem().getPrice());
                slotList.get(i).getItem().setCalories(itemSlot.getItem().getCalories());
                slotList.get(i).setItemCode(itemSlot.getItemCode());
                slotList.get(i).setItemQuantity(itemSlot.getItemQuantity());
            }
        }
    }

    
  
    
    public ArrayList<ItemTransaction> getItemTransactionList(){
        return this.itemTransactionList;
    }
    
    public Boolean canGoToCheckout(ArrayList<ItemSlot> selectedItems,ArrayList<Denomination> payment){
        double totalPayment =0;
        double totalValue =0;
        for(Denomination d: payment){
            totalPayment += d.getTotalValue();
        }
        
        for(ItemSlot s:selectedItems){
            totalValue+=( s.getItem().getPrice() * s.getItemQuantity() );
        }
        
        return totalPayment>=totalValue;
    }
}