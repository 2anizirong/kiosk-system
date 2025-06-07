package view;

import dataManager.DataManager;
import menu.Menu;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {
    public MenuPanel(KioskFrame frame, DataManager dataManager) {
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("🍔 메뉴 선택 화면", SwingConstants.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        // 메뉴 리스트 받아오기
        Menu[] menuList = dataManager.getMenuList();

        // 메뉴를 보여줄 패널
        JPanel menuListPanel = new JPanel();
        menuListPanel.setLayout(new BoxLayout(menuListPanel, BoxLayout.Y_AXIS));

        for (Menu menu : menuList) {
            String menuInfo = String.format("%s - %s - %,d원",
                    menu.getMenuName(),
                    menu.getDescription(),
                    menu.getPrice());

            JLabel menuLabel = new JLabel(menuInfo);
            menuLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
            menuLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
            menuListPanel.add(menuLabel);
        }

        JScrollPane scrollPane = new JScrollPane(menuListPanel);
        add(scrollPane, BorderLayout.CENTER);

        JButton nextButton = new JButton("장바구니로 이동");
        nextButton.addActionListener(e -> frame.showPanel("Cart"));
        add(nextButton, BorderLayout.SOUTH);
    }
}
