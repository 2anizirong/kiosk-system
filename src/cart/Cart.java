package cart;

import java.util.ArrayList;
import java.util.List;
import menu.Menu; // Item 클래스가 menu 패키지에 있다고 가정

public class Cart {
    private List<Menu> cartItems = new ArrayList<Menu>();

    public Cart() {
    }

    void addToCart(Menu menu){
        cartItems.add(menu);
        System.out.println(menu.getName() + " 이(가) 장바구니에 추가되었습니다.");
    }

    int returnTotalPrice() {
        int total = 0;
        for (Menu item : cartItems) {
            total += item.getPrice();
        }
        return total;
    }

    public List<Menu> returnCartItemList(){
            return new ArrayList<>(cartItems);
    }
}
