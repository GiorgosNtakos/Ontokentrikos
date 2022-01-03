public class WrongID extends IllegalArgumentException
{
    public WrongID()
    {
    }
    
    public WrongID(String msg)
    {
        super(msg);
    }
    
    public String toString()
    {
        return "Wrong Type of ID.";
    }
}