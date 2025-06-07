package menu;

public class DrinkMenu implements Menu {
    private int id;
    private String menuName;
    private String description;
    private int price;

    public DrinkMenu(int id, String menuName, String description, int price) {
        this.id = id;
        this.menuName = menuName;
        this.description = description;
        this.price = price;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getMenuName() { return menuName; }
    public void setMenuName(String menuName) { this.menuName = menuName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }
}
