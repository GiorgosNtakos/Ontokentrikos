import java.util.*;

public class Menu {

    private final EShop eshop;
    private final Owner owner;

    private Buyer activeBuyer;   // logged-in buyer
    private final Scanner keyboard = new Scanner(System.in);

    public Menu(EShop eshop) {
        this.eshop = eshop;
        this.owner = eshop.getOwner();
    }

    public void welcome() {
        System.out.println("*-------------------------------*");
        System.out.println("|   |------------------------|  |");
        System.out.println("| --->Welcome to our E-Shop.<---|");
        System.out.println("|   |------------------------|  |");
        System.out.println("*-------------------------------*");
    }

    // ========================= LOGIN / REGISTER =========================

    public void enterEmail() {
        activeBuyer = null;

        System.out.print("Please enter your email: ");
        String email = keyboard.nextLine().trim();

        // Owner login
        if (owner.getEmail().equals(email)) {
            System.out.println("You logged in as Owner!");
            owner.getOwnerInfo();
            ownerMenu();
            return;
        }

        // Buyer login
        for (Buyer b : eshop.getBuyersList()) {
            if (b.getEmail().equals(email)) {
                activeBuyer = b;
                System.out.println("You logged in as Buyer!");
                b.getBuyerInfo();
                buyerMenu();
                return;
            }
        }

        // Not found -> register?
        System.out.println("You do not own an account in our E-shop.");
        System.out.print("Would you like to create a new one? (y/n): ");
        String choose = keyboard.nextLine().trim();

        while (!choose.equalsIgnoreCase("y") && !choose.equalsIgnoreCase("n")) {
            System.out.print("Please type y or n: ");
            choose = keyboard.nextLine().trim();
        }

        if (choose.equalsIgnoreCase("n")) {
            Exit();
            return;
        }

        // ✅ Register new buyer: ask BOTH name & email
        System.out.print("Give your name: ");
        String newName = keyboard.nextLine().trim();

        System.out.print("Give your email: ");
        String newEmail = keyboard.nextLine().trim();

        try {
            Buyer nb = new Buyer(newName, newEmail);
            eshop.addBuyer(nb);
            activeBuyer = nb;
            System.out.println("Account created successfully. Logging you in...");
            buyerMenu();

        } catch (DuplicateBuyerEmailException e) {
            System.out.println("A buyer with this email already exists. Try logging in.");
            enterEmail();
        }
    }

    // ========================= BUYER MENU =========================

    private void buyerMenu() {
        System.out.println("\nBuyer options:");
        System.out.println("(1) Browse Store");
        System.out.println("(2) View Cart");
        System.out.println("(3) Checkout");
        System.out.println("(4) Logout");
        System.out.println("(5) Exit");

        int choice = readInt(1, 5);

        switch (choice) {
            case 1:
                BrowseStore(false);
                break;
            case 2:
                ViewCart();
                break;
            case 3:
                callCheckout();
                break;
            case 4:
                logOut();
                break;
            case 5:
                Exit();
                break;
            default:
                System.out.println("Invalid choice.");
                buyerMenu();
        }
    }

    private void callCheckout() {
        activeBuyer.getShoppingCart().checkout();
        buyerMenu();
    }

    private void ViewCart() {
        ShoppingCart cart = activeBuyer.getShoppingCart();

        System.out.println("\n--- Your Cart ---");
        cart.showCart();

        System.out.println("\nChoose action:");
        System.out.println("(1) Edit order");
        System.out.println("(2) Clear cart");
        System.out.println("(3) Checkout");
        System.out.println("(4) Back");

        int c = readInt(1, 4);

        switch (c) {
            case 1:
                editCart();
                break;
            case 2:
                cart.clearCart();
                buyerMenu();
                break;
            case 3:
                cart.checkout();
                buyerMenu();
                break;
            case 4:
                buyerMenu(); // BACK
                break;
            default:
                System.out.println("Invalid choice.");
                buyerMenu();
        }
    }

    private void editCart() {
        ShoppingCart cart = activeBuyer.getShoppingCart();

        if (cart.getOrderList().isEmpty()) {
            System.out.println("Cart is empty.");
            buyerMenu();
            return;
        }

        System.out.println("\nEdit options:");
        System.out.println("(1) Remove item");
        System.out.println("(2) Change quantity");
        System.out.println("(3) Back");

        int c = readInt(1, 3);
        if (c == 3) { buyerMenu(); return; } // BACK

        System.out.print("Give item ID from your cart: ");
        int id = readInt(1, Integer.MAX_VALUE);

        Item target = null;
        for (ItemOrdered io : cart.getOrderList()) {
            if (io.getItem().getID() == id) {
                target = io.getItem();
                break;
            }
        }

        if (target == null) {
            System.out.println("This item is not in your cart.");
            buyerMenu();
            return;
        }

        if (c == 1) {
            cart.removeItemOrdered(target);
            buyerMenu();
            return;
        }

        // Change quantity
        System.out.println("\nQuantity change options:");
        System.out.println("(1) Add quantity");
        System.out.println("(2) Subtract quantity");
        System.out.println("(3) Back");

        int op = readInt(1, 3);
        if (op == 3) { buyerMenu(); return; } // BACK

        System.out.print("Enter quantity: ");
        int q = readInt(1, Integer.MAX_VALUE);

        try {
            if (op == 1) {
                cart.changeItemOrderedQuantity("add", target, q);
            } else {
                cart.changeItemOrderedQuantity("sub", target, q);
            }
        } catch (OutOfStock oos) {
            System.out.println("Not enough stock.");
        } catch (NegativeStock ns) {
            System.out.println("Quantity cannot become negative.");
        }

        buyerMenu();
    }

    // ========================= OWNER MENU =========================

    private void ownerMenu() {
        System.out.println("\nOwner options:");
        System.out.println("(1) Browse Store / Update Stock");
        System.out.println("(2) Check Status (buyers & carts)");
        System.out.println("(3) Logout");
        System.out.println("(4) Exit");

        int choice = readInt(1, 4);

        switch (choice) {
            case 1:
                BrowseStore(true);
                break;
            case 2:
                ownerCheckStatus();
                break;
            case 3:
                logOut();
                break;
            case 4:
                Exit();
                break;
            default:
                System.out.println("Invalid choice.");
                ownerMenu();
        }
    }

    private void ownerCheckStatus() {
        eshop.checkStatus();

        System.out.println("\n(1) View buyer cart by email");
        System.out.println("(2) Back");

        int c = readInt(1, 2);
        if (c == 2) { ownerMenu(); return; } // BACK

        System.out.print("Enter buyer email: ");
        String email = keyboard.nextLine().trim();

        Buyer found = null;
        for (Buyer b : eshop.getBuyersList()) {
            if (b.getEmail().equals(email)) {
                found = b;
                break;
            }
        }

        if (found == null) {
            System.out.println("No buyer with that email.");
            ownerMenu();
            return;
        }

        found.getBuyerInfo();
        found.getShoppingCart().showCart();
        ownerMenu();
    }

    // ========================= BROWSE STORE =========================

    private void BrowseStore(boolean asOwner) {
        System.out.println("\n" + eshop.getName());
        eshop.showCategories();

        System.out.print("Choose category (Pen/Pencil/Notebook/Paper) or type Back: ");
        String category = keyboard.nextLine().trim();

        if (category.equalsIgnoreCase("Back")) {
            if (asOwner) ownerMenu(); else buyerMenu();
            return; // BACK
        }

        while (!category.equalsIgnoreCase("Pen")
                && !category.equalsIgnoreCase("Pencil")
                && !category.equalsIgnoreCase("Notebook")
                && !category.equalsIgnoreCase("Paper")) {
            System.out.print("Incorrect category. Type Pen/Pencil/Notebook/Paper or Back: ");
            category = keyboard.nextLine().trim();

            if (category.equalsIgnoreCase("Back")) {
                if (asOwner) ownerMenu(); else buyerMenu();
                return; // BACK
            }
        }

        List<Item> catItems = eshop.showProductsInCategory(category);
        if (catItems.isEmpty()) {
            if (asOwner) ownerMenu(); else buyerMenu();
            return;
        }

        System.out.print("Choose item NUMBER from above (or 0 for Back): ");
        int choice = readInt(0, catItems.size());

        if (choice == 0) {
            if (asOwner) ownerMenu(); else buyerMenu();
            return; // BACK
        }

        Item selected = catItems.get(choice - 1);

        try {
            eshop.showProduct(selected.getID());
        } catch (WrongID e) {
            System.out.println("Invalid item.");
            if (asOwner) ownerMenu(); else buyerMenu();
            return;
        }

        if (asOwner) {
            System.out.println("\nOwner item options:");
            System.out.println("(1) Update stock");
            System.out.println("(2) Back");

            int c = readInt(1, 2);
            if (c == 2) { ownerMenu(); return; } // BACK

            System.out.print("Enter new stock quantity: ");
            int newStock = readInt(0, Integer.MAX_VALUE);

            try {
                eshop.updateItemStock(selected, newStock);
                System.out.println("Stock updated.");
            } catch (NegativeStock ns) {
                System.out.println("Stock cannot be negative.");
            }

            ownerMenu();
            return;
        }

        // Buyer flow
        System.out.println("\nBuyer item options:");
        System.out.println("(1) Add to cart");
        System.out.println("(2) Back");

        int c = readInt(1, 2);
        if (c == 2) { buyerMenu(); return; } // BACK

        System.out.print("Quantity: ");
        int q = readInt(1, Integer.MAX_VALUE);

        try {
            activeBuyer.placeOrder(selected, q);
            System.out.println("Item added to cart.");
        } catch (OutOfStock oos) {
            System.out.println("Not enough stock.");
        } catch (NegativeStock ns) {
            System.out.println("Quantity must be positive.");
        }

        buyerMenu();
    }

    // ========================= LOGOUT / EXIT =========================

    private void logOut() {
        System.out.println("Logging out...\n");
        enterEmail();
    }

    private void Exit() {
        System.out.println("\nThank you for visiting our E-Shop! =D");
        System.exit(0);
    }

    // ========================= helper input =========================

    private int readInt(int min, int max) {
        while (true) {
            try {
                int x = Integer.parseInt(keyboard.nextLine().trim());
                if (x < min || x > max) throw new NumberFormatException();
                return x;
            } catch (NumberFormatException e) {
                System.out.print("Please enter a number between " + min + " and " + max + ": ");
            }
        }
    }
}
