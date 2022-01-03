class Spirtokouto extends Kouti
{
    private double baros;
    
    //Constructor
    
    Spirtokouto(double y2 , double p2 , double m2 , double b)
    {
        super(y2,p2,m2); //καλει τον κατασκευαστη της υπερκλασης και θετει τις μεταβλητες ypsos1=y2 platos1=p2 mhkos1=m2
        baros=b;
    }
    
    //Methods
    double varos()
    {
        return baros; // επιστεφει το βαρος του 
    }
    
    public String toString()
    {
        return super.toString()+", Varos " ; //Καλει την μεθοδο toString() που εχει οριστει στην υπερκλαση Kouti και επιστρεφει την τιμη της μεθοδου varos
    }
}