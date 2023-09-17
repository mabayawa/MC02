package mc02final.mc02.Model;

import java.util.ArrayList;
public class SpecialItemSlot extends Slot {
    private SpecialItem specialItem;
    public SpecialItemSlot(String itemName, int itemCalories, double itemPrice, int itemQuantity, ArrayList<Item> ingredients){
        super(itemQuantity);
        this.specialItem = new SpecialItem(itemName, itemCalories, itemPrice, ingredients);
    }
    public SpecialItemSlot(String itemName, int itemCalories, double itemPrice, int itemQuantity, ArrayList<Item> ingredients, String itemCode){
        super(itemQuantity);
        this.specialItem = new SpecialItem(itemName, itemCalories, itemPrice, ingredients);
        this.setItemCode(itemCode);
    }
    
    public SpecialItem getSpecialItem(){
        return this.specialItem;
    }
}
