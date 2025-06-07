package userPanelSystem;

import manager.DataManager;
import menu.Menu;

public class MenuDisplay {
    private final DataManager dataManager;

    public MenuDisplay() {
        this.dataManager = new DataManager();
    }
    // private Scanner scanner = new Scanner(System.in);

    // 2. requestMenuList
    public void requestMenuList() {
        Menu[] menuList = dataManager.getMenuList();
        showMenuList(menuList);
    }

    // 6. showMenuList
    public void showMenuList(Menu[] menuList) {
        for (Menu menu : menuList) {
            System.out.printf("[%d] %s - %s - %,d원%n",
                    menu.getId(),
                    menu.getMenuName(),
                    menu.getDescription(),
                    menu.getPrice()
            );
        }
        // requestMenuList();
    }
}