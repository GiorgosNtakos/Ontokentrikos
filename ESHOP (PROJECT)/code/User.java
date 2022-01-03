abstract public class User
{
    private String name;
    private String email;
    
   User (String name, String email)
   {
       this.name=new String(name);
       this.email=new String(email);
   }   
   
   public   String getName(){return this.name;}
   public   String getEmail(){return this.email;}

   public  void userInfo()
   {
    System.out.println("User name :"+getName()+"\nUser email :"+getEmail());
   }
}

