package mc02final.mc02.Controller;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import mc02final.mc02.View.*;
import mc02final.mc02.Model.*;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.BorderLayout;

public class CheckoutController {
    private CheckoutWindow checkoutWindow;
    private VendingMachine vendingMachine;
    private SpecialVendingMachine specialVendingMachine;
    private ArrayList<ItemSlot> selectedItems;
    private ArrayList<SpecialItemSlot> selectedSpecialItems;
    private JPanel checkoutPanel;
    private ReceiptView receiptView;
    private RecieptController receiptController;
    private double totalPrice;
    private ArrayList<Denomination> payment;
    
    public CheckoutController(CheckoutWindow checkoutWindow, SpecialVendingMachine specialVendingMachine, ArrayList<SpecialItemSlot> selectedSpecialItems, ArrayList<Denomination> payment){
        this.checkoutWindow = checkoutWindow;
        this.specialVendingMachine = specialVendingMachine;
        this.selectedSpecialItems = selectedSpecialItems;
        this.payment = payment;
        
        checkoutPanel = checkoutWindow.getCheckoutPanel();
        
        totalPrice = 0;
        
        for(SpecialItemSlot selectedSlot: selectedSpecialItems){
            JLabel itemNameLabel = new JLabel(selectedSlot.getSpecialItem().getName());
            itemNameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            itemNameLabel.setForeground(Color.BLACK);
            checkoutPanel.add(itemNameLabel);

            JLabel itemPriceLabel = new JLabel(String.format("$%.2f", selectedSlot.getSpecialItem().getPrice()));
            itemPriceLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            itemPriceLabel.setForeground(Color.BLACK);
            checkoutPanel.add(itemPriceLabel);

            JLabel itemAmountLabel = new JLabel(Integer.toString(selectedSlot.getItemQuantity()));
            itemAmountLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            itemAmountLabel.setForeground(Color.BLACK);
            checkoutPanel.add(itemAmountLabel);

            JLabel itemCaloriesLabel = new JLabel(Integer.toString(selectedSlot.getSpecialItem().getCalories()));
            itemCaloriesLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            itemCaloriesLabel.setForeground(Color.BLACK);
            checkoutPanel.add(itemCaloriesLabel);

            totalPrice += (selectedSlot.getSpecialItem().getPrice() * selectedSlot.getItemQuantity());
        }
        
        checkoutWindow.getTotalLabel().setText("Total: $" + String.valueOf(totalPrice));
        
        checkoutWindow.getConfirmButton().addActionListener(e ->{
            totalPrice=0;
            for(SpecialItemSlot s:selectedSpecialItems){
                totalPrice+=(s.getSpecialItem().getPrice() * s.getItemQuantity());
            }
            if(specialVendingMachine.canGenerateChange(payment, totalPrice)){
                checkoutWindow.dispose();
                showPreparationPanelAndReceipt();
            }
        });
    }
    
    public CheckoutController(CheckoutWindow checkoutWindow,VendingMachine vendingMachine, ArrayList<ItemSlot> selectedItems, ArrayList<Denomination> payment){
        this.checkoutWindow = checkoutWindow;
        this.vendingMachine = vendingMachine;
        this.selectedItems = selectedItems;
        this.payment = payment;
        checkoutPanel = checkoutWindow.getCheckoutPanel();
        totalPrice  =0;
        
        for (ItemSlot selectedSlot : selectedItems) {
            JLabel itemNameLabel = new JLabel(selectedSlot.getItem().getName());
            itemNameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            itemNameLabel.setForeground(Color.BLACK);
            checkoutPanel.add(itemNameLabel);

            JLabel itemPriceLabel = new JLabel(String.format("$%.2f", selectedSlot.getItem().getPrice()));
            itemPriceLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            itemPriceLabel.setForeground(Color.BLACK);
            checkoutPanel.add(itemPriceLabel);

            JLabel itemAmountLabel = new JLabel(Integer.toString(selectedSlot.getItemQuantity()));
            itemAmountLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            itemAmountLabel.setForeground(Color.BLACK);
            checkoutPanel.add(itemAmountLabel);

            JLabel itemCaloriesLabel = new JLabel(Integer.toString(selectedSlot.getItem().getCalories()));
            itemCaloriesLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            itemCaloriesLabel.setForeground(Color.BLACK);
            checkoutPanel.add(itemCaloriesLabel);

            totalPrice += (selectedSlot.getItem().getPrice() * selectedSlot.getItemQuantity());
        }
        
        checkoutWindow.getTotalLabel().setText("Total: $" + String.valueOf(totalPrice));
        
        checkoutWindow.getCancelButton().addActionListener(e->{
            checkoutWindow.dispose();
        });
        
        checkoutWindow.getConfirmButton().addActionListener(e ->{
            totalPrice=0;
            for(ItemSlot s:selectedItems){
                totalPrice+=(s.getItem().getPrice() * s.getItemQuantity());
            }
            if(vendingMachine.canGenerateChange(payment, totalPrice)){
                checkoutWindow.dispose();
                receiptView = new ReceiptView();
                
                showPreparationPanelAndReceipt();
            }
        });
    }
    public void showPreparationPanelAndReceipt() {
        // Create the preparation panel and add it to the checkout window
        String selectedItemsText = generatePreparationText();
        PreparationPanel preparationPanel = new PreparationPanel(selectedItemsText);

        // Delay the appearance of the receipt for a few seconds
        Timer timer = new Timer(3000, e -> {
            preparationPanel.dispose();
            // Now, display the receipt
            showReceipt();
        });

        // Start the timer
        timer.setRepeats(false); // Only run the timer once
        timer.start();
    }
   
    private String generatePreparationText() {
    StringBuilder preparationText = new StringBuilder();

    for (SpecialItemSlot slot : selectedSpecialItems) {
        SpecialItem item = slot.getSpecialItem();
        preparationText.append(item.getName()).append("\n");

        if (item.getName().equals("Soju Bomb")) {
            preparationText.append("\nPlacing shot glasses on the counter...\n");
            preparationText.append("Pouring soju into each shot glass...\n");
            preparationText.append("Preparing beer glasses...\n");
            preparationText.append("Pouring beer into each glass...\n");
        } else if (item.getName().equals("Jack and Coke")) {
            preparationText.append("\nPreparing glass with ice cubes...\n");
            preparationText.append("Pouring Jack Daniel's whiskey into the glass...\n");
            preparationText.append("Adding Coca-Cola to the mix...\n");
            preparationText.append("Stirring gently with a bar spoon...\n");
        } else if (item.getName().equals("Gin and Tonic")) {
            preparationText.append("\nPreparing a chilled glass...\n");
            preparationText.append("Adding ice cubes to the glass...\n");
            preparationText.append("Pouring gin into the glass...\n");
            preparationText.append("Squeezing a fresh lime wedge into the mix...\n");
            preparationText.append("Topping up with tonic water...\n");
        } else if (item.getName().equals("Scredriver")) {
            preparationText.append("\nPreparing a highball glass...\n");
            preparationText.append("Filling the glass with ice cubes...\n");
            preparationText.append("Pouring vodka into the glass...\n");
            preparationText.append("Adding freshly squeezed orange juice to the mix...\n");
            preparationText.append("Stirring gently with a bar spoon...\n");
        }
        preparationText.append("\n");
    }

    return preparationText.toString();
}

    private void showReceipt() {
        // Create the receipt view and controller
        receiptView = new ReceiptView();
        if (specialVendingMachine != null) {
            receiptController = new RecieptController(receiptView, specialVendingMachine, selectedSpecialItems, payment);
        } else if (vendingMachine != null) {
            receiptController = new RecieptController(receiptView, vendingMachine, selectedItems, payment);
        }
        receiptView.setReceiptController(receiptController);

 
        receiptView.setVisible(true);
    }
    public CheckoutController(CheckoutWindow checkoutWindow){
        this.checkoutWindow = checkoutWindow;
        
    }
    
    public JPanel getCheckoutPanel(){
        return this.checkoutPanel;
    }
}
