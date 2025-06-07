package view;

import cart.Cart;

import javax.swing.*;
import java.awt.*;

public class PaymentPanel extends JPanel {
    public PaymentPanel(KioskFrame frame, Cart cart) {
        setLayout(new BorderLayout());

        JLabel label = new JLabel("결제", SwingConstants.CENTER);
        label.setFont(new Font("SansSerif", Font.BOLD, 24));
        add(label, BorderLayout.CENTER);

        JButton nextButton = new JButton("결제 완료");
        nextButton.addActionListener(e -> frame.showPanel("Result"));
        add(nextButton, BorderLayout.SOUTH);
    }
}
