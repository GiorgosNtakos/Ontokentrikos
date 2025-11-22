public class OutOfStock extends ArithmeticException
{
    public OutOfStock()
    {
    }
    
    public OutOfStock(String msg)
    {
        super(msg);
    }
    
    public String toString()
    {
        return "Out of stock.";
    }
}