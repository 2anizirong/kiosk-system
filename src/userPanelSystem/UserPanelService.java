package userpanel;

import java.util.Scanner;

public class UserPanelService {
    private Scanner scanner = new Scanner(System.in);
    private MenuDisplay menuDisplay = new MenuDisplay();

    // 1. selectOrder
    public void selectOrder() {
        System.out.println("\n=== 주문 시작 ===");
        System.out.println("주문을 시작합니다.");
        menuDisplay.requestMenuList();
    }

    // 10. selectSides
    public void selectSides() {
        System.out.println("\n=== 사이드 메뉴 선택 ===");
        System.out.println("1. ");
        System.out.println("2. ");
        System.out.println("3. );
        System.out.print("사이드를 선택하세요 (1-3): ");

        int choice = scanner.nextInt();
        System.out.println("사이드가 선택되었습니다.");
    }

    // 17. selectDrinkMenu
    public void selectDrinkMenu() {
        System.out.println("\n=== 음료 메뉴 선택 ===");
        System.out.println("1. 콜라 - 2,000원");
        System.out.println("2. 사이다 - 2,000원");
        System.out.println("3. 오렌지주스 - 2,500원");
        System.out.print("음료를 선택하세요 (1-3): ");

        int choice = scanner.nextInt();
        System.out.println("음료가 선택되었습니다.");
    }
}
