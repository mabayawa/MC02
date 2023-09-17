package mc02final.mc02.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainMenuView extends JPanel{
    JButton createVendingMachine;
    JButton createSpecialVendingMachine;
    JButton exitButton;
    JButton maintenanceButton;
    JLabel shotPa;
    JPanel welcomeMessage;
    JPanel buttonPanel;

    public MainMenuView(){
        this.setLayout(new BorderLayout());
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(5, 0, 5, 0);

        createVendingMachine = new JButton("Vending Machine");
        createVendingMachine.setBackground(Color.white);
        createVendingMachine.setForeground(Color.black);

        createSpecialVendingMachine = new JButton("Special Vending Machine");
        createSpecialVendingMachine.setBackground(Color.white);
        createSpecialVendingMachine.setForeground(Color.black);

        maintenanceButton = new JButton("Maintenance");
        maintenanceButton.setBackground(Color.white);
        maintenanceButton.setForeground(Color.black);

        exitButton = new JButton("Exit");
        exitButton.setBackground(Color.white);
        exitButton.setForeground(Color.black);

        welcomeMessage = new JPanel(new BorderLayout());
        welcomeMessage.setBackground(Color.white);

        shotPa = new JLabel("Welcome to Shot Pa!");
        shotPa.setHorizontalAlignment(JLabel.CENTER);
        shotPa.setFont(new Font("Arial", Font.BOLD, 30));

        buttonPanel.add(createVendingMachine);
        buttonPanel.add(createSpecialVendingMachine);
        buttonPanel.add(maintenanceButton);
        buttonPanel.add(exitButton);

        welcomeMessage.add(shotPa,BorderLayout.CENTER);

        this.add(welcomeMessage,BorderLayout.NORTH);
        this.add(buttonPanel,BorderLayout.CENTER);
        this.setVisible(true);
    }

    public JButton getCreateVendMashButton(){
        return this.createVendingMachine;
    }
    
    public JButton getCreateSpecialVendMashButton(){
        return this.createSpecialVendingMachine;
    }
    
    public JButton getMaintenanceButton(){
        return this.maintenanceButton;
    }
    
    public JButton getExitButton(){
        return this.exitButton;
    }
}
