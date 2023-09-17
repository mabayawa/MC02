package mc02final.mc02.Controller;
import mc02final.mc02.View.*;
import mc02final.mc02.Model.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.util.ArrayList;
public class UpdateItemController implements ActionListener{
    private VendingMachine vendingMachine;
    private SpecialVendingMachine specialVendingMachine;
    private UpdateItemWindow updateItemWindow;
    private ItemSlot selectedItem;
    private SpecialItemSlot selectedSpecialItem;
    private JPanel specialInputPanel;
    int i;
    public UpdateItemController(VendingMachine vendingMachine, SpecialVendingMachine specialVendingMachine, UpdateItemWindow updateItemWindow){
        this.vendingMachine = vendingMachine;
        this.specialVendingMachine = specialVendingMachine;
        this.updateItemWindow = updateItemWindow;
        setLabel();
        setSlotButtonListActionListener();
        
        updateItemWindow.getUpdateButton().addActionListener(this);
    }
    
    public void setLabel(){
        int slotListSize = vendingMachine.getSlotList().size();
        for(i=0;i<(vendingMachine.getSlotList().size() + specialVendingMachine.getSpecialSlotList().size());i++){
            if(i>=slotListSize){
                updateItemWindow.getNameLabelList().get(i).setText("Name: " + specialVendingMachine.getSpecialSlotList().get(i-slotListSize).getSpecialItem().getName());
                updateItemWindow.getCodeLabelList().get(i).setText("Code: " + specialVendingMachine.getSpecialSlotList().get(i-slotListSize).getItemCode());
                String price = String.valueOf(specialVendingMachine.getSpecialSlotList().get(i-slotListSize).getSpecialItem().getPrice());
                updateItemWindow.getPriceLabelList().get(i).setText("Price: $" + price);
                String calories = String.valueOf(specialVendingMachine.getSpecialSlotList().get(i-slotListSize).getSpecialItem().getCalories());
                updateItemWindow.getCaloriesLabelList().get(i).setText("Calories: $" + calories);
                String quantity = String.valueOf(specialVendingMachine.getSpecialSlotList().get(i-slotListSize).getItemQuantity());
                updateItemWindow.getQuantityLabelList().get(i).setText("Quantity: $" + quantity);
            } else{
                updateItemWindow.getNameLabelList().get(i).setText("Name: " + vendingMachine.getSlotList().get(i).getItem().getName());
                updateItemWindow.getCodeLabelList().get(i).setText("Code: " + vendingMachine.getSlotList().get(i).getItemCode());
                String price = String.valueOf(vendingMachine.getSlotList().get(i).getItem().getPrice());
                updateItemWindow.getPriceLabelList().get(i).setText("Price: $" + price);
                String calories = String.valueOf(vendingMachine.getSlotList().get(i).getItem().getCalories());
                updateItemWindow.getCaloriesLabelList().get(i).setText("Calories: $" + calories);
                String quantity = String.valueOf(vendingMachine.getSlotList().get(i).getItemQuantity());
                updateItemWindow.getQuantityLabelList().get(i).setText("Quantity: $" + quantity);
            }
        }
    }
    
    public void setSlotButtonListActionListener(){
        updateItemWindow.getButtonList().get(0).addActionListener(e->{
            updateItemWindow.getFullInventoryPanel().setVisible(false);
            updateItemWindow.remove(updateItemWindow.getFullInventoryPanel());
            updateItemWindow.add(updateItemWindow.getInputPanel(),BorderLayout.CENTER);
            selectedItem = vendingMachine.getSlotList().get(0);
        });
        
        updateItemWindow.getButtonList().get(1).addActionListener(e->{
            updateItemWindow.getFullInventoryPanel().setVisible(false);
            updateItemWindow.remove(updateItemWindow.getFullInventoryPanel());
            updateItemWindow.add(updateItemWindow.getInputPanel(),BorderLayout.CENTER);
            selectedItem = vendingMachine.getSlotList().get(1);
        });
        
        updateItemWindow.getButtonList().get(2).addActionListener(e->{
            updateItemWindow.getFullInventoryPanel().setVisible(false);
            updateItemWindow.remove(updateItemWindow.getFullInventoryPanel());
            updateItemWindow.add(updateItemWindow.getInputPanel(),BorderLayout.CENTER);
            selectedItem = vendingMachine.getSlotList().get(2);
        });
        
        updateItemWindow.getButtonList().get(3).addActionListener(e->{
            updateItemWindow.getFullInventoryPanel().setVisible(false);
            updateItemWindow.remove(updateItemWindow.getFullInventoryPanel());
            updateItemWindow.add(updateItemWindow.getInputPanel(),BorderLayout.CENTER);
            selectedItem = vendingMachine.getSlotList().get(3);
        });
        
        updateItemWindow.getButtonList().get(4).addActionListener(e->{
            updateItemWindow.getFullInventoryPanel().setVisible(false);
            updateItemWindow.remove(updateItemWindow.getFullInventoryPanel());
            updateItemWindow.add(updateItemWindow.getInputPanel(),BorderLayout.CENTER);
            selectedItem = vendingMachine.getSlotList().get(4);
        });
        
        updateItemWindow.getButtonList().get(5).addActionListener(e->{
            updateItemWindow.getFullInventoryPanel().setVisible(false);
            updateItemWindow.remove(updateItemWindow.getFullInventoryPanel());
            updateItemWindow.add(updateItemWindow.getInputPanel(),BorderLayout.CENTER);
            selectedItem = vendingMachine.getSlotList().get(5);
        });
        
        updateItemWindow.getButtonList().get(6).addActionListener(e->{
            updateItemWindow.getFullInventoryPanel().setVisible(false);
            updateItemWindow.remove(updateItemWindow.getFullInventoryPanel());
            updateItemWindow.add(updateItemWindow.getInputPanel(),BorderLayout.CENTER);
            selectedItem = vendingMachine.getSlotList().get(6);
        });
        
        updateItemWindow.getButtonList().get(7).addActionListener(e->{
            updateItemWindow.getFullInventoryPanel().setVisible(false);
            updateItemWindow.remove(updateItemWindow.getFullInventoryPanel());
            updateItemWindow.add(updateItemWindow.getInputPanel(),BorderLayout.CENTER);
            selectedItem = vendingMachine.getSlotList().get(7);
        });
        
        updateItemWindow.getButtonList().get(8).addActionListener(e->{
            updateItemWindow.getFullInventoryPanel().setVisible(false);
            updateItemWindow.remove(updateItemWindow.getFullInventoryPanel());
            updateItemWindow.add(updateItemWindow.getInputPanel(),BorderLayout.CENTER);
            selectedItem = vendingMachine.getSlotList().get(8);
        });
        
        updateItemWindow.getButtonList().get(9).addActionListener(e->{
            updateItemWindow.getFullInventoryPanel().setVisible(false);
            updateItemWindow.remove(updateItemWindow.getFullInventoryPanel());
            updateItemWindow.add(updateItemWindow.getInputPanel(),BorderLayout.CENTER);
            selectedItem = vendingMachine.getSlotList().get(9);
        });
        
        updateItemWindow.getButtonList().get(10).addActionListener(e->{
            updateItemWindow.getFullInventoryPanel().setVisible(false);
            updateItemWindow.remove(updateItemWindow.getFullInventoryPanel());
            updateItemWindow.add(updateItemWindow.getInputPanel(),BorderLayout.CENTER);
            selectedItem = vendingMachine.getSlotList().get(10);
        });
        
        updateItemWindow.getButtonList().get(11).addActionListener(e->{
            updateItemWindow.getFullInventoryPanel().setVisible(false);
            updateItemWindow.remove(updateItemWindow.getFullInventoryPanel());
            updateItemWindow.add(updateItemWindow.getInputPanel(),BorderLayout.CENTER);
            selectedItem = vendingMachine.getSlotList().get(11);
        });
        
        updateItemWindow.getButtonList().get(12).addActionListener(e->{
            updateItemWindow.getFullInventoryPanel().setVisible(false);
            updateItemWindow.remove(updateItemWindow.getFullInventoryPanel());
            updateItemWindow.add(updateItemWindow.getInputPanel(),BorderLayout.CENTER);
            selectedSpecialItem = specialVendingMachine.getSpecialSlotList().get(0);
        });
        
        updateItemWindow.getButtonList().get(13).addActionListener(e->{
            updateItemWindow.getFullInventoryPanel().setVisible(false);
            updateItemWindow.remove(updateItemWindow.getFullInventoryPanel());
            updateItemWindow.add(updateItemWindow.getInputPanel(),BorderLayout.CENTER);
            selectedSpecialItem = specialVendingMachine.getSpecialSlotList().get(1);
        });
        
        updateItemWindow.getButtonList().get(14).addActionListener(e->{
            updateItemWindow.getFullInventoryPanel().setVisible(false);
            updateItemWindow.remove(updateItemWindow.getFullInventoryPanel());
            updateItemWindow.add(updateItemWindow.getInputPanel(),BorderLayout.CENTER);
            selectedSpecialItem = specialVendingMachine.getSpecialSlotList().get(2);
        });
        
        updateItemWindow.getButtonList().get(15).addActionListener(e->{
            updateItemWindow.getFullInventoryPanel().setVisible(false);
            updateItemWindow.remove(updateItemWindow.getFullInventoryPanel());
            updateItemWindow.add(updateItemWindow.getInputPanel(),BorderLayout.CENTER);
            selectedSpecialItem = specialVendingMachine.getSpecialSlotList().get(3);
        });
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getActionCommand().equals("Update")) {
            String codeIndex = selectedItem.getItemCode();
            int newQuantity = Integer.parseInt(updateItemWindow.getQuantityField().getText());
            
            if(selectedItem != null){
                selectedItem.setItemQuantity(newQuantity);
                vendingMachine.updateItem(selectedItem,codeIndex);
            } else if(selectedSpecialItem != null){
                selectedSpecialItem.setItemQuantity(newQuantity);
                specialVendingMachine.updateItem(selectedSpecialItem,codeIndex);
            }
            
            
            // Update the button label
            //String label = newName + "\nPrice: $" + newPrice;
            

            updateItemWindow.dispose();
        } 
    }
}
