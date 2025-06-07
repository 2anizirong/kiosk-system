package payment;

public class CardPayment {
    private static final PaymentService paymentService = new PaymentService();

    // 33. selectCardPayment()
    public static boolean selectCardPayment(int amount, String cardNumber) {
        if (!cardRecognition(cardNumber)) {
            return false;
        }
        return paymentConfirmation(cardNumber, amount);
    }

    // 36. cardRecognition()
    public static boolean cardRecognition(String cardNumber)
    {
        // 카드 번호 오류
        return cardNumber != null && cardNumber.length() == 16;
    }

    // 37. paymentConfirmation()
    public static boolean paymentConfirmation(String cardNumber, int amount) {
        try {
            Thread.sleep(3000); // 3초 대기 (시뮬레이션)
            if (paymentService.paymentConfirmation(cardNumber, amount)) {
                paymentService.savePaymentHistory(cardNumber, amount);
                printReceipt();
                return true;
            } else {
                System.err.println("카드 결제 실패!");
                return false;
            }
        } catch (InterruptedException e) {
            System.err.println("결제 처리 중 오류가 발생했습니다.");
            return false;
        }
    }

    // 39. printReceipt()
    public static void printReceipt() {
        System.out.println("[영수증 출력]");
    }
}

