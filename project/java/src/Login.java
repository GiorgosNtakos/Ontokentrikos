import java.util.Scanner; // I use scanner because it's command line.
import java.io.*;
public class Login {
 public static void  main(String args[])
 {
    try
        {
    Scanner scan = new Scanner (new File("C:\\Users\\giorg\\Desktop\\ΦΑΚΕΛΟΣ ΣΧΟΛΗΣ\\ontokentrikos\\projectJAVA\\test.txt"));
    Scanner keyboard = new Scanner (System.in);
    String user = scan.nextLine();
    String pass = scan.nextLine(); // looks at selected file in scan

    String inpUser = keyboard.nextLine();
    String inpPass = keyboard.nextLine(); // gets input from user

    if (inpUser.equals(user) && inpPass.equals(pass)) {
        System.out.print("your login message");
    } else {
        System.out.print("your error message");
    }
}
catch (FileNotFoundException e)
        {
            System.err.println("There is no such a file...");
        }
}

} 