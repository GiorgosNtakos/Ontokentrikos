public class Main 
{
   public static void main()
    {
        Worker WorkerArray[]=new Worker[2]; //δημιουργουμε εναν πινακα 2 θεσεων που θα περιεχει μεσα τα αντικεινα τυπου Worker
        
        PermanentWorker pw1 = new PermanentWorker("Nikos Patzios", "72340002" , 123, 3000);//Δεσμευουμε μνημη για το στιγμιοτυπο PermanentWorker και δινουμε τιμες στα ορισματα του κατασκευαστη του
        NonPermanentWorker npw1 = new NonPermanentWorker("Sofia Christou", "98145000", 123, 210, 20);//Δεσμευουμε μνημη για το στιγμιοτυπο NonPermanentWorker και δινουμε τιμες στα ορισματα του κατασκευαστη του
        Company Company123= new Company("TSA", "13579246", 123);//Δεσμευουμε μνημη για το στιγμιοτυπο Company και δινουμε τιμες στα ορισματα του κατασκευαστη του
        
        //μια for η οποια τρεχει τις θεσεις του πινακα και προσθετει σε αυτες τους εργατες που δημιουργησαμε
        for(int i=0; i<WorkerArray.length; i++)
        {
           WorkerArray[i]=npw1;
           //Οταν η ακεραια μεταβλητη i φτασει και γινει ιση με 1 τοτε οτι υπαρχει την εντολη continue και μετα δεν θα εκτελεστει και το προγραμμα μας θα συνεχιστει με την επομενη επαναληψη του βροχου
           if(i==1) 
           continue;
           WorkerArray[i]=pw1;
        }
        
        //Μια for η οποια περναει απο καθε στοιχειο του πινακα και τυπωνει τα στοιχεια των εργατων που βρισκονται μεσα στον πινακα
         for(int i=0; i<WorkerArray.length; i++)
        {
            WorkerArray[i].printINFO();
        }
        
        Company123.addWorker(pw1);//Προσθετουμε στην λιστα μας για το αντικειμενο εταιρειας που φτιαξαμε  το αντικειμενο pw1  
        Company123.addWorker(npw1);//Προσθετουμε στην λιστα μας για το αντικειμενο εταιρειας που φτιαξαμε  το αντικειμενο npw1  
        Company123.companyInfo();//Θα τυπωσει τα στοιχεια την εταιρειας Company123 οπου δουλευουν οι εργατες
        Company123.getterWorkersNames();//Θα τυπωσει τα ονοματα των εργατων που δουλευουν στην εταιρεια Company123
        
    }
}