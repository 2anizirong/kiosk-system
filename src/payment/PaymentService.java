package payment;

public class PaymentService {

    // 결제 승인 처리
    public boolean paymentConfirmation(String cardNumber, int amount) {
        // 실제 카드 결제 승인 로직이 들어갈 부분
        if (cardNumber.length() == 16 && amount > 0) {
            System.out.println("[PaymentService] 결제 승인 완료");
            return true;
        } else {
            System.out.println("[PaymentService] 결제 승인 실패");
            return false;
        }
    }

    // 결제 내역 저장 (예시)
    public void savePaymentHistory(String cardNumber, int amount) {
        System.out.println("[PaymentService] 결제 내역 저장: 카드 " + cardNumber + ", 금액 " + amount + "원");
    }
}
