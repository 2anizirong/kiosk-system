package userpanel;

import payment.PaymentController;

public class UserInterface {
    private UserPanelService userService = new UserPanelService();
    private PaymentController paymentController = new PaymentController();
    private MenuDisplay menuDisplay = new MenuDisplay();

    public void startKiosk() {
        System.out.println("=== 버거 키오스크 시작 ===");

        // 주문 시작
        userService.selectOrder();

        // 음료 선택
        userService.selectDrinkMenu();

        // 총 가격 표시 후 결제로 이동
        System.out.println("\n총 주문금액: 15,000원");
        paymentController.selectCardPayment();
    }
}
