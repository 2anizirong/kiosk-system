package userPanelSystem;

import manager.DataManager;
import menu.Menu;

public class MenuDisplay {
    private final DataManager dataManager;

    public MenuDisplay(DataManager dataManager) {
        this.dataManager = dataManager;
    }
    // private Scanner scanner = new Scanner(System.in);

    // 2. requestMenuList
    public void requestMenuList() {
        System.out.println("\n=== 메뉴 요청 ===");
        System.out.println("메뉴 리스트를 요청합니다...");
        Menu[] menuList = dataManager.getMenuList();
        showMenuList(menuList);
    }

    // 6. showMenuList
    public void showMenuList(Menu[] menuList) {
        System.out.println("\n=== 메뉴 리스트 ===");
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