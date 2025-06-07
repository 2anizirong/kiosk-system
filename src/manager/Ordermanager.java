package manager;

import menu.Menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Ordermanager {
    private static AtomicInteger orderIdGenerator = new AtomicInteger(1);
    private static Map<Integer, OrderItem> currentOrders = new HashMap<>();

    // 주문 ID 생성
    public static int CreateOrderId() {
        return orderIdGenerator.getAndIncrement();
    }

    // 세트 여부와 함께 주문 저장
    public static void setSet(int orderId, Menu menu, boolean isSet) {
        OrderItem item = new OrderItem(menu.getId(), menu.getMenuName(), menu.getPrice(), isSet);
        currentOrders.put(orderId, item);
    }

    // 주문을 장바구니에 추가
    public static void sendToCart(Cart cartManager) {
        for (OrderItem item : currentOrders.values()) {
            cartManager.addToCart(item.toItem());
        }
        currentOrders.clear(); // 주문 비우기
    }

    // 내부 OrderItem 클래스
    private static class OrderItem {
        private int menuId;
        private String name;
        private int price;
        private boolean isSet;

        public OrderItem(int menuId, String name, int price, boolean isSet) {
            this.menuId = menuId;
            this.name = name + (isSet ? " (세트)" : "");
            this.price = price;
            this.isSet = isSet;
        }
    }
}
