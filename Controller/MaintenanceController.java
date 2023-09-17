package mc02final.mc02.Controller;

import mc02final.mc02.Model.*;
import mc02final.mc02.View.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MaintenanceController implements ActionListener {
    private VendingMachine vendingMachine;
    private SpecialVendingMachine specialVendingMachine;
    private MaintenanceModel maintenanceModel;
    private MaintenanceWindow maintenanceWindow;
    private PrintInventoryWindow printInventoryWindow;
    private PrintInventoryController printInventoryController;
    private UpdateDenominationWindow updateDenominationWindow;
    private UpdateDenominationController updateDenominationController;
    private UpdateItemWindow updateItemWindow;
    private UpdateItemController updateItemController;
    public MaintenanceController(VendingMachine vendingMachine,SpecialVendingMachine specialVendingMachine, MaintenanceWindow maintenanceWindow) {
        this.vendingMachine = vendingMachine;
        this.specialVendingMachine = specialVendingMachine;
        
        this.maintenanceWindow = maintenanceWindow;

        maintenanceWindow.getPrintInventoryButton().addActionListener(this);
        maintenanceWindow.getUpdateDenominationButton().addActionListener(this);
        maintenanceWindow.getUpdateItemButton().addActionListener(this);
        maintenanceWindow.getGoBackButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == maintenanceWindow.getPrintInventoryButton()) {
            // Handle print inventory action
            printInventoryWindow = new PrintInventoryWindow();
            printInventoryController = new PrintInventoryController(printInventoryWindow,vendingMachine,specialVendingMachine);
            printInventoryWindow.setVisible(true);
        } else if (e.getSource() == maintenanceWindow.getUpdateDenominationButton()) {
            // Handle update denomination action
            updateDenominationWindow = new UpdateDenominationWindow();
            updateDenominationController = new UpdateDenominationController(updateDenominationWindow,vendingMachine,specialVendingMachine);
            updateDenominationWindow.setVisible(true);
        } else if (e.getSource() == maintenanceWindow.getUpdateItemButton()) {
            // Handle update stock action
            updateItemWindow = new UpdateItemWindow();
            updateItemController = new UpdateItemController(vendingMachine,specialVendingMachine,updateItemWindow);
            updateItemWindow.setVisible(true);
        } else if (e.getSource() == maintenanceWindow.getGoBackButton()) {
            // Handle go back action to return to the main menu
            maintenanceWindow.setVisible(false);
            maintenanceWindow.dispose();
            // Assuming you have a reference to the main menu window, you can make it visible here
            // For example: mainMenu.setVisible(true);
        }
    }
}
