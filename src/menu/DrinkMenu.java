package menu;

import manager.LanguageManager;
import userPanelSystem.Language;

public class DrinkMenu implements Menu {
    private final int id;
    private final String menuNameKo;
    private final String menuNameEn;
    private final String description;
    private final int price;

    public DrinkMenu(int id, String menuNameKo, String menuNameEn, String description, int price) {
        this.id = id;
        this.menuNameKo = menuNameKo;
        this.menuNameEn = menuNameEn;
        this.description = description;
        this.price = price;
    }

    public int getId() { return id; }

    public String getMenuName() {
        Language lang = LanguageManager.getLanguage();
        return (lang == Language.EN) ? menuNameEn : menuNameKo;
    }

    public String getDescription() { return description; }

    public int getPrice() { return price; }
}
