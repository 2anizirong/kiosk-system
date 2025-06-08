package manager;

import userPanelSystem.Language;

public class LanguageManager {
    private static Language selectedLanguage = Language.KO; // 기본값

    public static void setLanguage(Language language) {
        selectedLanguage = language;
    }

    public static Language getLanguage() {
        return selectedLanguage;
    }
}
