package mc02final.mc02.View;

import javax.swing.*;
import java.awt.*;

public class PreparationPanel extends JFrame {
    private JTextArea processingTextArea;

    public PreparationPanel(String selectedItemsText) {
        setTitle("Preparation");
        setSize(400, 300);
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        processingTextArea = new JTextArea(selectedItemsText);
        processingTextArea.setEditable(false);
        processingTextArea.setFont(new Font("Arial", Font.PLAIN, 16));
        processingTextArea.setLineWrap(true);
        processingTextArea.setWrapStyleWord(true);
        processingTextArea.setAlignmentX(JTextArea.CENTER_ALIGNMENT);
        processingTextArea.setAlignmentY(JTextArea.CENTER_ALIGNMENT);

        JScrollPane scrollPane = new JScrollPane(processingTextArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }
}
