import java.io.*;

public class Askisi2
{
  //μεθοδος που διαβαζει τον ακεραιο που θα του δωσουμε.
  public static int readIntA() 
  {
      byte a[] = new byte[16];//οριζουμε εναν πινακα τυπου byte που θα δεχθει τα bytes του ρευματος εισοδου.
      String A;
      //Με την δομη try/catch ελεγχουμε το επιφοβο κομματι του κωδικα και στη συνεχεια αν υπαρξει καποιο σφαλμα δημιουργειται ειτε εξαιρεση τυπου IOException ειτε NumberFormatException
        try 
      {
          System.in.read(a);//ειναι ενα ρευμα εισοδου οπου διαβαζει τα δεδομενα που του δινουμε απο το πληκτρολογιο 
          A = (new String(a)).trim();//μετατρεπει αυτα τα δεδομενα σε string χωρις καποια κενα που εχει απο πριν ειτε κενα που ακολουθουν.
          return Integer.parseInt(A);//μετατρεπει το string σε ακεραιο 
      } 
        catch (IOException e) 
      {
        System.out.println("Exception: " + e.toString());
        return 0;
      } 
       catch (NumberFormatException e) 
      {
        System.out.println("Exception:Sfalma!.Prepei na dwsete akeraioys arithmoys");
        System.out.println("Den ginetai na ginei h diairesh me mh akeraious arithmous");
        System.exit(0);
        return -1;
      }
    }
    
  //μεθοδος που θα μας πεταξει το αποτελεσμα της διαιρεσης 
  public static void printResults(int Z, int K) 
  { 
     //Με την δομη try/catch ελεγχουμε το επιφοβο κομματι του κωδικα οπου εδω ειναι να προκυψει διαιρεση με το 0 και αν υπαρξει η προηγουμενη αριθμητικη κατασταση παραγει μια εξαιρεση τυπου ArithmeticException  
      try
      {
        System.out.println("To apotelesma ths diaireshs einai : "+ ((Z-15)*K)/((K-2)*Z));
      }
      catch(ArithmeticException e)
      {
        System.out.println("Exception:Sfalma exoyme diairesh me to 0 \nReturnedvalue: error");
     }
  }
    // η μεθοδος που θα μου τρεξει το προγραμμα 
  public static void main()
  {
      System.out.println("Dwste enan akeraio arithmo z:");
      int z = readIntA();
      System.out.println("Dwste enan akeraio arithmo k:");
      int k = readIntA();
      printResults(z,k);
  }
}