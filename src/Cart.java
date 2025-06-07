import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Item> cartItems = new ArrayList<Item>();

    public Cart() {
    }

    void addToCart(Item item){
        cartItems.add(item);
        System.out.println(item.getName() + " 이(가) 장바구니에 추가되었습니다.");
    }

    int returnTotalPrice() {
        int total = 0;
        for (Item item : cartItems) {
            total += item.getPrice();
        }
        return total;
    }

    List<Item> returnCartItemList(){
            return new ArrayList<>(cartItems);
    }
}
