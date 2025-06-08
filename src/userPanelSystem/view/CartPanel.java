package userPanelSystem.view;

import cart.Cart;
import manager.OrderManager;

import javax.swing.*;
import java.awt.*;

import java.util.List;

public class CartPanel extends JPanel {
    public CartPanel(KioskFrame frame, Cart cart) {
        setLayout(new BorderLayout());

        JLabel title = new JLabel("장바구니", SwingConstants.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 24));
        add(title, BorderLayout.NORTH);

        // 장바구니 목록 표시
        JPanel cartItemPanel = new JPanel();
        cartItemPanel.setLayout(new BoxLayout(cartItemPanel, BoxLayout.Y_AXIS));

        List<OrderManager.OrderItem> cartItems = cart.returnCartItemList();
        if (cartItems.isEmpty()) {
            cartItemPanel.add(new JLabel("장바구니가 비어 있습니다."));
        } else {
            for (OrderManager.OrderItem item : cartItems) {
                JLabel itemLabel = new JLabel("• " + item);
                itemLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
                itemLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
                cartItemPanel.add(itemLabel);
            }
        }

        // 총 금액 출력
        JLabel totalLabel = new JLabel("총 금액: " + cart.returnTotalPrice() + "원");
        totalLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        totalLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        cartItemPanel.add(totalLabel);

        JScrollPane scrollPane = new JScrollPane(cartItemPanel);
        add(scrollPane, BorderLayout.CENTER);

        // 버튼 패널
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10)); // 가운데 정렬 + 간격

        // 결제 버튼
        JButton nextButton = new JButton("결제 화면으로");
        nextButton.addActionListener(e ->
                frame.refreshCartPanel(() -> new PaymentPanel(frame, OrderManager.getCart()), "Payment")
        );
        buttonPanel.add(nextButton);

        // 돌아가기 버튼
        JButton backButton = new JButton("돌아가기");
        backButton.addActionListener(e -> frame.showPanel("Menu"));
        buttonPanel.add(backButton);

        // 버튼 패널을 SOUTH에 추가
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
