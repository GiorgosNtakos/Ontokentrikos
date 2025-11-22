import java.util.*;

public class EShop {
    private String name;
    private Owner owner;
    private List<Item> itemsList = new ArrayList<>();
    private List<Buyer> buyersList = new ArrayList<>();

    public EShop(String name, Owner owner) {
        this.name = name;
        this.owner = owner;
    }

    // getters
    public String getName() { return name; }
    public Owner getOwner() { return owner; }
    public List<Item> getItemsList() { return itemsList; }
    public List<Buyer> getBuyersList() { return buyersList; }

    public void addItem(Item item) {
    for (Item it : itemsList) {
        if (it.getID() == item.getID()) {
            throw new DuplicateItemIDException();
        }
    }
    itemsList.add(item);
}

    public void removeItem(Item item) {
        if (!itemsList.remove(item)) {
            throw new IllegalArgumentException("Item does not exist.");
        }
    }

    public void addBuyer(Buyer buyer) {
    for (Buyer b : buyersList) {
        if (b.getEmail().equals(buyer.getEmail())) {
            throw new DuplicateBuyerEmailException();
        }
    }
    buyersList.add(buyer);
}

    public void removeBuyer(Buyer buyer) {
        if (!buyersList.remove(buyer)) {
            throw new IllegalArgumentException("Buyer does not exist.");
        }
    }

    public Item getItemById(int id) {
        for (Item item : itemsList) {
            if (item.getID() == id) return item;
        }
        throw new WrongID();
    }

    public void updateItemStock(Item item, int stock) {
        if (stock < 0) throw new NegativeStock("Negative stock not allowed");
        item.setStock(stock);
    }

    public void showCategories() {
        int pen=0, pencil=0, notebook=0, paper=0;
        for (Item it : itemsList) {
            if (it instanceof Pen) pen++;
            else if (it instanceof Pencil) pencil++;
            else if (it instanceof Notebook) notebook++;
            else if (it instanceof Paper) paper++;
        }
        System.out.println("Categories:\n1.Pen(" + pen + ")\n2.Pencil(" + pencil +
                ")\n3.Notebook(" + notebook + ")\n4.Paper(" + paper + ")");
    }

    // Επιστρέφει λίστα items κατηγορίας για να χειριστούμε επιλογή με index.
    public List<Item> showProductsInCategory(String category) {
        List<Item> res = new ArrayList<>();
        for (Item it : itemsList) {
            if (category.equalsIgnoreCase("Pen") && it instanceof Pen) res.add(it);
            else if (category.equalsIgnoreCase("Pencil") && it instanceof Pencil) res.add(it);
            else if (category.equalsIgnoreCase("Notebook") && it instanceof Notebook) res.add(it);
            else if (category.equalsIgnoreCase("Paper") && it instanceof Paper) res.add(it);
        }
        if (res.isEmpty()) {
            System.out.println("Could not find that category or category is empty.");
        }
        // ωραία εκτύπωση 1..Ν
        for (int i = 0; i < res.size(); i++) {
            Item it = res.get(i);
            System.out.println((i + 1) + ". " + it.getName() + " (" + it.getID() + ")");
        }
        return res;
    }

    public void showProduct(int id) {
        Item item = getItemById(id); // αν δεν υπάρχει → WrongID
        System.out.println(item);
    }

    public void checkStatus() {
        System.out.println("Status for all clients:\n");
        for (int i = 0; i < buyersList.size(); i++) {
            Buyer b = buyersList.get(i);
            System.out.println("Buyer's " + (i + 1) + " data are:\nName: " + b.getName() +
                    "\nEmail: " + b.getEmail() +
                    "\nBonus Collected: " + b.getBonus() +
                    "\nCategory: " + b.getBuyerCategory() + "\n");
        }
    }
}
