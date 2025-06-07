package view;

import manager.DataManager;
import manager.OrderManager;
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
            String buttonText = String.format("%s - %s - %,d원",
                    menu.getMenuName(),
                    menu.getDescription(),
                    menu.getPrice());

            JButton menuButton = new JButton(buttonText);
            menuButton.setFont(new Font("SansSerif", Font.PLAIN, 16));
            menuButton.setAlignmentX(Component.LEFT_ALIGNMENT);
            menuButton.addActionListener(e -> {
                int result = JOptionPane.showConfirmDialog(
                        this,
                        menu.getMenuName() + " 세트를 선택하시겠습니까?",
                        "세트 선택",
                        JOptionPane.YES_NO_OPTION
                );

                int orderID = OrderManager.CreateOrderId();

                if (result == JOptionPane.YES_OPTION) {
                    OrderManager.setSet(orderID, menu, true);

                    // 사이드 메뉴 선택
                    Menu side = selectFromOptions("사이드 메뉴를 선택하세요", dataManager.getSideMenus());
                    if (side != null) {
                        OrderManager.setSide(orderID, side);
                    }

                    // 드링크 메뉴 선택
                    Menu drink = selectFromOptions("드링크 메뉴를 선택하세요", dataManager.getDrinkMenus());
                    if (drink != null) {
                        OrderManager.setDrink(orderID, drink);
                    }

                } else {
                    OrderManager.setSet(orderID, menu, false);
                }

                OrderManager.sendToCart();
            });

            menuListPanel.add(menuButton);
            menuListPanel.add(Box.createRigidArea(new Dimension(0, 10))); // 간격

        }

        JScrollPane scrollPane = new JScrollPane(menuListPanel);
        add(scrollPane, BorderLayout.CENTER);

        JButton nextButton = new JButton("장바구니로 이동");
        nextButton.addActionListener(e -> frame.showPanel("Cart"));
        add(nextButton, BorderLayout.SOUTH);
    }

    private Menu selectFromOptions(String message, Menu[] options) {
        String[] names = new String[options.length];
        for (int i = 0; i < options.length; i++) {
            names[i] = String.format("%s - %s (%d원)", options[i].getMenuName(), options[i].getDescription(), options[i].getPrice());
        }

        String selected = (String) JOptionPane.showInputDialog(
                this,
                message,
                "메뉴 선택",
                JOptionPane.PLAIN_MESSAGE,
                null,
                names,
                names[0]
        );

        if (selected == null) return null;

        for (Menu menu : options) {
            if (selected.contains(menu.getMenuName())) {
                return menu;
            }
        }
        return null;
    }

}
