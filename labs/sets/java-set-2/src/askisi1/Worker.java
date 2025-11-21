abstract public class Worker
{
    //μεταβλητες
    private String wName="";
    private String wAFM="";
    private int wCode=0;
    private static int counter=1;// ειναι ισο με ενα ετσι ο κωδικος του πρωτου εργατη θα εχει στο τελος την τιμη 1 δηλαδη ετσι 1231
    
    //Ο constuctor ο οποιος θα μας φτιαχνει αντικειμενα τυπου Worker
    Worker(String wName, String wAFM, int wCode)
    {
       this.wName=wName;
       this.wAFM=wAFM;
       this.wCode=wCode*10+counter;// τυπος που υπολογιζει αυτοματα το κωδικο του καθε εργατη
       counter+=1;//καθε φορα που καλειτε ο κατασκευαστης Worker αυξανει κατα 1 ο counter
    }
    
    // μεθοδος που μπορει και θετει το ονομα ενος εργατη οταν την καλουμε
    public void setwName(String n)
    {
        this.wName=n;
    }
    
    // μεθοδος που μας επιστρεφει το ονομα του εργατη
    public String getwName()
    {
        return  wName;
    }
    
    //μεθοδος που μπορει και θετει το ΑΦΜ ενος εργατη οταν την καλουμε
    public void wAFM(String a)
    {
        this.wAFM=a;
    }
    
    //μεθοδος επιστρεφει το ΑΦΜ του εργατη
    public String getwAFM()
    {
        return wAFM;
    }
    
    //μεθοδος που επιστρεφει τον κωδικό του εργατη
    public int getwCode()
    {
        return wCode;
    }
    
    //αφηρημενη μεθοδος που δεν πρεπει να εχει σωμα στην υπερκλαση.Σε καθε υποκλαση της υπερκλασης πρεπει υποχρεωτικα η καθε μια να εχει το δικο της σωμα στην μεθοδο αυτη 
    abstract public int workerPayment();
    
    //μεθοδος οταν καλειτε μας τυπωνει ολα τα στοιχεια του εργατη 
    public void printINFO()
    {
        System.out.println("Worker Code: "+ getwCode() +"\nWorker Name: "+ getwName() +"\nWorker Afm: "+ getwAFM());
    }
    
}