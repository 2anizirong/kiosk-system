package cart;

import java.util.ArrayList;
import java.util.List;
import manager.OrderManager.OrderItem;

public class Cart {
    private final List<OrderItem > cartItems = new ArrayList<>();

    public Cart() {
    }

    public void addToCart(OrderItem item){
        cartItems.add(item);
        System.out.println(item.name + " 이(가) 장바구니에 추가되었습니다.");
    }

    public int returnTotalPrice() {
        int total = 0;
        for (OrderItem  item : cartItems) {
            total += item.getPrice();
        }
        return total;
    }

    public List<OrderItem> returnCartItemList() {
        return new ArrayList<>(cartItems); // 깊은 복사
    }
}
