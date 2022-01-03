abstract public class Item
{
    private String name;
    private double price;
    private String description;
    private int stock;
    private int id;
    
    Item (String name,double price,String description,int stock,int id)
    {
        this.name=name;
        this.price=price;
        this.description=description;
        this.stock=stock;
        this.id=id;
    }
    
    public String getName(){return name;}
    public void setName(String name){this.name=name;}
    
    public double getPrice(){return price;}
    public void setPrice(double price){this.price=price;}
    
    public String getDescription(){return description;}
    public void setDescription(String description){this.description=description;}
    
    public int getStock(){return stock;}
    public void setStock(int stock){this.stock=stock;}
    
    public int getID(){return id;}
    public void setID(int id){this.id=id;}
    
    
    String getBasicInfo()
    {
        return ("\nItem Name: "+getName()+"\nPrice: "+getPrice()+"\nDescription: "+
        getDescription()+"\nStock: "+getStock()+"\nID: "+getID());
    }
    
    abstract String getDetails();
    
    public String toString()  
    {
        return getBasicInfo()+getDetails();
    }
}

