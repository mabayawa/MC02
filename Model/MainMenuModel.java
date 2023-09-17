package mc02final.mc02.Model;
public class MainMenuModel {
    private VendingMachine vendingMachine;
    private SpecialVendingMachine specialVendingMachine;
    private Driver driver;
    public MainMenuModel(){
        driver = new Driver();
        vendingMachine = new VendingMachine(driver.getSlotList(),driver.getSlotList().size(),driver.getDenomList());
        specialVendingMachine = new SpecialVendingMachine(driver.getSlotList(),driver.getSpecialSlotList().size(),driver.getDenomList(),driver.getSpecialSlotList());
    }
    
    public VendingMachine getVendingMachine(){
        return this.vendingMachine;
    }
    
    public SpecialVendingMachine getSpecialVendingMachine(){
        return this.specialVendingMachine;
    }
}
