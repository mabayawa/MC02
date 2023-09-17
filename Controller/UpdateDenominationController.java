package mc02final.mc02.Controller;
import mc02final.mc02.View.*;
import mc02final.mc02.Model.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class UpdateDenominationController{
    VendingMachine  vendingMachine;
    SpecialVendingMachine specialVendingMachine;
    UpdateDenominationWindow updateDenominationWindow;
    public UpdateDenominationController(UpdateDenominationWindow updateDenominationWindow, VendingMachine  vendingMachine, SpecialVendingMachine specialVendingMachine){
        this.vendingMachine = vendingMachine;
        this.specialVendingMachine = specialVendingMachine;
        this.updateDenominationWindow = updateDenominationWindow;
        
        updateCurrentAmount();
        updateDenominationWindow.getGoBackButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                updateDenominationWindow.setVisible(false);
                updateDenominationWindow.dispose();
            }
        });
        
        setIncreaseButtonActionListener();
        
        
        
    }
    
    private void updateCurrentAmount(){
        for(int i=0;i<vendingMachine.getDenomList().size();i++){
            String value = vendingMachine.getDenomList().get(i).toString();
            updateDenominationWindow.getDenomLabelList().get(i).setText("Denomination: " + value);
            String curAmount = String.valueOf(vendingMachine.getDenomList().get(i).getQuantity());
            updateDenominationWindow.getCurrentAmountLabelList().get(i).setText("Current Amount: " + curAmount);
        }
    }
    
    private void setIncreaseButtonActionListener(){
        
        updateDenominationWindow.getIncreaseButtonList().get(0).addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                specialVendingMachine.getDenomList().get(0).addQuantity(1);
                updateCurrentAmount();
            }
        });
        
        updateDenominationWindow.getIncreaseButtonList().get(1).addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                specialVendingMachine.getDenomList().get(1).addQuantity(1);
                updateCurrentAmount();
            }
        });
        
        updateDenominationWindow.getIncreaseButtonList().get(2).addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                specialVendingMachine.getDenomList().get(2).addQuantity(1);
                updateCurrentAmount();
            }
        });
        
        updateDenominationWindow.getIncreaseButtonList().get(3).addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                specialVendingMachine.getDenomList().get(3).addQuantity(1);
                updateCurrentAmount();
            }
        });
        
        updateDenominationWindow.getIncreaseButtonList().get(4).addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                specialVendingMachine.getDenomList().get(4).addQuantity(1);
                updateCurrentAmount();
            }
        });
        
        updateDenominationWindow.getIncreaseButtonList().get(5).addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                specialVendingMachine.getDenomList().get(5).addQuantity(1);
                updateCurrentAmount();
            }
        });
        
        updateDenominationWindow.getIncreaseButtonList().get(6).addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                specialVendingMachine.getDenomList().get(6).addQuantity(1);
                updateCurrentAmount();
            }
        });
        
        updateDenominationWindow.getIncreaseButtonList().get(7).addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                specialVendingMachine.getDenomList().get(7).addQuantity(1);
                updateCurrentAmount();
            }
        });
        
        updateDenominationWindow.getIncreaseButtonList().get(8).addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                specialVendingMachine.getDenomList().get(8).addQuantity(1);
                updateCurrentAmount();
            }
        });
    }
    
    
}
