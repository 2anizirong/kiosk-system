package view;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {
    public MenuPanel(KioskFrame frame) {
        setLayout(new BorderLayout());

        JLabel label = new JLabel("🍔 메뉴 선택 화면", SwingConstants.CENTER);
        label.setFont(new Font("SansSerif", Font.BOLD, 24));
        add(label, BorderLayout.CENTER);

        JButton nextButton = new JButton("장바구니로 이동");
        nextButton.addActionListener(e -> frame.showPanel("Cart"));
        add(nextButton, BorderLayout.SOUTH);
    }
}
