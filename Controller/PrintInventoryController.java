package mc02final.mc02.Controller;
import mc02final.mc02.View.*;
import mc02final.mc02.Model.*;
import java.util.ArrayList;

public class PrintInventoryController {
    VendingMachine vendingMachine;
    SpecialVendingMachine specialVendingMachine;
    PrintInventoryWindow printInventoryWindow;
    int i;
    int j;
    public PrintInventoryController(PrintInventoryWindow printInventoryWindow, VendingMachine vendingMachine, SpecialVendingMachine specialVendingMachine){
        this.vendingMachine = vendingMachine;
        this.specialVendingMachine = specialVendingMachine;
        this.printInventoryWindow = printInventoryWindow;
        
        ArrayList<ItemSlot> slotList = vendingMachine.getSlotList();
        for(i=0;i<slotList.size();i++){
            printInventoryWindow.getCodeLabelList().get(i).setText("Item Code: " + slotList.get(i).getItemCode());
            printInventoryWindow.getNameLabelList().get(i).setText("Item Name: " + slotList.get(i).getItem().getName());
            printInventoryWindow.getPriceLabelList().get(i).setText("Item Price: $" + String.valueOf(slotList.get(i).getItem().getPrice()));
            printInventoryWindow.getCalorieLabelList().get(i).setText("Item Calories: " + String.valueOf(slotList.get(i).getItem().getCalories()));
            printInventoryWindow.getQuantityLabelList().get(i).setText("Item Quantity: " + String.valueOf(slotList.get(i).getItemQuantity()));
        }
        
        ArrayList<SpecialItemSlot> specialSlotList = specialVendingMachine.getSpecialSlotList();
        for(i=0;i<specialSlotList.size();i++){
            printInventoryWindow.getSpecialCodeLabelList().get(i).setText("Item Code: " + specialSlotList.get(i).getItemCode());
            printInventoryWindow.getSpecialNameLabelList().get(i).setText("Item Name: " + specialSlotList.get(i).getSpecialItem().getName());
            printInventoryWindow.getSpecialPriceLabelList().get(i).setText("Item Price: $" + String.valueOf(specialSlotList.get(i).getSpecialItem().getPrice()));
            printInventoryWindow.getSpecialCalorieLabelList().get(i).setText("Item Calories: " + String.valueOf(specialSlotList.get(i).getSpecialItem().getCalories()));
            printInventoryWindow.getSpecialQuantityLabelList().get(i).setText("Item Quantity: " + String.valueOf(specialSlotList.get(i).getItemQuantity()));
            for(j=0;j<specialSlotList.get(i).getSpecialItem().getIngredients().size();j++){
                printInventoryWindow.getIngredientNameLabelList().get(j).setText("Ingredient Name: " + specialSlotList.get(i).getSpecialItem().getIngredients().get(j).getName());
                printInventoryWindow.getIngredientCalorieLabelList().get(j).setText("Ingredient Calories: " + String.valueOf(specialSlotList.get(i).getSpecialItem().getIngredients().get(j).getCalories()));
            }
        }
    }
}
