package userPanelSystem.view;

import manager.DataManager;
import manager.LanguageManager;
import manager.OrderManager;
import userPanelSystem.Language;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.xml.crypto.Data;

public class StartPanel extends JPanel {
    private Image backgroundImage;

    public StartPanel(KioskFrame frame) {
        setLayout(new BorderLayout());

        try {
            backgroundImage = ImageIO.read(new File("src/userPanelSystem/view/start.png"));
        } catch (IOException e) {
            System.err.println("배경 이미지 로드 실패: " + e.getMessage());
        }

        // 언어 선택 콤보박스
        String[] languageOptions = {"한국어", "English"};
        JComboBox<String> languageBox = new JComboBox<>(languageOptions);
        languageBox.setFont(new Font("SansSerif", Font.PLAIN, 14));
        languageBox.setPreferredSize(new Dimension(140, 30)); // 크기 설정

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 20));
        topPanel.setOpaque(false);
        topPanel.add(languageBox);
        add(topPanel, BorderLayout.NORTH);

        languageBox.addActionListener(e -> {
            int selectedIndex = languageBox.getSelectedIndex();
            LanguageManager.setLanguage(selectedIndex == 0 ? Language.KO : Language.EN);
        });

        // 시작하기 버튼
        JButton startButton = new JButton("시작하기");
        startButton.setFont(new Font("SansSerif", Font.BOLD, 24));
        startButton.setPreferredSize(new Dimension(595, 100));
        DataManager dataManager = new DataManager();
        startButton.addActionListener(e ->
                frame.refreshCartPanel(() -> new MenuPanel(frame, dataManager), "Menu")
        );

        JPanel bottomPanel = new JPanel();
        bottomPanel.setOpaque(false);
        bottomPanel.add(startButton);

        add(bottomPanel, BorderLayout.SOUTH);
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
