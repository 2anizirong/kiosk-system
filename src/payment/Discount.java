package payment;

import java.util.Scanner;

public class Discount {
    private Scanner scanner = new Scanner(System.in);

     public int selectDiscount() {
        System.out.println("[0] 할인 여부를 선택하세요.");
        System.out.println("1. 쿠폰 할인");
        System.out.println("2. 통신사 할인");
        System.out.println("3. 할인 없이 결제");
        System.out.print("선택 (1-3): ");
        int choice = scanner.nextInt();
        while (choice < 1 || choice > 3) {
            System.out.print("잘못된 선택입니다. 다시 입력하세요 (1-3): ");
            choice = scanner.nextInt();
        }
        return choice;
    }
    
    public void discountPayment(int amount) {
        int discountChoice = selectDiscount();

        switch (discountChoice) {
            case 1:
                System.out.println("쿠폰 할인이 적용됩니다.");
                System.out.print("쿠폰 코드를 입력하세요: ");
                String coupon = scanner.next();
                
                // COUPON-10p: 토탈 가격에서 10% 할인
                if (coupon.equals("COUPON-10p")) {
                    amount = amount - (amount * 10 / 100);
                    System.out.println("10% 쿠폰이 적용되었습니다. 결제 금액: " + amount + "원");
                } 
                // COUPON-2000w: 토탈 가격에서 2000원 할인
                else if (coupon.equals("COUPON-2000w")) {
                    amount = Math.max(0, amount - 2000);
                    System.out.println("2000원 쿠폰이 적용되었습니다. 결제 금액: " + amount + "원");
                } else {
                    System.out.println("유효하지 않은 쿠폰입니다. 할인 없이 결제합니다.");
                }
                break;
            case 2:
                System.out.println("통신사 할인이 적용됩니다.");
                System.out.println("통신사를 선택하세요:");
                System.out.println("1. SKT");
                System.out.println("2. KT");
                System.out.println("3. U+");
                System.out.print("선택 (1-3): ");
                int telecomChoice = scanner.nextInt();
                while (telecomChoice < 1 || telecomChoice > 3) {
                    System.out.print("잘못된 선택입니다. 다시 입력하세요 (1-3): ");
                    telecomChoice = scanner.nextInt();
                }
                
                // SKT 만 5% 할인 해주는 걸로 가정
                if (telecomChoice == 1) {
                    amount = amount - (amount * 5 / 100);
                    System.out.println("SKT 5% 통신사 할인이 적용되었습니다. 결제 금액: " + amount + "원");
                } else {
                    System.out.println((telecomChoice == 2 ? "KT" : "U+") + "는 통신사 할인 대상이 아닙니다.");
                    System.out.println("할인 없이 결제 금액: " + amount + "원");
                }
                break;
            case 3:
                System.out.println("할인 없이 결제합니다.");
                break;
        }
        payment.CardPayment.selectCardPayment(amount);
    }
}