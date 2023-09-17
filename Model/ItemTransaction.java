package mc02final.mc02.Model;

import java.util.ArrayList;
public class ItemTransaction extends Transaction{
    private ArrayList<Item> items;
    public ItemTransaction(ArrayList<Item> items,double totalValue){
        super(totalValue);
        this.items=items;
    }
    
    public ArrayList<Item> getItems(){
        return this.items;
    }
}
