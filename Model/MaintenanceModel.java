package mc02final.mc02.Model;

public class MaintenanceModel {
    private VendingMachine vendingMachine;
    private SpecialVendingMachine specialVendingMachine;

    public MaintenanceModel(VendingMachine vendingMachine, SpecialVendingMachine specialVendingMachine) {
        this.vendingMachine = vendingMachine;
        this.specialVendingMachine = specialVendingMachine;
    }

    public VendingMachine getVendingMachine() {
        return this.vendingMachine;
    }

    public SpecialVendingMachine getSpecialVendingMachine() {
        return this.specialVendingMachine;
    }
}
