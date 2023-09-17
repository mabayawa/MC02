package mc02final.mc02.View;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SpecialVendingMachineMenu extends JPanel{
    JLabel shotPaLabel;
    private ArrayList<JButton> selectionList;
    JLabel totalLabel;
    ArrayList<JButton> denomButtonList;
    JButton yesMashButton;
    JButton noMashButton;
    private JLabel selectedItemsLabel; // Move the declaration here
    private JButton clearButton = new JButton("Clear");
    ArrayList<JButton> buttons = new ArrayList<>();
    JButton ingredientButton;
    private ArrayList<JLabel> nameLabelList;
    private ArrayList<JLabel> priceLabelList;
    public SpecialVendingMachineMenu(){
        this.setLayout(new BorderLayout());
        this.selectionList = new ArrayList<JButton>();
        this.denomButtonList = new ArrayList<JButton>();
        this.nameLabelList = new ArrayList<JLabel>();
        this.priceLabelList = new ArrayList<JLabel>();

        shotPaLabel = new JLabel("Shot Pa!");
        shotPaLabel.setHorizontalAlignment(JLabel.CENTER);
        shotPaLabel.setFont(new Font("Arial", Font.BOLD, 40));
        shotPaLabel.setForeground(Color.black);
        
        JPanel topPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        topPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        topPanel.setBackground(Color.white);
        shotPaLabel.setVisible(true);
        
        JPanel vendingMachinePanel = new JPanel(new BorderLayout());
        vendingMachinePanel.setBackground(Color.black);
        JLabel vendingMachineLabel = new JLabel("Vending Machine");
        vendingMachineLabel.setHorizontalAlignment(JLabel.CENTER);
        vendingMachineLabel.setFont(new Font("Arial", Font.BOLD, 20));
        vendingMachineLabel.setForeground(Color.white);
        vendingMachinePanel.add(vendingMachineLabel, BorderLayout.CENTER);
        vendingMachinePanel.setBorder(BorderFactory.createLineBorder(Color.black, 5));
        
        JLabel pickYourChoiceLabel = new JLabel("Pick your choice!");
        pickYourChoiceLabel.setHorizontalAlignment(JLabel.CENTER);
        pickYourChoiceLabel.setFont(new Font("Arial", Font.ITALIC, 16));
        pickYourChoiceLabel.setForeground(Color.white);
        vendingMachinePanel.add(pickYourChoiceLabel, BorderLayout.SOUTH);
        
        topPanel.add(shotPaLabel);
        topPanel.add(vendingMachinePanel);
        
        this.add(topPanel, BorderLayout.NORTH);
        
        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        buttonPanel.setBackground(Color.white);
        
        for (int i = 1; i <= 4; i++) {
            JPanel buttonWrapper = new JPanel(new BorderLayout());
            ingredientButton = new JButton("Ingredients:  ");
            ingredientButton.setPreferredSize(new Dimension(100, 100));
            ingredientButton.setBackground(Color.white);
            ingredientButton.setForeground(Color.black);
            ingredientButton.setBorder(BorderFactory.createLineBorder(Color.black));
            
            JPanel buttonDetails = new JPanel(new GridLayout(2, 1));
            JLabel nameLabel = new JLabel("Name");
            nameLabel.setHorizontalAlignment(JLabel.CENTER);
            nameLabel.setBorder(BorderFactory.createLineBorder(Color.black));
            nameLabel.setBackground(Color.black);
            nameLabel.setForeground(Color.white);
            nameLabel.setOpaque(true);
            this.nameLabelList.add(nameLabel);
            
            JLabel priceLabel = new JLabel();
            priceLabel.setText("$0.00");
            priceLabel.setHorizontalAlignment(JLabel.CENTER);
            priceLabel.setBorder(BorderFactory.createLineBorder(Color.black));
            priceLabel.setBackground(Color.black);
            priceLabel.setForeground(Color.white);
            priceLabel.setOpaque(true);
            this.priceLabelList.add(priceLabel);
            
            buttonDetails.add(nameLabel);
            buttonDetails.add(priceLabel);
            buttonWrapper.add(ingredientButton, BorderLayout.CENTER);
            buttonWrapper.add(buttonDetails, BorderLayout.SOUTH);
            buttonPanel.add(buttonWrapper);
            buttons.add(ingredientButton);
            
            selectionList.add(ingredientButton);
            
        }
        
        this.add(buttonPanel, BorderLayout.CENTER);
        
        JPanel selectionPanel = new JPanel(new BorderLayout());
        selectionPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        selectionPanel.setBackground(Color.white);

        selectedItemsLabel = new JLabel("You have chosen these items: _____");
        selectedItemsLabel.setHorizontalAlignment(JLabel.CENTER);
        selectedItemsLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        selectedItemsLabel.setForeground(Color.black);

        totalLabel = new JLabel("Total: $0.00");
        totalLabel.setHorizontalAlignment(JLabel.CENTER);
        totalLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        totalLabel.setForeground(Color.black);

        selectionPanel.add(selectedItemsLabel, BorderLayout.NORTH);
        
        //test
        JPanel amountPanel = new JPanel(new GridLayout(2, 1));
        amountPanel.setBackground(Color.white);
        
        JPanel totalPanel = new JPanel(new BorderLayout());
        totalPanel.setBackground(Color.white);
        totalPanel.add(totalLabel, BorderLayout.CENTER);
        amountPanel.add(totalPanel);
        
        JPanel amountButtonsPanel = new JPanel(new GridLayout(1, 5, 10, 10));
        amountButtonsPanel.setBackground(Color.white);
        
        String[] amounts = {"$1", "$5", "$10", "$20", "$50", "$100", "$200", "$500", "$1000"};
        for (String amount : amounts) {
            JButton amountButton = new JButton(amount);
            amountButton.setBackground(Color.white);
            amountButton.setForeground(Color.black);
            amountButtonsPanel.add(amountButton);
            this.denomButtonList.add(amountButton);
        }
        
        JPanel enterAmountPanel = new JPanel(new BorderLayout());
        enterAmountPanel.setBackground(Color.white);
        JLabel enterAmountLabel = new JLabel("Enter amount to pay:");
        enterAmountLabel.setHorizontalAlignment(JLabel.LEFT);
        enterAmountLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        enterAmountLabel.setForeground(Color.black);
        enterAmountPanel.add(enterAmountLabel, BorderLayout.WEST);
        enterAmountPanel.add(amountButtonsPanel, BorderLayout.CENTER);
        amountPanel.add(enterAmountPanel);
        
        selectionPanel.add(amountPanel, BorderLayout.CENTER);
        
        JPanel checkoutPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        checkoutPanel.setBackground(Color.white);
        
        JLabel checkoutLabel = new JLabel("Checkout Items?");
        checkoutLabel.setHorizontalAlignment(JLabel.LEFT);
        checkoutLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        checkoutLabel.setForeground(Color.black);
        checkoutPanel.add(checkoutLabel);
        
        yesMashButton = new JButton("Yes");
        yesMashButton.setBackground(Color.white);
        yesMashButton.setForeground(Color.black);
        checkoutPanel.add(yesMashButton);
        
        noMashButton = new JButton("No");
        noMashButton.setBackground(Color.white);
        noMashButton.setForeground(Color.black);
        checkoutPanel.add(noMashButton);
        
        selectionPanel.add(checkoutPanel, BorderLayout.SOUTH);
        
        this.add(selectionPanel, BorderLayout.SOUTH);
         // Initialize the selected items label
        selectedItemsLabel = new JLabel("You have chosen these items: ");
        selectedItemsLabel.setHorizontalAlignment(JLabel.CENTER);
        selectedItemsLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        selectedItemsLabel.setForeground(Color.black);
        selectionPanel.add(selectedItemsLabel, BorderLayout.NORTH);
        
        
        clearButton = new JButton("Clear");
        clearButton.setBackground(Color.white);
        clearButton.setForeground(Color.black);
        clearButton.setVisible(false);
        
        selectionPanel.add(clearButton, BorderLayout.EAST);
    }
    
    public ArrayList<JButton> getSelectionList(){
        return this.selectionList;
    }
    
    public ArrayList<JButton> getDenomButtonList(){
        return this.denomButtonList;
    }
    
    public JButton getClearButton(){
        return this.clearButton;
    }
    
    
    public JLabel getTotalLabel(){
        return this.totalLabel;
    }
    
    public JLabel getSelectedLabel(){
        return this.selectedItemsLabel;
    }
    
    public ArrayList<JLabel> getNameLabelList(){
        return this.nameLabelList;
    }
    
    public ArrayList<JLabel> getPriceLabelList(){
        return this.priceLabelList;
    }
    
    public JButton getYesButton(){
        return this.yesMashButton;
    }
    
    public JButton getNoButton(){
        return this.noMashButton;
    }
}
