package mc02final.mc02.Controller;
import java.text.SimpleDateFormat;
import mc02final.mc02.Model.*;
import mc02final.mc02.View.*;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;

public class RecieptController{
    private ReceiptView receiptView;
    private VendingMachine vendingMachine;
    private SpecialVendingMachine specialVendingMachine;
    private String receiptContent;
    private ArrayList<ItemSlot> selectedItems;
    private ArrayList<SpecialItemSlot> selectedSpecialItems;
    private ArrayList<Denomination> payment;
    private ArrayList<Denomination> change;
    private ItemTransaction itemTransaction;
    private SpecialItemTransaction specialItemTransaction;
    private JPanel receiptTextPanel;
    
    public RecieptController(ReceiptView receiptView, SpecialVendingMachine specialVendingMachine, ArrayList<SpecialItemSlot> selectedItems, ArrayList<Denomination> payment){
        this.receiptView = receiptView;
        this.specialVendingMachine = specialVendingMachine;
        this.selectedSpecialItems = selectedItems;
        this.payment = payment;
        
        double totalValue = 0;
        ArrayList<SpecialItem> specialItemList = new ArrayList<SpecialItem>();
        for(SpecialItemSlot s: selectedItems){
            specialItemList.add(s.getSpecialItem());
            totalValue+=(s.getSpecialItem().getPrice() * s.getItemQuantity());
        }
        
        this.specialItemTransaction = new SpecialItemTransaction(specialItemList,totalValue);
        specialItemTransaction.setUserPayment(payment);
        this.change = specialVendingMachine.generateChange(payment,totalValue);
        specialItemTransaction.setChangeGiven(change);
        
        receiptTextPanel = new JPanel();
        JTextArea receiptTextArea = new JTextArea();
        receiptTextArea.setEditable(false);
        this.receiptContent = new String();
        receiptContent = "---------- Receipt ----------\n";
        receiptContent+=("Date: ");
        receiptContent+=(getCurrentDateTime());
        receiptContent+="\nItems Purchased:\n";
        
        for (int i=0;i<specialItemList.size();i++) {
            int quantity = specialItemList.size();
            receiptContent+=(String.valueOf(quantity) + " x " + specialItemList.get(i).getName());
            receiptContent+=(" - Price: $" + String.format("%.2f", specialItemList.get(i).getPrice()));
            receiptContent+=(" - Amount: " + String.valueOf(1));
            receiptContent+=(" - Calories: " + String.valueOf(specialItemList.get(i).getCalories() + "\n"));
        }
        
        receiptContent+=("Total Price: $" + String.format("%.2f", specialItemTransaction.getTotalValue()) + "\n");
        
        receiptContent+=("Payment:\n");
        for (Denomination denom : payment) {
            receiptContent+=(String.valueOf(denom.getQuantity()) + " x " + String.valueOf(denom.getValue()) + "\n");
        }

        receiptContent+=("Change:\n");
        for (Denomination denom : change) {
            receiptContent+=(String.valueOf(denom.getQuantity()) + " x " + String.valueOf(denom.getValue()) +"\n");
        }
        
        receiptTextArea.setText(receiptContent);
        receiptTextPanel.add(receiptTextArea);
        
        specialVendingMachine.releaseSpecialItem(selectedItems);
        specialVendingMachine.recievePayment(payment);
    }
    
    public RecieptController(ReceiptView receiptView, VendingMachine vendingMachine, ArrayList<ItemSlot> selectedItems, ArrayList<Denomination> payment ){
        this.receiptView = receiptView;
        this.vendingMachine = vendingMachine;
        this.selectedItems = selectedItems;
        this.payment = payment;
        
        double totalValue =0;
        ArrayList<Item> itemList = new ArrayList<Item>();
        for(ItemSlot s: selectedItems){
            itemList.add(s.getItem());
            totalValue+=(s.getItem().getPrice() * s.getItemQuantity());
        }
        
        this.itemTransaction = new ItemTransaction(itemList,totalValue);
        this.itemTransaction.setUserPayment(payment);
        this.change = vendingMachine.generateChange(itemTransaction);
        this.itemTransaction.setChangeGiven(change);
       
        receiptTextPanel = new JPanel();
        JTextArea receiptTextArea = new JTextArea();
        receiptTextArea.setEditable(false);
        this.receiptContent = new String();
        receiptContent = "---------- Receipt ----------\n";
        receiptContent+=("Date: ");
        receiptContent+=(getCurrentDateTime());
        receiptContent+="\nItems Purchased:\n";
        
        for (int i=0;i<itemList.size();i++) {
            int quantity = itemList.size();
            receiptContent+=(String.valueOf(quantity) + " x " + itemList.get(i).getName());
            receiptContent+=(" - Price: $" + String.format("%.2f", itemList.get(i).getPrice()));
            receiptContent+=(" - Amount: " + String.valueOf(1));
            receiptContent+=(" - Calories: " + String.valueOf(itemList.get(i).getCalories() + "\n"));
        }
        
        receiptContent+=("Total Price: $" + String.format("%.2f", itemTransaction.getTotalValue()) + "\n");
        
        receiptContent+=("Payment:\n");
        for (Denomination denom : payment) {
            receiptContent+=(String.valueOf(denom.getQuantity()) + " x " + String.valueOf(denom.getValue()) + "\n");
        }

        receiptContent+=("Change:\n");
        for (Denomination denom : change) {
            receiptContent+=(String.valueOf(denom.getQuantity()) + " x " + String.valueOf(denom.getValue()) +"\n");
        }
        
        receiptContent+="-----------------------------\n";
        
        receiptTextArea.setText(receiptContent);
        receiptTextPanel.add(receiptTextArea);
        
        vendingMachine.releaseItem(selectedItems);
        vendingMachine.recievePayment(payment);
    }
    
    public RecieptController(ReceiptView receiptView){
        this.receiptView = receiptView;
    }
    
    public String getReceiptContent(){
        return this.receiptContent;
    }
    
    public JPanel getReceiptTextPanel(){
        return this.receiptTextPanel;
    }
    private String getCurrentDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currentDate = new Date();
        return dateFormat.format(currentDate);
    }
}
