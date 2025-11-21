import java.util.*;
public class  EShop 
{
     private  static String name="Ceid shop";
     private  static Owner owner;
     public static  List<Item> itemsList = new ArrayList<Item>();
     public static  List<Buyer> buyersList = new ArrayList<Buyer>();
    
    EShop (String name,Owner owner)
    {
        this.name=name;
        this.owner=owner;
    }
   
    void addItem(Item item)
    {
        if (itemsList.contains(item)) System.out.println("Item already exists");//thelei ejeresi
        else itemsList.add(item);
    }
    
    Item getItemById(int id)
    {
        try
            {
        for(Item item:itemsList)
        {
            if (item.getID()==id) {return item;}
            else if(item.getID()!=itemsList.lastIndexOf(item)) { throw new WrongID();}
        }
    }
        catch(WrongID WID)
        {
            System.err.println("You gave an ID that doesn't Exist please give one from the above items");
        }
        return null;
    }
    void removeItem(Item item)
    {
        if (itemsList.contains(item)) itemsList.remove(item);
        else System.out.println("Item does not exist");//εξαιρεση
    }
    public  void addBuyer(Buyer buyer)
    {
        if (buyersList.contains(buyer.getEmail())) System.out.println("Buyer already exists");//εξαιρεση
        else buyersList.add(buyer);
    }
    public void removeBuyer(Buyer buyer)
    {
        if (buyersList.contains(buyer)) buyersList.remove(buyer);
        else  System.out.println("Buyer does not exist");
    }
    public void updateItemStock(Item item,int stock)
    {
        item.setStock(stock);
    }
    public void showCategories()
    { 
        int counterPen=0;
        int counterPencil=0;
        int counterNotebook=0;
        int counterPaper=0;
        for (int i=0;i<itemsList.size();i++)
        {
            if (itemsList.get(i) instanceof Pen){counterPen++;}
           
            if (itemsList.get(i) instanceof Pencil){counterPencil++;}
            
            if (itemsList.get(i) instanceof Notebook){counterNotebook++;}
            
            if (itemsList.get(i) instanceof Paper){counterPaper++;}
    }
    
    System.out.println("Categories:\n1.Pen("+counterPen+")\n2.Pencil("+counterPencil+")\n3.Notebook("+counterNotebook+")\n4.Paper("+counterPaper+")");
    
}
    public  void showProductsInCategory(String category)
    {
        boolean CategoryNotFound=false;
        System.out.println("Items in category "+category+":");
        for (int i=0;i<itemsList.size();i++)
        {
            if (category.equals("Pen")){if (itemsList.get(i) instanceof Pen)
            {System.out.println(i+"."+itemsList.get(i).getName()+" ("+itemsList.get(i).getID()+") .");}}
            else if (category.equals("Pencil")){if (itemsList.get(i) instanceof Pencil)
            {System.out.println(i+"."+itemsList.get(i).getName()+" ("+itemsList.get(i).getID()+") .");}}
            else if (category.equals("Notebook")){if (itemsList.get(i) instanceof Notebook)
            {System.out.println(i+"."+itemsList.get(i).getName()+" ("+itemsList.get(i).getID()+") .");}}
            else if (category.equals("Paper")){if (itemsList.get(i) instanceof Paper)
            {System.out.println(i+"."+itemsList.get(i).getName()+" ("+itemsList.get(i).getID()+") .");}}
            else CategoryNotFound=true;
        }  
        if (CategoryNotFound==true)System.out.println("Could not find that category.");
    }
    public static void showProduct(Item item)
    {
        System.out.println(item.toString());
    }
    public void checkStatus()
    {
        System.out.println("Status for all clients: \n");
        for (int i=0;i<buyersList.size();i++)
        {
            System.out.println("Buyer's "+(i+1)+" data are:"+"\nName: "+buyersList.get(i).getName()+"\nEmail: "+buyersList.get(i).getEmail()+"\nBonus Collected: "+
            buyersList.get(i).getBonus()+"\nCategory: "+buyersList.get(i).getBuyerCategory()+"\n\n");
        }
    }
}

