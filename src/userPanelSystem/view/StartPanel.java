package userPanelSystem.view;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class StartPanel extends JPanel {
    private Image backgroundImage;

    public StartPanel(KioskFrame frame) {
        try {
            backgroundImage = ImageIO.read(new File("src/userPanelSystem/view/start.png"));
        } catch (IOException e) {
            System.err.println("배경 이미지 로드 실패: " + e.getMessage());
        }

        setLayout(null);

        // 투명한 패널 위에 버튼 배치
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);

        JButton startButton = new JButton("시작하기");
        startButton.setFont(new Font("SansSerif", Font.BOLD, 24));
        startButton.setBounds(39, 318, 510, 100);
        add(startButton);
        startButton.addActionListener(e -> frame.showPanel("Menu"));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            // 이미지 크기에 맞춰 전체 화면에 그리기
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
