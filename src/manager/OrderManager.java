package manager;

import cart.Cart;
import menu.Menu;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderManager {
    private static final AtomicInteger orderIdGenerator = new AtomicInteger(1);
    private static Map<Integer, OrderItem> currentOrders = new HashMap<>();
    private static Cart cart;

    public static void setCart(Cart sharedCart) {
        cart = sharedCart;
    }

    public static Cart getCart() {
        return cart;
    }

    // 주문 ID 생성
    public static int CreateOrderId() {
        return orderIdGenerator.getAndIncrement();
    }

    public static void clearOrders() {
        currentOrders.clear();
    }

    // 세트 여부와 함께 주문 저장
    public static void setSet(int orderId, Menu menu, boolean isSet) {
        OrderItem item = new OrderItem(menu.getId(), menu.getMenuName(), menu.getPrice(), isSet);
        currentOrders.put(orderId, item);
    }

    public static void setSide(int orderId, Menu sideMenu) {
        OrderItem item = currentOrders.get(orderId);
        if (item != null) {
            item.setSide(sideMenu.getMenuName(), sideMenu.getPrice());
        }
    }

    public static void setDrink(int orderId, Menu drinkMenu) {
        OrderItem item = currentOrders.get(orderId);
        if (item != null) {
            item.setDrink(drinkMenu.getMenuName(), drinkMenu.getPrice());
        }
    }

    // 주문을 장바구니에 추가
    public static void sendToCart() {
        for (OrderItem item : currentOrders.values()) {
            cart.addToCart(item);
        }
        currentOrders.clear(); // 주문 비우기
    }

    // 내부 OrderItem 클래스
    public static class OrderItem {
        private int menuId;
        public String name;
        private int price;
        private boolean isSet;

        private String sideName = null;
        private int sidePrice = 0;

        private String drinkName = null;
        private int drinkPrice = 0;

        public OrderItem(int menuId, String name, int price, boolean isSet) {
            this.menuId = menuId;
            this.name = name + (isSet ? " (세트)" : "");
            this.price = price;
            this.isSet = isSet;
        }

        public void setSide(String name, int price) {
            this.sideName = name;
            this.sidePrice = price;
        }

        public void setDrink(String name, int price) {
            this.drinkName = name;
            this.drinkPrice = price;
        }

        public int getPrice() {
            return price + sidePrice + drinkPrice;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder(name);
            if (sideName != null) sb.append(" + ").append(sideName);
            if (drinkName != null) sb.append(" + ").append(drinkName);
            sb.append(" = ").append(getPrice()).append("원");
            return sb.toString();
        }
    }
}
