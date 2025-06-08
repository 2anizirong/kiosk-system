package userPanelSystem.view;

import cart.Cart;
import manager.DataManager;
import manager.OrderManager;

import javax.swing.*;
import java.awt.*;
import java.util.function.Supplier;

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
        Cart cart = new Cart();
        OrderManager.setCart(cart);

        mainPanel.add(new StartPanel(this), "Start");
        mainPanel.add(new MenuPanel(this, dataManager), "Menu");
        mainPanel.add(new CartPanel(this, cart), "Cart");
        mainPanel.add(new PaymentPanel(this, cart), "Payment");
        mainPanel.add(new ResultPanel(this), "Result");

        add(mainPanel);
        setVisible(true);
        showPanel("Start");
    }

    public void showPanel(String name) {
        cardLayout.show(mainPanel, name);

        if (name.equals("Result")) {
            for (Component c : mainPanel.getComponents()) {
                if (c instanceof ResultPanel resultPanel) {
                    resultPanel.refresh();
                }
            }
        }
    }

    public void refreshCartPanel(Supplier<JPanel> panelSupplier, String name) {
        Component[] components = mainPanel.getComponents();
        for (Component c : components) {
            if (c.getClass().getSimpleName().equals(name)) {
                mainPanel.remove(c);
                break;
            }
        }
        mainPanel.add(panelSupplier.get(), name);
        showPanel(name);
    }

}
