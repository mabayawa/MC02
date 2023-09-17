
package mc02final.mc02.Controller;
import mc02final.mc02.Model.*;

public class MainMenuController {
    private Driver driver;
    private VendingMachine vendingMachine;
    private SpecialVendingMachine specialVendingMachine;
    public MainMenuController(){
        this.driver=new Driver();
        this.vendingMachine = new VendingMachine(driver.getSlotList(),driver.getSlotList().size(),driver.getDenomList());
        this.specialVendingMachine = new SpecialVendingMachine(driver.getSlotList(),driver.getSpecialSlotList().size(),driver.getDenomList(),driver.getSpecialSlotList());
    }
    
    public VendingMachine getVendingMachine(){
        return this.vendingMachine;
    }
    
    public SpecialVendingMachine getSpecialVendingMachine(){
        return this.specialVendingMachine;
    }
}
