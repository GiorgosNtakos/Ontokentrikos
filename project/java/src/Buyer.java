public class Buyer extends User {
    private int bonus = 0;
    private String buyerCategory = "BRONZE";
    private final ShoppingCart myShoppingCart;

    public Buyer(String name, String email) {
        super(name, email);
        this.myShoppingCart = new ShoppingCart(this); // cart ξέρει owner
    }

    public String getBuyerCategory() { return buyerCategory; }
    public int getBonus() { return bonus; }

    public void awardBonus(int orderBonus) {
        this.bonus += orderBonus;
        if (bonus >= 200) buyerCategory = "GOLD";
        else if (bonus >= 100) buyerCategory = "SILVER";
        else buyerCategory = "BRONZE";
    }

    public void placeOrder(Item item, int quantity) {
        myShoppingCart.addItemOrdered(item, quantity);
    }

    public void getBuyerInfo() {
        super.userInfo();
        System.out.println("Bonus points: " + bonus + "\nBuyer Category: " + buyerCategory);
    }

    public ShoppingCart getShoppingCart() { return myShoppingCart; }
}
