package mc02final.mc02.Controller;
import mc02final.mc02.View.*;
import mc02final.mc02.Model.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.util.ArrayList;
public class VendingMachineController{
    VendingMachine vendingMachine;
    VendingMachineMenuView vendingMachineMenu;
    private CheckoutWindow checkoutWindow;
    private CheckoutController checkoutController;
    ArrayList<ItemSlot> selectedItems;
    ArrayList<Denomination> payment;
    ArrayList<String> selectedItemNames;
    ArrayList<String> selectedDenominationNames;
    ArrayList<JButton> selectionList;
    ArrayList<JButton> denomButtonList;
    JButton clearButton;
    int i;
    double newTotal;
    double totalPayment;
    public VendingMachineController(VendingMachineMenuView vendingMachineMenu, VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
        this.vendingMachineMenu = vendingMachineMenu;
        this.selectedItems = new ArrayList<ItemSlot>();
        this.payment = new ArrayList<Denomination>();
        this.selectedDenominationNames = new ArrayList<String>();
        for(i=0;i<vendingMachine.getSlotList().size();i++){
            vendingMachineMenu.getNameLabelList().get(i).setText(vendingMachine.getSlotList().get(i).getItem().getName());
            String price = String.valueOf(vendingMachine.getSlotList().get(i).getItem().getPrice());
            vendingMachineMenu.getPriceLabelList().get(i).setText(price);
        }
        
        this.selectedItemNames = new ArrayList<String>();
        
        selectionList = vendingMachineMenu.getSelectionList();
        setSelectionListActionListener();
        
        clearButton = vendingMachineMenu.getClearButton();
        clearButton.addActionListener(e -> {
            this.selectedItems.clear();
            this.newTotal = 0;
        
            vendingMachineMenu.getTotalLabel().setText("Total: $0.00");
            updateSelectedItemNames();
            updateSelectedItemsLabel();
        });
        
        denomButtonList = vendingMachineMenu.getDenomButtonList();
        setDenomButtonListActionListener();
        
        vendingMachineMenu.getYesButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == vendingMachineMenu.getYesButton() && vendingMachine.canGoToCheckout(selectedItems, payment)){
                    checkoutWindow = new CheckoutWindow();
                    checkoutController = new CheckoutController(checkoutWindow,vendingMachine,selectedItems,payment);
                    checkoutWindow.setCheckoutController(checkoutController);
                }
            }
        });
        clearButton.setVisible(!selectedItems.isEmpty());
        
        
    }
    
    private void setSelectionListActionListener(){
        selectionList.get(0).addActionListener(e ->{
            newTotal=0;
            String itemName = vendingMachine.getSlotList().get(0).getItem().getName();
            int itemCalories = vendingMachine.getSlotList().get(0).getItem().getCalories();
            double itemPrice = vendingMachine.getSlotList().get(0).getItem().getPrice();
            int itemQuantity = 1;
            String itemCode = vendingMachine.getSlotList().get(0).getItemCode();
            ItemSlot selectedItem = new ItemSlot(itemName,itemCalories,itemPrice,itemQuantity,itemCode);
            
            selectedItems.add(selectedItem);
            
            for(ItemSlot s: selectedItems){
                newTotal += (s.getItem().getPrice() * s.getItemQuantity());
            }
            vendingMachineMenu.getTotalLabel().setText("Total: " + String.valueOf(newTotal));
            // Update the selected item names list and the label
            updateSelectedItemNames();
            updateSelectedItemsLabel();
            clearButton.setVisible(!selectedItems.isEmpty());
        });
        
        selectionList.get(1).addActionListener(e -> {
            newTotal=0;
                String itemName = vendingMachine.getSlotList().get(1).getItem().getName();
                int itemCalories = vendingMachine.getSlotList().get(1).getItem().getCalories();
                double itemPrice = vendingMachine.getSlotList().get(1).getItem().getPrice();
                int itemQuantity = 1;
                String itemCode = vendingMachine.getSlotList().get(1).getItemCode();
                ItemSlot selectedItem = new ItemSlot(itemName,itemCalories,itemPrice,itemQuantity,itemCode);
                
                selectedItems.add(selectedItem);
                
                for(ItemSlot s: selectedItems){
                    newTotal += (s.getItem().getPrice() * s.getItemQuantity());
                }
                vendingMachineMenu.getTotalLabel().setText("Total: " + String.valueOf(newTotal));
                // Update the selected item names list and the label
                updateSelectedItemNames();
                updateSelectedItemsLabel();
                vendingMachineMenu.getClearButton().setVisible(!selectedItems.isEmpty());
        });
        
        selectionList.get(2).addActionListener(e ->{
            newTotal=0;
            String itemName = vendingMachine.getSlotList().get(2).getItem().getName();
            int itemCalories = vendingMachine.getSlotList().get(2).getItem().getCalories();
            double itemPrice = vendingMachine.getSlotList().get(2).getItem().getPrice();
            int itemQuantity = 1;
            String itemCode = vendingMachine.getSlotList().get(2).getItemCode();
            ItemSlot selectedItem = new ItemSlot(itemName,itemCalories,itemPrice,itemQuantity,itemCode);
            
            selectedItems.add(selectedItem);
            
            for(ItemSlot s: selectedItems){
                newTotal += (s.getItem().getPrice() * s.getItemQuantity());
            }
            vendingMachineMenu.getTotalLabel().setText("Total: " + String.valueOf(newTotal));
            // Update the selected item names list and the label
            updateSelectedItemNames();
            updateSelectedItemsLabel();
            vendingMachineMenu.getClearButton().setVisible(!selectedItems.isEmpty());
        });
        
        selectionList.get(3).addActionListener(e -> {
            newTotal=0;
                String itemName = vendingMachine.getSlotList().get(3).getItem().getName();
                int itemCalories = vendingMachine.getSlotList().get(3).getItem().getCalories();
                double itemPrice = vendingMachine.getSlotList().get(3).getItem().getPrice();
                int itemQuantity = 1;
                String itemCode = vendingMachine.getSlotList().get(3).getItemCode();
                ItemSlot selectedItem = new ItemSlot(itemName,itemCalories,itemPrice,itemQuantity,itemCode);
                
                selectedItems.add(selectedItem);
                
                for(ItemSlot s: selectedItems){
                    newTotal += (s.getItem().getPrice() * s.getItemQuantity());
                }
                vendingMachineMenu.getTotalLabel().setText("Total: " + String.valueOf(newTotal));
                // Update the selected item names list and the label
                updateSelectedItemNames();
                updateSelectedItemsLabel();
                vendingMachineMenu.getClearButton().setVisible(!selectedItems.isEmpty());
        });
        
        selectionList.get(4).addActionListener(e ->{
            newTotal=0;
            String itemName = vendingMachine.getSlotList().get(4).getItem().getName();
            int itemCalories = vendingMachine.getSlotList().get(4).getItem().getCalories();
            double itemPrice = vendingMachine.getSlotList().get(4).getItem().getPrice();
            int itemQuantity = 1;
            String itemCode = vendingMachine.getSlotList().get(4).getItemCode();
            ItemSlot selectedItem = new ItemSlot(itemName,itemCalories,itemPrice,itemQuantity,itemCode);
            
            selectedItems.add(selectedItem);
            
            for(ItemSlot s: selectedItems){
                newTotal += (s.getItem().getPrice() * s.getItemQuantity());
            }
            vendingMachineMenu.getTotalLabel().setText("Total: " + String.valueOf(newTotal));
            // Update the selected item names list and the label
            updateSelectedItemNames();
            updateSelectedItemsLabel();
            vendingMachineMenu.getClearButton().setVisible(!selectedItems.isEmpty());
        });
        
        selectionList.get(5).addActionListener(e -> {
            newTotal=0;
                String itemName = vendingMachine.getSlotList().get(5).getItem().getName();
                int itemCalories = vendingMachine.getSlotList().get(5).getItem().getCalories();
                double itemPrice = vendingMachine.getSlotList().get(5).getItem().getPrice();
                int itemQuantity = 1;
                String itemCode = vendingMachine.getSlotList().get(5).getItemCode();
                ItemSlot selectedItem = new ItemSlot(itemName,itemCalories,itemPrice,itemQuantity,itemCode);
                
                selectedItems.add(selectedItem);
                
                for(ItemSlot s: selectedItems){
                    newTotal += (s.getItem().getPrice() * s.getItemQuantity());
                }
                vendingMachineMenu.getTotalLabel().setText("Total: " + String.valueOf(newTotal));
                // Update the selected item names list and the label
                updateSelectedItemNames();
                updateSelectedItemsLabel();
                vendingMachineMenu.getClearButton().setVisible(!selectedItems.isEmpty());
        });
        
        selectionList.get(6).addActionListener(e ->{
            newTotal=0;
            String itemName = vendingMachine.getSlotList().get(6).getItem().getName();
            int itemCalories = vendingMachine.getSlotList().get(6).getItem().getCalories();
            double itemPrice = vendingMachine.getSlotList().get(6).getItem().getPrice();
            int itemQuantity = 1;
            String itemCode = vendingMachine.getSlotList().get(6).getItemCode();
            ItemSlot selectedItem = new ItemSlot(itemName,itemCalories,itemPrice,itemQuantity,itemCode);
            
            selectedItems.add(selectedItem);
            
            for(ItemSlot s: selectedItems){
                newTotal += (s.getItem().getPrice() * s.getItemQuantity());
            }
            vendingMachineMenu.getTotalLabel().setText("Total: " + String.valueOf(newTotal));
            // Update the selected item names list and the label
            updateSelectedItemNames();
            updateSelectedItemsLabel();
            vendingMachineMenu.getClearButton().setVisible(!selectedItems.isEmpty());
        });
        
        selectionList.get(7).addActionListener(e -> {
            newTotal=0;
                String itemName = vendingMachine.getSlotList().get(7).getItem().getName();
                int itemCalories = vendingMachine.getSlotList().get(7).getItem().getCalories();
                double itemPrice = vendingMachine.getSlotList().get(7).getItem().getPrice();
                int itemQuantity = 1;
                String itemCode = vendingMachine.getSlotList().get(7).getItemCode();
                ItemSlot selectedItem = new ItemSlot(itemName,itemCalories,itemPrice,itemQuantity,itemCode);
                
                selectedItems.add(selectedItem);
                
                for(ItemSlot s: selectedItems){
                    newTotal += (s.getItem().getPrice() * s.getItemQuantity());
                }
                vendingMachineMenu.getTotalLabel().setText("Total: " + String.valueOf(newTotal));
                // Update the selected item names list and the label
                updateSelectedItemNames();
                updateSelectedItemsLabel();
                vendingMachineMenu.getClearButton().setVisible(!selectedItems.isEmpty());
        });
        
        selectionList.get(8).addActionListener(e ->{
            newTotal=0;
            String itemName = vendingMachine.getSlotList().get(8).getItem().getName();
            int itemCalories = vendingMachine.getSlotList().get(8).getItem().getCalories();
            double itemPrice = vendingMachine.getSlotList().get(8).getItem().getPrice();
            int itemQuantity = 1;
            String itemCode = vendingMachine.getSlotList().get(8).getItemCode();
            ItemSlot selectedItem = new ItemSlot(itemName,itemCalories,itemPrice,itemQuantity,itemCode);
            
            selectedItems.add(selectedItem);
            
            for(ItemSlot s: selectedItems){
                newTotal += (s.getItem().getPrice() * s.getItemQuantity());
            }
            vendingMachineMenu.getTotalLabel().setText("Total: " + String.valueOf(newTotal));
            // Update the selected item names list and the label
            updateSelectedItemNames();
            updateSelectedItemsLabel();
            vendingMachineMenu.getClearButton().setVisible(!selectedItems.isEmpty());
        });
        
        selectionList.get(9).addActionListener(e -> {
            newTotal=0;
                String itemName = vendingMachine.getSlotList().get(9).getItem().getName();
                int itemCalories = vendingMachine.getSlotList().get(9).getItem().getCalories();
                double itemPrice = vendingMachine.getSlotList().get(9).getItem().getPrice();
                int itemQuantity = 1;
                String itemCode = vendingMachine.getSlotList().get(9).getItemCode();
                ItemSlot selectedItem = new ItemSlot(itemName,itemCalories,itemPrice,itemQuantity,itemCode);
                
                selectedItems.add(selectedItem);
                
                for(ItemSlot s: selectedItems){
                    newTotal += (s.getItem().getPrice() * s.getItemQuantity());
                }
                vendingMachineMenu.getTotalLabel().setText("Total: " + String.valueOf(newTotal));
                // Update the selected item names list and the label
                updateSelectedItemNames();
                updateSelectedItemsLabel();
                vendingMachineMenu.getClearButton().setVisible(!selectedItems.isEmpty());
        });
        
        selectionList.get(10).addActionListener(e ->{
            newTotal=0;
            String itemName = vendingMachine.getSlotList().get(10).getItem().getName();
            int itemCalories = vendingMachine.getSlotList().get(10).getItem().getCalories();
            double itemPrice = vendingMachine.getSlotList().get(10).getItem().getPrice();
            int itemQuantity = 1;
            String itemCode = vendingMachine.getSlotList().get(10).getItemCode();
            ItemSlot selectedItem = new ItemSlot(itemName,itemCalories,itemPrice,itemQuantity,itemCode);
            
            selectedItems.add(selectedItem);
            
            for(ItemSlot s: selectedItems){
                newTotal += (s.getItem().getPrice() * s.getItemQuantity());
            }
            vendingMachineMenu.getTotalLabel().setText("Total: " + String.valueOf(newTotal));
            // Update the selected item names list and the label
            updateSelectedItemNames();
            updateSelectedItemsLabel();
            vendingMachineMenu.getClearButton().setVisible(!selectedItems.isEmpty());
        });
        
        selectionList.get(11).addActionListener(e -> {
            newTotal=0;
                String itemName = vendingMachine.getSlotList().get(11).getItem().getName();
                int itemCalories = vendingMachine.getSlotList().get(11).getItem().getCalories();
                double itemPrice = vendingMachine.getSlotList().get(11).getItem().getPrice();
                int itemQuantity = 1;
                String itemCode = vendingMachine.getSlotList().get(11).getItemCode();
                ItemSlot selectedItem = new ItemSlot(itemName,itemCalories,itemPrice,itemQuantity,itemCode);
                
                selectedItems.add(selectedItem);
                
                for(ItemSlot s: selectedItems){
                    newTotal += (s.getItem().getPrice() * s.getItemQuantity());
                }
                vendingMachineMenu.getTotalLabel().setText("Total: " + String.valueOf(newTotal));
                // Update the selected item names list and the label
                updateSelectedItemNames();
                updateSelectedItemsLabel();
                vendingMachineMenu.getClearButton().setVisible(!selectedItems.isEmpty());
        });
        
        vendingMachineMenu.getClearButton().setVisible(!selectedItems.isEmpty());
    }
    
    private void setDenomButtonListActionListener(){
        denomButtonList.get(0).addActionListener(e->{
            totalPayment =0;
            Denomination denom = new Denomination(vendingMachine.getDenomList().get(0).getValue());
            denom.setQuantity(1);
            payment.add(denom);
            
            for(Denomination d: payment){
                totalPayment += d.getTotalValue();
            }
            selectedDenominationNames.add(String.valueOf(denom.getValue()));
            updateDenominationLabel();
        });
        
        denomButtonList.get(1).addActionListener(e->{
            totalPayment =0;
            Denomination denom = new Denomination(vendingMachine.getDenomList().get(1).getValue());
            denom.setQuantity(1);
            payment.add(denom);
            
            for(Denomination d: payment){
                totalPayment += d.getTotalValue();
            }
            selectedDenominationNames.add(String.valueOf(denom.getValue()));
            updateDenominationLabel();
        });
        
        denomButtonList.get(2).addActionListener(e->{
            totalPayment =0;
            Denomination denom = new Denomination(vendingMachine.getDenomList().get(2).getValue());
            denom.setQuantity(1);
            payment.add(denom);
            
            for(Denomination d: payment){
                totalPayment += d.getTotalValue();
            }
            selectedDenominationNames.add(String.valueOf(denom.getValue()));
            updateDenominationLabel();
        });
        
        denomButtonList.get(3).addActionListener(e->{
            totalPayment =0;
            Denomination denom = new Denomination(vendingMachine.getDenomList().get(3).getValue());
            denom.setQuantity(1);
            payment.add(denom);
            
            for(Denomination d: payment){
                totalPayment += d.getTotalValue();
            }
            selectedDenominationNames.add(String.valueOf(denom.getValue()));
            updateDenominationLabel();
        });
        
        denomButtonList.get(4).addActionListener(e->{
            totalPayment =0;
            Denomination denom = new Denomination(vendingMachine.getDenomList().get(4).getValue());
            denom.setQuantity(1);
            payment.add(denom);
            
            for(Denomination d: payment){
                totalPayment += d.getTotalValue();
            }
            selectedDenominationNames.add(String.valueOf(denom.getValue()));
            updateDenominationLabel();
        });
        
        denomButtonList.get(5).addActionListener(e->{
            totalPayment =0;
            Denomination denom = new Denomination(vendingMachine.getDenomList().get(5).getValue());
            denom.setQuantity(1);
            payment.add(denom);
            
            for(Denomination d: payment){
                totalPayment += d.getTotalValue();
            }
            selectedDenominationNames.add(String.valueOf(denom.getValue()));
            updateDenominationLabel();
        });
        
        denomButtonList.get(6).addActionListener(e->{
            totalPayment =0;
            Denomination denom = new Denomination(vendingMachine.getDenomList().get(6).getValue());
            denom.setQuantity(1);
            payment.add(denom);
            
            for(Denomination d: payment){
                totalPayment += d.getTotalValue();
            }
            selectedDenominationNames.add(String.valueOf(denom.getValue()));
            updateDenominationLabel();
        });
        
        denomButtonList.get(7).addActionListener(e->{
            totalPayment =0;
            Denomination denom = new Denomination(vendingMachine.getDenomList().get(7).getValue());
            denom.setQuantity(1);
            payment.add(denom);
            
            for(Denomination d: payment){
                totalPayment += d.getTotalValue();
            }
            selectedDenominationNames.add(String.valueOf(denom.getValue()));
            updateDenominationLabel();
        });
        
        denomButtonList.get(8).addActionListener(e->{
            totalPayment =0;
            Denomination denom = new Denomination(vendingMachine.getDenomList().get(8).getValue());
            denom.setQuantity(1);
            payment.add(denom);
            
            for(Denomination d: payment){
                totalPayment += d.getTotalValue();
            }
            selectedDenominationNames.add(String.valueOf(denom.getValue()));
            updateDenominationLabel();
        });
    }
    
    
    private void updateSelectedItemNames() {
        selectedItemNames.clear();
        for (ItemSlot s : selectedItems) {
            selectedItemNames.add(s.getItem().getName());
        }
    }
    
    public void updateSelectedItemsLabel() {
        // Create a formatted string of the selected item names
        String formattedNames = String.join(", ", selectedDenominationNames);

        // Update the label
        vendingMachineMenu.getSelectedLabel().setText("You have chosen these items: " + formattedNames);

        // Show/hide the "Clear" button based on the number of selected items
        vendingMachineMenu.getClearButton().setVisible(!selectedItems.isEmpty());
    }
    
    public double getTotalPayment(){
        return this.totalPayment;
    }
    
    public void updateDenominationLabel(){
        String formattedNames = String.join(", ", selectedDenominationNames);

        // Update the label
        vendingMachineMenu.getSelectedDenomination().setText("You have chosen these Denominations: " + formattedNames);

        // Show/hide the "Clear" button based on the number of selected items
        vendingMachineMenu.getClearButton().setVisible(!selectedItems.isEmpty());
    }
}
