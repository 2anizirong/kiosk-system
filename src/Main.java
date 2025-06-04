import payment.CardPayment;
import userPanelSystem.Customer;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.selectLanguage(); // 언어 선택
        customer.selectOrder();    // 주문 및 결제 흐름
    }
}
