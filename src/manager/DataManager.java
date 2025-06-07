package manager;

import menu.Menu;
import menu.MenuItem;

public class DataManager {
    private Menu[] menuList;

    public DataManager() {
        menuList = new Menu[]{
                new MenuItem(1, "치즈버거", "고소한 치즈와 패티", 5500),
                new MenuItem(2, "불고기버거", "달콤한 불고기 소스", 6000),
                new MenuItem(3, "감자튀김", "바삭한 프렌치프라이", 2500)
        };
    }

    public Menu[] getMenuList() {
        return menuList;
    }

    public int getPrice(int menuId) {
        for (Menu menu : menuList) {
            if (menu.getId() == menuId) {
                return menu.getPrice();
            }
        }
        return -1; // ID가 없을 경우
    }
}
