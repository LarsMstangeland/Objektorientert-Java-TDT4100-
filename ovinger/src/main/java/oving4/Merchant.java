package oving4;

import java.util.ArrayList;
import java.util.List;

public class Merchant {

    private double balance;
    private List<Item> inventar = new ArrayList<Item>();

    public Merchant(double balance) {
        if (!ValidBalance(balance)) {

            throw new IllegalArgumentException("ugyldig balance å starte med (negativ == fyfy!)");
        }
        this.balance = balance;

    }

    private boolean ValidBalance(double balance) {
        return balance > 0;
    }

    public void obtainItem(Item item) {

        this.inventar.add(item);
        item.changeOwner(this);

    }

    public void removeItem(Item item) {
        this.inventar.remove(item);
    }

    public double getBalance() {
        return this.balance;
    }

    public void sellItem(Item item, Merchant merchant) {

        if (merchant.getBalance() < item.getPrice()) {
            throw new IllegalArgumentException("kan ikke utføre transaksjon, kjøper har ikke nok peng!");
        }

        if (!this.inventar.contains(item)) {
            throw new IllegalArgumentException("kan ikke utføre transaksjon, selger har ikke varen!");
        }
        if (merchant.equals(this)) {
            throw new IllegalArgumentException("kan ikke selge vare til seg selv");
        }

        this.removeItem(item);
        this.balance += item.getPrice();
        merchant.balance -= item.getPrice();
        merchant.obtainItem(item);

    }

    public void itemSale(double sale, Item item) {

        if (!this.inventar.contains(item)) {
            throw new IllegalArgumentException("kan ikke starte salg på noe du ikke eier!");
        }

        if (!(1 > sale && sale > 0)) {
            throw new IllegalArgumentException("ugyldig salg på gang!");
        }

        item.setPrice(item.getPrice() - item.getPrice() * sale);

    }

    public void inventorySale(double sale) {

        for (Item item : inventar) {
            itemSale(sale, item);
        }
    }

    public List<Item> getInventory() {
        return this.inventar;
    }

}
