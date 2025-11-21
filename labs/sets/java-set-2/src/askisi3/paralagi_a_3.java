import java.io.*;

public class paralagi_a_3
{
    public static void main(String args[])
    {

       int countpapaki = 0;
       int countline = 0;
       String line ="";
       try
       {
          File fi = new File("input.txt");
          File fo = new File("output.txt");
          System.out.println(fi +(fi.exists()?" does":"doesn't")+" exist");
          BufferedReader get_file=new BufferedReader(new FileReader(fi));
          System.out.println("To arxeio input exei megethos "+fi.length()+" bytes");
          BufferedWriter send_file=new BufferedWriter(new FileWriter(fo));
          line=get_file.readLine();
          while(line!=null)
          {  
              for(int i=0; i<line.length(); i++)
              if(line.charAt(i)==' ')
              countpapaki+=1;
              send_file.append(line.replace(' ', '@'));
              send_file.append("\n <<#NEW_LINE#>> \n");
              countline+=1;
              line=get_file.readLine();
            }
            get_file.close();
            send_file.close();
            
            System.out.println("To arxeio input exei megethos "+fi.length()+" bytes \n");
            System.out.println("To arxeio output exei megethos "+fo.length()+" bytes \n");
            System.out.println("To plhthos twn grammwn sto arxeio input einai "+countline+"\n");
            System.out.println("To plhthos twn grammwn sto arxeio output einai "+2*countline+"\n"); 
            System.out.println("To plhthos twn @ sto arxeio output einai "+countpapaki);
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