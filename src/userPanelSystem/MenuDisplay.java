package userpanel;

import payment.PaymentController;

import java.util.Scanner;

public class MenuDisplay {
    private Scanner scanner = new Scanner(System.in);

    // 2. requestMenuList
    public void requestMenuList() {
        System.out.println("\n=== 메뉴 요청 ===");
        System.out.println("메뉴 리스트를 요청합니다...");
        showMenuList();
    }

    // 5. menuList (화면에 메뉴 표시)
    void showMenuList() {
        System.out.println("\n=== 메인 메뉴 ===");
        System.out.println("1. 햄버거 - 3000원");
        System.out.println("2. 치즈버거 - 4000원");
        System.out.println("3. 치킨버거 - 5000원");
        System.out.print("메뉴를 선택하세요 (1-3): ");

        int choice = scanner.nextInt();
        System.out.println("메뉴가 선택되었습니다.");

        // 세트 선택 여부 묻기
        System.out.print("세트를 선택하시겠습니까? (y/n): ");
        String setChoice = scanner.next();

        if (setChoice.equalsIgnoreCase("y")) {
            selectSet();
        } else {
            // 세트 선택 안 하면 바로 결제로 이동
            System.out.println("세트 선택 없이 결제로 이동합니다.");
            PaymentController paymentController = new PaymentController();
            paymentController.selectCardPayment();
        }
    }

    // 세트 선택 메서드
    void selectSet() {
        System.out.println("세트가 선택되었습니다! (예시)");
        // 여기서 세트 구성 선택 로직 추가 가능
        // 세트 선택 후 사이드로 이동
        UserPanelService userService = new UserPanelService();
        userService.selectSides();
    }
}