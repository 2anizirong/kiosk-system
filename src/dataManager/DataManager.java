package dataManager;

import menu.Menu;

public class DataManager {
    private Menu[] menuList;

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
