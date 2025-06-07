package payment;

public class Discount {
    // 할인 타입 상수
    public enum Type { NONE, COUPON_10P, COUPON_2000W, SKT }

    public static int discountPayment(int amount, Type type) {
        return switch (type) {
            case COUPON_10P -> amount - (amount * 10 / 100);
            case COUPON_2000W -> Math.max(0, amount - 2000);
            case SKT -> amount - (amount * 5 / 100);
            default -> amount;
        };
    }
}