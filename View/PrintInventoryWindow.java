package mc02final.mc02.View;

import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import java.util.ArrayList;

public class PrintInventoryWindow extends JFrame {
    private ArrayList<JPanel> slotPanelList;
    private ArrayList<JLabel> codeLabelList;
    private ArrayList<JLabel> nameLabelList;
    private ArrayList<JLabel> priceLabelList;
    private ArrayList<JLabel> caloriesLabelList;
    private ArrayList<JLabel> quantityLabelList;
    
    private ArrayList<JLabel> specialCodeLabelList;
    private ArrayList<JLabel> specialNameLabelList;
    private ArrayList<JLabel> specialPriceLabelList;
    private ArrayList<JLabel> specialCaloriesLabelList;
    private ArrayList<JLabel> specialQuantityLabelList;
    
    private ArrayList<JLabel> ingredientNameLabelList;
    private ArrayList<JLabel> ingredientCalorieLabelList;
    public PrintInventoryWindow() {
        this.slotPanelList = new ArrayList<JPanel>();
        this.codeLabelList = new ArrayList<JLabel>();
        this.priceLabelList = new ArrayList<JLabel>();
        this.caloriesLabelList = new ArrayList<JLabel>();
        this.quantityLabelList = new ArrayList<JLabel>();
        
        this.nameLabelList = new ArrayList<JLabel>();
        this.specialCodeLabelList = new ArrayList<JLabel>();
        this.specialPriceLabelList = new ArrayList<JLabel>();
        this.specialCaloriesLabelList = new ArrayList<JLabel>();
        this.specialQuantityLabelList = new ArrayList<JLabel>();
        
        this.specialCodeLabelList = new ArrayList<JLabel>();
        this.specialNameLabelList = new ArrayList<JLabel>();
        this.specialPriceLabelList = new ArrayList<JLabel>();
        this.specialCaloriesLabelList = new ArrayList<JLabel>();
        this.specialQuantityLabelList = new ArrayList<JLabel>();
        
        this.ingredientNameLabelList = new ArrayList<JLabel>();
        this.ingredientCalorieLabelList = new ArrayList<JLabel>();
        // Set up the window properties
        this.setTitle("Print Inventory");
        this.setSize(500, 400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());

        // Add components to the window
        JLabel titleLabel = new JLabel("Current Inventory");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.BLACK);
        this.add(titleLabel, BorderLayout.NORTH);

        // Add any additional components or logic related to the "Print Inventory" window
        JPanel inventoryPanel = new JPanel();
        inventoryPanel.setLayout(new GridLayout(4,3));
        
        Border border = BorderFactory.createLineBorder(Color.BLACK,2);
        for(int i=0;i<12;i++){
            
            JPanel slotPanel = new JPanel();
            slotPanel.setLayout(new BoxLayout(slotPanel,BoxLayout.Y_AXIS));
            slotPanel.setBackground(Color.white);
            slotPanel.setBorder(border);
            slotPanelList.add(slotPanel);
            
            JLabel codeLabel = new JLabel("Item Code: ");
            codeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            codeLabel.setForeground(Color.black);
            slotPanel.add(codeLabel);
            codeLabelList.add(codeLabel);
            
            JLabel nameLabel = new JLabel("Item Name: ");
            nameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            nameLabel.setForeground(Color.black);
            slotPanel.add(nameLabel);
            nameLabelList.add(nameLabel);
            
            JLabel priceLabel = new JLabel("Item Price: $");
            priceLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            priceLabel.setForeground(Color.black);
            slotPanel.add(priceLabel);
            priceLabelList.add(priceLabel);
            
            JLabel calorieLabel = new JLabel("Item Calories: ");
            calorieLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            calorieLabel.setForeground(Color.black);
            slotPanel.add(calorieLabel);
            caloriesLabelList.add(calorieLabel);
            
            JLabel quantityLabel = new JLabel("Item Quantity: ");
            quantityLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            quantityLabel.setForeground(Color.black);
            slotPanel.add(quantityLabel);
            quantityLabelList.add(quantityLabel);
            
            inventoryPanel.add(slotPanel);
        }
        
        JPanel specialInventoryPanel = new JPanel();
        specialInventoryPanel.setLayout(new GridLayout(2,2));
        
        
        for(int i=0;i<4;i++){
            JPanel slotPanel = new JPanel();
            slotPanel.setLayout(new BoxLayout(slotPanel,BoxLayout.Y_AXIS));
            slotPanel.setBackground(Color.white);
            slotPanel.setBorder(border);
            
            JLabel codeLabel = new JLabel("Item Code: ");
            codeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            codeLabel.setForeground(Color.black);
            slotPanel.add(codeLabel);
            specialCodeLabelList.add(codeLabel);
            
            JLabel nameLabel = new JLabel("Item Name: ");
            nameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            nameLabel.setForeground(Color.black);
            slotPanel.add(nameLabel);
            specialNameLabelList.add(nameLabel);
            
            JLabel priceLabel = new JLabel("Item Price: $");
            priceLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            priceLabel.setForeground(Color.black);
            slotPanel.add(priceLabel);
            specialPriceLabelList.add(priceLabel);
            
            JLabel calorieLabel = new JLabel("Item Calories: ");
            calorieLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            calorieLabel.setForeground(Color.black);
            slotPanel.add(calorieLabel);
            specialCaloriesLabelList.add(calorieLabel);
            
            JLabel quantityLabel = new JLabel("Item Quantity: ");
            quantityLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            quantityLabel.setForeground(Color.black);
            slotPanel.add(quantityLabel);
            specialQuantityLabelList.add(quantityLabel);
            
            JPanel ingredientsPanel = new JPanel();
            ingredientsPanel.setLayout(new BoxLayout(ingredientsPanel,BoxLayout.Y_AXIS));
            for(int j=0;j<2;j++){
                JLabel ingredientNameLabel = new JLabel("Ingredient Name: ");
                ingredientNameLabel.setFont(new Font("Arial",Font.PLAIN,16));
                ingredientNameLabel.setForeground(Color.black);
                ingredientsPanel.add(ingredientNameLabel);
                this.ingredientNameLabelList.add(ingredientNameLabel);
                
                JLabel ingredientCalorieLabel = new JLabel("Ingredient Calories: ");
                ingredientCalorieLabel.setFont(new Font("Arial",Font.PLAIN,16));
                ingredientCalorieLabel.setForeground(Color.black);
                ingredientsPanel.add(ingredientCalorieLabel);
                this.ingredientCalorieLabelList.add(ingredientCalorieLabel);
            }
            slotPanel.add(ingredientsPanel);
            specialInventoryPanel.add(slotPanel);
        }
        
        JPanel fullInventoryPanel = new JPanel();
        fullInventoryPanel.setLayout(new BoxLayout(fullInventoryPanel,BoxLayout.Y_AXIS));
        
        fullInventoryPanel.add(inventoryPanel);
        fullInventoryPanel.add(specialInventoryPanel);
        
        this.add(fullInventoryPanel,BorderLayout.CENTER);
        
        JScrollPane scrollPane = new JScrollPane(fullInventoryPanel);
        this.add(scrollPane, BorderLayout.CENTER);
    }
    
    public ArrayList<JLabel> getCodeLabelList(){
        return this.codeLabelList;
    }
    
    public ArrayList<JLabel> getNameLabelList(){
        return this.nameLabelList;
    }
    
    public ArrayList<JLabel> getPriceLabelList(){
        return this.priceLabelList;
    }
    
    public ArrayList<JLabel> getCalorieLabelList(){
        return this.caloriesLabelList;
    }
    
    public ArrayList<JLabel> getQuantityLabelList(){
        return this.quantityLabelList;
    }
    
    public ArrayList<JLabel> getSpecialCodeLabelList(){
        return this.specialCodeLabelList;
    }
    
    public ArrayList<JLabel> getSpecialNameLabelList(){
        return this.specialNameLabelList;
    }
    
    public ArrayList<JLabel> getSpecialPriceLabelList(){
        return this.specialPriceLabelList;
    }
    
    public ArrayList<JLabel> getSpecialCalorieLabelList(){
        return this.specialCaloriesLabelList;
    }
    
    public ArrayList<JLabel> getSpecialQuantityLabelList(){
        return this.specialQuantityLabelList;
    }
    
    public ArrayList<JLabel> getIngredientNameLabelList(){
        return this.ingredientNameLabelList;
    }
    
    public ArrayList<JLabel> getIngredientCalorieLabelList(){
        return this.ingredientCalorieLabelList;
    }
}
