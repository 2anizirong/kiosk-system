package userPanelSystem;

import java.util.Scanner;

public class UserPanel {
    private MenuDisplay menuDisplay = new MenuDisplay();



    // 1. selectOrder
    public void selectOrder() {
        System.out.println("\n=== 주문 시작 ===");
        System.out.println("주문을 시작합니다.");
        menuDisplay.requestMenuList();
    }
}