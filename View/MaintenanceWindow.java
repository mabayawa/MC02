package mc02final.mc02.View;

import javax.swing.*;
import java.awt.*;
import mc02final.mc02.Controller.MaintenanceController;

public class MaintenanceWindow extends JFrame {
    JButton updateDenominationButton;
    JButton updateItemButton;
    JButton printInventoryButton;
    JButton goBackButton;
    JPanel buttonPanel;

    public MaintenanceWindow() {
        // Set up the window properties
        setTitle("Maintenance Window");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        updateDenominationButton = new JButton("Update Denominations");
        updateItemButton = new JButton("Update Stock");
        printInventoryButton = new JButton("Print Inventory");
        goBackButton = new JButton("Go Back");

        buttonPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        buttonPanel.add(updateDenominationButton);
        buttonPanel.add(updateItemButton);
        buttonPanel.add(printInventoryButton);
        buttonPanel.add(goBackButton);

        add(buttonPanel, BorderLayout.CENTER);
        
        
    }

    public JButton getPrintInventoryButton() {
        return this.printInventoryButton;
    }

    public JButton getUpdateDenominationButton() {
        return this.updateDenominationButton;
    }

    public JButton getUpdateItemButton() {
        return this.updateItemButton;
    }

    public JButton getGoBackButton() {
        return this.goBackButton;
    }

    public JPanel getButtonPanel() {
        return this.buttonPanel;
    }
}
