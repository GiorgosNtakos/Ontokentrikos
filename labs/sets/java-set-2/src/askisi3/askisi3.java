import java.io.*;

public class askisi3
{
    public static void main(String args[])
    {
            //μεταβλητες 
            int countpapaki = 0;
            int countline = 1;
            char []data = new char[1000];
            String str="";
            String fileNameInput="input.txt";
            String fileNameOutput = "output.txt";
            try
            {
                File fi =new File(fileNameInput);//δημιουργουμε ενα αντικειμενο αρχειου που αντιστοιχει στο ιδιο το αρχειο input.txt
                File fo = new File(fileNameOutput);//δημιουργουμε ενα αντικειμενο αρχειου που αντιστοιχει στο ιδιο το αρχειο output.txt
                System.out.println(fileNameInput +(fi.exists()?" does":"doesn't")+" exist");//Παιρνουμε την απαντηση το αν υπαρχει το αρχειο input η οχι 
                FileReader fr = new FileReader(fi);//δημιουργουμε ενα αντικειμενο που θα χρησιμοποιηθει για την αναγνωση του αρχειου input.txt
                System.out.println("To arxeio input exei megethos "+fi.length()+" bytes");//Παιρνουμε το μηκος του αρχειου input.txt σε bytes
                FileWriter fw = new FileWriter(fo);//δημιουργουμε ενα αντικειμενο που θα χρησιμοποιηθει για την εγγραφη δεδομενων τυπου χαρακτηρων στο αρχειου output.txt
                System.out.println("To arxeio output exei megethos "+fo.length()+" bytes \n");//Παιρνουμε το μηκος του αρχειου output.txt σε bytes
                fr.read(data);//διαβαζουμε τα περιεχομενα του αρχειου input.txt
                
                /*ελεγχουμε χαρακτηρα προς χαρακτηρα μεχρι το τελος του πινακα και αν εντοπισουμε κενο 
                 *χαρακτηρα αυξανουμε το countpapaki κατα 1 αφου οσα ειναι και τα κενα τοσα και τα παπακια
                 * που θα μπουν στο κειμενο του output.txt.Στη συνεχεια  αν εντοπισουμε τον χαρακτηλα \n δηλαδη νεα 
                 * γραμμη αυξανουμε κατα 1 τον countline και ετσι εχουμε τον αριθμο γραμμων του αρχειου input.txt
                 * Και μετα μετραπουμε τον πινακα χαρακτηρων σε ενα αλφαριθμητικο str
                */
                for(int i=0; i<data.length; i++)
                {
                    if((char)data[i]==' ')
                    {
                        countpapaki+=1;
                    }
                    else if ((char)data[i]=='\n')
                    {
                        countline+=1;
                    }
                    
                   str=str+data[i];
                }
                
                  str=str.replace(' ', '@');//Αντικαθιστουμε ολους τους κενους χαρακτηρες με το χαρακτηρα @
                    
                  str=str.replaceAll("\n", "<<#NEW_LINE#>> \n");//Αντικαθιστα το υπο-αλφαριθμητικο \n  δηλαδη νεα γραμμη με το αλφαριθμητικο <<#NEW_LINE#>>.  
                    
                  fw.write(str);//γραφει τα περιεχομενα του αλφαριθμητικου str στο αρχειο output.txt
                  fw.write("\n<<#NEW_LINE>>");
                  
                fr.close();//κλεινει το ρευμα εισοδου
                fw.close();//κλεινει το ρευμα εξοδου
                //Τυπωνει τα αποτελεσματα 
                System.out.println("To arxeio input exei megethos "+fi.length()+" bytes \n");//Τυπωνει το μεγεθος του input.txt μετα το κλεισιμο των αρχειων
                System.out.println("To arxeio output exei megethos "+fo.length()+" bytes \n");//Tυπωνει το μεγεθος του output.txt μετα το κλεισιμο των αρχειων
                System.out.println("To plhthos twn grammwn sto arxeio input einai "+countline+"\n");//Τυπωνει τον αριθμο γραμμων του input.txt αρχειο
                System.out.println("To plhthos twn grammwn sto arxeio output einai "+2*countline+"\n");//Τυπωνει τον αριθμο των γραμμων του output.txt αρχειο. 
                System.out.println("To plhthos twn @ sto arxeio output einai "+countpapaki);//Τυπωνει το ποσες φορες εμφανισθηκε ο χαρακτηρας @ στο αρχειο output.txt
            }
                catch(FileNotFoundException e)
                {
                 System.err.println("Den yparxei to arxeio");
                 System.exit(1);
                }
                catch(IOException ae)
                {
                System.err.println(ae.toString());
               }
        }
    }