package view;

import cart.Cart;
import payment.CardPayment;
import payment.Discount;

import javax.swing.*;
import java.awt.*;

public class PaymentPanel extends JPanel {
    public PaymentPanel(KioskFrame frame, Cart cart) {
        setLayout(new BorderLayout());

        JLabel label = new JLabel("\uD83D\uDCB3 \uACB0\uC81C \uD654\uBA74", SwingConstants.CENTER);
        label.setFont(new Font("SansSerif", Font.BOLD, 24));
        add(label, BorderLayout.NORTH);

        int totalAmount = cart.returnTotalPrice();

        // 1. 할인 선택
        String[] discountOptions = {"할인 없음", "10% 쿠폰 (COUPON-10p)", "2000원 쿠폰 (COUPON-2000w)", "SKT 통신사 할인"};
        int discountChoice = JOptionPane.showOptionDialog(
                this,
                "할인 옵션을 선택하세요:",
                "할인 선택",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                discountOptions,
                discountOptions[0]
        );

        Discount.Type discountType = switch (discountChoice) {
            case 1 -> Discount.Type.COUPON_10P;
            case 2 -> Discount.Type.COUPON_2000W;
            case 3 -> Discount.Type.SKT;
            default -> Discount.Type.NONE;
        };

        int discountedAmount = Discount.discountPayment(totalAmount, discountType);

        JLabel amountLabel = new JLabel("총 결제 금액: " + discountedAmount + "원", SwingConstants.CENTER);
        amountLabel.setFont(new Font("SansSerif", Font.PLAIN, 20));
        add(amountLabel, BorderLayout.CENTER);

        JButton nextButton = new JButton("카드로 결제");
        nextButton.addActionListener(e -> {
            String cardNumber = JOptionPane.showInputDialog(this, "카드 번호를 입력하세요 (16자리)");

            if (cardNumber == null) return; // 취소 버튼 눌렀을 경우
            if (cardNumber.length() != 16) {
                JOptionPane.showMessageDialog(this, "❌ 잘못된 카드번호입니다.");
                return;
            }

            // 결제 진행 (CardPayment 내부 로직 호출)
            CardPayment.selectCardPayment(
                    discountedAmount,
                    cardNumber,
                    () -> {
                        JOptionPane.showMessageDialog(this, "✅ 결제가 완료되었습니다.");
                        frame.showPanel("Result");
                    },
                    () -> {
                        JOptionPane.showMessageDialog(this, "❌ 결제 실패! 다시 시도해주세요.");
                    }
            );
        });

        add(nextButton, BorderLayout.SOUTH);
    }
}