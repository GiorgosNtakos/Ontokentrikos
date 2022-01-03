public class  Owner extends User
{
    private static boolean isAdmin=true;
    
    Owner (String name,String email)
    {
        super(name,email);
        this.isAdmin=true;
    }
    
    public void getOwnerInfo()
    {
        System.out.println("This user is the Owner.");
        super.userInfo();
    }
}
