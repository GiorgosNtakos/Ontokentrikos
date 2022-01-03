class PermanentWorker extends  Worker  //κλαση PermanentWorker υποκλαση του Worker
{
    //μεταβλητες
    private int salary=0;
    
    //Ο constuctor ο οποιος θα μας φτιαχνει αντικειμενα τυπου PermanentWorker
    PermanentWorker(String wName, String wAFM, int wCode, int salary)
    {
        super(wName, wAFM, wCode); //καλει τον κατασκευαστη της υπερκλασης και θετει τις τιμες του κατασκευαστη PermanentWorker που βρισκονται μεσα στο super ισες με αυτες του Worker
        this.salary=salary;
    }
    
    //μεθοδος που μπορει και θετει τον μισθο ενος μονιμου εργατη οταν την καλουμε
    public void setSalary(int s)
    {
        this.salary=s;
    }
    
    //μεθοδος που μας επιστρεφει τον μισθο ενος μονιμου εργατη
    public int workerPayment()
    {
        return salary;
    }
    
    //μεθοδος που θα μας τυπωνει τα στοιχεια του μονιμου εργατη
    public void printINFO()
    {
        super.printINFO();// καλει την μεθοδο printINFO() της υπερκλασης
        System.out.println("Worker Payment: "+workerPayment());
    }
    
}