package oving4;

public class Item {

    private String Name;
    private String Type;
    private double price;
    private Merchant eier;

    public Item(String name, String type, double price) {

        if (ValidType(type) && ValidName(name) && ValidPrice(price)) {

            this.Name = name;
            this.Type = type;
            this.price = price;

        } else {
            throw new IllegalArgumentException("The type, name or balance is not valid");

        }
    }

    private boolean ValidType(String type) {
        return type == "Weapon" || type == "Armour" || type == "Valuable" || type == "Potion";
    }

    private boolean ValidName(String name) {
        return !name.isEmpty();
    }

    private boolean ValidPrice(double price) {
        return price > 0;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (!ValidPrice(price)) {
            throw new IllegalArgumentException("Kan ikke sette negativ pris");
        }
        this.price = price;

    }

    public Merchant getOwner() {
        return eier;
    }

    public void changeOwner(Merchant eier) {
        this.eier = eier;
    }

    public String getName() {
        return Name;
    }

    public String getType() {
        return Type;
    }

    @Override
    public String toString() {
        return "Item [Name=" + Name + ", Type=" + Type + ", price=" + price + ", eier=" + eier + "]";
    }

}
