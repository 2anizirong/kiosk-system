package view;

import manager.OrderManager;

import javax.swing.*;
import java.awt.*;

public class ResultPanel extends JPanel {
    public ResultPanel(KioskFrame frame) {
        setLayout(new BorderLayout());

        JLabel label = new JLabel("주문 완료!", SwingConstants.CENTER);
        label.setFont(new Font("SansSerif", Font.BOLD, 24));
        add(label, BorderLayout.CENTER);

        JButton homeButton = new JButton("메인으로 돌아가기");
        homeButton.addActionListener(e -> frame.showPanel("Start"));
        add(homeButton, BorderLayout.SOUTH);
    }

    public void refresh() {
        OrderManager.clearOrders();
        OrderManager.getCart().clear();
        System.out.println("[DEBUG] 장바구니 및 주문 초기화됨");
    }
}
