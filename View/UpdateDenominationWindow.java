package mc02final.mc02.View;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;
import java.util.ArrayList;
public class UpdateDenominationWindow extends JFrame{
    private JPanel denominationPanel;
    private ArrayList<JButton> increaseButtonList;
    private ArrayList<JButton> decreaseButtonList;
    private ArrayList<JLabel> denomLabelList;
    private ArrayList<JLabel> currentAmountLabelList;
    private JButton goBackButton;
    public UpdateDenominationWindow() {
        this.increaseButtonList = new ArrayList<JButton>();
        this.decreaseButtonList = new ArrayList<JButton>();
        this.denomLabelList = new ArrayList<JLabel>();
        this.currentAmountLabelList = new ArrayList<JLabel>();
        // Set up the window properties
        this.setTitle("Update Denominations");
        this.setSize(300, 400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());

        // Add components to the window
        JLabel titleLabel = new JLabel("Update Denominations");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.BLACK);
        this.add(titleLabel, BorderLayout.NORTH);

        // Create and add the denominationPanel
        denominationPanel = new JPanel();
        denominationPanel.setLayout(new GridLayout(9, 3, 10, 10));
        denominationPanel.setBackground(Color.WHITE);

        // Sample denominations with initial quantity set to 10
        for (int i=0;i<9;i++) {
            addDenominationEntry();
        }

        this.add(denominationPanel, BorderLayout.CENTER);

        // Add the Go Back button
        goBackButton = new JButton("Go Back");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(goBackButton);

        this.add(buttonPanel, BorderLayout.SOUTH);
    }
    
    private void addDenominationEntry() {
        JLabel denomLabel = new JLabel("Denomination: $");
        denomLabelList.add(denomLabel);
        JLabel currentAmountLabel = new JLabel("Current Amount:");
        currentAmountLabelList.add(currentAmountLabel);

        JButton increaseButton = new JButton("+");
        increaseButtonList.add(increaseButton);
        JButton decreaseButton = new JButton("-");
        decreaseButtonList.add(decreaseButton);

        JPanel denomEntryPanel = new JPanel(new BorderLayout());
        denomEntryPanel.add(denomLabel, BorderLayout.NORTH);
        denomEntryPanel.add(currentAmountLabel, BorderLayout.CENTER);
        denomEntryPanel.add(increaseButton, BorderLayout.EAST);
        denomEntryPanel.add(decreaseButton, BorderLayout.WEST);

        denominationPanel.add(denomEntryPanel);
    }
    
    public ArrayList<JButton> getIncreaseButtonList(){
        return this.increaseButtonList;
    }
    
    public ArrayList<JButton> getDecreaseButtonList(){
        return this.decreaseButtonList;
    }
    
    public ArrayList<JLabel> getDenomLabelList(){
        return this.denomLabelList;
    }
    
    public ArrayList<JLabel> getCurrentAmountLabelList(){
        return this.currentAmountLabelList;
    }
    
    public JButton getGoBackButton(){
        return this.goBackButton;
    }
}
