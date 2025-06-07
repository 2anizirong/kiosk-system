package view;

import javax.swing.*;
import java.awt.*;

public class ResultPanel extends JPanel {
    public ResultPanel(KioskFrame frame) {
        setLayout(new BorderLayout());

        JLabel label = new JLabel("✅ 주문 완료!", SwingConstants.CENTER);
        label.setFont(new Font("SansSerif", Font.BOLD, 24));
        add(label, BorderLayout.CENTER);

        JButton homeButton = new JButton("메인으로 돌아가기");
        homeButton.addActionListener(e -> frame.showPanel("Menu"));
        add(homeButton, BorderLayout.SOUTH);
    }
}
