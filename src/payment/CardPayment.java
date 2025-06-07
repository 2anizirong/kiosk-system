package payment;

public class CardPayment {
    private static final PaymentService paymentService = new PaymentService();

    // 33. selectCardPayment()
    public static void selectCardPayment(int amount, String cardNumber, Runnable onSuccess, Runnable onFailure) {
        cardRecognition(amount, cardNumber, onSuccess, onFailure);
    }

    // 36. cardRecognition()
    public static void cardRecognition(int amount, String cardNumber, Runnable onSuccess, Runnable onFailure)
    {
        if (cardNumber != null && cardNumber.length() == 16) {
            paymentConfirmation(cardNumber, amount, onSuccess, onFailure);
        } else {
            System.out.println("잘못된 카드번호입니다.");
            if (onFailure != null) onFailure.run();
        }
    }

    // 37. paymentConfirmation()
    public static void paymentConfirmation(String cardNumber, int amount, Runnable onSuccess, Runnable onFailure) {
        System.out.println("결제 승인 중...");
        try {
            Thread.sleep(3000); // 3초 대기 (시뮬레이션)
            if (paymentService.paymentConfirmation(cardNumber, amount)) {
                paymentService.savePaymentHistory(cardNumber, amount);
                printReceipt();
                if (onSuccess != null) onSuccess.run();
            } else {
                System.out.println("카드 결제 실패!");
                if (onFailure != null) onFailure.run();
            }
        } catch (InterruptedException e) {
            System.out.println("결제 처리 중 오류가 발생했습니다.");
        }
    }

    // 39. printReceipt()
    public static void printReceipt() {
        System.out.println("[영수증 출력]");
    }
}

