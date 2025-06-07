package userPanelSystem;

import payment.CardPayment;

import java.util.Scanner;

// 없어야 됨 지우기

public class Customer {
    private Language language;

    // 언어 선택 메서드
    public void selectLanguage() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("언어를 선택하세요 / Please select language");
        System.out.println("1. 한국어 (Korean)");
        System.out.println("2. English");
        System.out.print("선택 (1-2): ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                language = Language.KO;
                break;
            case 2:
                language = Language.EN;
                break;
            default:
                System.out.println("잘못된 선택입니다. 기본값(한국어)으로 설정합니다.");
                language = Language.KO;
        }
        System.out.println("선택된 언어: " + language);
    }

    public Language getLanguage() {
        return language;
    }

    // 1. selectOrder()
    public void selectOrder() {
        CardPayment cardPayment = new CardPayment();
        UserPanel customer = new UserPanel();

        System.out.println("=== 버거 키오스크 시작 ===");

        customer.selectOrder();

        // 총 가격 표시 후 결제로 이동
        int amount = 190; // 테스트 위해서 하드코딩
        // int amount = totalPrice(menuId);
        System.out.println("\n총 주문금액: " + amount);        // 추후 수정

        cardPayment.selectCardPayment(amount);
    }
}
