package mc02final.mc02.Model;

import java.util.ArrayList;
import java.util.Scanner;
public class SpecialVendingMachine extends VendingMachine {
    private ArrayList<SpecialItemSlot> specialItemList;
    private ArrayList<SpecialItemTransaction> specialTransactionList;
    
    public SpecialVendingMachine(ArrayList<ItemSlot> slotList, int StockLimit, ArrayList<Denomination> denomList, ArrayList<SpecialItemSlot> specialItemList){
        super(slotList,StockLimit,denomList);
        this.specialItemList = specialItemList;
        this.specialTransactionList = new ArrayList<SpecialItemTransaction>();
    }
    
    
    public boolean specialCanGoToCheckout(ArrayList<SpecialItemSlot> selectedItems, ArrayList<Denomination> payment){
        double totalPayment=0,totalValue =0;
        for(Denomination d: payment){
            totalPayment += d.getTotalValue();
        }
        
        for(SpecialItemSlot s: selectedItems){
            totalValue = s.getSpecialItem().getPrice();
        }
        
        return totalPayment>=totalValue;
    }
    
    public void generateChange(SpecialItemTransaction currentTransaction) {
        ArrayList<Denomination> payment = currentTransaction.getUserPayment();
  
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
            System.out.println("Insufficient change available.");
        }
    }
    
    public ArrayList<SpecialItemSlot> getSpecialSlotList(){
        return this.specialItemList;
    }
    
    public void releaseSpecialItem(ArrayList<SpecialItemSlot> selectedItems){
        for(SpecialItemSlot s: selectedItems){
            int index = searchItem(s.getItemCode());
            specialItemList.get(index).setItemQuantity(specialItemList.get(index).getItemQuantity() - s.getItemQuantity());
        }
    }
    
    @Override
    protected int searchItem(String itemCode){
        int nReturn = -1;
        for (int i = 0; i < slotList.size(); i++) {
            if (itemCode.equals(specialItemList.get(i).getItemCode())) {
                nReturn = i;
                break;
            }
        }
        return nReturn;
    }
    
    public void updateItem(SpecialItemSlot selectedItem, String index){
        int nIndex = searchItem(index);
        specialItemList.get(nIndex).getSpecialItem().setName(selectedItem.getSpecialItem().getName());
        specialItemList.get(nIndex).getSpecialItem().setPrice(selectedItem.getSpecialItem().getPrice());
        specialItemList.get(nIndex).getSpecialItem().setCalories(selectedItem.getSpecialItem().getCalories());
        specialItemList.get(nIndex).setItemCode(selectedItem.getItemCode());
        specialItemList.get(nIndex).setItemQuantity(selectedItem.getItemQuantity());
    }
}
