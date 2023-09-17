package mc02final.mc02.View;
import mc02final.mc02.Controller.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CheckoutWindow extends JFrame {
    private JPanel checkoutPanel;
    private JLabel totalLabel;
    private JButton cancelButton;
    private JButton confirmButton;
    private CheckoutController checkoutController;
    
    
    private void setUpWindow(){
        checkoutController = new CheckoutController(this);
        setTitle("Checkout");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Color.BLACK); 

        JLabel checkoutLabel = new JLabel("Items Selected");
        checkoutLabel.setHorizontalAlignment(JLabel.CENTER);
        checkoutLabel.setFont(new Font("Arial", Font.BOLD, 20));
        checkoutLabel.setForeground(Color.WHITE); 
        headerPanel.add(checkoutLabel);

        add(headerPanel, BorderLayout.NORTH);
        
        checkoutPanel = new JPanel(new GridLayout(0, 4, 10, 5));
        checkoutPanel.setBackground(Color.WHITE);
        
        JLabel nameLabel = new JLabel("Item");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        nameLabel.setForeground(Color.BLACK);
        checkoutPanel.add(nameLabel);

        JLabel priceLabel = new JLabel("Price");
        priceLabel.setFont(new Font("Arial", Font.BOLD, 16));
        priceLabel.setForeground(Color.BLACK);
        checkoutPanel.add(priceLabel);

        JLabel amountLabel = new JLabel("Amount");
        amountLabel.setFont(new Font("Arial", Font.BOLD, 16));
        amountLabel.setForeground(Color.BLACK);
        checkoutPanel.add(amountLabel);

        JLabel caloriesLabel = new JLabel("Calories");
        caloriesLabel.setFont(new Font("Arial", Font.BOLD, 16));
        caloriesLabel.setForeground(Color.BLACK);
        checkoutPanel.add(caloriesLabel);
        add(checkoutPanel, BorderLayout.CENTER);
        
        
        // Show the total price
        totalLabel = new JLabel("Total: $");
        totalLabel.setHorizontalAlignment(JLabel.LEFT);
        totalLabel.setFont(new Font("Arial", Font.BOLD, 16));

        // Create the Confirm button
        confirmButton = new JButton("Confirm");

        // Create the Cancel Order button
        cancelButton = new JButton("Cancel Order");

        // Add the buttons to the button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(confirmButton);
        buttonPanel.add(cancelButton);
        add(buttonPanel, BorderLayout.SOUTH);

        buttonPanel.add(confirmButton);
        buttonPanel.add(totalLabel);

        // Make the checkout window visible
        setVisible(true);
    }
    
    public CheckoutWindow() {
        setUpWindow();
        
    }
    
    public void setCheckoutController(CheckoutController checkoutController) {
        this.checkoutController = checkoutController; 
    }
    
    public JButton getConfirmButton(){
        return this.confirmButton;
    }
    
    public JButton getCancelButton(){
        return this.cancelButton;
    }
    
    public JLabel getTotalLabel(){
        return this.totalLabel;
    }
    
    public JPanel getCheckoutPanel(){
        return this.checkoutPanel;
    }
    
    public void showPreparationPanelandReceipt() {
        if (checkoutController != null)
            checkoutController.showPreparationPanelAndReceipt();
    }
}