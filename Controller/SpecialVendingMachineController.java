package mc02final.mc02.Controller;
import mc02final.mc02.View.*;
import mc02final.mc02.Model.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.util.ArrayList;

public class SpecialVendingMachineController{
    private SpecialVendingMachine specialVendingMachine;
    private SpecialVendingMachineMenu specialVendingMachineMenu;
    private ArrayList<JButton> specialSelectionList;
    private ArrayList<SpecialItemSlot> specialSlotList;
    private JButton clearButton;
    private ArrayList<JButton> denomButtonList;
    private ArrayList<SpecialItemSlot> selectedItems;
    private ArrayList<Denomination> payment;
    private ArrayList<String> selectedItemNames;
    private ArrayList<String> selectedDenominationNames;
    private CheckoutWindow checkoutWindow;
    private CheckoutController checkoutController;
    int i;
    int j;
    double newTotal;
    double totalPayment;
    public SpecialVendingMachineController(SpecialVendingMachine specialVendingMachine, SpecialVendingMachineMenu specialVendingMachineMenu){
        this.specialVendingMachineMenu = specialVendingMachineMenu;
        this.specialVendingMachine = specialVendingMachine;
        this.specialSlotList = specialVendingMachine.getSpecialSlotList();
        this.specialSelectionList = specialVendingMachineMenu.getSelectionList();
        
        this.selectedItems = new ArrayList<SpecialItemSlot>();
        this.selectedItemNames = new ArrayList<String>();
        this.payment = new ArrayList<Denomination>();
        
        for(i=0;i<specialSlotList.size();i++){
            String ingredients ="Ingredients: ";
            for(Item j: specialSlotList.get(i).getSpecialItem().getIngredients()){
                ingredients+=(j.getName() + ", ");
                specialSelectionList.get(i).setText(ingredients);
            }
        }
        
        for(i=0;i<specialVendingMachine.getSpecialSlotList().size();i++){
            specialVendingMachineMenu.getNameLabelList().get(i).setText(specialVendingMachine.getSpecialSlotList().get(i).getSpecialItem().getName());
            String price = String.valueOf(specialVendingMachine.getSpecialSlotList().get(i).getSpecialItem().getPrice());
            specialVendingMachineMenu.getPriceLabelList().get(i).setText(price);
        }
        
        setSelectionListActionListener();
        
        clearButton = specialVendingMachineMenu.getClearButton();
        clearButton.addActionListener(e -> {
            this.selectedItems.clear();
            this.newTotal=0;
            
            specialVendingMachineMenu.getTotalLabel().setText("Total: $0.00");
        });
        
        denomButtonList = specialVendingMachineMenu.getDenomButtonList();
        setDenomButtonListActionListener();
        
        specialVendingMachineMenu.getYesButton().addActionListener(e->{
            if(specialVendingMachine.specialCanGoToCheckout(selectedItems, payment)){
                checkoutWindow = new CheckoutWindow();
                checkoutController = new CheckoutController(checkoutWindow,specialVendingMachine,selectedItems,payment);
                checkoutWindow.setCheckoutController(checkoutController);
            }
        });
        clearButton.setVisible(!selectedItems.isEmpty());
    }
    private void updateSelectedItemNames() {
        selectedItemNames.clear();
        for (SpecialItemSlot s : selectedItems) {
            selectedItemNames.add(s.getSpecialItem().getName());
        }
    }
    
    private void updateSelectedItemsLabel() {
        // Create a formatted string of the selected item names
        String formattedNames = String.join(", ", selectedItemNames);

        // Update the label
        specialVendingMachineMenu.getSelectedLabel().setText("You have chosen these items: " + formattedNames);

        // Show/hide the "Clear" button based on the number of selected items
        specialVendingMachineMenu.getClearButton().setVisible(!selectedItems.isEmpty());
    }
    
    private void setSelectionListActionListener(){
        specialVendingMachineMenu.getSelectionList().get(0).addActionListener(e->{
            newTotal =0;
            String itemName = specialVendingMachine.getSpecialSlotList().get(0).getSpecialItem().getName();
            int itemCalories = specialVendingMachine.getSpecialSlotList().get(0).getSpecialItem().getCalories();
            double itemPrice = specialVendingMachine.getSpecialSlotList().get(0).getSpecialItem().getPrice();
            int itemQuantity = 1;
            String itemCode = specialVendingMachine.getSpecialSlotList().get(0).getItemCode();
            ArrayList<Item> ingredients = specialVendingMachine.getSpecialSlotList().get(0).getSpecialItem().getIngredients();
            SpecialItemSlot selectedItem = new SpecialItemSlot(itemName,itemCalories,itemPrice,itemQuantity,ingredients,itemCode);
            selectedItems.add(selectedItem);
            
            for(SpecialItemSlot s: selectedItems){
                newTotal += (s.getSpecialItem().getPrice() * s.getItemQuantity());
            }
            specialVendingMachineMenu.getTotalLabel().setText("Total: " + String.valueOf(newTotal));
            
            updateSelectedItemNames();
            updateSelectedItemsLabel();
        });
        
        specialVendingMachineMenu.getSelectionList().get(1).addActionListener(e->{
            newTotal =0;
            String itemName = specialVendingMachine.getSpecialSlotList().get(1).getSpecialItem().getName();
            int itemCalories = specialVendingMachine.getSpecialSlotList().get(1).getSpecialItem().getCalories();
            double itemPrice = specialVendingMachine.getSpecialSlotList().get(1).getSpecialItem().getPrice();
            int itemQuantity = 1;
            String itemCode = specialVendingMachine.getSpecialSlotList().get(1).getItemCode();
            ArrayList<Item> ingredients = specialVendingMachine.getSpecialSlotList().get(1).getSpecialItem().getIngredients();
            SpecialItemSlot selectedItem = new SpecialItemSlot(itemName,itemCalories,itemPrice,itemQuantity,ingredients,itemCode);
            selectedItems.add(selectedItem);
            
            for(SpecialItemSlot s: selectedItems){
                newTotal += (s.getSpecialItem().getPrice() * s.getItemQuantity());
            }
            specialVendingMachineMenu.getTotalLabel().setText("Total: " + String.valueOf(newTotal));
            
            updateSelectedItemNames();
            updateSelectedItemsLabel();
        });
        
        specialVendingMachineMenu.getSelectionList().get(2).addActionListener(e->{
            newTotal =0;
            String itemName = specialVendingMachine.getSpecialSlotList().get(2).getSpecialItem().getName();
            int itemCalories = specialVendingMachine.getSpecialSlotList().get(2).getSpecialItem().getCalories();
            double itemPrice = specialVendingMachine.getSpecialSlotList().get(2).getSpecialItem().getPrice();
            int itemQuantity = 1;
            String itemCode = specialVendingMachine.getSpecialSlotList().get(2).getItemCode();
            ArrayList<Item> ingredients = specialVendingMachine.getSpecialSlotList().get(2).getSpecialItem().getIngredients();
            SpecialItemSlot selectedItem = new SpecialItemSlot(itemName,itemCalories,itemPrice,itemQuantity,ingredients,itemCode);
            selectedItems.add(selectedItem);
            
            for(SpecialItemSlot s: selectedItems){
                newTotal += (s.getSpecialItem().getPrice() * s.getItemQuantity());
            }
            specialVendingMachineMenu.getTotalLabel().setText("Total: " + String.valueOf(newTotal));
            
            updateSelectedItemNames();
            updateSelectedItemsLabel();
        });
        
        specialVendingMachineMenu.getSelectionList().get(3).addActionListener(e->{
            newTotal =0;
            String itemName = specialVendingMachine.getSpecialSlotList().get(3).getSpecialItem().getName();
            int itemCalories = specialVendingMachine.getSpecialSlotList().get(3).getSpecialItem().getCalories();
            double itemPrice = specialVendingMachine.getSpecialSlotList().get(3).getSpecialItem().getPrice();
            int itemQuantity = 1;
            String itemCode = specialVendingMachine.getSpecialSlotList().get(3).getItemCode();
            ArrayList<Item> ingredients = specialVendingMachine.getSpecialSlotList().get(3).getSpecialItem().getIngredients();
            SpecialItemSlot selectedItem = new SpecialItemSlot(itemName,itemCalories,itemPrice,itemQuantity,ingredients,itemCode);
            selectedItems.add(selectedItem);
            
            for(SpecialItemSlot s: selectedItems){
                newTotal += (s.getSpecialItem().getPrice() * s.getItemQuantity());
            }
            specialVendingMachineMenu.getTotalLabel().setText("Total: " + String.valueOf(newTotal));
            
            updateSelectedItemNames();
            updateSelectedItemsLabel();
        });
        
        
    }
    
    private void setDenomButtonListActionListener(){
        denomButtonList.get(0).addActionListener(e->{
            totalPayment =0;
            Denomination denom = new Denomination(specialVendingMachine.getDenomList().get(0).getValue());
            denom.setQuantity(1);
            payment.add(denom);
            
            for(Denomination d: payment){
                totalPayment += d.getTotalValue();
            }
            
            selectedDenominationNames.add(String.valueOf(denom.getQuantity()));
        });
        
        denomButtonList.get(1).addActionListener(e->{
            totalPayment =0;
            Denomination denom = new Denomination(specialVendingMachine.getDenomList().get(1).getValue());
            denom.setQuantity(1);
            payment.add(denom);
            
            for(Denomination d: payment){
                totalPayment += d.getTotalValue();
            }
        });
        
        denomButtonList.get(2).addActionListener(e->{
            totalPayment =0;
            Denomination denom = new Denomination(specialVendingMachine.getDenomList().get(2).getValue());
            denom.setQuantity(1);
            payment.add(denom);
            
            for(Denomination d: payment){
                totalPayment += d.getTotalValue();
            }
        });
        
        denomButtonList.get(3).addActionListener(e->{
            totalPayment =0;
            Denomination denom = new Denomination(specialVendingMachine.getDenomList().get(3).getValue());
            denom.setQuantity(1);
            payment.add(denom);
            
            for(Denomination d: payment){
                totalPayment += d.getTotalValue();
            }
        });
        
        denomButtonList.get(4).addActionListener(e->{
            totalPayment =0;
            Denomination denom = new Denomination(specialVendingMachine.getDenomList().get(4).getValue());
            denom.setQuantity(1);
            payment.add(denom);
            
            for(Denomination d: payment){
                totalPayment += d.getTotalValue();
            }
        });
        
        denomButtonList.get(5).addActionListener(e->{
            totalPayment =0;
            Denomination denom = new Denomination(specialVendingMachine.getDenomList().get(5).getValue());
            denom.setQuantity(1);
            payment.add(denom);
            
            for(Denomination d: payment){
                totalPayment += d.getTotalValue();
            }
        });
        
        denomButtonList.get(6).addActionListener(e->{
            totalPayment =0;
            Denomination denom = new Denomination(specialVendingMachine.getDenomList().get(6).getValue());
            denom.setQuantity(1);
            payment.add(denom);
            
            for(Denomination d: payment){
                totalPayment += d.getTotalValue();
            }
        });
        
        denomButtonList.get(7).addActionListener(e->{
            totalPayment =0;
            Denomination denom = new Denomination(specialVendingMachine.getDenomList().get(7).getValue());
            denom.setQuantity(1);
            payment.add(denom);
            
            for(Denomination d: payment){
                totalPayment += d.getTotalValue();
            }
        });
        
        denomButtonList.get(8).addActionListener(e->{
            totalPayment =0;
            Denomination denom = new Denomination(specialVendingMachine.getDenomList().get(8).getValue());
            denom.setQuantity(1);
            payment.add(denom);
            
            for(Denomination d: payment){
                totalPayment += d.getTotalValue();
            }
        });
    }
    
    
}
