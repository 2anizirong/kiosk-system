import userPanelSystem.view.KioskFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("햄버거 주문 키오스크입니다.");
        SwingUtilities.invokeLater(KioskFrame::new);
    }
}