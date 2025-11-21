public class Notebook extends Item
{
    private int sections;
    
    Notebook (String name,double price,String description,int stock,int id,
    int sections)
    {
        super(name,price,description,stock,id);
        this.sections=sections;
    }
    
    public int getSections(){return sections;}
    public void setSections(int sections){this.sections=sections;}
    
    String getDetails()
    {
        return ("\nNumber of sections: "+this.sections);
    }
    
    @Override
    public String toString()  
    {
        return getBasicInfo()+getDetails();
    }
}
