import java.util.*;
public class ShoppingCart 
{
    Scanner scanner=new Scanner(System.in);
    EShop eshop;
    ItemOrdered itemOrdered;
    private List<ItemOrdered> orderList = new ArrayList<ItemOrdered>();
    ShoppingCart(){};   
    
    public ItemOrdered getItemOrdered(){return itemOrdered;}
    public void setitemOrdered(ItemOrdered itemOrdered){this.itemOrdered=itemOrdered;}
    
    public List<ItemOrdered> getOrderList(){return orderList;}
    
    public void addItemOrdered(Item item,int quantity)
    {
        int stock=item.getStock();
        int quantityItemOrdered=0;
        if (quantity>item.getStock()) throw new OutOfStock("Out of Stock");
        else
        {
            stock-=quantity;
            item.setStock(stock);
            boolean itemFound=false;
            for (int i=0;i<orderList.size();i++)
            {
                if (orderList.get(i).getItem()==item) 
                {
                    quantityItemOrdered=orderList.get(i).getQuantity();
                    quantityItemOrdered+=quantity;
                    orderList.get(i).setQuantity(quantityItemOrdered);
                    itemFound=true;
                }
            }
            if (itemFound==false) orderList.add(new ItemOrdered(item,quantity));
        }         
    }
    public void removeItemOrdered(Item item)
    {
        int stock=item.getStock();
        boolean itemFound=false;
        for (int i=0;i<orderList.size();i++)
            {
                if (orderList.get(i).getItem()==item) 
                {
                    stock=orderList.get(i).getItem().getStock();
                    stock+=orderList.get(i).getQuantity();
                    item.setStock(stock);
                    orderList.remove(i);
                    itemFound=true;
                }
            }
        if (itemFound==false) System.out.println("Item not in shopping cart.");
    }
    public void changeItemOrderedQuantity(String doWhat,Item item,int quantity)
    {
        int stock=item.getStock();
        boolean itemFound=false;
        int quantityItemOrdered=0;
        if (quantity>item.getStock()) throw new OutOfStock("Out of Stock");
        
        else
        {
        for(int i=0; i<orderList.size(); i++)
        {
            if (orderList.get(i).getItem()==item)
            {
                if(doWhat.equals("add"))
                {
                quantityItemOrdered=orderList.get(i).getQuantity();
                quantityItemOrdered+=quantity;
                orderList.get(i).setQuantity(quantityItemOrdered);
                stock-=quantity;
                item.setStock(stock);
            }
                else if (doWhat.equals("sub"))
                {
                quantityItemOrdered=orderList.get(i).getQuantity();
                quantityItemOrdered-=quantity;
                orderList.get(i).setQuantity(quantityItemOrdered);
                stock+=quantity;
                item.setStock(stock);
            }
                itemFound=true;
            }   
        }
        if(itemFound==false) System.out.println("Item not in shopping cart.");
       }
    }
    public double OrderCost()
    {
        double sum=0;
        for(int i=0; i<orderList.size();i++)
        {
            sum +=  orderList.get(i).getQuantity() * orderList.get(i).getItem().getPrice();
        }
        return sum;
    }
    public void showCart()
    {
        System.out.println("The items in the shopping cart are:");
        for(int i=0; i<orderList.size();i++)
        {
            System.out.println(orderList.get(i).getItem().getName()+" , quantity:" + orderList.get(i).getQuantity()+", price:" + orderList.get(i).getItem().getPrice()+", ID:"+orderList.get(i).getItem().getID() );
        }
        System.out.println("The sum price is " + OrderCost() + " the courier cost is " + calculateCourierCost());
    }
    public double calculateCourierCost ()
    {
        double courier=0;
        courier=OrderCost()*0.02;
        for(Buyer i: eshop.buyersList)
        {
            if (courier<3 && i.getBuyerCategory().equals("BRONZE")){courier=3;}
            else if(i.getBuyerCategory().equals("SILVER")){courier/=2;}
            else if(i.getBuyerCategory().equals("GOLD")){courier=0;}
        }
        return courier;
    }
    public void clearCart()
    {

        for( int i=0;i<orderList.size();i++)
        {
            removeItemOrdered(orderList.get(i).getItem());
        }
        
    }

    public void  checkout()
    {
        String s=null;
        double bonus=OrderCost()*0.1;
        for(Buyer i: eshop.buyersList){
            i.getShoppingCart().clearCart();
            System.out.println("If you are ready to checkout, type in Accept, if not do not type anything.");
            s=scanner.nextLine();
            if (s.equals("Accept"))
            {
                i.awardBonus((int)bonus);
                orderList.clear();
            }
            else{System.out.println("You are not ready for checkout");}
            break;
        }
    }
    public double calculateNET(){return OrderCost()+calculateCourierCost();}
}