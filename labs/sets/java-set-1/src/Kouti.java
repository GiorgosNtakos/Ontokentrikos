class Kouti
{
    //Instance Variables
    double mikos;
    double platos;
    double ypsos;
    
    //Constructors
    
    Kouti(double plevra)
    {
        mikos = plevra;
        platos = plevra;
        ypsos = plevra;
    }
    
    Kouti(double ypsos1 , double platos1 , double mikos1)
    {
        ypsos = ypsos1;
        platos = platos1;
        mikos = mikos1;
    }
    
    //Methods
     double calculate()
    {
        return mikos*platos*ypsos; //υπολογιζει τον ογκο 
    }
    
     double epifaneia()
    {
        return 2*(mikos*platos)+2*(mikos*ypsos)+2*(ypsos*platos);//υπολογιζει το εμβαδον της επιφανειας 
    }
    
     public String toString()
    {
       return "Epifaneia "+epifaneia()+", Ogkos "+calculate();//επιστρεφει της  τιμες των μεθοδων epifaneia και ogkos
    }
}