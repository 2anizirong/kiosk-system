package menu;

import manager.LanguageManager;
import userPanelSystem.Language;

public class SideMenu implements Menu {
    private final int id;
    private final String SideMenuNameKo;
    private final String SideMenuNameEn;
    private final String description;
    private final int price;

    public SideMenu(int id, String menuNameKo, String menuNameEn, String description, int price) {
        this.id = id;
        this.SideMenuNameKo = menuNameKo;
        this.SideMenuNameEn = menuNameEn;
        this.description = description;
        this.price = price;
    }

    public int getId() { return id; }

    public String getMenuName() {
        Language lang = LanguageManager.getLanguage();
        return (lang == Language.EN) ? SideMenuNameEn : SideMenuNameKo;
    }

    public String getDescription() { return description; }

    public int getPrice() { return price; }
}
