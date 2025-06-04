package payment;

import java.util.Scanner;

public class CardPayment {
    private static Scanner scanner = new Scanner(System.in);
    private static PaymentService paymentService = new PaymentService();

    // 33. selectCardPayment()
    public static void selectCardPayment(int amount) {
        System.out.println("[1] 카드 결제가 선택되었습니다.");
        confirmCardPayment(amount);
    }

    // 34. confirmCardPayment()
    public static void confirmCardPayment(int amount) {
        System.out.print("[2] 카드 결제를 진행하시겠습니까? (y/n): ");
        String confirm = scanner.next();
        if (confirm.equalsIgnoreCase("y")) {
            cardRecognition(amount);
        } else {
            System.out.println("결제가 취소되었습니다.");
        }
    }

    // 36. cardRecognition()
    public static void cardRecognition(int amount) {
        System.out.print("[3] 카드번호 입력 (16자리): ");
        String cardNumber = scanner.next();

        if (cardNumber.length() == 16) {
            System.out.println("카드가 인식되었습니다.");
            paymentConfirmation(cardNumber, amount);
        } else {
            System.out.println("잘못된 카드번호입니다. 다시 시도해주세요.");
            cardRecognition(amount);
        }
    }

    // 37. paymentConfirmation()
    public static void paymentConfirmation(String cardNumber, int amount) {
        System.out.println("결제 승인 중...");
        try {
            Thread.sleep(3000); // 결제 승인 시간 3초 정도 슬립
            if (paymentService.paymentConfirmation(cardNumber, amount)) {
                paymentService.savePaymentHistory(cardNumber, amount);
                printReceipt();
            } else {
                System.out.println("카드 결제 실패! 다시 시도해주세요.");
            }
        } catch (InterruptedException e) {
            System.out.println("결제 처리 중 오류가 발생했습니다.");
        }
    }

    // 39. printReceipt()
    public static void printReceipt() {
        System.out.println("[5] 영수증을 출력합니다.");
    }
}

