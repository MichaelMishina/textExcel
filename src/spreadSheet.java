/**
 * Created by bal_mcmishina on 3/8/2016.
 */
import java.util.Scanner;
public class spreadSheet {

    private Scanner sheetScanner;
    public boolean finisher = false;
    private String Header = "            |      A      |      B      |      C      |      D      |      E      |     F      |      G      |";
    private String Separator = "------------+-------------+-------------+-------------+-------------+-------------+------------+-------------+";
    public spreadSheet(){}

    public void commandInput(Scanner commandScanner){
        System.out.print("Welcome. ");
        while(!finisher) {
            System.out.println("Enter a command.");
        String input1 = commandScanner.nextLine();
            if ((input1.toLowerCase().contains("print"))) {
                System.out.println(Header);
                System.out.println(Separator);
                for(int i = 0;i < 11;i++) {
                    if (i > 9) {
                        System.out.println("    " + i + "      |             |             |             |             |             |            |             |");
                        System.out.println(Separator);

                    } else {
                        System.out.println("     " + i + "      |             |             |             |             |             |            |             |");
                        System.out.println(Separator);

                    }
                }

            } else if ((input1.toLowerCase().contains("exit"))) {
                System.out.println("Process: end");
                finisher = true;
            }
        }

    }















}
