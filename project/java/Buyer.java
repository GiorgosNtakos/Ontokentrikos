import java.util.*;

public class Buyer extends User 
{
    private int bonus=0;
    private String buyerCategory="BRONZE";
    private ShoppingCart MyShoppingCart= new ShoppingCart();
    
    Buyer (String name,String email)
    {
        super(name,email);
        this.bonus=0;
        this.buyerCategory="BRONZE";
    }
    
    public String getBuyerCategory(){return buyerCategory;}
    public int getBonus(){return bonus;}
    
    public void awardBonus(int orderbonus)
    {
        this.bonus+=orderbonus;
        if (this.bonus>=100 && this.bonus<200){setbuyerCategory("SILVER");}
        else if (this.bonus>=200){setbuyerCategory("GOLD");}
    }
    public void setbuyerCategory(String category)
    {
        this.buyerCategory=category;
        //SILVER: 50% METAFORIKA
        //GOLD: METAFORIKA FREE
    }
    public void placeOrder(Item item,int quantity)
    {
        this.MyShoppingCart.addItemOrdered(item,quantity);
    }
    
    public void getBuyerInfo()
    {
        super.userInfo();
        System.out.println("Bonus points: "+getBonus()+"\nBuyer Category: "+getBuyerCategory());
    }
    
    ShoppingCart getShoppingCart(){return MyShoppingCart;}
}
