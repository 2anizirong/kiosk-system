package manager;

import menu.DrinkMenu;
import menu.MainMenu;
import menu.Menu;
import menu.SideMenu;

public class DataManager {
    private final Menu[] mainMenus;
    private final Menu[] sideMenus;
    private final Menu[] drinkMenus;

    public DataManager() {
        mainMenus = new Menu[] {
                new MainMenu(1, "치즈버거", "Cheese Burger", "고소한 치즈와 패티", 5500),
                new MainMenu(2, "불고기버거", "Bulgogi Burger", "달콤한 불고기 소스", 6000),
                new MainMenu(3, "강정버거", "Gangjung Burger", "차승환의 강정버거", 2000)
        };

        sideMenus = new Menu[] {
                new SideMenu(4, "감자튀김", "Chips", "바삭한 프렌치프라이", 2500),
                new SideMenu(5, "치즈스틱", "Cheese Stick", "고소한 치즈 튀김", 3000)
        };

        drinkMenus = new Menu[] {
                new DrinkMenu(6, "콜라", "Coke", "시원한 탄산음료", 1500),
                new DrinkMenu(7, "사이다", "Soda", "청량한 탄산", 1500)
        };
    }

    public Menu[] getMainMenus() {
        return mainMenus;
    }

    public Menu[] getSideMenus() {
        return sideMenus;
    }

    public Menu[] getDrinkMenus() {
        return drinkMenus;
    }

    public Menu[] getMenuList() {
        int size = mainMenus.length + sideMenus.length + drinkMenus.length;
        Menu[] all = new Menu[size];
        int idx = 0;
        for (Menu m : mainMenus) all[idx++] = m;
        for (Menu m : sideMenus) all[idx++] = m;
        for (Menu m : drinkMenus) all[idx++] = m;
        return all;
    }

    public int getPrice(int menuId) {
        for (Menu menu : getMenuList()) {
            if (menu.getId() == menuId) {
                return menu.getPrice();
            }
        } 
        return -1; // ID가 없을 경우
    }
}
