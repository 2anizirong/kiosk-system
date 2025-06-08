package userPanelSystem.view;

import manager.OrderManager;

import javax.swing.*;
import java.awt.*;

public class ResultPanel extends JPanel {
    private JLabel orderIdLabel;
    public ResultPanel(KioskFrame frame) {
        setLayout(new BorderLayout());

        orderIdLabel = new JLabel("", SwingConstants.CENTER);
        orderIdLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
        add(orderIdLabel, BorderLayout.CENTER);

        JButton homeButton = new JButton("메인으로 돌아가기");
        homeButton.addActionListener(e -> frame.showPanel("Start"));
        add(homeButton, BorderLayout.SOUTH);
    }

    public void refresh() {
        int lastOrderId = OrderManager.getLastOrderId();
        orderIdLabel.setText("주문 완료! 주문 번호: " + lastOrderId);
        OrderManager.getCart().clear();
        System.out.println("[DEBUG] 장바구니 및 주문 초기화됨");
    }
}
