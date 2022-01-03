import java.util.*; // για μπορουμε να χρησιμοποιησουμε ολες τις κλασεις και μεθοδους του πακετου java.util

public class Company
{
    private String name ="";
    private String afm ="";
    private int cCode=0 ; 
    
    //Ο constuctor ο οποιος θα μας φτιαχνει αντικειμενα τυπου Company
    Company(String name, String afm, int cCode)
    {
        this.name=name;
        this.afm=afm;
        this.cCode=cCode;
    }
    
    //Η δημουργια της λιστας μου  
    private ArrayList<Worker> myWorkers = new ArrayList<Worker>();
    
    //Μεθοδος η οποια διατρεχει την λιστα και τυπωνει τα ονοματα των εργατων που περιεχει μεσα σε αυτην.
    public void getterWorkersNames()
    {
        for(Worker c:myWorkers)
        {
            c.getwName();
            System.out.println(c.getwName());
        }
    }
    /*public void getterWorkersNames()
    {
        Iterator iter=myWorkers.iterator();
        while(iter.hasNext())
        {
            Worker a = (Worker)iter.next();
            a.getwName();
            System.out.println(a.getwName());
        }
    }
    */
    //μεθοδος που βαζει μεσα στην λιστα μου τους εργατες που δουλευουν για την εταιρεια
     public void addWorker(Worker awc)
    {
        myWorkers.add(awc);
    }
    
    // μεθοδος που μας επιστρεφει το ονομα της εταιρειας
    public String getterName()
    {
        return name;
    }
    
    //μεθοδος που μας επιστρεφει τον κωδικο της εταιρειας
    public int gettercCode()
    {
        return cCode;
    }
    
    //μεθοδος μας τυπωνει για ποια εταιρεια δουλευουν οι εργατες και τον κωδικο της εταιρειας
    public void companyInfo()
    {
        System.out.print("Employees working for "+ getterName() +", code "+ gettercCode() +":\n");
    }
}
    