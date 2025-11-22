import java.util.*;

public class ShoppingCart {
    private final Buyer owner;
    private final Scanner scanner = new Scanner(System.in);
    private final List<ItemOrdered> orderList = new ArrayList<>();

    public ShoppingCart(Buyer owner) {
        this.owner = owner;
    }

    public List<ItemOrdered> getOrderList() { return orderList; }

    public void addItemOrdered(Item item, int quantity) {
        if (quantity <= 0) throw new NegativeStock("Quantity must be positive");
        if (quantity > item.getStock()) throw new OutOfStock("Out of Stock");

        // δεσμεύουμε stock
        item.setStock(item.getStock() - quantity);

        for (ItemOrdered io : orderList) {
            if (io.getItem() == item) {
                io.setQuantity(io.getQuantity() + quantity);
                return;
            }
        }
        orderList.add(new ItemOrdered(item, quantity));
    }

    public void removeItemOrdered(Item item) {
        for (int i = 0; i < orderList.size(); i++) {
            ItemOrdered io = orderList.get(i);
            if (io.getItem() == item) {
                // επιστροφή stock
                item.setStock(item.getStock() + io.getQuantity());
                orderList.remove(i);
                return;
            }
        }
        System.out.println("Item not in shopping cart.");
    }

    public void changeItemOrderedQuantity(String doWhat, Item item, int quantity) {
        if (quantity <= 0) throw new NegativeStock("Quantity must be positive");

        for (int i = 0; i < orderList.size(); i++) {
            ItemOrdered io = orderList.get(i);
            if (io.getItem() == item) {
                if (doWhat.equalsIgnoreCase("add")) {
                    if (quantity > item.getStock()) throw new OutOfStock("Out of Stock");
                    io.setQuantity(io.getQuantity() + quantity);
                    item.setStock(item.getStock() - quantity);
                    return;
                } else if (doWhat.equalsIgnoreCase("sub")) {
                    int newQ = io.getQuantity() - quantity;
                    if (newQ < 0) throw new NegativeStock("Resulting quantity negative");
                    item.setStock(item.getStock() + quantity);

                    if (newQ == 0) orderList.remove(i);
                    else io.setQuantity(newQ);
                    return;
                }
            }
        }
        System.out.println("Item not in shopping cart.");
    }

    public double calculateNet() {
        double sum = 0;
        for (ItemOrdered io : orderList) {
            sum += io.getQuantity() * io.getItem().getPrice();
        }
        return sum;
    }

    public double calculateCourierCost() {
        double courier = calculateNet() * 0.02;

        if (owner.getBuyerCategory().equals("BRONZE")) {
            if (courier < 3) courier = 3;
        } else if (owner.getBuyerCategory().equals("SILVER")) {
            courier = courier / 2;
        } else if (owner.getBuyerCategory().equals("GOLD")) {
            courier = 0;
        }
        return courier;
    }

    public double calculateTotal() {
        return calculateNet() + calculateCourierCost();
    }

    public void showCart() {
        if (orderList.isEmpty()) {
            System.out.println("Shopping cart is empty.");
            return;
        }
        System.out.println("The items in the shopping cart are:");
        for (ItemOrdered io : orderList) {
            System.out.println(io.getItem().getName() + " (id " + io.getItem().getID() +
                    "), quantity: " + io.getQuantity() +
                    ", subtotal: " + (io.getQuantity() * io.getItem().getPrice()));
        }
        System.out.println("Net: " + calculateNet());
        System.out.println("Courier cost: " + calculateCourierCost());
        System.out.println("Total: " + calculateTotal());
    }

    public void clearCart() {
        for (int i = orderList.size() - 1; i >= 0; i--) {
            removeItemOrdered(orderList.get(i).getItem());
        }
    }

    public void checkout() {
        showCart();
        if (orderList.isEmpty()) return;

        System.out.print("Type Accept to pay: ");
        String s = scanner.nextLine();

        if (!s.equalsIgnoreCase("Accept")) {
            System.out.println("Checkout cancelled.");
            return;
        }

        int orderBonus = (int) (calculateNet() * 0.10);
        owner.awardBonus(orderBonus);

        // Στο checkout ΔΕΝ αλλάζουμε stock, απλά αδειάζουμε το καλάθι.
        orderList.clear();
        System.out.println("Payment completed. Bonus awarded: " + orderBonus);
    }
}
