public class NegativeStock extends ArithmeticException
{
    public NegativeStock()
    {
    }
    
    public NegativeStock(String msg)
    {
        super(msg);
    }
    
    public String toString()
    {
        return "Negative number of stock .";
    }
}