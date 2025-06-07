import payment.CardPayment;
import userPanelSystem.UserPanel;
import view.KioskFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        UserPanel userPanel = new UserPanel();

        userPanel.selectLanguage(); // 언어 선택
        UserPanel.selectOrder();    // 주문 및 결제 흐름

        System.out.println("햄버거 주문 키오스크입니다.");
        SwingUtilities.invokeLater(KioskFrame::new);
    }
}
