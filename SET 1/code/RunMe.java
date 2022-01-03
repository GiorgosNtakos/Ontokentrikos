public class RunMe
{
    /*Δημιουργουμε μια δικια μας μεθοδο checkKyvos για να ελεγξουμε αν εγινε καποιο λαθος κατα την αρχικοποιηση του αντικειμενου kyvos.Μεσα στο σωμα της μεθοδου εχουμε μια εντολη if
     * που μεσα στο σωμα της εχει μια εξαιρεση η οποια οταν ικανοποιηθει η συνθηκη if μας πεταει το μηνυμα σφαλματος που του εχουμε δωσει.Με την εντολη throw new παραγουμε
     * αυτην την εξαιρεση.Με λιγα λογια η εξαιρεση παραγεται οταν το συστημα εκτελεσης του προγραμματος δεν γνωριζει τι πρεπει να κανει σε απροσδοκητη κατασταση.
     */
    static void  checkKyvos(double pl1)
     {
        if (pl1<0)
        {
            throw new ArithmeticException("Sfalma kata thn arxikopoihsh tou kubou.H metablhth plevra toy kubou prepei na einai  mh arnitikh kai to upsos,platos,mikos na einai isa.");
        }
     }
    public static void main(String args[])
    {
        Kouti kouti=new Kouti(1.0, 2.0, 3.5); //Δεσμευουμε μνημη για το στιγμιοτυπο kouti και δινουμε τιμες στα ορισματα του κατασκευαστη του
        
        Kyvos kyvos=new Kyvos(-2.0);//Δεσμευουμε μνημη για το στιγμιοτυπο kyvos και δινουμε μια τιμη στο ορισμα του κατασκευαστη του
        
        checkKyvos(2.0);//καλουμε την μεθοδο check κyvos που περιεχει τη εξαιρεσαι για να γινει ελεγχος για τυχον σφαλμα στο αντικειμενο kyvos
        
        Spirtokouto spirtokouto=new Spirtokouto(2.0, 4.0, 3.0, 16.0);//Δεσμευουμε μνημη για το στιγμιοτυπο spirtokouto και δινουμε τιμες στα ορισματα του κατασκευαστη του
        
        //Εκτυπωση αποτελεσματων για το kouti
        System.out.println(kouti.toString());//Εκτυπωνει τα αποτελεσματα της μεθοδου toString() για το στιγμιοτυπο kouti
        
        //Εκτυπωση αποτελεσματων για το kyvos
        System.out.println("Kyvos: "+kyvos.toString());//Εκτυπωνει τα αποτελεσματα της μεθοδου toString() για το στιγμιοτυπο kyvos
        
        //Εκτυπωση αποτελεσματων για το spirtokouto
        System.out.println("Spirtokouto: "+spirtokouto.toString());//Εκτυπωνει τα αποτελεσματα της μεθοδου toString() για το στιγμιοτυπο spirtokouto
    }
}