package menu;

import manager.LanguageManager;
import userPanelSystem.Language;

public class DrinkMenu implements Menu {
    private final int id;
    private final String DrinkMenuNameKo;
    private final String DrinkMenuNameEn;
    private final String description;
    private final int price;

    public DrinkMenu(int id, String menuNameKo, String menuNameEn, String description, int price) {
        this.id = id;
        this.DrinkMenuNameKo = menuNameKo;
        this.DrinkMenuNameEn = menuNameEn;
        this.description = description;
        this.price = price;
    }

    public int getId() { return id; }

    public String getMenuName() {
        Language lang = LanguageManager.getLanguage();
        return (lang == Language.EN) ? DrinkMenuNameEn : DrinkMenuNameKo;
    }

    public String getDescription() { return description; }

    public int getPrice() { return price; }
}
