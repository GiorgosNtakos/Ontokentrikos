public class Pen extends Item
{
    private String color;
    private double tipSize;
    Pen (String name,double price,String description,int stock,int id,
    String color,double tipSize)
    {
        super(name,price,description,stock,id);
        this.color=color;
        this.tipSize=tipSize;
    }
    
    public String getColor(){return color;}
    public void setColor(String color){this.color=color;}
    
    public double gettipSize(){return tipSize;}
    public void settipSize(double tipSize){this.tipSize=tipSize;}
    
    String getDetails()
    {
        return("\nPen color: "+this.color+"\nPen tip size in mm: "+this.tipSize);
    }
    
    @Override
    public String toString()  
    {
        return getBasicInfo()+getDetails();
    }
}
