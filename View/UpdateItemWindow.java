package mc02final.mc02.View;

import java.awt.*;
import javax.swing.border.Border;
import javax.swing.*;
import java.util.ArrayList;

public class UpdateItemWindow extends JFrame{
    private JTextField quantityField;
    private ArrayList<JLabel> codeLabelList;
    private ArrayList<JLabel> nameLabelList;
    private ArrayList<JLabel> priceLabelList;
    private ArrayList<JLabel> caloriesLabelList;
    private ArrayList<JLabel> quantityLabelList;
    private JButton cancelButton;
    private JButton updateButton;
    ArrayList<JButton> slotButtonList;
    JPanel inventoryPanel;
    JPanel inputPanel;
    JPanel specialInventoryPanel;
    JPanel fullInventoryPanel;
    
    public UpdateItemWindow() {
        this.slotButtonList = new ArrayList<JButton>();
        this.codeLabelList = new ArrayList<JLabel>();
        this.nameLabelList = new ArrayList<JLabel>();
        this.priceLabelList = new ArrayList<JLabel>();
        this.caloriesLabelList = new ArrayList<JLabel>();
        this.quantityLabelList = new ArrayList<JLabel>();
        
        this.setTitle("Update Item");
        this.setSize(300, 200);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
        Border border = null;
        
        
        inventoryPanel = new JPanel();
        this.setLayout(new GridLayout(4,3));
        border = BorderFactory.createLineBorder(Color.BLACK,2);
        for(int i=0;i<12;i++){
            JButton slotButton = new JButton();
            slotButton.setLayout(new BoxLayout(slotButton,BoxLayout.Y_AXIS));
            slotButton.setBackground(Color.white);
            slotButton.setBorder(border);
            
            JLabel codeLabel = new JLabel("Item Code: ");
            codeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            codeLabel.setForeground(Color.black);
            slotButton.add(codeLabel);
            codeLabelList.add(codeLabel);
            
            JLabel nameLabel = new JLabel("Item Name: ");
            nameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            nameLabel.setForeground(Color.black);
            slotButton.add(nameLabel);
            nameLabelList.add(nameLabel);
            
            JLabel priceLabel = new JLabel("Item Price: $");
            priceLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            priceLabel.setForeground(Color.black);
            slotButton.add(priceLabel);
            priceLabelList.add(priceLabel);
            
            JLabel calorieLabel = new JLabel("Item Calories: ");
            calorieLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            calorieLabel.setForeground(Color.black);
            slotButton.add(calorieLabel);
            caloriesLabelList.add(calorieLabel);
            
            JLabel quantityLabel = new JLabel("Item Quantity: ");
            quantityLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            quantityLabel.setForeground(Color.black);
            slotButton.add(quantityLabel);
            quantityLabelList.add(quantityLabel);
            
            inventoryPanel.add(slotButton);
            slotButtonList.add(slotButton);
        }
        
        specialInventoryPanel = new JPanel();
        specialInventoryPanel.setLayout(new GridLayout(2,2));
        
        for(int i=0;i<4;i++){
            JButton slotButton = new JButton();
            slotButton.setLayout(new BoxLayout(slotButton,BoxLayout.Y_AXIS));
            slotButton.setBackground(Color.white);
            slotButton.setBorder(border);
            
            JLabel codeLabel = new JLabel("Item Code: ");
            codeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            codeLabel.setForeground(Color.black);
            slotButton.add(codeLabel);
            codeLabelList.add(codeLabel);
            
            JLabel nameLabel = new JLabel("Item Name: ");
            nameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            nameLabel.setForeground(Color.black);
            slotButton.add(nameLabel);
            nameLabelList.add(nameLabel);
            
            JLabel priceLabel = new JLabel("Item Price: $");
            priceLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            priceLabel.setForeground(Color.black);
            slotButton.add(priceLabel);
            priceLabelList.add(priceLabel);
            
            JLabel calorieLabel = new JLabel("Item Calories: ");
            calorieLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            calorieLabel.setForeground(Color.black);
            slotButton.add(calorieLabel);
            caloriesLabelList.add(calorieLabel);
            
            JLabel quantityLabel = new JLabel("Item Quantity: ");
            quantityLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            quantityLabel.setForeground(Color.black);
            slotButton.add(quantityLabel);
            quantityLabelList.add(quantityLabel);
            
            specialInventoryPanel.add(slotButton);
            slotButtonList.add(slotButton);
        }
        
        fullInventoryPanel = new JPanel();
        fullInventoryPanel.setLayout(new BoxLayout(fullInventoryPanel,BoxLayout.Y_AXIS));
        fullInventoryPanel.add(inventoryPanel);
        fullInventoryPanel.add(specialInventoryPanel);
        
        // Add components to the window
        JLabel titleLabel = new JLabel("Update Stock");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.BLACK);
        this.add(titleLabel, BorderLayout.NORTH);
        
        this.add(fullInventoryPanel, BorderLayout.CENTER);
        
        inputPanel = new JPanel(new GridLayout(1, 1, 10, 10));
        inputPanel.setBackground(Color.WHITE);

        
        inputPanel.add(new JLabel("Item Quantity:"));
        quantityField = new JTextField(10);
        inputPanel.add(quantityField);

        

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);

        updateButton = new JButton("Update");
        buttonPanel.add(updateButton);

        cancelButton = new JButton("Cancel");
        buttonPanel.add(cancelButton);

        this.add(buttonPanel, BorderLayout.SOUTH);
        
        
    }
    
    public ArrayList<JLabel> getNameLabelList(){
        return this.nameLabelList;
    }
    
    public ArrayList<JLabel> getCodeLabelList(){
        return this.codeLabelList;
    }
    
    public ArrayList<JLabel> getPriceLabelList(){
        return this.priceLabelList;
    }
    
    public ArrayList<JLabel> getCaloriesLabelList(){
        return this.caloriesLabelList;
    }
    
    public ArrayList<JLabel> getQuantityLabelList(){
        return this.quantityLabelList;
    }
    
    public JTextField getQuantityField(){
        return this.quantityField;
    }
    
    public JButton getCancelButton(){
        return this.cancelButton;
    }
    
    public ArrayList<JButton> getButtonList(){
        return this.slotButtonList;
    }
    
    public JPanel getFullInventoryPanel(){
        return this.fullInventoryPanel;
    }
    
    public JPanel getInputPanel(){
        return this.inputPanel;
    }
    
    public JButton getUpdateButton(){
        return this.updateButton;
    }
}
