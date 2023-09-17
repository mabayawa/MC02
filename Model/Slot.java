package mc02final.mc02.Model;
public abstract class Slot {
    private int itemQuantity;
    private boolean itemAvailability;
    private String itemCode;
    
    protected Slot(int itemQuantity){
        this.itemQuantity = itemQuantity;
        this.itemAvailability = true;
    }
    
    public void setItemAvailability(boolean newAvailability){
        this.itemAvailability = newAvailability;
    }
    
    public boolean getItemAvailability(){
        return this.itemAvailability;
    }
    
    public void setItemQuantity(int newQuantity){
        this.itemQuantity = newQuantity;
    }
    
    public int getItemQuantity(){
        return this.itemQuantity;
    }
    
    public void setItemCode(String itemCode){
        this.itemCode = itemCode;
    }
    
    public String getItemCode(){
        return this.itemCode;
    }
    
    public void addItemQuantity(int newQuantity){
        this.itemQuantity += newQuantity;
    }
}
