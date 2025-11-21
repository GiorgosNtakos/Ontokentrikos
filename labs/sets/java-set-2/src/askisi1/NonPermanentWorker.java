class NonPermanentWorker extends Worker//κλαση NonPermanentWorker υποκλαση του Worker
{
  private int hoursWorked = 0;
  private int hourlyPayment = 0;
  
  //Ο constuctor ο οποιος θα μας φτιαχνει αντικειμενα τυπου Worker
  NonPermanentWorker(String wName, String wAFM, int wCode, int hoursWorked, int hourlyPayment)
  {
      super(wName, wAFM, wCode);//καλει τον κατασκευαστη της υπερκλασης και θετει τις τιμες του κατασκευαστη NonPermanentWorker που βρισκονται μεσα στο super ισες με αυτες του Worker
      this.hoursWorked=hoursWorked;
      this.hourlyPayment=hourlyPayment;
  }
  
  // μεθοδος που μπορει και θετει τις ωρες δουλειας ενος μη μονιμου εργατη οταν την καλουμε
  public void setHoursWorked(int hw)
  {
      this.hoursWorked=hw;
  }
  
  // μεθοδος που μας επιστρεφει τις ωρες δουλειας του μη μονιμου εργατη
  public int getHoursWorked()
  {
      return hoursWorked;
  }
  
  //μεθοδος που μπορει και θετει το ωρομισθιο ενος μη μονιμου εργατη
  public void setHourlyPayment(int hp)
  {
      this.hourlyPayment=hp;
  }
  
  // μεθοδος που μας επιστρεφει το ωρομισθιο του μη μονιμου εργατη
  public int getHourlyPayment()
  {
      return hourlyPayment;
  }
  
  //μεθοδος που μας επιστρεφει τον μισθο ενος μη μονιμου εργατη
  public int workerPayment()
  {
      return hoursWorked*hourlyPayment;
  }
  
  //μεθοδος που θα μας τυπωνει τα στοιχεια του μη μονιμου εργατη
  public void printINFO()
  {
      super.printINFO();
      System.out.println("Worker Payment: "+this.workerPayment()+"\n");
  }
    
}