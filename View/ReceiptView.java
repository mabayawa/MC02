package mc02final.mc02.View;
import mc02final.mc02.Controller.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ReceiptView extends JFrame {
    
    private RecieptController receiptController;
    private String temp;
    private String receiptContent;
    private JPanel receiptTextPanel;
    private JScrollPane scrollPane;
    public ReceiptView() {
        receiptController = new RecieptController(this);
        setTitle("Receipt");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setVisible(true);
        receiptTextPanel = new JPanel();
        JTextArea receiptTextArea = new JTextArea();
        receiptTextArea.setEditable(false);
        
        
        receiptContent = "---------- Receipt ----------\n";
        receiptContent+=("Date: ");
        receiptContent+=(getCurrentDateTime());
        receiptContent+="\nItems Purchased:\n";

        receiptContent+="-----------------------------\n";
        receiptTextArea.setText(receiptContent);
        receiptTextPanel.add(receiptTextArea);
        scrollPane = new JScrollPane(receiptTextPanel);
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));

        /* 
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the receipt window
                // Show main menu window (Assuming you have a reference to the main menu JFrame)
                vendingMachine.KULANG TO();
            }
        });
        buttonPanel.add(exitButton);

        /* 
        JButton orderAgainButton = new JButton("Order Again");
        orderAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                vendingMachine.KULANG TO();
            }
        }); 
        buttonPanel.add(orderAgainButton);*/

        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private String getCurrentDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currentDate = new Date();
        return dateFormat.format(currentDate);
    }
    
    
    
    public void setReceiptController(RecieptController receiptController){
        remove(scrollPane);
        this.receiptController = receiptController;
        this.receiptTextPanel = receiptController.getReceiptTextPanel();
        JScrollPane scrollPanel = new JScrollPane(receiptTextPanel);
        add(scrollPanel, BorderLayout.CENTER);
        pack();
    }
    
    
}
