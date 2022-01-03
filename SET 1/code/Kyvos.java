public class Kyvos extends Kouti
{
     double plevra;
    
    //Constructor
    Kyvos(double pl1)
    {
       super(pl1, pl1, pl1); //καλει τον κατασκευαστη της υπερκλασης και θετει τις μεταβλητες ypsos1=mhkos1=platos1=pl1
       plevra=pl1;
    }
    
    //Methods
    
       double calculate()
     {
        return Math.pow(plevra,3);//υπολογιζει τον ογκο ενος κυβου
     }
    
       double epifaneia()
     {
        return 6*Math.pow(plevra,2);//υπολογιζει το εμβαδον επιφανειας ενος κυβου
     }
    
       public String toString()
     {
        return "Epifaneia "+epifaneia()+", Ogkos "+calculate();//επιστρεφει της  τιμες των μεθοδων epifaneia και ogkos
    }
}
