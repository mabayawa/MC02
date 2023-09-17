package mc02final.mc02.View;
import mc02final.mc02.Controller.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class App extends JFrame{
    MainMenuView mainMenuView;
    MainMenuController mainMenuController;
    VendingMachineMenuView vendingMachineMenu;
    VendingMachineController vendingMachineController;
    SpecialVendingMachineMenu specialVendingMachineMenu;
    SpecialVendingMachineController specialVendingMachineController;
    MaintenanceWindow maintenanceWindow;
    MaintenanceController maintenanceController;
    
    public App(){
        this.setTitle("Shot Pa");
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setVisible(true);
        

        mainMenuView = new MainMenuView();
        mainMenuController = new MainMenuController();
        mainMenuView.setVisible(true);
        this.add(mainMenuView);
        pack();
        
        mainMenuView.getCreateVendMashButton().addActionListener(e->{
                mainMenuView.setVisible(false);
                
                
                
                remove(mainMenuView);
                
                revalidate();
                repaint();
                vendingMachineMenu = new VendingMachineMenuView();
                vendingMachineController = new VendingMachineController(vendingMachineMenu, mainMenuController.getVendingMachine());
                add(vendingMachineMenu,BorderLayout.CENTER);
                pack();
                
                vendingMachineMenu.getNoButton().addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        remove(vendingMachineMenu);
                        dispose();
                    }
                });
            });
        mainMenuView.getCreateSpecialVendMashButton().addActionListener(e->{
                //mainMenuView.setVisible(false);
                JFrame test = new JFrame();
                test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                test.setSize(500,500);
                
                //remove(mainMenuView);
                specialVendingMachineMenu = new SpecialVendingMachineMenu();
                specialVendingMachineController = new SpecialVendingMachineController(mainMenuController.getSpecialVendingMachine(),specialVendingMachineMenu);
                revalidate();
                repaint();
                test.add(specialVendingMachineMenu,BorderLayout.CENTER);
                test.setVisible(true);
                test.pack();
                pack();
                
                specialVendingMachineMenu.getNoButton().addActionListener(new ActionListener(){
                    @Override
                    public void  actionPerformed(ActionEvent e){
                        remove(specialVendingMachineMenu);
                        dispose();
                    }
                });
        });
        mainMenuView.getExitButton().addActionListener(e->{
            dispose();
        });
        
        mainMenuView.getMaintenanceButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                maintenanceWindow = new MaintenanceWindow();
                maintenanceController = new MaintenanceController(mainMenuController.getVendingMachine(), mainMenuController.getSpecialVendingMachine(), maintenanceWindow);
                maintenanceWindow.setVisible(true);
            }
        });
    }
    public static void main(String[] args){
        new App();
    }
}