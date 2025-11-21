import java.util.*;
import java.lang.*; 
import java.io.*;
public class Menu 
{
        String Email=null;
        Owner owner=new Owner("Takhs Tsoukalas","Takhs7Tsoukalas@hotmail.com");
        Buyer buyer;
        EShop eshop=new EShop("Ceid Shop", owner);
        Item item;
        Scanner keyboard = new Scanner(System.in);
    
    void welcome()
   {
       System.out.println("*-------------------------------*");
       System.out.println("|   |------------------------|  |");
       System.out.println("| --->Welcome to our E-Shop.<---|");
       System.out.println("|   |------------------------|  |");
       System.out.println("*-------------------------------*");
    }
            
       //Μεθοδοσ στην οποια ο χρηστης εισαγει ενα email και αναλογα αν υπαρχει κανει λογκιν αλλιως ερωταται αν θελει να φτιαξει νεο λογαριασμο η οχι. 
        void enterEmail()
        {
            String Choose=null;
            String newName=null;
            String newEmail=null;
            String line="";
             System.out.print("Please Enter your email:");
            Email=keyboard.nextLine();//Εισαγουμε ενα string που παριστανει το Email ταυτοποιησης
                label1:
                
                //Τρεχουμε την λιστα των buyers
           for(int i=0; i<eshop.buyersList.size(); i++)
           {
               /*Παρακατω αν υπαρχει το Email που βαλαμε ως εισοδο ανηκει στο buyersList η ειναι ο owner
               Και αναλογα αν ειναι owner η buyer τυπωνουμε τα αντιστοιχα μηνυματα και βγαινουν τα αντιστοιχα Menu*/
                 if(eshop.buyersList.get(i).getEmail().equals(Email) || owner.getEmail().equals(Email))
             {   
                System.out.println("You logged in !!!");
                if(owner.getEmail().equals(Email))
               {
                    System.out.println("Welcome "+owner.getName()+".Your personal details are: ");
                    owner.getOwnerInfo();
                    ownerMenu();
               }
               else
               {
                System.out.println("Welcome "+eshop.buyersList.get(i).getName()+".Your personal details are: ");
                eshop.buyersList.get(i).getBuyerInfo();
                buyerMenu();
                }
                break;//για να βγουμε απο τον βρογχο σε περιπτωση που εχουμε βρει καποιο Email
             }
             
             /*συνθηκη που αν ο δεικτης i ειναι μικροτερο απο το μηκος της λιστας - 1
              συνεχιζουμε στην επομενη επαναληψη το βρογχου και αυτο γιατι θελουμε να
              τρεξουμε ολη την λιστα για να βρουμε το email και οχι μια θεση της buyersList*/
             else if( i<eshop.buyersList.size()-1)
             {  
                 continue label1;  
                }
//Παρακατω αν το email δεν ανηκει σε κανεναν χρηστη το προγραμμα μας ρωταει αν θελουμε να φτιαξουμε νεο λογαριασμο με νεο ονομα και email
            else
           {
               
            System.out.println("You do not own an account in our E-shop.\n Do you wish to create a new one ?\t(Type Yes or No)");
            Choose=keyboard.nextLine();
            
            while(!(Choose.equals("Yes") || Choose.equals("No")))
           {
               System.out.println("Please Type in Yes or No. Anything else it's incorrect!!!");
               Choose=keyboard.nextLine();
                }
                
            if(Choose.equals("Yes"))
            {
                System.out.println("Please enter your name:");
                newName=keyboard.nextLine();
                System.out.println("Please enter a new email:");
                newEmail=keyboard.nextLine();
                boolean IsNewEmailExist=true;
                label2:
                
                /*Τρεχουμε ολη την λιστα ωστε σε περιπτω που βρουμε το email οτι υπαρχει στην λιστα να τυπωθει μηνυμα το
                   οποιο μας ενημερωνει οτι το Email υπαρχει ηδη και οτι πρεπει να βαλουμε καποιο καινουργιο*/
                for(int k=0; k<eshop.buyersList.size(); k++)
                    {
                        if(eshop.buyersList.get(k).getEmail().equals(newEmail) || owner.getEmail().equals(newEmail))
                        {
                            System.out.println("This email is already in use.\n Please enter a new one. ");
                            newEmail=keyboard.nextLine();
                            k=-1;//κ=-1 διοτι οταν θα βαλουμε νεο email αφου το προηγουμενο που βαλαμε υπαρχει θα μου εξασφασιλει οτι θα σκαναρει την λιστα απο την αρχη
                            continue label2;
                        }
                        /*συνθηκη που αν ο δεικτης κ ειναι μικροτερο απο το μηκος της λιστας - 1
                         * συνεχιζουμε στην επομενη επαναληψη το βρογχου και αυτο γιατι θελουμε να
                         * τρεξουμε ολη την λιστα για να ελεγξουμε το email και οχι μια θεση της*/
                        else if(k<eshop.buyersList.size()-1)
                        {
                            continue label2;
                        }
                        //Αν το Email δεν ανηκει σε καποιον buyer η owner τοτε δημιουργειται ενα νεο στιγμιοτυπο του Buyer με ορισματα το ονομα και το email που του βαλαμε εμεις
                        else
                        {
                            Buyer buyer1=new Buyer(newName,newEmail);
                            eshop.addBuyer(buyer1);
                            System.out.println("Your new account created successfully.Now you can log in to your new account.");
                            enterEmail();
                        }
                        break;
                    }
            }
            
               else if(Choose.equals("No")){System.out.println("\nThank you for visiting our E-Shop! =D");  System.exit(0);}
          }  
          break;
        }
    }
        void BrowseStore() //throws NegativeStock
        {
            String addCart=null;
            int chooseItem=0;
            String chooseCategory=null;
            int quantity=0;
            
            System.out.println("Ceid Shop");
            eshop.showCategories();
            
            System.out.println("Please choose the category that you interest in: ");
            chooseCategory=keyboard.nextLine();
            
            while(!(chooseCategory.equals("Pen") || chooseCategory.equals("Pencil") || chooseCategory.equals("Notebook") || chooseCategory.equals("Paper")))
            {
                System.out.println("Incorrect category.Type Pen or Pencil or Notebook or Paper.");
                chooseCategory=keyboard.nextLine();
            }
            
            eshop.showProductsInCategory(chooseCategory);
            
            System.out.println("Please choose one of the items above.");
            chooseItem=keyboard.nextInt();
            EShop.showProduct(eshop.getItemById(chooseItem));
            
            if(owner.getEmail().equals(Email))
            {
                System.out.println("Would you like to edit the stock of this item in your Eshop ?\t(y/n)");
                addCart=keyboard.nextLine();
                
                 while(!(addCart.equals("y") || addCart.equals("n")))
            {
                System.out.println("Please Type Yes or No: ");
                addCart=keyboard.nextLine();
            }
            
            if(addCart.equals("Yes"))
            {   

            System.out.println("Choose the whole stock of the product that you wish");
            quantity=keyboard.nextInt();
            //Αν εχουμε quantity μικροτερου του 0 φτιαχνεται μια εξαιρεση τυπου NegativeStock και εγειρεται χαρη στην catch και μας πεταει το καταλληλο μηνυμα
            try
            {
                if(quantity<0)
            throw new NegativeStock();
            
            }
            catch(NegativeStock NS)
            {
                System.err.println("You can not give a negative Stock.");
                ownerMenu();
                }
            eshop.updateItemStock(eshop.getItemById(chooseItem),quantity);
            ownerMenu();
        }
        
        else  if(addCart.equals("No"))
        {
            ownerMenu();
        }
            
            }
            else
            {
            System.out.println("Would you like to add this item to your shopping cart ?\t(Yes/No)");
            addCart=keyboard.nextLine();
            
            while(!(addCart.equals("Yes") || addCart.equals("No")))
            {
                System.out.println("Please Type Yes or No: ");
                addCart=keyboard.nextLine();
            }
            
            if(addCart.equals("Yes"))
            {
            System.out.println("Choose the quantity of the product that you wish");
            quantity=keyboard.nextInt();
            label7:
            /*Τρεχουμε την λιστα itemsList και αν ειναι σωστο το ID που δωσαμε καλειται η placeOrder με ορισματα το Item που περιεχει το ID 
               και την ποσοτητα που του δινουμε εμεις.Αν η ποσοτητα ειναι αρνητικη η υπερβαινει τον αριθμο του στοκ τοτε εγειρονται οι καταλληλες εξαιρεσεις*/
            for(Item i : eshop.itemsList)
            {
                if(i.getID()==chooseItem)
                {
            try
            {
                if(quantity<0)
            throw new NegativeStock();
             else if (quantity>i.getStock())
             throw new OutOfStock();
            }
            catch(OutOfStock oos)
            {
                System.err.println("The quantity of the item is not available. Please provide a quantity that is available in stock.");
            }
            catch(NegativeStock NS)
            {
                System.err.println("You can not give a negative Stock.");
                ownerMenu();
                }
            //Τρεχουμε την λιστα buyers ωστε η αγορα να συμπληρωθει στον σωστο αγοραστη 
                label6:
                for(Buyer buyer : eshop.buyersList )
                {
                    if(buyer.getEmail().equals(Email))
                    {
            buyer.placeOrder(i,quantity);
            buyerMenu();
        }
        else{continue label6;}
        }
    }
        else{continue label7;}
    }
}
            
        else if(addCart.equals("No"))
        {
            buyerMenu();
        }
        
        }
    } 
        void buyerMenu()
        {
            int ChooseNum=0;
            
            System.out.println("Please press:\n(1).BrowseStore\n(2).ViewCart\n(3).Checkout\n(4).Logout\n(5).Exit from the Eshop");
            ChooseNum=keyboard.nextInt();
            
            while(ChooseNum<=0 || ChooseNum>5)
            {
                System.out.println("Press (1), (2), (3), (4) or (5)");
                ChooseNum=keyboard.nextInt();
            }
            
            switch(ChooseNum)
            {
                case 1:
                BrowseStore();
                break;
                
                case 2:
                ViewCart();
                break;
                
                case 3:
                callCheckout();
                break;
                
                case 4:
                logOut();
                break;
                
                case 5:
                Exit();
                break;
            }

        }
        
       void callCheckout()
       {
           //Τρεχουμε την buyersList και αναloγα με το email καλειται η Chekout για τον συγκεκριμενο Buyer
           for(Buyer i: eshop.buyersList)
           {
               if(i.getEmail().equals(Email))
                    {
               i.getShoppingCart().checkout();
               buyerMenu();
            }
            }
        }
        
    void ViewCart ()
    {   
        String ChooseAction=null;
        int chooseItem=0;
        String ChooseChar=null;
        int chooseQuantity=0;
        label5:
        for(Buyer i: eshop.buyersList)
        {
            if(i.getEmail().equals(Email))
            {
            if(i.getShoppingCart().getOrderList().size()!=0){i.getShoppingCart().showCart();}
            else{System.out.println("The cart is empty."); buyerMenu();}
            System.out.println("Whould you like to edit an order, clear your cart, checkout or go back to Menu.\n Please type in\t(edit/clear/checkout/back)");
            ChooseAction=keyboard.nextLine();
            while(!(ChooseAction.equals("edit") || ChooseAction.equals("clear") || ChooseAction.equals("checkout") || ChooseAction.equals("back")))
            {
                System.out.println("Please type in edit, clear, checkout, back"); 
                ChooseAction=keyboard.nextLine();
            }
            switch (ChooseAction)
            {
                case "edit":
                System.out.println("Would you like to remove an item from your order or change the quantity of the item?\tPlease type in (remove/change)");
                ChooseAction=keyboard.nextLine();
                while(!(ChooseAction.equals("remove") || ChooseAction.equals("change")))
                {System.out.println("Please type in remove or change"); ChooseAction=keyboard.nextLine();}
                System.out.println("Please choose the item by ID that you want to edit");
                chooseItem=keyboard.nextInt();
                label4:
                for(int k=0;k<i.getShoppingCart().getOrderList().size();k++){
                    if(i.getShoppingCart().getOrderList().get(k).getItem().getID()==chooseItem){
                            if(ChooseAction.equals("remove")){i.getShoppingCart().removeItemOrdered(i.getShoppingCart().getOrderList().get(k).getItem()); buyerMenu();}
                            else if(ChooseAction.equals("change")){
                                System.out.println("Enter the quantity that you want to add/sub");
                                chooseQuantity=keyboard.nextInt();
                                System.out.println("Please choose if you want to icrease or decrease the item's quantity.Type in (add/sub)"); //Exception
                                ChooseChar=keyboard.next();
                                while(!(ChooseChar.equals("add") || ChooseChar.equals("sub")))
                                {System.out.println("Please type in add or sub"); ChooseChar=keyboard.next();}
                                i.getShoppingCart().changeItemOrderedQuantity(ChooseChar,i.getShoppingCart().getOrderList().get(k).getItem(),chooseQuantity); 
                                buyerMenu();
                                break;
                            }
                        }
                        else if(k<i.getShoppingCart().getOrderList().size()-1){continue label4;}
                        else
                        {
                            System.out.println("This item is not included in the Order List. Please choose a new one.");
                            k=-1;
                            chooseItem=keyboard.nextInt(); 
                            continue label4;
                        }
                    }
                break;
                case "clear":
                i.getShoppingCart().clearCart(); 
                buyerMenu();
                break;
                case "checkout":
                i.getShoppingCart().checkout();
                buyerMenu();
                break;
                case "back":
                buyerMenu();
                break;
            }
        }
        else
        {
            continue label5;
        }
            break;
        }
    }
        
        void Exit()
        {
            System.out.println("\nThank you for visiting our E-Shop! =D");
            System.exit(0);
        }
            
        void logOut()
        {
            String ChooseLog=null;
            System.out.println("You are logged out.\nDo you wish to enter with an other user or exit from E-shop.\nType in\t(newUser/Exit).");
            ChooseLog=keyboard.nextLine();
            
            
            while(!(ChooseLog.equals("newUser") || ChooseLog.equals("Exit")))
            {
                System.out.println("Please type in newUser or Exit");
                ChooseLog=keyboard.nextLine();
            }
        
            if(ChooseLog.equals("newUser"))    {enterEmail();}
            
            else if (ChooseLog.equals("Exit"))    {Exit();}
            
            
        }
        
     void CheckStatus()
    {
        String chooseChar=null;
        String EmailClient=null;
        eshop.checkStatus();
        System.out.println("Would you like to edit a client? (Yes/No)");
        chooseChar=keyboard.nextLine();
        while(!(chooseChar.equals("Yes") || chooseChar.equals("No")))
        {System.out.println("Please type in Yes or No"); chooseChar=keyboard.nextLine();}
        if(chooseChar.equals("Yes"))
        {
            System.out.println("Please enter the email of the client that you want to edit.");
            EmailClient=keyboard.nextLine(); //Exception
            label3:
            for(int i=0;i<eshop.buyersList.size();i++)
            {
                if(eshop.buyersList.get(i).getEmail().equals(EmailClient))
                {
                    eshop.buyersList.get(i).getShoppingCart().showCart();
                    System.out.println("Would you like to delete this client?(Yes/No)");
                    chooseChar=keyboard.nextLine();
                    while(!(chooseChar.equals("Yes") || chooseChar.equals("No")))
                    {System.out.println("Please type in Yes or No"); chooseChar=keyboard.nextLine();}
                    if(chooseChar.equals("Yes"))
                    {
                        eshop.buyersList.get(i).getShoppingCart().clearCart();
                        eshop.removeBuyer(eshop.buyersList.get(i));
                        ownerMenu();
                    }
                    else if(chooseChar.equals("No")){ownerMenu();}
                }
                
                else if(i<eshop.buyersList.size()-1)
                {
                    continue label3;
                }
                
                else
                {
                    System.out.println("Type in a valid email"); 
                    i=-1;
                    EmailClient=keyboard.nextLine();
                    continue label3;
                }
            }
        }
        else if(chooseChar.equals("No")){ownerMenu();}
    }
        
        void ownerMenu()
        {
            int ChooseNum=0;
        System.out.println("Please press: (1) to browse the shop, (2) to check status of clients, (3) to log out, (4) to exit the shop.");
        ChooseNum=keyboard.nextInt();
        while(ChooseNum<=0 || ChooseNum>5){System.out.println("Please press (1),(2),(3) or (4)");}
        switch(ChooseNum)
        {
            case 1:
            BrowseStore();
            break;
            case 2:
            CheckStatus();
            break;
            case 3:
            logOut();
            break;
            case 4:
            Exit();
            break;
        }
      }
}