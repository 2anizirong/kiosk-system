package menu;

public interface Menu {
    int getId();
    String getMenuName();
    String getDescription();
    int getPrice();

    void setId(int id);
    void setMenuName(String name);
    void setDescription(String description);
    void setPrice(int price);
}
