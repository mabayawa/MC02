package mc02final.mc02.Model;
public class ItemSlot extends Slot{
    private Item item;
    
    public ItemSlot(String itemName, int itemCalories, double itemPrice, int itemQuantity){
        super(itemQuantity);
        this.item = new Item(itemName, itemCalories, itemPrice);
    }
    
    public ItemSlot(String itemName, int itemCalories, double itemPrice, int itemQuantity, String itemCode){
        super(itemQuantity);
        this.item = new Item(itemName, itemCalories, itemPrice);
        this.setItemCode(itemCode);
    }
    
    public Item getItem(){
        return this.item;
    }
}