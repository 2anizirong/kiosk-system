package view;

import javax.swing.*;
import java.awt.*;

public class CartPanel extends JPanel {
    public CartPanel(KioskFrame frame) {
        setLayout(new BorderLayout());

        JLabel label = new JLabel("🛒 장바구니 화면", SwingConstants.CENTER);
        label.setFont(new Font("SansSerif", Font.BOLD, 24));
        add(label, BorderLayout.CENTER);

        JButton nextButton = new JButton("결제 화면으로");
        nextButton.addActionListener(e -> frame.showPanel("Payment"));
        add(nextButton, BorderLayout.SOUTH);
    }
}
