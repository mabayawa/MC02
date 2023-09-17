package mc02final.mc02.Model;
import java.util.ArrayList;
public class SpecialItemTransaction extends Transaction{
    private ArrayList<SpecialItem> specialItems;
    public SpecialItemTransaction(ArrayList<SpecialItem> specialItems, double totalValue){
        super(totalValue);
        this.specialItems = specialItems;
    }
    
    public ArrayList<SpecialItem> getSpecialItems(){
        return this.specialItems;
    }
}
