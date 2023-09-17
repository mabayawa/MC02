package mc02final.mc02.Model;
import java.util.ArrayList;
public class SpecialItem extends Item{
    private ArrayList<Item> ingredients;
    
    public SpecialItem(String itemName, int calories, double price, ArrayList<Item> ingredients){
        super(itemName,calories,price);
        this.ingredients = ingredients;
    }
    
    public void displayIngredients(){
        System.out.println("Ingredients: ");
        for(Item s: ingredients){
            System.out.println(s.getName());
        }
    }
    
    public ArrayList<Item> getIngredients(){
        return this.ingredients;
    }
}
