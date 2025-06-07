package view;

import manager.DataManager;

import javax.swing.*;
import java.awt.*;

public class KioskFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public KioskFrame() {
        setTitle("키오스크");
        setSize(595, 842);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // 화면 중앙

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        DataManager dataManager = new DataManager();

        mainPanel.add(new MenuPanel(this, dataManager), "Menu");
        mainPanel.add(new CartPanel(this), "Cart");
        mainPanel.add(new PaymentPanel(this), "Payment");
        mainPanel.add(new ResultPanel(this), "Result");

        add(mainPanel);
        setVisible(true);
    }

    public void showPanel(String name) {
        cardLayout.show(mainPanel, name);
    }
}
