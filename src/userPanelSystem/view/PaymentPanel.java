package userPanelSystem.view;

import cart.Cart;
import payment.CardPayment;
import payment.Discount;

import javax.swing.*;
import java.awt.*;

public class PaymentPanel extends JPanel {
    private int totalAmount;
    private JComboBox<String> discountBox;
    private JLabel amountLabel;

    public PaymentPanel(KioskFrame frame, Cart cart) {
        setLayout(new BorderLayout());

        // 제목
        JLabel label = new JLabel("결제 화면", SwingConstants.CENTER);
        label.setFont(new Font("SansSerif", Font.BOLD, 24));
        add(label, BorderLayout.NORTH);

        totalAmount = cart.returnTotalPrice();

        // 중앙 패널: 할인 선택 + 금액
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // 할인 선택
        JLabel discountLabel = new JLabel("할인 선택:");
        discountLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));

        String[] discountOptions = {
                "할인 없음",
                "10% 쿠폰 (COUPON-10p)",
                "2000원 쿠폰 (COUPON-2000w)",
                "SKT 통신사 할인"
        };

        discountBox = new JComboBox<>(discountOptions);
        discountBox.setMaximumSize(new Dimension(300, 25));
        discountBox.addActionListener(e -> updateAmountLabel());

        // 결제 금액
        amountLabel = new JLabel();
        amountLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        updateAmountLabel();

        // 중앙에 요소 추가
        centerPanel.add(discountLabel);
        centerPanel.add(Box.createVerticalStrut(5));
        centerPanel.add(discountBox);
        centerPanel.add(Box.createVerticalStrut(20));
        centerPanel.add(amountLabel);

        add(centerPanel, BorderLayout.CENTER);

        // 버튼 패널
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        // 결제 버튼
        JButton nextButton = new JButton("카드로 결제");
        nextButton.addActionListener(e -> handlePayment(frame));
        buttonPanel.add(nextButton);

        // 돌아가기 버튼
        JButton backButton = new JButton("돌아가기");
        backButton.addActionListener(e -> frame.showPanel("Menu"));
        buttonPanel.add(backButton);

        // 버튼 패널을 SOUTH에 추가
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void updateAmountLabel() {
        Discount.Type type = getSelectedDiscountType();
        int discounted = Discount.discountPayment(totalAmount, type);
        amountLabel.setText("총 결제 금액: " + discounted + "원");
    }

    private Discount.Type getSelectedDiscountType() {
        int selected = discountBox.getSelectedIndex();
        return switch (selected) {
            case 1 -> Discount.Type.COUPON_10P;
            case 2 -> Discount.Type.COUPON_2000W;
            case 3 -> Discount.Type.SKT;
            default -> Discount.Type.NONE;
        };
    }

    private void handlePayment(KioskFrame frame) {
        int finalAmount = Discount.discountPayment(totalAmount, getSelectedDiscountType());

        String cardNumber = JOptionPane.showInputDialog(this, "카드 번호를 입력하세요 (16자리)");

        if (cardNumber == null) return;

        if (!CardPayment.cardRecognition(cardNumber)) {
            JOptionPane.showMessageDialog(this, "잘못된 카드번호입니다.");
            return;
        }

        boolean success = CardPayment.selectCardPayment(finalAmount, cardNumber);
        if (success) {
            JOptionPane.showMessageDialog(this, "결제가 완료되었습니다.");
            frame.showPanel("Result");
        } else {
            JOptionPane.showMessageDialog(this, "결제 실패! 다시 시도해주세요.");
        }
    }

}
