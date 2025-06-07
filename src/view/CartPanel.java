package view;

import cart.Cart;

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

        List<String> cartItems = cart.returnCartItemList();
        if (cartItems.isEmpty()) {
            cartItemPanel.add(new JLabel("장바구니가 비어 있습니다."));
        } else {
            for (String item : cartItems) {
                JLabel itemLabel = new JLabel("• " + item);
                itemLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
                itemLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
                cartItemPanel.add(itemLabel);
            }
        }

        JScrollPane scrollPane = new JScrollPane(cartItemPanel);
        add(scrollPane, BorderLayout.CENTER);

        JButton nextButton = new JButton("결제 화면으로");
        nextButton.addActionListener(e -> frame.showPanel("Payment"));
        add(nextButton, BorderLayout.SOUTH);
    }
}
